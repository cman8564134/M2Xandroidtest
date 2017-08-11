package mydd2017.com.mylibrary.model;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;

import mydd2017.com.mylibrary.common.Constants;
import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.network.JsonRequest;

/**
 * Created by kristinpeterson on 12/26/15.
 */
public class Command {

    public static final int REQUEST_CODE_LIST_COMMANDS = 5001;
    public static final int REQUEST_CODE_SEND_COMMAND = 5002;
    public static final int REQUEST_CODE_VIEW_COMMAND_DETAILS = 5003;

    public static final void listCommands(Context context, HashMap<String,String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                Constants.COMMANDS_LIST,
                params,
                listener,
                REQUEST_CODE_LIST_COMMANDS
        );
    }

    public static final void sendCommand(Context context, JSONObject body, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                Constants.COMMANDS_SEND,
                body,
                listener,
                REQUEST_CODE_SEND_COMMAND
        );
    }

    public static final void viewCommandDetails(Context context, String commandId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.COMMANDS_VIEW_DETAILS, commandId),
                null,
                listener,
                REQUEST_CODE_VIEW_COMMAND_DETAILS
        );
    }

}
