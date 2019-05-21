package com.example.lab5

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_h.*

class Main2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val navController = this.findNavController(R.id.myNavHostFragment2)
        NavigationUI.setupActionBarWithNavController(this,navController)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout2, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout2.addDrawerListener(toggle)
        toggle.syncState()

        nav_view2.setNavigationItemSelectedListener(this)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController((R.id.myNavHostFragment))
        return navController.navigateUp()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.inventarios -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.productos -> {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            }
        }

        drawer_layout2.closeDrawer(GravityCompat.START)
        return true
    }
}
