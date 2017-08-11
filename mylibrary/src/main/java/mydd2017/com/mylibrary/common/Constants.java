package mydd2017.com.mylibrary.common;

import mydd2017.com.mylibrary.BuildConfig;

/**
 * Created by Joaquin on 28/11/14.
 */
public class Constants {

    public static final String API_BASE_URL = "http://api-m2x.att.com/v2"; //PROD
    public static final String USER_AGENT = "M2X-Android/".
                                            concat(BuildConfig.VERSION_NAME).
                                            concat(" java/21 (").
                                            concat(System.getProperty("os.arch")).
                                            concat(" ").
                                            concat(android.os.Build.VERSION.RELEASE).
                                            concat(")");
    
    //Device calls
    public static final String DEVICE_SEARCH_PUBLIC_CATALOG = API_BASE_URL.concat("/devices/catalog");
    public static final String DEVICE_LIST = API_BASE_URL.concat("/devices");
    public static final String DEVICE_SEARCH = API_BASE_URL.concat("/devices/search");
    public static final String DEVICE_LIST_TAGS = API_BASE_URL.concat("/devices/tags");
    public static final String DEVICE_CREATE = API_BASE_URL.concat("/devices");
    public static final String DEVICE_UPDATE_DETAILS = API_BASE_URL.concat("/devices/%s");
    public static final String DEVICE_VIEW_DETAILS = API_BASE_URL.concat("/devices/%s");
    public static final String DEVICE_READ_LOCATION = API_BASE_URL.concat("/devices/%s/location");
    public static final String DEVICE_READ_LOCATION_HISTORY = API_BASE_URL.concat("/devices/%s/location/waypoints");
    public static final String DEVICE_DELETE_LOCATION = API_BASE_URL.concat("/devices/%s/location/waypoints");
    public static final String DEVICE_UPDATE_LOCATION = API_BASE_URL.concat("/devices/%s/location");
    public static final String DEVICE_METADATA = API_BASE_URL.concat("/devices/%s/metadata");
    public static final String DEVICE_METADATA_FIELD = API_BASE_URL.concat("/devices/%s/metadata/%s");
    public static final String DEVICE_LIST_DATA_STREAMS = API_BASE_URL.concat("/devices/%s/streams");
    public static final String DEVICE_CREATE_UPDATE_DATA_STREAMS = API_BASE_URL.concat("/devices/%s/streams/%s");
    public static final String DEVICE_UPDATE_DATA_STREAM_VALUE = API_BASE_URL.concat("/devices/%s/streams/%s/value");
    public static final String DEVICE_VIEW_DATA_STREAM = API_BASE_URL.concat("/devices/%s/streams/%s");
    public static final String DEVICE_LIST_DATA_STREAM_VALUES = API_BASE_URL.concat("/devices/%s/streams/%s/values");
    public static final String DEVICE_LIST_DATA_STREAM_SAMPLING = API_BASE_URL.concat("/devices/%s/streams/%s/sampling");
    public static final String DEVICE_LIST_DATA_STREAM_STATS = API_BASE_URL.concat("/devices/%s/streams/%s/stats");
    public static final String DEVICE_SEARCH_DATA_STREAM_VALUES = API_BASE_URL.concat("/devices/%s/values/search.%s");
    public static final String DEVICE_POST_DATA_STREAM_VALUES = API_BASE_URL.concat("/devices/%s/streams/%s/values");
    public static final String DEVICE_EXPORT_VALUES = API_BASE_URL.concat("/devices/%s/values/export.csv");
    public static final String DEVICE_DELETE_DATA_STREAM_VALUES = API_BASE_URL.concat("/devices/%s/streams/%s/values");
    public static final String DEVICE_DELETE_DATA_STREAM = API_BASE_URL.concat("/devices/%s/streams/%s");
    public static final String DEVICE_POST_UPDATE = API_BASE_URL.concat("/devices/%s/update");
    public static final String DEVICE_POST_UPDATES = API_BASE_URL.concat("/devices/%s/updates");
    public static final String DEVICE_REQUEST_LOG = API_BASE_URL.concat("/devices/%s/log");
    public static final String DEVICE_DELETE = API_BASE_URL.concat("/devices/%s");
    public static final String DEVICE_LIST_RECEIVED_COMMANDS = API_BASE_URL.concat("/devices/%s/commands");
    public static final String DEVICE_VIEW_COMMAND_DETAILS = API_BASE_URL.concat("/devices/%s/commands/%s");
    public static final String DEVICE_MARK_COMMAND_PROCESSED = API_BASE_URL.concat("/devices/%s/commands/%s/process");
    public static final String DEVICE_MARK_COMMAND_REJECTED = API_BASE_URL.concat("/devices/%s/commands/%s/reject");

