package mx.tec.coronaibarra_p1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import mx.tec.coronaibarra_p1.adapter.CustomAdapter
import mx.tec.coronaibarra_p1.databinding.ActivityMain2Binding
import mx.tec.coronaibarra_p1.modelo.Elemento

class MainActivity2 : AppCompatActivity() , CustomAdapter.OnItemClickListener {
    lateinit var binding: ActivityMain2Binding
    lateinit var ubicacionesList: MutableList<Elemento>
    private var isFiltered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)
        val ubicacionesSet = sharedPreference.getStringSet("ubicaciones", HashSet())
        ubicacionesList = mutableListOf()

        ubicacionesSet?.forEach { ubicacionStr ->
            val ubicacionData = ubicacionStr.split(",")
            if (ubicacionData.size == 5) {
                val ubicacion = Elemento(ubicacionData[0], ubicacionData[1], ubicacionData[2], ubicacionData[3].toDouble(), ubicacionData[4].toDouble())
                ubicacionesList.add(ubicacion)
            }
        }

        //sacar los estados de ubicacionesList
        val estadosList = getEstados()

        val spAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, estadosList)
        binding.spinner.adapter = spAdapter


        val adaptador = CustomAdapter(this@MainActivity2, R.layout.layout_elemento, ubicacionesList)
        adaptador.setOnItemClickListener(this)



        binding.spinner.adapter = spAdapter
        binding.rvLista.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rvLista.setHasFixedSize(true)
        binding.rvLista.adapter = adaptador

        //filtrar la lista por estado
        binding.btnFiltrar.setOnClickListener {
            val selecEstado = binding.spinner.selectedItem.toString()

            if (isFiltered) {
                val listaFiltrada = ubicacionesList.filter { ubicacion ->
                    ubicacion.estado == selecEstado
                }

                (binding.rvLista.adapter as CustomAdapter).updateData(listaFiltrada)
            } else {
                val listaFiltrada = ubicacionesList.filter { ubicacion ->
                    ubicacion.estado == selecEstado
                }

                (binding.rvLista.adapter as CustomAdapter).updateData(listaFiltrada)
                isFiltered = true
            }
        }

        binding.btnQuitar.setOnClickListener {
            if (!isFiltered) {
                return@setOnClickListener
            }
            (binding.rvLista.adapter as CustomAdapter).updateData(ubicacionesList)
            isFiltered = false
        }

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun onItemClick(elemento: Elemento) {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Qué desea hacer?")
        builder.setPositiveButton(("Eliminar")) { dialog, which ->
            ubicacionesList.remove(elemento)
            val estadosnuevos = getEstados()
            val spAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, estadosnuevos)
            binding.spinner.adapter = spAdapter
            val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)
            val ubicacionesSet = HashSet<String>()
            ubicacionesList.forEach { ubicacion ->
                ubicacionesSet.add("${ubicacion.nombre},${ubicacion.descripcion},${ubicacion.estado},${ubicacion.latitud},${ubicacion.longitud}")
            }
            with(sharedPreference.edit()) {
                putStringSet("ubicaciones", ubicacionesSet)
                commit()
            }
            binding.rvLista.adapter?.notifyDataSetChanged()
        }
        builder.setNegativeButton(("Ver mapa")) { dialog, which ->
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            intent.putExtra("latitud", elemento.latitud)
            intent.putExtra("longitud", elemento.longitud)
            intent.putExtra("nombre", elemento.nombre)
            startActivity(intent)
        }
        builder.setNeutralButton(("Cancelar")) { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }

    fun getEstados(): ArrayList<String> {
        val estadosSet = HashSet<String>() // Para almacenar estados únicos
        ubicacionesList.forEach { ubicacion ->
            estadosSet.add(ubicacion.estado)
        }
        val estadosList = ArrayList(estadosSet)
        return estadosList
    }
}

