package com.slashmobility.seleccion.david.pasache.business.datasource

import com.example.display.business.datasource.local.androom.dao.GroupDao
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import javax.inject.Inject

class GroupLocalDataSource @Inject constructor(private val groupDao: GroupDao) {

    fun getFavoriteList(): List<GroupModel> {
        return groupDao.getGroups()
    }

    fun saveFavorite(group: GroupModel) {
        groupDao.insert(group)
    }

}