package com.example.ejemplodrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //drawer
        val drawerLayout: DrawerLayout= findViewById(R.id.drawer_app)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navControl = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_op1, R.id.nav_op2, R.id.nav_op3),drawerLayout)

        setupActionBarWithNavController(navControl,appBarConfiguration)
        navView.setupWithNavController(navControl)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navControl = findNavController(R.id.nav_host_fragment)
        return navControl.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
