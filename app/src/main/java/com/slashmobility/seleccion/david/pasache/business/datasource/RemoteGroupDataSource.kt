package com.slashmobility.seleccion.david.pasache.business.datasource

import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Single

class RemoteGroupDataSource(val apiService: APIService) {

    fun fetchGroups(): Single<List<GroupModel>> {
        return apiService.fetchGroups()
    }

}