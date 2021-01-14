package com.homehijack.homehijacking

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.pageReservation ->{
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, ReservationFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.pageFriends ->{
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, FriendsFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.pageSettings ->{
                supportFragmentManager.beginTransaction().replace(R.id.mainLayout, SettingsFragment()).commitAllowingStateLoss()
                return true
            }
        }
        return false
    }

}