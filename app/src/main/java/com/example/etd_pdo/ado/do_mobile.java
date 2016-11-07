package com.example.etd_pdo.ado;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class do_mobile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_mobile);

        TextView tv_hw = (TextView)findViewById(R.id.tv_hello_world);
        String now = DateUtils.formatDateTime(getApplicationContext(),(new Date()).getTime(), DateFormat.FULL);
        tv_hw.setText(getString(R.string.hello_world)+now);




    }

     public void QuandTuCliques(View v){
        final TextView tv_hw = (TextView)findViewById(R.id.tv_hello_world);

     DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                 // arg1 = year
                 // arg2 = month
                 // arg3 = day
                 tv_hw.setText(getString(R.string.hello_world)+arg1+" "+arg2+" "+arg3);
             }
         };
           Toast.makeText(getApplicationContext(),getString(R.string.msg),Toast.LENGTH_LONG).show();
         DatePickerDialog dpd = new DatePickerDialog(this,myDateListener,2016,11,07);
         dpd.show();

     }


}
