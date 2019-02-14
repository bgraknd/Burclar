package com.example.bugra.burclar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var burclar = arrayOf("Koç", "Boğa", "İkizler", "Yengeç", "Aslan", "Başak", "Terazi", "Akrep", "Yay", "Oğlak", "Kova", "Balık")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var burclarAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, burclar)

        listBurclar.adapter = burclarAdapter

        /*listBurclar.setOnItemClickListener(object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var gecici = p1 as TextView
                Toast.makeText(this@MainActivity, "Tiklandi: "+gecici.text.toString()+ " Pos: "+p2, Toast.LENGTH_SHORT).show()
            }
        })*/

        listBurclar.setOnItemClickListener { adapterView, view, i, l ->
            var gecici = view as TextView
            Toast.makeText(this@MainActivity, "Tiklandi: "+gecici.text.toString()+ " Pos: "+i, Toast.LENGTH_SHORT).show()
        }
    }
}
