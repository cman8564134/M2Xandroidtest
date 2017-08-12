package mydd2017.com.m2xandroidtest;

/**
 * Created by ksong on 11-Aug-17.
 */

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.main.M2XAPI;
import mydd2017.com.mylibrary.model.Device;
import mydd2017.com.mylibrary.network.ApiV2Response;

public class BluetoothConnectionService {
    private MainActivity mainActivity = MainActivity.getInstance();

    private static final String TAG = "BluetoothConnectionServ";

    private static final String appName = "MYAPP";

    private static final UUID MY_UUID_INSECURE =
//            UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");
            UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private static final String MASTER_ID = "670e1c1a7d206ea49e2b15c37bbca59b";
    private static final String DEVICE_ID = "db2b6bec974fca8dabc42fde299e3c53";

    private final BluetoothAdapter mBluetoothAdapter;
    Context mContext;

    private AcceptThread mInsecureAcceptThread;

    private ConnectThread mConnectThread;
    private BluetoothDevice mmDevice;
    private UUID deviceUUID;
    private String storeBuffer = "";
    ProgressDialog mProgressDialog;

    private ConnectedThread mConnectedThread;

    public BluetoothConnectionService(Context context) {
        mContext = context;
        M2XAPI.initialize(mContext, MASTER_ID);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        start();
    }


    /**
     * This thread runs while listening for incoming connections. It behaves
     * like a server-side client. It runs until a connection is accepted
     * (or until cancelled).
     */
    private class AcceptThread extends Thread {

        // The local server socket
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread(){
            BluetoothServerSocket tmp = null;

            // Create a new listening server socket
            try{
                tmp = mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(appName, MY_UUID_INSECURE);

                Log.d(TAG, "AcceptThread: Setting up Server using: " + MY_UUID_INSECURE);
            }catch (IOException e){
                Log.e(TAG, "AcceptThread: IOException: " + e.getMessage() );
            }

            mmServerSocket = tmp;
        }

        public void run(){
            Log.d(TAG, "run: AcceptThread Running.");

            BluetoothSocket socket = null;

            try{
                // This is a blocking call and will only return on a
                // successful connection or an exception
                Log.d(TAG, "run: RFCOM server socket start.....");

                socket = mmServerSocket.accept();

                Log.d(TAG, "run: RFCOM server socket accepted connection.");

            }catch (IOException e){
                Log.e(TAG, "AcceptThread: IOException: " + e.getMessage() );
            }

            //talk about this is in the 3rd
            if(socket != null){
                connected(socket,mmDevice);
            }

            Log.i(TAG, "END mAcceptThread ");
        }

