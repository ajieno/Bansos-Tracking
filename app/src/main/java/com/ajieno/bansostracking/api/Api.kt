package com.ajieno.tisol.service

import com.ajieno.bansostracking.api.response.DataBansosResponse
import retrofit2.Call
import retrofit2.http.*


interface Api {

    @GET("result")
    fun getlistdatabansos(): Call<ArrayList<DataBansosResponse>>

    @FormUrlEncoded
    @POST("databansos_id.php")
    fun getdatabansos(
        @Field("id_databansos") user_id: String
    ): Call<DataBansosResponse>

    @GET("result/{id}")
    fun detailresult(
        @Path("id") id: String
    ): Call<DataBansosResponse>

}