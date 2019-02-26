package com.example.bugra.burclar

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tumBurcBilgileri: ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.statusBarColor)


        veriKaynagiHazirla()

        var myBaseAdapter = BurclarBaseAdapter(this, tumBurcBilgileri)
        listBurclar.adapter = myBaseAdapter

        listBurclar.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(this@MainActivity, DetayActivity::class.java)
            intent.putExtra("tiklanilanOgePosition", i)
            intent.putExtra("tumBurcBilgileri", tumBurcBilgileri)
            startActivity(intent)
        }


    }

    private fun veriKaynagiHazirla() {
        tumBurcBilgileri = ArrayList<Burc>(12)

        var burclar = resources.getStringArray(R.array.burclar)
        var burcTarihleri = resources.getStringArray(R.array.burcTarih)
        var burcResimleri = arrayOf(
            R.drawable.aries1, R.drawable.taurus2, R.drawable.gemini3, R.drawable.cancer4,
            R.drawable.leo5, R.drawable.virgo6, R.drawable.libra7, R.drawable.scorpio8,
            R.drawable.sagittarius9, R.drawable.capricorn10, R.drawable.aquarius11, R.drawable.pisces12
        )
        var burcBuyukResimleri = arrayOf(
            R.drawable.koc_buyuk1, R.drawable.boga_buyuk2, R.drawable.ikizler_buyuk3,
            R.drawable.yengec_buyuk4, R.drawable.aslan_buyuk5, R.drawable.basak_buyuk6,
            R.drawable.terazi_buyuk7, R.drawable.akrep_buyuk8, R.drawable.yay_buyuk9,
            R.drawable.oglak_buyuk10, R.drawable.kova_buyuk11, R.drawable.balik_buyuk12
        )
        var burcGenelOzellikler = resources.getStringArray(R.array.burcGenelOzellikler)

        for (i in 0..11) {
            var arraylisteAtanacakBurc = Burc(
                burclar[i], burcTarihleri[i],
                burcResimleri[i], burcBuyukResimleri[i], burcGenelOzellikler[i]
            )
            tumBurcBilgileri.add(arraylisteAtanacakBurc)
        }
    }
}
