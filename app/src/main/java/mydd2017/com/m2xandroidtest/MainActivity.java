package mydd2017.com.m2xandroidtest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ManagerActivity{

    public static MainActivity instance;
    private TextView tvHRV, tvHeartRate, tvTemperature;

    public static MainActivity getInstance() {
//        if (instance == null) {
//            instance = new MainActivity();
//        }

        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHRV = (TextView) findViewById(R.id.tvHRV);
        tvHeartRate = (TextView) findViewById(R.id.tvHeartRate);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);

        instance = this;
    }

    public TextView getTvHRV() {
        return tvHRV;
    }

    public TextView getTvHeartRate() {
        return tvHeartRate;
    }

    public TextView getTvTemperature() {
        return tvTemperature;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.dashboard: return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

