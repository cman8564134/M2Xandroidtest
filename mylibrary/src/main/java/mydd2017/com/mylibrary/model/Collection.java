package mydd2017.com.mylibrary.model;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;

import mydd2017.com.mylibrary.common.Constants;
import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.network.JsonRequest;


/**
 * Created by kristinpeterson on 12/28/15.
 */
public class Collection {

    public static final int REQUEST_CODE_LIST_COLLECTIONS = 6001;
    public static final int REQUEST_CODE_CREATE_COLLECTION = 6002;
    public static final int REQUEST_CODE_VIEW_COLLECTION_DETAILS = 6003;
    public static final int REQUEST_CODE_UPDATE_COLLECTION_DETAILS = 6004;
    public static final int REQUEST_CODE_LIST_DEVICES = 6005;
    public static final int REQUEST_CODE_METADATA = 6006;
    public static final int REQUEST_CODE_UPDATE_METADATA = 6007;
    public static final int REQUEST_CODE_METADATA_FIELD = 6008;
    public static final int REQUEST_CODE_UPDATE_METADATA_FIELD = 6009;
    public static final int REQUEST_CODE_DELETE_COLLECTION = 6010;
    public static final int REQUEST_CODE_ADD_DEVICE_TO_COLLECTION = 6011;
    public static final int REQUEST_CODE_DELETE_DEVICE_FROM_COLLECTION = 6012;

    public static final void list(Context context, HashMap<String, String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                Constants.COLLECTION_LIST,
                params,
                listener,
                REQUEST_CODE_LIST_COLLECTIONS
        );
    }

    public static final void create(Context context, JSONObject body, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                Constants.COLLECTION_CREATE,
                body,
                listener,
                REQUEST_CODE_CREATE_COLLECTION
        );
    }

    public static final void viewDetails(Context context, String collectionId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.COLLECTION_VIEW_DETAILS, collectionId),
                null,
                listener,
                REQUEST_CODE_VIEW_COLLECTION_DETAILS
        );
    }

    public static final void updateDetails(Context context, String collectionId, JSONObject body, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.COLLECTION_UPDATE_DETAILS,collectionId),
                body,
                listener,
                REQUEST_CODE_UPDATE_COLLECTION_DETAILS
        );
    }

    public static final void listDevices(Context context, String collectionId, HashMap<String, String> params, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.COLLECTION_LIST_DEVICES, collectionId),
                params,
                listener,
                REQUEST_CODE_LIST_DEVICES
        );
    }

    public static final void metadata(Context context, String collectionId, ResponseListener listener){
        Metadata.metadata(
                context,
                String.format(Locale.US, Constants.COLLECTION_METADATA, collectionId),
                listener,
                REQUEST_CODE_METADATA);
    }

    public static final void updateMetadata(Context context, String collectionId, JSONObject body, ResponseListener listener){
        Metadata.updateMetadata(
                context,
                String.format(Locale.US, Constants.COLLECTION_METADATA, collectionId),
                body,
                listener,
                REQUEST_CODE_UPDATE_METADATA);
    }

    public static final void metadataField(Context context, String collectionId, String field, ResponseListener listener){
        Metadata.metadataField(
                context,
                String.format(Locale.US, Constants.COLLECTION_METADATA_FIELD, collectionId, field),
                listener,
                REQUEST_CODE_METADATA_FIELD);
    }

    public static final void updateMetadataField(Context context, String collectionId, String field, JSONObject body, ResponseListener listener){
        Metadata.updateMetadataField(
                context,
                String.format(Locale.US, Constants.COLLECTION_METADATA_FIELD, collectionId, field),
                body,
                listener,
                REQUEST_CODE_UPDATE_METADATA_FIELD);
    }

    public static final void delete(Context context, String collectionId, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.COLLECTION_DELETE, collectionId),
                null,
                listener,
                REQUEST_CODE_DELETE_COLLECTION
        );
    }

    public static final void deleteDeviceFromCollection(Context context, String collectionId, String deviceId, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.COLLECTION_DELETE_DEVICE_FROM_COLLECTION, collectionId, deviceId),
                null,
                listener,
                REQUEST_CODE_DELETE_DEVICE_FROM_COLLECTION
        );
    }

    public static final void addDeviceToCollection(Context context, String collectionId, String deviceId, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.COLLECTION_ADD_DEVICE_TO_COLLECTION, collectionId, deviceId),
                null,
                listener,
                REQUEST_CODE_ADD_DEVICE_TO_COLLECTION
        );
    }
}
