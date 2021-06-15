package com.ajieno.bansostracking.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajieno.bansostracking.R
import com.ajieno.bansostracking.ui.dasabansosinput.ListBansosInputActivity
import com.ajieno.bansostracking.ui.databansosresult.ListDataBansosActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        cardView5.setOnClickListener {
            val intent = Intent(this, ListDataBansosActivity::class.java)
            startActivity(intent)
        }

        cardView6.setOnClickListener {
            val intent = Intent(this, ListBansosInputActivity::class.java)
            startActivity(intent)
        }
    }
}