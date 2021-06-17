package com.slashmobility.seleccion.david.pasache.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.business.repository.GroupRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ImagesViewModel @Inject constructor(private val groupRepository: GroupRepository): ViewModel() {

    var errorFetchLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var imageListLiveData: MutableLiveData<List<String>> = MutableLiveData()
    var imageList: ArrayList<String> = ArrayList()


    public fun getImages(groupId: String) {
        groupRepository.fetchImages(groupId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleListResponse, this::handleError)
    }

    private fun handleListResponse(groupList: List<String>) {
        this.imageList.clear()
        this.imageList.addAll(groupList)
        imageListLiveData.value = this.imageList
    }

    private fun handleError(t: Throwable) {
        Log.w("RETROFIT", "HAS BEEN AN ERROR: " + t.message)
        errorFetchLiveData.value = true
    }

}