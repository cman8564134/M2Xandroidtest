package mydd2017.com.mylibrary.model;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;

import mydd2017.com.mylibrary.common.Constants;
import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.network.JsonRequest;

/**
 * Created by Joaquin on 28/11/14.
 */
public class Device {

    public static final int REQUEST_CODE_SEARCH_PUBLIC_CATALOG = 1001;
    public static final int REQUEST_CODE_SEARCH_DEVICES = 1002;
    public static final int REQUEST_CODE_LIST_DEVICE_TAG = 1003;
    public static final int REQUEST_CODE_CREATE_DEVICE = 1004;
    public static final int REQUEST_CODE_DEVICE_DETAILS = 1005;
    public static final int REQUEST_CODE_DEVICE_LOCATION = 1006;
    public static final int REQUEST_CODE_DEVICE_UPDATE_LOCATION = 1007;
    public static final int REQUEST_CODE_DEVICE_LIST_DATA_STREAMS = 1008;
    public static final int REQUEST_CODE_DEVICE_CREATE_UPDATE_DATA_STREAMS = 1009;
    public static final int REQUEST_CODE_DEVICE_UPDATE_DATA_STREAM_VALUE = 1010;
    public static final int REQUEST_CODE_DEVICE_VIEW_DATA_STREAM = 1011;
    public static final int REQUEST_CODE_DEVICE_LIST_DATA_STREAM_VALUES = 1012;
    public static final int REQUEST_CODE_DEVICE_DATA_STREAM_SAMPLING = 1013;
    public static final int REQUEST_CODE_DEVICE_DATA_STREAM_STATS = 1014;
    public static final int REQUEST_CODE_DEVICE_POST_DATA_STREAM_VALUES = 1015;
    public static final int REQUEST_CODE_DEVICE_DELETE_DATA_STREAM_VALUES = 1016;
    public static final int REQUEST_CODE_DEVICE_DELETE_DATA_STREAM = 1017;
    public static final int REQUEST_CODE_DEVICE_POST_DEVICE_UPDATES = 1018;
    public static final int REQUEST_CODE_DEVICE_VIEW_REQUEST_LOG = 1025;
    public static final int REQUEST_CODE_DEVICE_DELETE = 1026;
    public static final int REQUEST_CODE_LIST_DEVICES = 1027;
    public static final int REQUEST_CODE_METADATA = 1028;
    public static final int REQUEST_CODE_UPDATE_METADATA = 1029;
    public static final int REQUEST_CODE_METADATA_FIELD = 1030;
    public static final int REQUEST_CODE_UPDATE_METADATA_FIELD = 1031;
    public static final int REQUEST_CODE_DEVICE_LOCATION_HISTORY = 1032;
    public static final int REQUEST_CODE_LIST_RECEIVED_COMMANDS = 1033;
    public static final int REQUEST_CODE_VIEW_COMMAND_DETAILS = 1034;
    public static final int REQUEST_CODE_MARK_COMMAND_PROCESSED = 1035;
    public static final int REQUEST_CODE_MARK_COMMAND_REJECTED = 1036;
    public static final int REQUEST_CODE_DEVICE_POST_DEVICE_UPDATE = 1037;
    public static final int REQUEST_CODE_DEVICE_EXPORT_VALUES = 1038;
    public static final int REQUEST_CODE_SEARCH_DATA_STREAM_VALUES = 1039;
    public static final int REQUEST_CODE_DEVICE_DELETE_LOCATION = 1040;

