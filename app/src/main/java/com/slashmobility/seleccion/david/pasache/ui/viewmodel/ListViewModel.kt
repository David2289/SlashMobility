package com.slashmobility.seleccion.david.pasache.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel @Inject constructor(private val groupRepository: GroupRepository): ViewModel() {

    var errorFetchLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var groupListLiveData: MutableLiveData<List<GroupModel>> = MutableLiveData()
    var groupList: ArrayList<GroupModel> = ArrayList()

    fun getGroups() {
        groupRepository.getGroups()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleListResponse, this::handleError)
    }

    private fun handleListResponse(groupList: List<GroupModel>) {
        this.groupList.clear()
        this.groupList.addAll(groupList)
        groupListLiveData.value = this.groupList
    }

    private fun handleError(t: Throwable) {
        Log.w("RETROFIT", "HAS BEEN AN ERROR: " + t.message)
        errorFetchLiveData.value = true
    }

}