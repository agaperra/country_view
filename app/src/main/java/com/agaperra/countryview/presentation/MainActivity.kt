package com.agaperra.countryview.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agaperra.countryview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity
 *
 * @constructor Create empty Main activity with view binding
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * Binding
     *
     * lateinit container for view binding
     */
    private lateinit var binding: ActivityMainBinding


    /**
     * On create
     *
     * @param savedInstanceState saved instance state parameter
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}