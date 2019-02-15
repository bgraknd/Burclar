package com.example.bugra.burclar

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        var tek_satir_view = convertView
        var viewHolder: ViewHolder? = null

        if (tek_satir_view == null) {
            var inflater = LayoutInflater.from(gelenContext)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, parent, false)

            viewHolder = ViewHolder(tek_satir_view)
            tek_satir_view.tag = viewHolder

            Log.e("BUGRA", "INFLATION YAPILDI: ${burcAdlari[position]}")
        } else {
            //viewHolder = ViewHolder(tek_satir_view)
            viewHolder = tek_satir_view.getTag() as ViewHolder
        }

/*
        var burcImgageView = tek_satir_view?.imgBurcSembol
        var burcAdi = tek_satir_view?.tvBurcAdi
        var burcTarihi = tek_satir_view?.tvBurcTarihi


        burcImgageView?.setImageResource(burcResimleri[position])
        burcAdi?.setText(burcAdlari[position])
        burcTarihi?.setText(burcTarihleri[position])
*/
        //Log.e("TEST", "" + parent.toString())
        //Log.e("TEST", "" + tek_satir_view.toString())
        //Log.e("TEST", "" + tek_satir_view.parent)
        //Log.e("TEST", "" + tek_satir_view.layoutParams)

        viewHolder.burcResim.setImageResource(burcResimleri[position])
        viewHolder.burcAdi.setText(burcAdlari[position])
        viewHolder.burcTarihi.setText(burcTarihleri[position])

        return tek_satir_view
    }

    class ViewHolder(tek_satir_view: View) {

        var burcResim: ImageView
        var burcAdi: TextView
        var burcTarihi: TextView

        init {
            this.burcResim = tek_satir_view.imgBurcSembol
            this.burcAdi = tek_satir_view.tvBurcAdi
            this.burcTarihi = tek_satir_view.tvBurcTarihi
        }
    }


}