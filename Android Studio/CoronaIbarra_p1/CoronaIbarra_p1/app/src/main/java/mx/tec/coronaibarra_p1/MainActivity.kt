package mx.tec.coronaibarra_p1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.tec.coronaibarra_p1.databinding.ActivityMainBinding
import mx.tec.coronaibarra_p1.modelo.Elemento

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val ubicacionesList = mutableListOf<Elemento>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)

        binding.btnEnviar.setOnClickListener {
            val nombre = binding.edtNombre.text.toString()
            val descripcion = binding.edtDescripcion.text.toString()
            val estado = binding.edtEstado.text.toString()
            val latitud = binding.edtLat.text.toString()
            val longitud = binding.edtLon.text.toString()

            if (nombre.isNotEmpty() && descripcion.isNotEmpty() && estado.isNotEmpty() && latitud.isNotEmpty() && longitud.isNotEmpty()) {
                val ubicacion = Elemento(nombre, descripcion, estado, latitud.toDouble(), longitud.toDouble())
                ubicacionesList.add(ubicacion)

                // Guardar la lista de ubicaciones en SharedPreferences
                val ubicacionesSet = HashSet<String>()
                ubicacionesList.forEach { ubicacion ->
                    ubicacionesSet.add("${ubicacion.nombre},${ubicacion.descripcion},${ubicacion.estado},${ubicacion.latitud},${ubicacion.longitud}")
                }

                with(sharedPreference.edit()) {
                    putStringSet("ubicaciones", ubicacionesSet)
                    commit()
                }

                binding.edtNombre.text.clear()
                binding.edtDescripcion.text.clear()
                binding.edtEstado.text.clear()
                binding.edtLat.text.clear()
                binding.edtLon.text.clear()

            } else {
                Toast.makeText(this@MainActivity, "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnVisualizar.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}