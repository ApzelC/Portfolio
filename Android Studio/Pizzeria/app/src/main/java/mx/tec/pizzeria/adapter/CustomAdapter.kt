package mx.tec.pizzeria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import mx.tec.pizzeria.R
import mx.tec.pizzeria.model.Elemento


class CustomAdapter(val context: Context, val layout: Int, val datos: List<Elemento>): BaseAdapter() {
    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(layout, parent, false)

        val imgImagen = view.findViewById<ImageView>(R.id.imgImagen)
        val txtTitulo = view.findViewById<TextView>(R.id.txtTitulo)
        val txtPrecio = view.findViewById<TextView>(R.id.txtPrecio)
        val elemento = getItem(position) as Elemento

        imgImagen.setImageResource(elemento.imagen)
        txtTitulo.text = elemento.titulo
        txtPrecio.text = elemento.precio.toString()

        return view
    }
}