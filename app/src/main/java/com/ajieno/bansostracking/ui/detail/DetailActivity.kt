package com.ajieno.bansostracking.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ajieno.bansostracking.R
import com.ajieno.bansostracking.RetrofitClient
import com.ajieno.bansostracking.api.response.DataBansosResponse
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_list_data_bansos.*
import retrofit2.Call
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val extradata = getIntent().getStringExtra("Extra_Data").toString()
        getDataBansos(extradata)


    }

    private fun getDataBansos(extradata: String) {
        progressBar2.visibility = View.VISIBLE
        RetrofitClient.instance.detailresult(extradata)
            .enqueue(object : retrofit2.Callback<DataBansosResponse> {
                override fun onResponse(
                    call: Call<DataBansosResponse>,
                    response: Response<DataBansosResponse>
                ) {
                    det_nik.text = response.body()?.nik.toString()
                    det_nama.text = response.body()?.nama.toString()
                    det_umur.text = response.body()?.umur.toString()
                    det_provinsi.text = response.body()?.provinsi.toString()
                    det_kota.text = response.body()?.kabkota.toString()
                    det_kecamatan.text = response.body()?.kecamatan.toString()
                    det_desa.text = response.body()?.desa.toString()
                    det_penghasilan.text = response.body()?.penghasilan.toString()
                    det_jtanggungjawab.text = response.body()?.jmltj.toString()
                    det_ibuhamil.text = response.body()?.ibuhamil.toString()
                    det_lanjutusia.text = response.body()?.lansia.toString()
                    det_disabilitas.text = response.body()?.disable.toString()
                    det_jmotor.text = response.body()?.jmlmtr.toString()
                    det_jmobil.text = response.body()?.jmlmob.toString()
                    det_bpnt.text = response.body()?.bpnt.toString()
                    det_bst.text = response.body()?.bst.toString()
                    det_pkh.text = response.body()?.pkh.toString()
                    det_penerima.text = response.body()?.penerima.toString()

                    progressBar2.visibility = View.GONE
                }

                override fun onFailure(call: Call<DataBansosResponse>, t: Throwable) {
                    progressBar2.visibility = View.GONE
                    Toast.makeText(this@DetailActivity, t.message, Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}