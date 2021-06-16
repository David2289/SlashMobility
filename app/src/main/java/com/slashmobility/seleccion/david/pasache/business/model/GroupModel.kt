package com.slashmobility.seleccion.david.pasache.business.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "table_group")
data class GroupModel(

    @PrimaryKey
    var id: Int,

    var date: String,

    var dateFormat: String,

    var defaultImageUrl: String,

    var description: String,

    var descriptionShort: String,

    var name: String,

    var isFavorite: Boolean

): Parcelable