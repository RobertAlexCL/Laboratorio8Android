package com.example.lab5


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.lab5.databinding.NuevoFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class new : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding: NuevoFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.nuevo_fragment, container, false
        )

        binding.add.setOnClickListener(){ view:View->
            val nname = binding.editText.text.toString()
            val nid = binding.editText2.text.toString()
            var list = inventario.pro
            var fi = row(product(nname,nid),0)
            list.add(nname)
            inventario.globalInventario[0].Inventory.add(fi)
            Navigation.findNavController(view).navigate(R.id.action_neww_to_fproducts)
        }
        return binding.root
    }

}
