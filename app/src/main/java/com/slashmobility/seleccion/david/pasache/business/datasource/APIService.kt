package com.slashmobility.seleccion.david.pasache.business.datasource

import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("groups.json")
    fun fetchGroups(): Single<List<GroupModel>>

    @GET("groups.json")
    fun fetchGroupsCall(): Call<List<GroupModel>>

    @GET("images/{group_id}.json")
    fun fetchImages(@Path(value = "group_id", encoded = true) groupId: String): Single<List<String>>

}