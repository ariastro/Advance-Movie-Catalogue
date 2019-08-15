package com.astronout.advancedmoviecatalogue.main.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.astronout.advancedmoviecatalogue.R
import com.astronout.advancedmoviecatalogue.databinding.ActivityMainBinding
import com.astronout.advancedmoviecatalogue.main.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setSupportActionBar(mainToolbar)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navController = Navigation.findNavController(this, R.id.fragment)
        setupActionBarWithNavController(navController)
        NavigationUI.setupWithNavController(bottomNavigation, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.fragment).navigateUp()
    }

    fun hideNavigation(value: Boolean){
        if (value){
            bottomNavigation.visibility = View.GONE
        }else{
            bottomNavigation.visibility = View.VISIBLE
        }
    }

}
