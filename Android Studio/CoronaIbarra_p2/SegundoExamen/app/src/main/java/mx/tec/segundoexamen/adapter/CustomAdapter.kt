package mx.tec.segundoexamen.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.tec.segundoexamen.R
import mx.tec.segundoexamen.model.Recordatorio


class CustomAdapter(val context: Context, val layout: Int, val datos: List<Recordatorio>): BaseAdapter() {
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

        val tvTitulo = view.findViewById<TextView>(R.id.tvTituloRecor)
        val tvDescripcion = view.findViewById<TextView>(R.id.tvDescripcionRecor)
        val tvCategoria = view.findViewById<TextView>(R.id.tvCategoriaRecor)

        val recordatorio = getItem(position) as Recordatorio

        tvTitulo.text = recordatorio.titulo
        tvDescripcion.text = recordatorio.descripcion
        tvCategoria.text = recordatorio.categoria

        return view
    }
}