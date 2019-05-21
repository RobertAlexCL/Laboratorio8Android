package com.example.lab5


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.example.lab5.databinding.ProductosFragmentBinding

class fproducts: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: ProductosFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.productos_fragment, container, false
        )


        val adaptador = ArrayAdapter(context, android.R.layout.simple_list_item_1,inventario.pro)
        binding.lisxD.adapter = adaptador
        binding.newb.setOnClickListener(){view:View->
            Navigation.findNavController(view).navigate(R.id.action_fproducts_to_nuevo2)
        }
        return binding.root
    }


}
