package com.slashmobility.seleccion.david.pasache.ui.activity

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.commons.ui.component.enums.DialogType
import com.example.commons.ui.component.extensions.DialogExtensions.Companion.setup
import com.example.commons.ui.model.button.ButtonModel
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.databinding.ImagesActivityBinding
import com.slashmobility.seleccion.david.pasache.ui.adapter.ImagesAdapter
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.ImagesViewModel
import com.slashmobility.seleccion.david.pasache.utility.Constants
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class ImagesActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ImagesViewModel
    private lateinit var binding: ImagesActivityBinding

    private lateinit var adapter: ImagesAdapter

    private var loadingDialog: Dialog? = null
    private var errorFetchDialog: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ImagesViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.images_activity)

        initDialogs()
        initObservers()
        configUI()

        val groupId = intent.getStringExtra(Constants.EXTRA_GROUPID) as String

        viewModel.getImages(groupId)
        loadingDialog?.show()
        setContentView(binding.root)
    }

    private fun configUI() {
        adapter = ImagesAdapter(viewModel.imageList)
        binding.viewpager.adapter = adapter

        binding.dotsIndicator.setViewPager2(binding.viewpager)
    }

    private fun initDialogs() {
        if (loadingDialog == null) {
            loadingDialog = Dialog(this).setup(
                type = DialogType.LOADING,
                desc = R.string.screen_images_dialog_loading_desc)
        }
        loadingDialog?.setCancelable(false)

        errorFetchDialog = Dialog(this).setup(
            type = DialogType.BUTTON,
            desc = R.string.screen_images_dialog_error_desc,
            buttonMdl1 = ButtonModel(
                title = R.string.commons_accept,
                onClick = {
                    errorFetchDialog?.dismiss()
                    finish()
                }
            )
        )
        errorFetchDialog?.setCancelable(false)
    }

    private fun initObservers() {

        val imagesObserver = Observer<List<String>> {
            loadingDialog?.let {
                if (it.isShowing) { it.dismiss() }
            }
            adapter.notifyDataSetChanged()

        }
        viewModel.imageListLiveData.observe(this, imagesObserver)

        val errorFetchObserver = Observer<Boolean> {
            loadingDialog?.let {
                if (it.isShowing) { it.dismiss() }
            }
            errorFetchDialog?.show()
        }
        viewModel.errorFetchLiveData.observe(this, errorFetchObserver)
    }

}