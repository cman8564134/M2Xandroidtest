package mydd2017.com.mylibrary.model;

import android.content.Context;

import org.json.JSONObject;

import java.util.Locale;

import mydd2017.com.mylibrary.common.Constants;
import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.network.JsonRequest;

/**
 * Created by Joaquin on 28/11/14.
 */
public class Distribution {

    public static final int REQUEST_CODE_LIST_DISTRIBUTIONS = 2001;
    public static final int REQUEST_CODE_CREATE_DISTRIBUTION = 2002;
    public static final int REQUEST_CODE_VIEW_DISTRIBUTION_DETAILS = 2003;
    public static final int REQUEST_CODE_UPDATE_DISTRIBUTION_DETAILS = 2004;
    public static final int REQUEST_CODE_LIST_DEVICES = 2005;
    public static final int REQUEST_CODE_ADD_DEVICE = 2006;
    public static final int REQUEST_CODE_DELETE_DISTRIBUTION = 2007;
    public static final int REQUEST_CODE_LIST_DATA_STREAMS = 2008;
    public static final int REQUEST_CODE_CREATE_UPDATE_DATA_STREAMS = 2009;
    public static final int REQUEST_CODE_VIEW_DATA_STREAM = 2010;
    public static final int REQUEST_CODE_DELETE_DATA_STREAM = 2011;
    public static final int REQUEST_CODE_METADATA = 2012;
    public static final int REQUEST_CODE_UPDATE_METADATA = 2013;
    public static final int REQUEST_CODE_METADATA_FIELD = 2014;
    public static final int REQUEST_CODE_UPDATE_METADATA_FIELD = 2015;

    public static final void list(Context context, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                Constants.DISTRIBUTION_LIST,
                null,
                listener,
                REQUEST_CODE_LIST_DISTRIBUTIONS
        );
    }

    public static final void create(Context context, JSONObject params, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                Constants.DISTRIBUTION_CREATE,
                params,
                listener,
                REQUEST_CODE_CREATE_DISTRIBUTION
        );
    }

    public static final void viewDetails(Context context, String distributionId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_VIEW_DETAILS,distributionId),
                null,
                listener,
                REQUEST_CODE_VIEW_DISTRIBUTION_DETAILS
        );
    }

    public static final void updateDetails(Context context, JSONObject params, String distributionId, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_UPDATE_DETAILS,distributionId),
                params,
                listener,
                REQUEST_CODE_UPDATE_DISTRIBUTION_DETAILS
        );
    }
    public static final void metadata(Context context, String distributionId, ResponseListener listener){
        Metadata.metadata(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_METADATA, distributionId),
                listener,
                REQUEST_CODE_METADATA);
    }
    public static final void updateMetadata(Context context, String distributionId, JSONObject body, ResponseListener listener){
        Metadata.updateMetadata(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_METADATA, distributionId),
                body,
                listener,
                REQUEST_CODE_UPDATE_METADATA);
    }
    public static final void metadataField(Context context, String distributionId, String field, ResponseListener listener){
        Metadata.metadataField(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_METADATA_FIELD, distributionId, field),
                listener,
                REQUEST_CODE_METADATA_FIELD);
    }
    public static final void updateMetadataField(Context context, String distributionId, String field, JSONObject body, ResponseListener listener){
        Metadata.updateMetadataField(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_METADATA_FIELD, distributionId, field),
                body,
                listener,
                REQUEST_CODE_UPDATE_METADATA_FIELD);
    }

    public static final void listDevices(Context context, String distributionId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_LIST_DEVICES,distributionId),
                null,
                listener,
                REQUEST_CODE_LIST_DEVICES
        );
    }

    public static final void addDevice(Context context, JSONObject params, String distributionId, ResponseListener listener){
        JsonRequest.makePostRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_ADD_DEVICE,distributionId),
                params,
                listener,
                REQUEST_CODE_ADD_DEVICE
        );
    }

    public static final void delete(Context context, String distributionId, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_DELETE,distributionId),
                null,
                listener,
                REQUEST_CODE_DELETE_DISTRIBUTION
        );
    }

    public static final void listDataStreams(Context context, String distributionId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_LIST_DATA_STREAMS,distributionId),
                null,
                listener,
                REQUEST_CODE_LIST_DATA_STREAMS
        );
    }

    public static final void createUpdateDataStream(Context context, JSONObject params, String distributionId, String streamName, ResponseListener listener){
        JsonRequest.makePutRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_CREATE_UPDATE_DATA_STREAMS,distributionId,streamName),
                params,
                listener,
                REQUEST_CODE_CREATE_UPDATE_DATA_STREAMS
        );
    }

    public static final void viewDataStream(Context context, String distributionId, String streamName, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_VIEW_DATA_STREAMS,distributionId,streamName),
                null,
                listener,
                REQUEST_CODE_VIEW_DATA_STREAM
        );
    }

    public static final void deleteDataStream(Context context, String distributionId, String streamName, ResponseListener listener){
        JsonRequest.makeDeleteRequest(
                context,
                String.format(Locale.US, Constants.DISTRIBUTION_DELETE_DATA_STREAMS,distributionId,streamName),
                null,
                listener,
                REQUEST_CODE_DELETE_DATA_STREAM
        );
    }







}
