package com.example.lab5


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.Navigation
import com.example.lab5.databinding.InventariosFragmentBinding
import java.time.LocalDateTime

class finventory : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InventariosFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.inventarios_fragment, container, false
        )
        val adaptador = ArrayAdapter(context, android.R.layout.simple_list_item_1,inventario.globalInventario)
        binding.invs.adapter = adaptador
        binding.nueIn.setOnClickListener(){ view:View->
            val current = LocalDateTime.now()
            val init = arrayListOf<row>()
            val product = product("Nachos", "doritos")
            val row = row(product,9)
            init.add(row)
            val invent = init(init,current)
            inventario.globalInventario.add(invent)
            Navigation.findNavController(view).navigate(R.id.action_finventory_to_flist)
        }
        return binding.root
    }
}
