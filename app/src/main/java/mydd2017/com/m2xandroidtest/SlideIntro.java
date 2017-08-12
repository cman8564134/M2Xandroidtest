package mydd2017.com.m2xandroidtest;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hang on 8/12/2017.
 */

public class SlideIntro {
    SharedPreferences pref;
SharedPreferences.Editor editor;
Context _context;

        // shared pref mode
        int PRIVATE_MODE = 0;

        // Shared preferences file name
        private static final String PREF_NAME = "androidhive-welcome";

        private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

        public SlideIntro(Context context) {
this._context = context;
pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
editor = pref.edit();
}

        public void setFirstTimeLaunch(boolean isFirstTime) {
editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
editor.commit();
}

        public boolean isFirstTimeLaunch() {
return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
}
}
