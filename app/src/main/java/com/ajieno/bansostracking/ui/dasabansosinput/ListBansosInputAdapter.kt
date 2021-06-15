package com.ajieno.bansostracking.ui.dasabansosinput

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajieno.bansostracking.R
import com.ajieno.bansostracking.api.response.DataBansosResponse
import com.ajieno.bansostracking.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.item_bansos.view.*
import kotlin.collections.ArrayList

class ListBansosInputAdapter (private val list: ArrayList<DataBansosResponse>): RecyclerView.Adapter<ListBansosInputAdapter.LaporanViewHolder>(){
    inner class LaporanViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        lateinit var id_databansos: String
        lateinit var nama: String

        fun bind(postResponse: DataBansosResponse){
            with(itemView){

                nik_txt.text = "${postResponse.nik}"
                nama_txt.text = "${postResponse.nama}"

                id_databansos = "${postResponse.nik}"

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaporanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bansos_input, parent, false)
        return LaporanViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaporanViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("Extra_Data", holder.id_databansos)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = list.size


}