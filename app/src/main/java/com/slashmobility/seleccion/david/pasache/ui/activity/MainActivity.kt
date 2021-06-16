package com.slashmobility.seleccion.david.pasache.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        // Nav Controller
        navController = findNavController(R.id.fragment_content)
        // Setup ActionBar
        NavigationUI.setupActionBarWithNavController(this, navController)

        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}