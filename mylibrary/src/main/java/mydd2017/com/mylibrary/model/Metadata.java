package mydd2017.com.mylibrary.model;

import android.content.Context;

import org.json.JSONObject;

import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.network.JsonRequest;

/**
 * Created by kristinpeterson on 12/26/15.
 */
public class Metadata {

    /**
     * Get custom metadata of an existing entity.
     *
     * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Read-Device-Metadata">https://m2x.att.com/developer/documentation/v2/device#Read-Device-Metadata</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Read-Distribution-Metadata">https://m2x.att.com/developer/documentation/v2/distribution#Read-Distribution-Metadata</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Read-Collection-Metadata">https://m2x.att.com/developer/documentation/v2/collections#Read-Collection-Metadata</a>
     */
    public static final void metadata(Context context, String path, ResponseListener listener, int requestCode) {
        JsonRequest.makeGetRequest(context, path, null, listener, requestCode);
    }

    /**
     * Update the custom metadata of the specified entity.
     *
     * @param body parameters for the request as JSON object
     * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Update-Device-Metadata">https://m2x.att.com/developer/documentation/v2/device#Update-Device-Metadata</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Metadata">https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Metadata</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Update-Collection-Metadata">https://m2x.att.com/developer/documentation/v2/collections#Update-Collection-Metadata</a>
     */
    public static final void updateMetadata(Context context, String path, JSONObject body, ResponseListener listener, int requestCode) {
        JsonRequest.makePutRequest(context, path, body, listener, requestCode);
    }

    /**
     * Get the value of a single custom metadata field from an existing entity.
     *
     * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Read-Device-Metadata-Field">https://m2x.att.com/developer/documentation/v2/device#Read-Device-Metadata-Field</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Read-Distribution-Metadata-Field">https://m2x.att.com/developer/documentation/v2/distribution#Read-Distribution-Metadata-Field</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Read-Collection-Metadata-Field">https://m2x.att.com/developer/documentation/v2/collections#Read-Collection-Metadata-Field</a>
     */
    public static final void metadataField(Context context, String path, ResponseListener listener, int requestCode) {
        JsonRequest.makeGetRequest(context, path, null, listener, requestCode);
    }

    /**
     * Update the custom metadata of the specified entity.
     *
     * @param body parameters for the request as JSON object
     * @see <a href="https://m2x.att.com/developer/documentation/v2/device#Update-Device-Metadata-Field">https://m2x.att.com/developer/documentation/v2/device#Update-Device-Metadata-Field</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Metadata-Field">https://m2x.att.com/developer/documentation/v2/distribution#Update-Distribution-Metadata-Field</a>
     * @see <a href="https://m2x.att.com/developer/documentation/v2/collections#Update-Collection-Metadata-Field">https://m2x.att.com/developer/documentation/v2/collections#Update-Collection-Metadata-Field</a>
     */
    public static final void updateMetadataField(Context context, String path, JSONObject body, ResponseListener listener, int requestCode) {
        JsonRequest.makePutRequest(context, path, body, listener, requestCode);
    }

}
