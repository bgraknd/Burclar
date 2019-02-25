package com.example.bugra.burclar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //var burclar = arrayOf("Koç", "Boğa", "İkizler", "Yengeç", "Aslan", "Başak", "Terazi", "Akrep", "Yay", "Oğlak", "Kova", "Balık")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Bu Alttaki kisimlarda arrayadapter yeterli gelmedigi icin iptal edildi


        //var burclarAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, burclar)
        var burclarAdapter = ArrayAdapter<String>(this, R.layout.tek_satir, R.id.tvBurcAdi, burclar)

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
        */

        var burclar = resources.getStringArray(R.array.burclar)
        var burcTarihleri = resources.getStringArray(R.array.burcTarih)
        var burcResimleri = arrayOf(
            R.drawable.aries1, R.drawable.taurus2, R.drawable.gemini3, R.drawable.cancer4,
            R.drawable.leo5, R.drawable.virgo6, R.drawable.libra7, R.drawable.scorpio8, R.drawable.sagittarius9,
            R.drawable.capricorn10, R.drawable.aquarius11, R.drawable.pisces12
        )
/*arrayadapter ile yapilan ornek
        //var myAdapter = ArrayAdapter<String>(this, R.layout.tek_satir, R.id.tvBurcAdi, burclar)
        var myAdapter =
            BurclarArrayAdaptor(this, R.layout.tek_satir, R.id.tvBurcAdi, burclar, burcTarihleri, burcResimleri)
        listBurclar.adapter = myAdapter
*/

        var myBaseAdapter = BurclarBaseAdapter(this)

        listBurclar.adapter = myBaseAdapter



    }
}
