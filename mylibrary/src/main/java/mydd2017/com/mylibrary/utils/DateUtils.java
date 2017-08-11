package mydd2017.com.mylibrary.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by kristinpeterson on 4/29/15
 */
public class DateUtils {

    /**
     * Formats a Date value to an ISO8601 timestamp
     *
     * @param dateTime the Date object being converted
     * @return the given Date object as an ISO8601 timestamp formatted string
     */
    public static String dateTimeToString(Date dateTime)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(dateTime).concat("Z");
    }

}
