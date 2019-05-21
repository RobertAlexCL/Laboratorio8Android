package com.example.lab5


import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lab5.databinding.ListaFragmentBinding
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.lista_fragment.*
import android.R.attr.data
import android.support.annotation.NonNull
import android.support.v7.widget.helper.ItemTouchHelper
import android.widget.Toast
import com.google.zxing.integration.android.IntentResult



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class flist : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding: ListaFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.lista_fragment, container, false
        )
        var lista = inventario.globalInventario[0].Inventory
        binding.listaItems.layoutManager=LinearLayoutManager(context,LinearLayout.VERTICAL,false)
        val ada = adaptor(lista)
        binding.listaItems.adapter=ada
        setHasOptionsMenu(true)



        var helper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(@NonNull recyclerView: RecyclerView, @NonNull viewHolder: RecyclerView.ViewHolder, @NonNull viewHolder1: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(@NonNull target: RecyclerView.ViewHolder, p1:Int){
                val position = target.getAdapterPosition()
                lista.removeAt(position)
                binding.listaItems.adapter?.notifyDataSetChanged()
            }
        })
        helper.attachToRecyclerView(binding.listaItems)


        binding.b.setOnClickListener(){
            val scanner = IntentIntegrator(activity)
            scanner.initiateScan()
        }
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflowmenu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId!!.equals(R.id.reiniciar)){
            var lista = inventario.globalInventario
            lista[0].Inventory.clear()
            lista.clear()
            listaItems.adapter?.notifyDataSetChanged()
        }
        if(item.itemId.equals(R.id.actual)){
            Toast.makeText(context, "Tiene muchos items en su inventario", Toast.LENGTH_LONG).show()
        }
        return NavigationUI.onNavDestinationSelected(item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
}
