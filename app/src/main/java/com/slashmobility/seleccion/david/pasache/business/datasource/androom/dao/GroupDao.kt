package com.example.display.business.datasource.local.androom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel

@Dao
interface GroupDao {

    @Query("SELECT * FROM table_group")
    fun getGroups(): List<GroupModel>

    @Insert
    fun insert(group: GroupModel)

    @Delete
    fun delete(group: GroupModel)

}