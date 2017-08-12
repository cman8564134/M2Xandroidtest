package mydd2017.com.m2xandroidtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ManagerActivity{

    public static MainActivity instance;
    private TextView tvHRC, tvHeartRate, tvTemperature;

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

        tvHRC = (TextView) findViewById(R.id.tvHRC);
        tvHeartRate = (TextView) findViewById(R.id.tvHeartRate);
        tvTemperature = (TextView) findViewById(R.id.tvTemperature);

        instance = this;
    }

    public TextView getTvHRC() {
        return tvHRC;
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

