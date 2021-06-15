package com.ajieno.bansostracking.ui.dasabansosinput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajieno.bansostracking.R
import com.ajieno.bansostracking.RetrofitClient
import com.ajieno.bansostracking.api.response.DataBansosResponse
import kotlinx.android.synthetic.main.activity_list_bansos_input.*
import kotlinx.android.synthetic.main.activity_list_data_bansos.add_databansos
import kotlinx.android.synthetic.main.activity_list_data_bansos.progressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListBansosInputActivity : AppCompatActivity() {

    private val list = ArrayList<DataBansosResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_bansos_input)


        rv_databansosinput.setHasFixedSize(true)
        rv_databansosinput.layoutManager = LinearLayoutManager(this)
        getDataBansosInput()

        add_databansos.setOnClickListener {
            val intent = Intent(this, EditDataBansosActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getDataBansosInput(){
        progressBar.visibility = View.VISIBLE
        RetrofitClient.instance2.getlistdatabansos().enqueue(object :
            Callback<ArrayList<DataBansosResponse>> {
            override fun onResponse(
                call: Call<ArrayList<DataBansosResponse>>,
                response: Response<ArrayList<DataBansosResponse>>
            ) {
                progressBar.visibility = View.GONE
                response.body()?.let { list.addAll(it) }
                val adapter =
                    ListBansosInputAdapter(
                        list
                    )
                rv_databansosinput.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<DataBansosResponse>>, t: Throwable) {
                progressBar.visibility = View.GONE
                Toast.makeText(
                    this@ListBansosInputActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        )

    }
}