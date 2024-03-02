//Axel Daniel Corona Ibarra - A01425010@tec.mx

package mx.tec.deluna

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import mx.tec.deluna.databinding.ActivityMainBinding
import mx.tec.deluna.model.Elemento
import org.json.JSONArray
import java.util.Calendar
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var timer: Timer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var datoss: List<Elemento> = recibeDatos()
        Log.d("datitos", datoss.toString())
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        supportActionBar?.hide()
    }

    fun calcularDistancia(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val radioTierra = 6371 // Radio de la Tierra en kilómetros

        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2)
        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

        return radioTierra * c // Distancia en kilómetros
    }

    private fun calcularDisponibilidad(horario: String): String {

        //9:00 a 21:30
        val horarioArray = horario.split(" - ")
        val horaInicio = horarioArray[0].split(":")
        val horaFin = horarioArray[1].split(":")
        val horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val minutoActual = Calendar.getInstance().get(Calendar.MINUTE)
        val horaInicioInt = horaInicio[0].toInt()
        val horaFinInt = horaFin[0].toInt()
        val minutoInicioInt = horaInicio[1].toInt()
        val minutoFinInt = horaFin[1].toInt()
        val horaActualInt = horaActual.toInt()
        val minutoActualInt = minutoActual.toInt()

        if (horaActualInt >= horaInicioInt && horaActualInt <= horaFinInt) {
            if (horaActualInt == horaInicioInt && minutoActualInt < minutoInicioInt) {
                return "Cerrado"
            } else if (horaActualInt == horaFinInt && minutoActualInt > minutoFinInt) {
                return "Cerrado"
            } else {
                return "Abierto"
            }
        } else {
            return "Cerrado"
        }
    }

    override fun onResume() {
        super.onResume()
        val elementosJson = getSharedPreferences("archivo", Context.MODE_PRIVATE).getString("elementosJson", "")

        if(elementosJson != null) {
            actualizarDistanciasYDisponibilidad()
            if (timer == null) {
                timer = Timer()
                timer?.scheduleAtFixedRate(object : TimerTask() {
                    override fun run() {
                        actualizarDistanciasYDisponibilidad()
                    }
                }, 0, 2000)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        timer?.cancel()
        timer = null
    }

    // Función para calcular distancias y disponibilidad
     fun actualizarDistanciasYDisponibilidad() {
        val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)
        val elementosJson = sharedPreference.getString("elementosJson", "")

        if (!elementosJson.isNullOrEmpty()) {
            val gson = Gson()
            try {
                val datos = gson.fromJson(elementosJson, Array<Elemento>::class.java).toList()
                val sharedPreference2 = getSharedPreferences("LatLang", Context.MODE_PRIVATE)
                val latitud = sharedPreference2.getString("latitudActual", "0.0")
                val longitud = sharedPreference2.getString("longitudActual", "0.0")

                datos.forEach { elemento ->
                    val distancia = calcularDistancia(
                        latitud!!.toDouble(),
                        longitud!!.toDouble(),
                        elemento.latitud,
                        elemento.longitud
                    )
                    elemento.distancia = String.format("%.2f", distancia) + " km"
                }
                datos.forEach { elemento ->
                    elemento.disponible = calcularDisponibilidad(elemento.horario)
                }

                Log.d("elementos", datos.toString())
                val elementosJson2 = gson.toJson(datos)
                sharedPreference.edit().putString("elementosJson", elementosJson2).apply()
            } catch (e: Exception) {
                Log.e("Error", "Error al deserializar elementosJson: ${e.message}")
            }
        } else {
            Log.e("Error", "Error al obtener elementosJson")
        }

    }


    fun recibeDatos(): List<Elemento> {

        var queue = Volley.newRequestQueue(this)
        val url = "https://apideluna-production.up.railway.app/api/negocios"
        var datos = mutableListOf<Elemento>()

        val listener = Response.Listener<JSONArray> { response ->
            Log.d("dodo", response.toString())
            for(i in 0 until response.length()) {
                val id = response.getJSONObject(i).getInt("id")
                val imgNegocio = response.getJSONObject(i).getString("imagenNegocio")
                val nombre = response.getJSONObject(i).getString("tituloNegocio")
                val disponible = response.getJSONObject(i).getString("disponible")
                val distancia = response.getJSONObject(i).getString("distancia")
                val descripcion = response.getJSONObject(i).getString("descripcion")
                val insigniaJson = response.getJSONObject(i).getInt("insignia")
                val tipo = response.getJSONObject(i).getString("tipoNegocio")
                val direccion = response.getJSONObject(i).getString("direccion")
                val imgReal = response.getJSONObject(i).getString("imagenRealNegocio")
                val nombreCategoria = response.getJSONObject(i).getString("nombreCategoria")
                val horario = response.getJSONObject(i).getString("horario")
                val latitudNegocio = response.getJSONObject(i).getDouble("latitud")
                val longitudNegocio = response.getJSONObject(i).getDouble("longitud")

                val insignia: Boolean
                if(insigniaJson == 1){
                    insignia = true
                }else{
                    insignia = false
                }

                val imgCategoria : Int
                when(nombreCategoria){
                    "Turismo Consciente" -> {
                        imgCategoria = R.drawable.vector
                    }
                    "Bioconstrucción" -> {
                        imgCategoria = R.drawable.vectorbiocons
                    }
                    "Agricultura Regenerativa" -> {
                        imgCategoria = R.drawable.vector_agri
                    }
                    "Medicina Tradicional" -> {
                        imgCategoria = R.drawable.vector_medi
                    }
                    else -> {
                        imgCategoria = R.drawable.vector
                    }
                }


                var elemento = Elemento(id, imgNegocio, nombre, "Abierto", "1.5 km", imgCategoria, descripcion, insignia, tipo , direccion, imgReal, nombreCategoria, horario, latitudNegocio,  longitudNegocio)
                datos.add(elemento)
                Log.d("dadada", datos.toString())

                val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)
                val sharedPreference2 = getSharedPreferences("LatLang", Context.MODE_PRIVATE)

                val  latitud = sharedPreference2.getString("latitudActual", "0.0")
                val  longitud = sharedPreference2.getString("longitudActual", "0.0")

                datos.forEach { elemento ->
                    val distancia = calcularDistancia(latitud!!.toDouble(), longitud!!.toDouble(), elemento.latitud, elemento.longitud)
                    elemento.distancia = String.format("%.2f", distancia) + " km"
                }

                datos.forEach { elemento ->
                    elemento.disponible = calcularDisponibilidad(elemento.horario)
                }

                val gson = Gson()
                val elementosJson = gson.toJson(datos)
                sharedPreference.edit().putString("elementosJson", elementosJson).apply()

            }
        }

        val error = Response.ErrorListener { error ->
            Log.e("RESTLIBS", error.message!!)
        }
        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, listener, error)
        queue.add(jsonArrayRequest)

        val sharedPreference = getSharedPreferences("archivo", Context.MODE_PRIVATE)
        val sharedPreference2 = getSharedPreferences("LatLang", Context.MODE_PRIVATE)

        return datos
    }
}