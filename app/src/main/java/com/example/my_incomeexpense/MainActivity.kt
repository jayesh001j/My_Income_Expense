package com.example.my_incomeexpense

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.my_incomeexpense.Fragment.CategoryFragment
import com.example.my_incomeexpense.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hkinfo.mybudget_traker.Fragments.AddDatatFragment
import com.hkinfo.mybudget_traker.Fragments.HomeFragment

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var Type = arrayOf("home","Add","AddCategory")
        var Fragments = arrayOf(HomeFragment(),AddDatatFragment(), CategoryFragment())
        loadFragment(HomeFragment())
        binding.bottomNav.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId) {
                    R.id.home->
                        {
                        loadFragment(HomeFragment())
                    }
                    R.id.add->
                        {
                        loadFragment(AddDatatFragment())
                    }
                    R.id.AddCategory->
                        {
                        loadFragment(CategoryFragment())
                    }

                }
                return true
            }
        })
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
}
