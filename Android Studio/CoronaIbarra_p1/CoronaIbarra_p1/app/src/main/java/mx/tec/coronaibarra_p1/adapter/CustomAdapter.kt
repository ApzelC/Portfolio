package mx.tec.coronaibarra_p1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import mx.tec.coronaibarra_p1.MainActivity
import mx.tec.coronaibarra_p1.MainActivity2
import mx.tec.coronaibarra_p1.MainActivity3
import mx.tec.coronaibarra_p1.R
import mx.tec.coronaibarra_p1.modelo.Elemento

class CustomAdapter (
    private val context: Context,
    private val layout: Int,
    private val datos: List<Elemento>,
) : RecyclerView.Adapter<CustomAdapter.ElementoViewHolder>(){

    interface OnItemClickListener {
        fun onItemClick(elemento: Elemento)
    }

    class ElementoViewHolder(inflater: LayoutInflater, parent: ViewGroup, layout: Int) :
        RecyclerView.ViewHolder(inflater.inflate(layout, parent, false)) {

        var nombre: TextView? = null
        var descripcion: TextView? = null
        var estado: TextView? = null

        init {
            nombre = itemView.findViewById(R.id.tvNombre) as TextView
            descripcion = itemView.findViewById(R.id.tvDescripcion) as TextView
            estado = itemView.findViewById(R.id.tvEstado) as TextView
        }

        fun bindData(elemento: Elemento) {
            nombre!!.text = elemento.nombre
            descripcion!!.text = elemento.descripcion
            estado!!.text = elemento.estado
        }
    }

    private var filteredDatos: List<Elemento> = datos

    override fun getItemCount(): Int {
        return filteredDatos.size
    }

    private var itemClickListener: OnItemClickListener? = null


    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ElementoViewHolder(inflater, parent, layout)
    }

    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        val elemento = filteredDatos[position]
        holder.bindData(elemento)

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(elemento)
        }
    }
    fun updateData(newData: List<Elemento>) {
        filteredDatos = newData
        notifyDataSetChanged()
    }
}