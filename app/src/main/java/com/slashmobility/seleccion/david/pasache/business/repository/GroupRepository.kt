package com.slashmobility.seleccion.david.pasache.business.repository

import com.slashmobility.seleccion.david.pasache.business.datasource.GroupLocalDataSource
import com.slashmobility.seleccion.david.pasache.business.datasource.GroupRemoteDataSource
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GroupRepository @Inject constructor(val groupRemoteDataSource: GroupRemoteDataSource,
                                          val groupLocalDataSource: GroupLocalDataSource) {

    fun getGroups(): Single<List<GroupModel>> {
        return groupRemoteDataSource.fetchGroups()
    }
}