package com.slashmobility.seleccion.david.pasache.business.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GroupModel(
    var date: String,
    var dateFormat: String,
    var defaultImageUrl: String,
    var description: String,
    var descriptionShort: String,
    var id: Int,
    var name: String
): Parcelable