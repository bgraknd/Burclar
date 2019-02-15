package com.example.bugra.burclar

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarArrayAdaptor(
    var gelenContext: Context,
    resource: Int,
    textViewResourceId: Int,
    var burcAdlari: Array<String>,
    var burcTarihleri: Array<String>,
    var burcResimleri: Array<Int>
) :
    ArrayAdapter<String>(gelenContext, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var inflater = LayoutInflater.from(gelenContext)
        var tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)

        var burcImgageView = tek_satir_view.imgBurcSembol
        var burcAdi = tek_satir_view.tvBurcAdi
        var burcTarihi = tek_satir_view.tvBurcTarihi

        burcImgageView.setImageResource(burcResimleri[position])
        burcAdi.setText(burcAdlari[position])
        burcTarihi.setText(burcTarihleri[position])

        Log.e("TEST", "" + parent.toString())
        Log.e("TEST", "" + tek_satir_view.toString())
        Log.e("TEST", "" + tek_satir_view.parent)
        Log.e("TEST", "" + tek_satir_view.layoutParams)

        return tek_satir_view
    }


}