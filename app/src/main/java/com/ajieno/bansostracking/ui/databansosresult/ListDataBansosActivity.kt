package com.ajieno.bansostracking.ui.databansosresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajieno.bansostracking.R
import com.ajieno.bansostracking.RetrofitClient
import com.ajieno.bansostracking.api.response.DataBansosResponse
import com.ajieno.bansostracking.ui.dasabansosinput.EditDataBansosActivity
import kotlinx.android.synthetic.main.activity_list_data_bansos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListDataBansosActivity : AppCompatActivity() {

    private val list = ArrayList<DataBansosResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data_bansos)


        rv_databansos.setHasFixedSize(true)
        rv_databansos.layoutManager = LinearLayoutManager(this)
        getDataBansos()

        add_databansos.setOnClickListener {
            val intent = Intent(this, EditDataBansosActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getDataBansos(){
        progressBar.visibility = View.VISIBLE
        RetrofitClient.instance.getlistdatabansos().enqueue(object :
                Callback<ArrayList<DataBansosResponse>> {
            override fun onResponse(
                    call: Call<ArrayList<DataBansosResponse>>,
                    response: Response<ArrayList<DataBansosResponse>>
            ) {
                progressBar.visibility = View.GONE
                response.body()?.let { list.addAll(it) }
                val adapter =
                        ListDataBansosAdapter(
                                list
                        )
                rv_databansos.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<DataBansosResponse>>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(
                        this@ListDataBansosActivity,
                        t.message,
                        Toast.LENGTH_SHORT
                ).show()
            }

        }
        )

    }
}