package com.example.etd_pdo.ado;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DateFormat;
import java.util.Date;

public class do_mobile extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_mobile);

        TextView tv_hw = (TextView) findViewById(R.id.tv_hello_world);
        String now = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        tv_hw.setText(getString(R.string.hello_world) + now );


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void changerH(){
        final TextView tv_hw = (TextView) findViewById(R.id.tv_hello_world);

        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                // arg1 = year
                // arg2 = month
                // arg3 = day
                arg2 = arg2%12 + 1;
                tv_hw.setText(getString(R.string.hello_world) + arg1 + "/" + arg2 + "/" + arg3);
            }
        };
        Toast.makeText(getApplicationContext(), getString(R.string.msg), Toast.LENGTH_LONG).show();
        DatePickerDialog dpd = new DatePickerDialog(this, myDateListener, 2016, 11, 07);
        dpd.show();
    }

    public void QuandTuCliques(View v) {
        //changerH();
        notification_test();
        intentSecondeActivity();

    }

    public void Locate(View v){
     startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=Londre")));
    }

    public void notification_test() {
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this);
        notif.setContentTitle("Here comes the Money");
        notif.setContentText("Give me the dollar bill yo..");
        notif.setSmallIcon(R.drawable.ic_euro_symbol_white_18dp);//BitmapFactory.decodeResource(getResources(), R.drawable.ic_euro_symbol_black_18dp));

        NotificationManager notifmanager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notifmanager.notify(1, notif.build());
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.toast) {
            Toast.makeText(getApplicationContext(), "Recherche depuis l'action bar !", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void intentSecondeActivity(){
        Intent i = new Intent(this, SecondeActivity.class);
        startActivity(i);
    }
}
