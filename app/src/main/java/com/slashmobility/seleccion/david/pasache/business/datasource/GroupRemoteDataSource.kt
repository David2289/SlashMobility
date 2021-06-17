package com.slashmobility.seleccion.david.pasache.business.datasource

import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GroupRemoteDataSource @Inject constructor(val apiService: APIService) {

    fun fetchGroups(): Single<List<GroupModel>> {
        return apiService.fetchGroups()
    }

    fun fetchImages(groupId: String): Single<List<String>> {
        return apiService.fetchImages(groupId)
    }

}