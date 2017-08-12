package mydd2017.com.m2xandroidtest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by ksong on 12-Aug-17.
 */

public class PersonalRecord {
    void postHealthyHeartRate() throws JSONException {

        String record = "{ \"values\": [\n" +
                " {\"timestamp\":\"2015-03-02T05:06:00.123z\",\"value\": 80}";

        for (int hour = 0; hour < 24; hour ++) {
            for (int minute = 0; minute < 60; minute ++) {
                record += ",\n {\"timestamp\":\"2015-03-02T"+String.format("%2d", hour)+ ":"+String.format("%2d", minute)+
                        ":00.123z\",\"value\": "+new Random().nextInt(135-105)+105+"}";
            }
        }
        record += "] }";
//        JSONObject jsonObject = new JSONObject("{ \"values\": [\n" +
//                " {\"timestamp\":\"2015-03-02T05:06:00.123z\",\"value\": 80},\n" +
//                " {\"timestamp\":\"2015-03-02T05:06:00.123z\",\"value\": 80},\n" +
//                " {\"timestamp\":\"2015-03-02T05:06:00.123z\",\"value\": 80},\n" +
//                "] }");

        JSONObject jsonObject = new JSONObject(record);
    }

    void postHealthBodyTemperature() throws JSONException {

        String record = "{ \"values\": [\n" +
                " {\"timestamp\":\"2015-03-02T05:06:00.123z\",\"value\": 80}";

        for (int hour = 0; hour < 24; hour ++) {
            for (int minute = 0; minute < 60; minute ++) {
                record += ",\n {\"timestamp\":\"2015-03-02T"+String.format("%2d", hour)+ ":"+String.format("%2d", minute)+
                        ":00.123z\",\"value\": "+new Random().nextInt(37-33)+33+"}";
            }
        }
        record += "] }";

        JSONObject jsonObject = new JSONObject(record);
    }
}
