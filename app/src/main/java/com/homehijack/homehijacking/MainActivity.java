package com.homehijack.homehijacking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ReservationFragment reservationFragment;
    private FriendFragment friendFragment;
    private SettingFragment settingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bnv);

        reservationFragment = new ReservationFragment();
        friendFragment = new FriendFragment();
        settingFragment = new SettingFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, reservationFragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.reservation: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, reservationFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.friend: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, friendFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.setting: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, settingFragment).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });

    }
}