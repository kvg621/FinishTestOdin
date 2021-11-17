package com.example.finishtestodin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var menuBottomBar: BottomNavigationView

private const val LAST_SELECTED_ITEM = "Item"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menuBottomBar = findViewById(R.id.nav_bar_bottom)
        menuBottomBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.to_home -> {
                    val menuFragment = HomeFragment()
                    replaceFragment(menuFragment)
                }
                R.id.to_about -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
            }

            true
        }
        menuBottomBar.selectedItemId =
            if (savedInstanceState == null) R.id.to_home else savedInstanceState.getInt(
                LAST_SELECTED_ITEM
            )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_activity_main, fragment)
            .commit()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, menuBottomBar.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}