package mydd2017.com.mylibrary.model;

import android.content.Context;

import java.util.Locale;

import mydd2017.com.mylibrary.common.Constants;
import mydd2017.com.mylibrary.listeners.ResponseListener;
import mydd2017.com.mylibrary.network.JsonRequest;

/**
 * Created by kristinpeterson on 12/28/15.
 */
public class Job {

    public static final int REQUEST_CODE_VIEW_JOB_DETAILS = 7001;

    public static final void viewDetails(Context context, String jobId, ResponseListener listener){
        JsonRequest.makeGetRequest(
                context,
                String.format(Locale.US, Constants.JOB_VIEW, jobId),
                null,
                listener,
                REQUEST_CODE_VIEW_JOB_DETAILS
        );
    }

}
