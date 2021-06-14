package com.slashmobility.seleccion.david.pasache.business.datasource

import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("groups.json")
    fun fetchGroups(): Single<List<GroupModel>>

}