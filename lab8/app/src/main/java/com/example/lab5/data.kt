package com.example.lab5

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import java.time.LocalDateTime

class data : ViewModel(){

    var row = MutableLiveData<row>()

    // The current score
    var init = MutableLiveData<init>()


    private fun resetList() {
        inventario.globalInventario.clear()
    }

    var product = MutableLiveData<product>()
    init {
        resetList()
        addPro(product("",""))
        product.value = product("","")
        row.value = row(product("",""),0)
        init.value = init(ArrayList(), LocalDateTime.now())
    }
    private fun addPro(producto: product) {
        inventario.pro.add(producto.name)
    }
}