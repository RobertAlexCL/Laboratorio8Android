package com.example.lab5

import android.app.Application
import java.util.*

/*
Clase Inventario, solo esta conformada por una variable global la cual es una lista que recibe obejetos de tipo fila
 */
class inventario: Application(){
    override fun toString(): String {
        return "Producto: "+ globalInventario[0].Inventory[0].product.name+"Cantidad: "+globalInventario[0].Inventory[0].q
    }

    companion object{var globalInventario: ArrayList<init> = arrayListOf()
        var pro: ArrayList<String> = arrayListOf()}



}