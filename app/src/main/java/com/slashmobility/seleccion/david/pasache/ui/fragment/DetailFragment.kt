package com.slashmobility.seleccion.david.pasache.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.databinding.DetailFragmentBinding
import com.slashmobility.seleccion.david.pasache.utility.Constants
import com.squareup.picasso.Picasso

class DetailFragment: Fragment() {

    private lateinit var binding: DetailFragmentBinding
    lateinit var group: GroupModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)

        group = arguments?.getParcelable<GroupModel>(Constants.BUNDLE_GROUP) as GroupModel
        binding.group = group
        Picasso.get().load(group.defaultImageUrl).into(binding.bgImage)

        binding.icFavorite.setOnClickListener { view -> view.isSelected = !view.isSelected }

        return binding.root
    }
}