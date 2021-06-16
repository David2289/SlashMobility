package com.slashmobility.seleccion.david.pasache.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val groupRepository: GroupRepository): ViewModel() {

    fun getFavoriteList() {

    }

    fun saveFavorite(group: GroupModel) {
        groupRepository.saveFavorite(group)
    }

    fun deleteFavorite(group: GroupModel) {
        groupRepository.deleteFavorite(group)
    }

}