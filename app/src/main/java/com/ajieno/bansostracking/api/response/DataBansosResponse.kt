package com.ajieno.bansostracking.api.response

import com.google.gson.annotations.SerializedName

data class DataBansosResponse(

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("provinsi")
        val provinsi: String? = null,

        @field:SerializedName("kabkota")
        val kabkota: String? = null,

        @field:SerializedName("kecamatan")
        val kecamatan: String? = null,

        @field:SerializedName("desa")
        val desa: String? = null,

        @field:SerializedName("nik")
        val nik: String? = null,

        @field:SerializedName("nama")
        val nama: String? = null,

        @field:SerializedName("penghasilan")
        val penghasilan: String? = null,

        @field:SerializedName("jmltj")
        val jmltj: String? = null,

        @field:SerializedName("umur")
        val umur: String? = null,

        @field:SerializedName("ibuhamil")
        val ibuhamil: String? = null,

        @field:SerializedName("lansia")
        val lansia: String? = null,

        @field:SerializedName("disable")
        val disable: String? = null,

        @field:SerializedName("jmlmtr")
        val jmlmtr: String? = null,

        @field:SerializedName("jmlmob")
        val jmlmob: String? = null,

        @field:SerializedName("bpnt")
        val bpnt: String? = null,

        @field:SerializedName("bst")
        val bst: String? = null,

        @field:SerializedName("pkh")
        val pkh: String? = null,

        @field:SerializedName("penerima")
        val penerima: String? = null


)