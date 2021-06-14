package com.slashmobility.seleccion.david.pasache.business.repository

import com.slashmobility.seleccion.david.pasache.business.datasource.LocalGroupDataSource
import com.slashmobility.seleccion.david.pasache.business.datasource.RemoteGroupDataSource
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Single

class GroupRepository(val remoteGroupDataSource: RemoteGroupDataSource,
                      val localGroupDataSource: LocalGroupDataSource) {

    fun getGroups(): Single<List<GroupModel>> {
        return remoteGroupDataSource.fetchGroups()
    }
}