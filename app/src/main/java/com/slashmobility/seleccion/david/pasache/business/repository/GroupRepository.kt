package com.slashmobility.seleccion.david.pasache.business.repository

import com.slashmobility.seleccion.david.pasache.business.datasource.GroupLocalDataSource
import com.slashmobility.seleccion.david.pasache.business.datasource.GroupRemoteDataSource
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GroupRepository @Inject constructor(val groupRemoteDataSource: GroupRemoteDataSource,
                                          val groupLocalDataSource: GroupLocalDataSource) {

    fun fetchGroups(): Single<List<GroupModel>> {
        return groupRemoteDataSource.fetchGroups()
    }

    fun getFavoriteList(): List<GroupModel> {
        return groupLocalDataSource.getFavoriteList()
    }

    fun saveFavorite(group: GroupModel) {
        groupLocalDataSource.saveFavorite(group)
    }

    fun deleteFavorite(group: GroupModel) {
        groupLocalDataSource.deleteFavorite(group)
    }

}