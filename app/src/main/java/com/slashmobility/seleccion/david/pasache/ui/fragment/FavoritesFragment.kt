package com.slashmobility.seleccion.david.pasache.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.display.ui.adapter.GroupsAdapter
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.databinding.FavoritesFragmentBinding
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.FavoritesViewModel
import com.slashmobility.seleccion.david.pasache.utility.Constants
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoritesFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var binding: FavoritesFragmentBinding

    private lateinit var adapter: GroupsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FavoritesViewModel::class.java)

        initObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.favorites_fragment, container, false)

        configUI()
        viewModel.getFavorites()

        return binding.root
    }

    private fun initObservers() {
        val emptyListObserver = Observer<Boolean> {
            binding.recyclerview.visibility = View.GONE
            binding.emptyContent.visibility = View.VISIBLE
        }
        viewModel.emptyListLiveData.observe(this, emptyListObserver)

        val favoriteListObserver = Observer<List<GroupModel>> {
            adapter.notifyDataSetChanged()
            binding.recyclerview.visibility = View.VISIBLE
            binding.emptyContent.visibility = View.GONE
        }
        viewModel.favoriteListLiveData.observe(this, favoriteListObserver)
    }

    private fun configUI() {
        adapter = GroupsAdapter(viewModel.favoriteList) { group ->
            val bundle = Bundle()
            bundle.putParcelable(Constants.BUNDLE_GROUP, group)
            bundle.putString(Constants.BUNDLE_DETAIL_TITLE, group.name)
            Navigation.findNavController(binding.root).navigate(R.id.action_favorites_to_detail, bundle)
        }
        val llm = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = llm
        binding.recyclerview.adapter = adapter
    }

}