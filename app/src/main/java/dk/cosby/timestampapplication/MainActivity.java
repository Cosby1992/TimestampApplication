package dk.cosby.timestampapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnBigBlueButton;

    private TextView tvPunchedInTime;
    private TextView tvPunchedOutTime;

    private TextView tvPunchedInText;
    private TextView tvPunchedOutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnBigBlueButton = (Button) findViewById(R.id.btn_big_blue_button);

        tvPunchedInTime = (TextView) findViewById(R.id.tv_punched_in_time);
        tvPunchedOutTime = (TextView) findViewById(R.id.tv_punched_out_time);

        tvPunchedInText = (TextView) findViewById(R.id.tv_punched_in_text);
        tvPunchedOutText = (TextView) findViewById(R.id.tv_punched_out_text);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    public void onBigBlueButtonClick(View view){

        SaveTimeStamp saveTimeStamp = new SaveTimeStamp();

        String time = saveTimeStamp.saveTimeNow();

        tvPunchedInText.setVisibility(View.VISIBLE);
        tvPunchedInTime.setText(saveTimeStamp.getTimeNow());

        Toast.makeText(getApplicationContext(), "Time was set to: " + time, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_time_settings){

            //Starting the TimeSetting Activity
            Intent timeSettingActivityIntend = new Intent(getApplicationContext(), TimeSettingsActivity.class);
            startActivity(timeSettingActivityIntend);

        } else if (id == R.id.nav_share) {

            Toast.makeText(getApplicationContext(), "This menu item has not been developed", Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_send) {

            Toast.makeText(getApplicationContext(), "This menu item has not been developed", Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
