package com.tria.github.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tria.github.R
import com.tria.github.databinding.ActivityMainBinding
import com.tria.github.ui.sett.SettingViewModel
import com.tria.github.ui.sett.SettingViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavbar: BottomNavigationView = binding.bottomNavbar

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home,
            R.id.nav_favorite,
            R.id.nav_setting
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavbar.setupWithNavController(navController)

        supportActionBar?.hide()

//        Akses night mode preference dari setting fragment
        val factory: SettingViewModelFactory = SettingViewModelFactory.getInstance(applicationContext)
        val settingViewModel: SettingViewModel by viewModels{ factory }

        settingViewModel.getThemeSettings().observe(this) { isDarkModeActive: Boolean ->
            if (isDarkModeActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

    }
}