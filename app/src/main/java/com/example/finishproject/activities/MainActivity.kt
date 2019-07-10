package com.example.finishproject.activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.finishproject.OnFragmentInteractionListener
import com.example.finishproject.OnSelectedItemListener
import com.example.finishproject.R
import com.example.finishproject.fragments.MapsActivity
import com.example.finishproject.fragments.TracksListActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity() : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, Parcelable,
    OnFragmentInteractionListener, OnSelectedItemListener {

    constructor(parcel: Parcel) : this() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = TracksListActivity()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, firstFragment).commit()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            //создание нового трекера
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setCheckedItem(R.id.nav_home)
        navView.setNavigationItemSelectedListener(this)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, TracksListActivity())
//            .addToBackStack(null)
//            .commit()
    }

    override fun onFragmentInteraction(position: Int) {
        startActivity(Intent(this, MapsActivity::class.java))
    }

    override fun onSelectedItem(position: Int) {
        startActivity(Intent(this, MapsActivity::class.java))
    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_remind -> {

            }
            R.id.nav_exit -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
