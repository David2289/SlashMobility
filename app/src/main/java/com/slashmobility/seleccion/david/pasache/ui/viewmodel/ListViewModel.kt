package com.slashmobility.seleccion.david.pasache.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListViewModel(val groupRepository: GroupRepository): ViewModel() {

    fun getGroups() {
        groupRepository.getGroups()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleListResponse, this::handleError)
    }

    private fun handleListResponse(userList: List<GroupModel>) {
//        this.userList.clear()
//        this.userList.addAll(userList)
    }

    private fun handleError(t: Throwable) {
        Log.w("RETROFIT", "HAS BEEN AN ERROR: " + t.message)
    }

}