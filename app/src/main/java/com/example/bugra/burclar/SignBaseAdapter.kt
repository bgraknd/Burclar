package com.example.bugra.burclar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.tek_satir.view.*

class BurclarBaseAdapter(context: Context, tumBurcBilgileri: ArrayList<Sign>) : BaseAdapter() {

    var tumBurclar: ArrayList<Sign>
    var context: Context

    init {
        this.tumBurclar = tumBurcBilgileri
        this.context = context
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {

        var tek_satir_view = p1
        var viewHolder: ViewHolder2

        if (tek_satir_view == null) {
            var inflater = LayoutInflater.from(context)
            tek_satir_view = inflater.inflate(R.layout.tek_satir, p2, false)

            viewHolder = ViewHolder2(tek_satir_view)
            tek_satir_view.tag = viewHolder

        } else {
            viewHolder = tek_satir_view.getTag() as ViewHolder2
        }



        viewHolder.burcResim.imgBurcSembol.setImageResource(tumBurclar.get(p0).burcSembol)
        viewHolder.burcAdi.setText(tumBurclar.get(p0).burcAdi)
        viewHolder.burcTarih.setText(tumBurclar.get(p0).burcTarih)

        return tek_satir_view


    }

    override fun getItem(p0: Int): Any {
        return tumBurclar.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumBurclar.size
    }
}

class ViewHolder2(tek_satir_view: View) {
    var burcResim: ImageView
    var burcAdi: TextView
    var burcTarih: TextView

    init {
        this.burcResim = tek_satir_view.imgBurcSembol
        this.burcAdi = tek_satir_view.tvBurcAdi
        this.burcTarih = tek_satir_view.tvBurcTarihi
    }
}