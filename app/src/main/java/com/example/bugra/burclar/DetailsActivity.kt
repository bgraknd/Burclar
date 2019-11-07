package com.example.bugra.burclar

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        var position = intent.extras.get("tiklanilanOgePosition") as Int
        var tumBurcBilgileri = intent.extras.get("tumBurcBilgileri") as ArrayList<Sign>

        tvBurcOzellikleri.setText(tumBurcBilgileri.get(position).burcGenelOzellikleri)
        header.setImageResource(tumBurcBilgileri.get(position).burcBuyukResim)

        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdi

        var bitmap = BitmapFactory.decodeResource(resources, tumBurcBilgileri.get(position).burcBuyukResim)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener {
            override fun onGenerated(palette: Palette) {
                var color = palette.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color)

                window.statusBarColor = color
            }

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
