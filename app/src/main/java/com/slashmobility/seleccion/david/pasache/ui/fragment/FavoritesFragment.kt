package com.slashmobility.seleccion.david.pasache.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.display.ui.adapter.GroupsAdapter
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.databinding.FavoritesFragmentBinding
import com.slashmobility.seleccion.david.pasache.ui.viewmodel.FavoritesViewModel
import javax.inject.Inject

class FavoritesFragment: Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var binding: FavoritesFragmentBinding

    private lateinit var adapter: GroupsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FavoritesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.favorites_fragment, container, false)
        return binding.root
    }

}