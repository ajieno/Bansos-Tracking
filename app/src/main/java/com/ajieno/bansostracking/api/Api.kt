package com.ajieno.tisol.service

import com.ajieno.bansostracking.api.response.DataBansosResponse
import retrofit2.Call
import retrofit2.http.*


interface Api {

    @GET("data")
    fun getlistdatabansos(): Call<ArrayList<DataBansosResponse>>

    @FormUrlEncoded
    @POST("databansos_id.php")
    fun getdatabansos(
        @Field("id_databansos") user_id: String
    ): Call<DataBansosResponse>

    @GET("data/{id}")
    fun detailresult(
        @Path("id") id: String
    ): Call<DataBansosResponse>

    @FormUrlEncoded
    @POST("databansos_id.php")
    fun inputdatabansos(
        @Field("nama") nama: String,
        @Field("provisnsi") provinsi: String,
        @Field("kabkota") kabkota: String,
        @Field("kecamatan") kecamatan: String,
        @Field("desa") desa: String,
        @Field("nik") nik: String,
        @Field("penghasilan") penghasilan: String,
        @Field("jmltj") jmltj: String,
        @Field("umur") umur: String,
        @Field("ibuhamil") ibuhamil: String,
        @Field("lansia") lansia: String,
        @Field("disable") disable: String,
        @Field("bpnt") bpnt: String,
        @Field("bst") bst: String,
        @Field("pkh") pkh: String



    ): Call<DataBansosResponse>



}