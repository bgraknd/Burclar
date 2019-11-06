package com.example.bugra.burclar

import java.io.Serializable

data class Sign(
    var burcAdi: String, var burcTarih: String, var burcSembol: Int,
    var burcBuyukResim: Int, var burcGenelOzellikleri: String
) : Serializable {
}