        public void cancel() {
            Log.d(TAG, "cancel: Canceling AcceptThread.");
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "cancel: Close of AcceptThread ServerSocket failed. " + e.getMessage() );
            }
        }

    }

    /**
     * This thread runs while attempting to make an outgoing connection
     * with a device. It runs straight through; the connection either
     * succeeds or fails.
     */
    private class ConnectThread extends Thread {
        private BluetoothSocket mmSocket;

        public ConnectThread(BluetoothDevice device, UUID uuid) {
            Log.d(TAG, "ConnectThread: started.");
            mmDevice = device;
            deviceUUID = uuid;
        }

        public void run(){
            BluetoothSocket tmp = null;
            Log.i(TAG, "RUN mConnectThread ");

            // Get a BluetoothSocket for a connection with the
            // given BluetoothDevice
            try {
                Log.d(TAG, "ConnectThread: Trying to create InsecureRfcommSocket using UUID: "
                        +MY_UUID_INSECURE );
                tmp = mmDevice.createRfcommSocketToServiceRecord(deviceUUID);
            } catch (IOException e) {
                Log.e(TAG, "ConnectThread: Could not create InsecureRfcommSocket " + e.getMessage());
            }

            mmSocket = tmp;

            // Always cancel discovery because it will slow down a connection
            mBluetoothAdapter.cancelDiscovery();

            // Make a connection to the BluetoothSocket

            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                mmSocket.connect();

                Log.d(TAG, "run: ConnectThread connected.");
            } catch (IOException e) {
                // Close the socket
                try {
                    mmSocket.close();
                    Log.d(TAG, "run: Closed Socket.");
                } catch (IOException e1) {
                    Log.e(TAG, "mConnectThread: run: Unable to close connection in socket " + e1.getMessage());
                }
                Log.d(TAG, "run: ConnectThread: Could not connect to UUID: " + MY_UUID_INSECURE );
            }

            //will talk about this in the 3rd video
            connected(mmSocket,mmDevice);
        }
        public void cancel() {
            try {
                Log.d(TAG, "cancel: Closing Client Socket.");
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "cancel: close() of mmSocket in Connectthread failed. " + e.getMessage());
            }
        }
    }



    /**
     * Start the chat service. Specifically start AcceptThread to begin a
     * session in listening (server) mode. Called by the Activity onResume()
     */
    public synchronized void start() {
        Log.d(TAG, "start");

        // Cancel any thread attempting to make a connection
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }
        if (mInsecureAcceptThread == null) {
            mInsecureAcceptThread = new AcceptThread();
            mInsecureAcceptThread.start();
        }
    }

    /**
     AcceptThread starts and sits waiting for a connection.
     Then ConnectThread starts and attempts to make a connection with the other devices AcceptThread.
     **/

    public void startClient(BluetoothDevice device,UUID uuid){
        Log.d(TAG, "startClient: Started.");

        //initprogress dialog
        mProgressDialog = ProgressDialog.show(mContext,"Connecting Bluetooth"
                ,"Please Wait...",true);

        mConnectThread = new ConnectThread(device, uuid);
        mConnectThread.start();
    }

    /**
     Finally the ConnectedThread which is responsible for maintaining the BTConnection, Sending the data, and
     receiving incoming data through input/output streams respectively.
     **/
    private class ConnectedThread extends Thread {
        private final BluetoothSocket mmSocket;
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            Log.d(TAG, "ConnectedThread: Starting.");

            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            //dismiss the progressdialog when connection is established
            try{
                mProgressDialog.dismiss();
                mContext.startActivity(new Intent(mContext, MainActivity.class));
            }catch (NullPointerException e){
                e.printStackTrace();
            }


            try {
                tmpIn = mmSocket.getInputStream();
                tmpOut = mmSocket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        @Override
        public void run(){
            byte[] buffer = new byte[1024];  // buffer store for the stream

            int bytes; // bytes returned from read()
            int minute = 1;
            ArrayList<Integer> temperatureArray = new ArrayList<>();
            ArrayList<Integer> heartRateArray = new ArrayList<>();
            String storeBuffer = "";

            // Keep listening to the InputStream until an exception occurs
            while (true) {
                // Read from the InputStream
                try {
                    temperatureArray.clear();
                    heartRateArray.clear();
                    bytes = mmInStream.read(buffer);
                    String incomingMessage = new String(buffer, 0, bytes);
                    incomingMessage += "";
                    storeBuffer += incomingMessage;
                    Log.d(TAG, "InputStream: " + incomingMessage);
                    if (incomingMessage.equals("\n")) {
                        Log.d(TAG, "CompleteStream: " + storeBuffer);
                        storeBuffer = "";
                    }

                    String tempRecord = "{ \"values\": [\n {\"timestamp\":\"2017-08-10T05:01:00.123z\",\"value\": 80}";
                    String heartRateRecord = "{ \"values\": [\n {\"timestamp\":\"2017-08-10T05:01:00.123z\",\"value\": 80}";
                    String hazeRecord = "{ \"values\": [\n {\"timestamp\":\"2017-08-10T05:21:00.123z\",\"value\": 80}";
                    String HRVRecord = "{ \"values\": [\n {\"timestamp\":\"2017-08-10T05:21:00.123z\",\"value\": 80}";
                    String tempSensorRecord = "{ \"values\": [\n {\"timestamp\":\"2017-08-10T05:01:00.123z\",\"value\": 80}";

                    Random random = new Random();
                    int temp = 0;
                    int heartRate = 0;
                    int haze = 0;
                    int HRV = 0;
                    int tempSensor = 0;

                    for (int second = 0; second < 60; second ++) {
                        temp = random.nextInt(38 - 33) + 33;
                        heartRate = random.nextInt(141 - 105) + 105;
                        haze = random.nextInt(201 - 50) + 50;
                        HRV = random.nextInt(71 - 55) + 55;
                        tempSensor = random.nextInt(39 - 33) + 33;
                        temperatureArray.add(temp);
                        heartRateArray.add(heartRate);

                        tempRecord += ",\n {\"timestamp\":\"2017-08-11T07:"+String.format("%02d", minute)+
                                ":"+String.format("%02d", second)+".123z\",\"value\": "+temp+"}";

                        heartRateRecord += ",\n {\"timestamp\":\"2017-08-11T07:"+String.format("%02d", minute)+
                                ":"+String.format("%02d", second)+".123z\",\"value\": "+heartRate+"}";

                        hazeRecord += ",\n {\"timestamp\":\"2017-08-11T07:"+String.format("%02d", minute)+
                                ":"+String.format("%02d", second)+".123z\",\"value\": "+haze+"}";

                        HRVRecord += ",\n {\"timestamp\":\"2017-08-11T07:"+String.format("%02d", minute)+
                                ":"+String.format("%02d", second)+".123z\",\"value\": "+HRV+"}";

                        tempSensorRecord += ",\n {\"timestamp\":\"2017-08-11T07:"+String.format("%02d", minute)+
                                ":"+String.format("%02d", second)+".123z\",\"value\": "+tempSensor+"}";
                    }
                    minute++;
//                    for (int hour = 0; hour < 9; hour ++) {
//                        for (int minute = 0; minute < 60; minute ++) {
//                            temperatureRecord += ",\n {\"timestamp\":\"2015-07-02T"+String.format("%02d", hour)+ ":"+String.format("%02d", minute)+
//                                    ":00.123z\",\"value\": "+(new Random().nextInt(38-33)+33)+"}";
//                        }
//                    }
                    tempRecord += "] }";
                    heartRateRecord += "] }";
                    hazeRecord += "] }";
                    HRVRecord += "] }";
                    tempSensorRecord += "] }";

//                    int temperature = temperatureArray.get(temperatureArray.size() - 1);
                    int totalHeartRate = 0;
                    int maxHeartRate = 0;
                    int minHeartRate = 1000;
                    for (int rate: heartRateArray) {
                        if (maxHeartRate < rate)
                            maxHeartRate = rate;
                        if (minHeartRate > rate)
                            minHeartRate = rate;
                        totalHeartRate += rate;
                    }
                    double avgHeartRate = (double) totalHeartRate / heartRateArray.size();

                    if (mainActivity != null) {
                        TextView tvHRV = mainActivity.getTvHRV();
                        if (tvHRV != null && tvHRV.isShown()) {
                            tvHRV.setText("" + HRV + "HRV");
                            mainActivity.getTvHeartRate().setText("Avg. " + avgHeartRate
                                    + "\nMax. " + maxHeartRate
                                    + "\nMin. " + minHeartRate);
                            mainActivity.getTvTemperature().setText("" + temp + "°C");
                        }
                    }

                    JSONObject tempJason = new JSONObject(tempRecord);
                    JSONObject heartRateJason = new JSONObject(heartRateRecord);
                    JSONObject hazeJason = new JSONObject(hazeRecord);
                    JSONObject HRVJason = new JSONObject(HRVRecord);
                    JSONObject tempSensorJason = new JSONObject(tempSensorRecord);


                    Device.postDataStreamValues(mContext, tempJason, DEVICE_ID, "UserTempData", new ResponseListener() {
                        @Override
                        public void onRequestCompleted(ApiV2Response result, int requestCode) {
                            Log.d("response","tempJason push Completed: " + result.get_raw());
                        }

                        @Override
                        public void onRequestError(ApiV2Response error, int requestCode) {
                            Log.d("response","tempJason push Error: " + error.get_raw());
                        }
                    });

                    Device.postDataStreamValues(mContext, heartRateJason, DEVICE_ID, "userheartdata", new ResponseListener() {
                        @Override
                        public void onRequestCompleted(ApiV2Response result, int requestCode) {
                            Log.d("response","heartRateJason push Completed: " + result.get_raw());
                        }

                        @Override
                        public void onRequestError(ApiV2Response error, int requestCode) {
                            Log.d("response","heartRateJason push Error: " + error.get_raw());
                        }
                    });

                    Device.postDataStreamValues(mContext, hazeJason, DEVICE_ID, "APIID", new ResponseListener() {
                        @Override
                        public void onRequestCompleted(ApiV2Response result, int requestCode) {
                            Log.d("response","hazeJason push Completed: " + result.get_raw());
                        }

                        @Override
                        public void onRequestError(ApiV2Response error, int requestCode) {
                            Log.d("response","hazeJason push Error: " + error.get_raw());
                        }
                    });

                    Device.postDataStreamValues(mContext, HRVJason, DEVICE_ID, "VarianceStream", new ResponseListener() {
                        @Override
                        public void onRequestCompleted(ApiV2Response result, int requestCode) {
                            Log.d("response","HRVJason push Completed: " + result.get_raw());
                        }

                        @Override
                        public void onRequestError(ApiV2Response error, int requestCode) {
                            Log.d("response","HRVJason push Error: " + error.get_raw());
                        }
                    });

                    Device.postDataStreamValues(mContext, tempSensorJason, DEVICE_ID, "cityTemperatureSensor", new ResponseListener() {
                        @Override
                        public void onRequestCompleted(ApiV2Response result, int requestCode) {
                            Log.d("response","tempSensorJason push Completed: " + result.get_raw());
                        }

                        @Override
                        public void onRequestError(ApiV2Response error, int requestCode) {
                            Log.d("response","tempSensorJason push Error: " + error.get_raw());
                        }
                    });

                } catch (IOException e) {
                    Log.e(TAG, "write: Error reading Input Stream. " + e.getMessage() );
                    break;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        //Call this from the main activity to send data to the remote device
        public void write(byte[] bytes) {
            String text = new String(bytes, Charset.defaultCharset());
            Log.d(TAG, "write: Writing to outputstream: " + text);
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e(TAG, "write: Error writing to output stream. " + e.getMessage() );
            }
        }

        /* Call this from the main activity to shutdown the connection */
        public void cancel() {
            try {
                mmSocket.close();
            } catch (IOException e) { }
        }
    }

    private void connected(BluetoothSocket mmSocket, BluetoothDevice mmDevice) {
        Log.d(TAG, "connected: Starting.");

        // Start the thread to manage the connection and perform transmissions
        mConnectedThread = new ConnectedThread(mmSocket);
        mConnectedThread.start();
    }

    /**
     * Write to the ConnectedThread in an unsynchronized manner
     *
     * @param out The bytes to write
     * @see ConnectedThread#write(byte[])
     */
    public void write(byte[] out) {
        // Create temporary object
        ConnectedThread r;

        // Synchronize a copy of the ConnectedThread
        Log.d(TAG, "write: Write Called.");
        //perform the write
        mConnectedThread.write(out);
    }

}