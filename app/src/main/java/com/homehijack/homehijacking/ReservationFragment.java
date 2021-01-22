package com.homehijack.homehijacking;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;


public class ReservationFragment extends Fragment {
    ViewGroup viewGroup;

    private TextView tvStart;
    private TextView tvEnd;
    private final int START = 0;
    private final int END = 1;
    private Button btSearch;


    public ReservationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_reservation, container, false);

        tvStart = (TextView) viewGroup.findViewById(R.id.tvStart);
        tvEnd = (TextView) viewGroup.findViewById(R.id.tvEnd);
        btSearch = (Button) viewGroup.findViewById(R.id.bt_search);

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

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });


        return viewGroup;
    }

    private void showCalender(final int mode) {
        Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(viewGroup.getContext(), new DatePickerDialog.OnDateSetListener() {
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