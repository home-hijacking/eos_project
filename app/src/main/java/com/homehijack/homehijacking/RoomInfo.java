package com.homehijack.homehijacking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.homehijack.homehijacking.ui.login.LoginActivity;

import java.util.Calendar;

public class RoomInfo extends AppCompatActivity {

    private TextView tvName;
    private TextView tvAddress;
    private TextView tvMax;
    private TextView tvMemo;

    private TextView tvStart;
    private TextView tvEnd;

    private final int START = 0;
    private final int END = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        tvName = (TextView) findViewById(R.id.tvRoomName);
        tvAddress = (TextView) findViewById(R.id.tvRoomAddress);
        tvMax = (TextView) findViewById(R.id.tvRoomMax);
        tvMemo = (TextView) findViewById(R.id.tvRoomMemoContext);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        int max = intent.getIntExtra("max", 0);
        String memo = intent.getStringExtra("memo");

        tvName.setText(name + "의 방");
        tvAddress.setText(address);
        tvMax.setText("최대 인원 : " + max);
        tvMemo.setText(memo);



        tvStart = (TextView) findViewById(R.id.tvRoomStart);
        tvEnd = (TextView) findViewById(R.id.tvRoomEnd);

        Button buttonReserve = (Button) findViewById(R.id.btRoomReserve);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalender(START);
            }
        });


        tvEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalender(END);
            }
        });


        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void showCalender(final int mode) {
        Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                String month_s=new Integer(month+1).toString();
                String day_s=new Integer(dayOfMonth).toString();
                if(month+1<10) month_s="0"+month_s;
                if(dayOfMonth<10) day_s="0"+day_s;

                String date = "" + year + "/" + month_s + "/" + day_s;
                if (mode == START) {
                    tvStart.setText(date);
                } else if (mode == END) {
                    tvEnd.setText(date);
                } else { //TODO:Error
                }
            }
        }, mYear, mMonth, mDay).show();
    }

}