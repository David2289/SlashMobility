package com.slashmobility.seleccion.david.pasache.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.commons.ui.component.enums.DialogType
import com.example.commons.ui.component.extensions.DialogExtensions.Companion.setup
import com.example.commons.ui.model.button.ButtonModel
import com.example.display.ui.adapter.GroupsAdapter
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.databinding.ListFragmentBinding
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.ListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ListFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: ListFragmentBinding

    private lateinit var adapter: GroupsAdapter
    private lateinit var groupList: ArrayList<GroupModel>

    private var loadingDialog: Dialog? = null
    private var errorFetchDialog: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)

        initDialogs()
        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.list_fragment, container, false)

        configUI()

        viewModel.getGroups()
        loadingDialog?.show()

        return binding.root
    }

    private fun initDialogs() {
        context?.let {
            if (loadingDialog == null) {
                loadingDialog = Dialog(it).setup(
                    type = DialogType.LOADING,
                    desc = R.string.screen_list_dialog_loading_desc)
            }
            loadingDialog?.setCancelable(false)

            errorFetchDialog = Dialog(it).setup(
                type = DialogType.BUTTON,
                desc = R.string.screen_list_dialog_error_desc,
                buttonMdl1 = ButtonModel(
                    title = R.string.commons_accept,
                    onClick = { errorFetchDialog?.dismiss() }
                )
            )
        }
    }

    private fun initObservers() {
        val errorFetchObserver = Observer<Boolean> {
            loadingDialog?.let {
                if (it.isShowing) { it.dismiss() }
            }
            binding.recyclerview.visibility = View.GONE
            binding.emptyContent.visibility = View.VISIBLE
            errorFetchDialog?.show()
        }
        viewModel.errorFetchLiveData.observe(this, errorFetchObserver)

        val listObserver = Observer<List<GroupModel>> { result ->
            loadingDialog?.let {
                if (it.isShowing) { it.dismiss() }
            }
            groupList.clear()
            groupList.addAll(result)
            adapter.notifyDataSetChanged()
            binding.recyclerview.visibility = View.VISIBLE
            binding.emptyContent.visibility = View.GONE

        }
        viewModel.groupListLiveData.observe(this, listObserver)
    }

    private fun configUI() {
        groupList = ArrayList()
        adapter = GroupsAdapter(groupList) { user ->
//            val bundle = bundleOf(Constants.BUNDLE_USER to user)
//            Navigation.findNavController(binding.root).navigate(R.id.action_list_to_detail, bundle)
        }
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = llm
        binding.recyclerview.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_screen_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.refresh -> {
                viewModel.getGroups()
                loadingDialog?.show()
                true
            }
            R.id.favorites -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}