    public static final void searchPublicCatalog(Context context, HashMap<String,String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                Constants.DEVICE_SEARCH_PUBLIC_CATALOG,
                params,
                listener,
                REQUEST_CODE_SEARCH_PUBLIC_CATALOG
        );
    }

    public static final void listDevices(Context context, HashMap<String,String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                Constants.DEVICE_LIST,
                params,
                listener,
                REQUEST_CODE_LIST_DEVICES
        );
    }
    public static final void searchDevices(Context context, JSONObject body, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                Constants.DEVICE_SEARCH,
                body,
                listener,
                REQUEST_CODE_SEARCH_DEVICES
        );
    }

    public static final void listDeviceTags(Context context, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                Constants.DEVICE_LIST_TAGS,
                null,
                listener,
                REQUEST_CODE_LIST_DEVICE_TAG
        );
    }

    public static final void createDevice(Context context, JSONObject params, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                Constants.DEVICE_CREATE,
                params,
                listener,
                REQUEST_CODE_CREATE_DEVICE
        );
    }

    public static final void updateDeviceDetails(Context context, JSONObject params, String deviceId, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_UPDATE_DETAILS,deviceId),
                params,
                listener,
                REQUEST_CODE_CREATE_DEVICE
        );
    }

    public static final void viewDeviceDetails(Context context, String deviceId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_VIEW_DETAILS,deviceId),
                null,
                listener,
                REQUEST_CODE_DEVICE_DETAILS
        );
    }

    public static final void readDeviceLocation(Context context, String deviceId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_READ_LOCATION,deviceId),
                null,
                listener,
                REQUEST_CODE_DEVICE_LOCATION
        );
    }

    public static final void readDeviceLocationHistory(Context context, String deviceId, HashMap<String,String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_READ_LOCATION_HISTORY, deviceId),
                params,
                listener,
                REQUEST_CODE_DEVICE_LOCATION_HISTORY
        );
    }
    public static final void updateDeviceLocation(Context context, JSONObject params, String deviceId, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_UPDATE_LOCATION, deviceId),
                params,
                listener,
                REQUEST_CODE_DEVICE_UPDATE_LOCATION
        );
    }
    public static final void metadata(Context context, String deviceId, ResponseListener listener){
        Metadata.metadata(
                context,
                String.format(Locale.US, Constants.DEVICE_METADATA, deviceId),
                listener,
                REQUEST_CODE_METADATA);
    }
    public static final void updateMetadata(Context context, String deviceId, JSONObject body, ResponseListener listener){
        Metadata.updateMetadata(
                context,
                String.format(Locale.US, Constants.DEVICE_METADATA, deviceId),
                body,
                listener,
                REQUEST_CODE_UPDATE_METADATA);
    }
    public static final void metadataField(Context context, String deviceId, String field, ResponseListener listener){
        Metadata.metadataField(
                context,
                String.format(Locale.US, Constants.DEVICE_METADATA_FIELD, deviceId, field),
                listener,
                REQUEST_CODE_METADATA_FIELD);
    }
    public static final void updateMetadataField(Context context, String deviceId, String field, JSONObject body, ResponseListener listener){
        Metadata.updateMetadataField(
                context,
                String.format(Locale.US, Constants.DEVICE_METADATA_FIELD, deviceId, field),
                body,
                listener,
                REQUEST_CODE_UPDATE_METADATA_FIELD);
    }

    public static final void listDataStreams(Context context, String deviceId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_LIST_DATA_STREAMS, deviceId),
                null,
                listener,
                REQUEST_CODE_DEVICE_LIST_DATA_STREAMS
        );
    }

    public static final void createUpdateDataStreams(Context context, JSONObject params, String deviceId, String name, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_CREATE_UPDATE_DATA_STREAMS, deviceId,name),
                params,
                listener,
                REQUEST_CODE_DEVICE_CREATE_UPDATE_DATA_STREAMS
        );
    }

    public static final void updateDataStreamValue(Context context, JSONObject params, String deviceId, String name, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_UPDATE_DATA_STREAM_VALUE, deviceId,name),
                params,
                listener,
                REQUEST_CODE_DEVICE_UPDATE_DATA_STREAM_VALUE
        );
    }

    public static final void viewDataStream(Context context, String deviceId, String name, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_VIEW_DATA_STREAM, deviceId,name),
                null,
                listener,
                REQUEST_CODE_DEVICE_VIEW_DATA_STREAM
        );
    }

    public static final void listDataStreamValues(Context context, HashMap<String,String> params, String deviceId, String name, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_LIST_DATA_STREAM_VALUES, deviceId,name),
                params,
                listener,
                REQUEST_CODE_DEVICE_LIST_DATA_STREAM_VALUES
        );
    }

    public static final void dataStreamSampling(Context context, String deviceId, String name, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_LIST_DATA_STREAM_SAMPLING, deviceId,name),
                null,
                listener,
                REQUEST_CODE_DEVICE_DATA_STREAM_SAMPLING
        );
    }

    public static final void dataStreamStats(Context context, String deviceId, String name, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_LIST_DATA_STREAM_STATS, deviceId,name),
                null,
                listener,
                REQUEST_CODE_DEVICE_DATA_STREAM_STATS
        );
    }

    public static final void searchDataStreamValues(Context context, String deviceId, String format, JSONObject body, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_SEARCH_DATA_STREAM_VALUES, deviceId, format),
                body,
                listener,
                REQUEST_CODE_SEARCH_DATA_STREAM_VALUES
        );
    }
    public static final void postDataStreamValues(Context context, JSONObject params, String deviceId, String name, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_POST_DATA_STREAM_VALUES,deviceId,name),
                params,
                listener,
                REQUEST_CODE_DEVICE_POST_DATA_STREAM_VALUES
        );
    }
    public static final void exportValues(Context context, String deviceId, HashMap<String, String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_EXPORT_VALUES, deviceId),
                params,
                listener,
                REQUEST_CODE_DEVICE_EXPORT_VALUES
        );
    }

    public static final void deleteDataStreamValues(Context context, JSONObject params, String deviceId, String name, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_DELETE_DATA_STREAM_VALUES,deviceId,name),
                params,
                listener,
                REQUEST_CODE_DEVICE_DELETE_DATA_STREAM_VALUES
        );
    }

    public static final void deleteDataStream(Context context, String deviceId, String name, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_DELETE_DATA_STREAM,deviceId,name),
                null,
                listener,
                REQUEST_CODE_DEVICE_DELETE_DATA_STREAM
        );
    }

    public static final void deleteDeviceLocation(Context context, JSONObject params, String deviceId, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_DELETE_LOCATION, deviceId),
                params,
                listener,
                REQUEST_CODE_DEVICE_DELETE_LOCATION
        );
    }


    public static final void postDeviceUpdate(Context context, JSONObject params, String deviceId, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_POST_UPDATE, deviceId),
                params,
                listener,


                REQUEST_CODE_DEVICE_POST_DEVICE_UPDATE
        );
    }

    public static final void postDeviceUpdates(Context context, JSONObject params, String deviceId, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_POST_UPDATES,deviceId),
                params,
                listener,

                REQUEST_CODE_DEVICE_POST_DEVICE_UPDATES
        );
    }

    public static final void viewRequestLog(Context context, String deviceId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_REQUEST_LOG, deviceId),
                null,
                listener,
                REQUEST_CODE_DEVICE_VIEW_REQUEST_LOG
        );
    }

    public static final void deleteDevice(Context context, String deviceId, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_DELETE,deviceId),
                null,
                listener,
                REQUEST_CODE_DEVICE_DELETE
        );
    }

    public static final void listCommands(Context context, String deviceId, HashMap<String, String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_LIST_RECEIVED_COMMANDS, deviceId),
                params,
                listener,
                REQUEST_CODE_LIST_RECEIVED_COMMANDS
        );
    }
    public static final void viewCommand(Context context, String deviceId, String commandId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_VIEW_COMMAND_DETAILS, deviceId, commandId),
                null,
                listener,
                REQUEST_CODE_VIEW_COMMAND_DETAILS
        );
    }
    public static final void processCommand(Context context, String deviceId, String commandId, JSONObject body, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_MARK_COMMAND_PROCESSED, deviceId, commandId),
                body,
                listener,
                REQUEST_CODE_MARK_COMMAND_PROCESSED
        );
    }
    public static final void rejectCommand(Context context, String deviceId, String commandId, JSONObject body, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DEVICE_MARK_COMMAND_REJECTED, deviceId, commandId),
                body,
                listener,
                REQUEST_CODE_MARK_COMMAND_REJECTED
        );
    }
}
