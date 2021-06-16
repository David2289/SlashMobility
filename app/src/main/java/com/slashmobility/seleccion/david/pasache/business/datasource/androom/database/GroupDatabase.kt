package com.example.display.business.datasource.local.androom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.display.business.datasource.local.androom.dao.GroupDao
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel

@Database(
    entities = arrayOf(GroupModel::class),
    version = 1,
    exportSchema = false
)
abstract class GroupDatabase: RoomDatabase() {
    abstract fun groupDao(): GroupDao
}