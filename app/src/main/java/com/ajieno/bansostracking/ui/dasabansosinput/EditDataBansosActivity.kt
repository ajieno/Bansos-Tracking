package com.ajieno.bansostracking.ui.dasabansosinput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.ajieno.bansostracking.R
import com.ajieno.bansostracking.RetrofitClient
import com.ajieno.bansostracking.api.response.DataBansosResponse
import com.ajieno.bansostracking.ui.home.HomeActivity
import com.ajieno.herbi.util.SharedPreference
import kotlinx.android.synthetic.main.activity_edit_data_bansos.*
import retrofit2.Call
import retrofit2.Response

class EditDataBansosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_data_bansos)

        input_btn.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser(){
        val sharedPreference: SharedPreference = SharedPreference(this)

//        if (input_nama.editText?.text.toString().isEmpty()
//            || gender.isEmpty()
//            || input_mail.editText?.text.toString().isEmpty()
//            || input_alamat.editText?.text.toString().isEmpty() ) {
//            Toast.makeText(this, "Data belum lengkap", Toast.LENGTH_SHORT).show()
//            return
//        }

//        progressBar3.visibility = View.VISIBLE
//        btn_register.visibility = View.GONE

        RetrofitClient.instance.inputdatabansos(
            input_nama.editText?.text.toString(),
            input_provinsi.editText?.text.toString(),
            input_kota.editText?.text.toString(),
            input_kecamatan.editText?.text.toString(),
            input_desa.editText?.text.toString(),
            input_nik.editText?.text.toString(),
            input_penghasilan.editText?.text.toString(),
            input_jtanggungjawab.editText?.text.toString(),
            input_umur.editText?.text.toString(),
            input_ibuhamil.editText?.text.toString(),
            input_lansia.editText?.text.toString(),
            input_disabilitas.editText?.text.toString(),
            input_bpnt.editText?.text.toString(),
            input_bst.editText?.text.toString(),
            input_pkh.editText?.text.toString()


        ).enqueue(object : retrofit2.Callback<DataBansosResponse> {
            override fun onResponse(call: Call<DataBansosResponse>, response: Response<DataBansosResponse>) {
//                getdatauser()
                Handler().postDelayed({
//                    progressBar3.visibility = View.GONE
                    Toast.makeText(this@EditDataBansosActivity, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@EditDataBansosActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }, 2000)
            }
            override fun onFailure(call: Call<DataBansosResponse>, t: Throwable) {
//                progressBar3.visibility = View.GONE
                Toast.makeText(this@EditDataBansosActivity, t.message, Toast.LENGTH_SHORT).show()
//                btn_register.visibility = View.VISIBLE
            }

        })
    }
}