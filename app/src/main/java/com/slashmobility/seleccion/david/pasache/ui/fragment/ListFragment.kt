package com.slashmobility.seleccion.david.pasache.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.commons.ui.component.enums.DialogType
import com.example.commons.ui.component.extensions.DialogExtensions.Companion.setup
import com.example.commons.ui.model.button.ButtonModel
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.databinding.ListFragmentBinding
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.ListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListFragmentBinding
    private lateinit var loadingDialog: Dialog
    private lateinit var errorFetchDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)

        // ERROR FETCH OBSERVER
        val errorFetchObserver = Observer<Boolean> {
            context?.let {
                if (loadingDialog.isShowing) {
                    loadingDialog.dismiss()
                }
                errorFetchDialog = Dialog(it).setup(
                    type = DialogType.BUTTON,
                    desc = R.string.screen_list_dialog_error_desc,
                    buttonMdl1 = ButtonModel(
                        title = R.string.commons_accept,
                        onClick = { errorFetchDialog.dismiss() }
                    )
                )
                errorFetchDialog.show()
            }
        }
        viewModel.errorFetchLiveData.observe(this, errorFetchObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)
        viewModel.getGroups()

        context?.let {
            loadingDialog = Dialog(it).setup(
                type = DialogType.LOADING,
                desc = R.string.screen_list_dialog_loading_desc)
            loadingDialog.setCancelable(false)
            loadingDialog.show()
        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_screen_list, menu)
    }

}