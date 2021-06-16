package com.slashmobility.seleccion.david.pasache.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(private val groupRepository: GroupRepository): ViewModel() {

    var emptyListLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var favoriteListLiveData: MutableLiveData<List<GroupModel>> = MutableLiveData()
    var favoriteList: ArrayList<GroupModel> = ArrayList()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        if (groupRepository.getFavoriteList().isEmpty()) {
            emptyListLiveData.value = true
        } else {
            favoriteList.clear()
            favoriteList.addAll(groupRepository.getFavoriteList())
            favoriteListLiveData.value = this.favoriteList
        }
    }

}