    //Distribution
    public static final String DISTRIBUTION_LIST = API_BASE_URL.concat("/distributions");
    public static final String DISTRIBUTION_CREATE = API_BASE_URL.concat("/distributions");
    public static final String DISTRIBUTION_VIEW_DETAILS = API_BASE_URL.concat("/distributions/%s");
    public static final String DISTRIBUTION_UPDATE_DETAILS = API_BASE_URL.concat("/distributions/%s");
    public static final String DISTRIBUTION_METADATA = API_BASE_URL.concat("/distributions/%s/metadata");
    public static final String DISTRIBUTION_METADATA_FIELD = API_BASE_URL.concat("/distributions/%s/metadata/%s");
    public static final String DISTRIBUTION_LIST_DEVICES = API_BASE_URL.concat("/distributions/%s/devices");
    public static final String DISTRIBUTION_ADD_DEVICE = API_BASE_URL.concat("/distributions/%s/devices");
    public static final String DISTRIBUTION_DELETE = API_BASE_URL.concat("/distributions/%s");
    public static final String DISTRIBUTION_LIST_DATA_STREAMS = API_BASE_URL.concat("/distributions/%s/streams");
    public static final String DISTRIBUTION_CREATE_UPDATE_DATA_STREAMS = API_BASE_URL.concat("/distributions/%s/streams/%s");
    public static final String DISTRIBUTION_VIEW_DATA_STREAMS = API_BASE_URL.concat("/distributions/%s/streams/%s");
    public static final String DISTRIBUTION_DELETE_DATA_STREAMS = API_BASE_URL.concat("/distributions/%s/streams/%s");

    //Keys
    public static final String KEYS_LIST = API_BASE_URL.concat("/keys");
    public static final String KEYS_CREATE = API_BASE_URL.concat("/keys");
    public static final String KEYS_DETAIL = API_BASE_URL.concat("/keys/%s");
    public static final String KEYS_UPDATE = API_BASE_URL.concat("/keys/%s");
    public static final String KEYS_REGENERATE = API_BASE_URL.concat("/keys/%s/regenerate");
    public static final String KEYS_DELETE = API_BASE_URL.concat("/keys/%s");

    //Command
    public static final String COMMANDS_LIST = API_BASE_URL.concat("/commands");
    public static final String COMMANDS_SEND = API_BASE_URL.concat("/commands");
    public static final String COMMANDS_VIEW_DETAILS = API_BASE_URL.concat("/commands/%s");

    //Job
    public static final String JOB_VIEW = API_BASE_URL.concat("/jobs/%s");

    //Collection
    public static final String COLLECTION_LIST = API_BASE_URL.concat("/collections");
    public static final String COLLECTION_CREATE = API_BASE_URL.concat("/collections");
    public static final String COLLECTION_VIEW_DETAILS = API_BASE_URL.concat("/collections/%s");
    public static final String COLLECTION_UPDATE_DETAILS = API_BASE_URL.concat("/collections/%s");
    public static final String COLLECTION_LIST_DEVICES = API_BASE_URL.concat("/collections/%s/devices");
    public static final String COLLECTION_METADATA = API_BASE_URL.concat("/collections/%s/metadata");
    public static final String COLLECTION_METADATA_FIELD = API_BASE_URL.concat("/collections/%s/metadata/%s");
    public static final String COLLECTION_DELETE = API_BASE_URL.concat("/collections/%s");
    public static final String COLLECTION_ADD_DEVICE_TO_COLLECTION = API_BASE_URL.concat("/collections/%s/devices/%s");
    public static final String COLLECTION_DELETE_DEVICE_FROM_COLLECTION = API_BASE_URL.concat("/collections/%s/devices/%s");

}
