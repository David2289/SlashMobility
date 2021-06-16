package com.slashmobility.seleccion.david.pasache.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.databinding.ImagesActivityBinding
import com.slashmobility.seleccion.david.pasache.ui.adapter.ImagesAdapter

class ImagesActivity: AppCompatActivity() {

    private lateinit var adapter: ImagesAdapter
    private lateinit var binding: ImagesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.images_activity)
        configUI()
        setContentView(binding.root)
    }

    private fun configUI() {
//        adapter = ImagesAdapter(wtItemList)
        binding.viewpager.adapter = adapter

        binding.dotsIndicator.setViewPager2(binding.viewpager)
    }

}