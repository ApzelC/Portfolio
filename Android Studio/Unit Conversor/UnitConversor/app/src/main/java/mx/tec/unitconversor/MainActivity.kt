package mx.tec.unitconversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import mx.tec.unitconversor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        unitConverter()
    }

    private fun unitConverter() {
        val listaTipoUnidades = listOf("Longitud", "Masa", "Velocidad", "Temperatura")
        val listaLongitud = listOf(
            "Kilómetros",
            "Metros",
            "Centímetros",
            "Milímetros",
            "Millas",
            "Yardas",
            "Pies",
            "Pulgadas"
        )
        val listaMasa = listOf(
            "Toneladas",
            "Kilogramos",
            "Gramos",
            "Miligramos",
            "Toneladas cortas",
            "Toneladas largas",
            "Libras",
            "Onzas"
        )
        val listaVelocidad = listOf(
            "Metros por segundo",
            "Kilómetros por hora",
            "Millas por hora",
            "Nudos",
            "Pies por segundo"
        )
        val listaTemperatura = listOf("Celsius", "Fahrenheit", "Kelvin")

        val adapter: ArrayAdapter<String>
        val adapterLongitud: ArrayAdapter<String>
        val adapterMasa: ArrayAdapter<String>
        val adapterVelocidad: ArrayAdapter<String>
        val adapterTemperatura: ArrayAdapter<String>

        adapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, listaTipoUnidades)
        adapterLongitud =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, listaLongitud)
        adapterMasa =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, listaMasa)
        adapterVelocidad =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, listaVelocidad)
        adapterTemperatura =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, listaTemperatura)

        binding.spTipoUnidades.adapter = adapter

        binding.spTipoUnidades.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    when (position) {
                        0 -> {
                            binding.spUnidadUno.adapter = adapterLongitud
                            binding.spUnidadDos.adapter = adapterLongitud
                        }

                        1 -> {
                            binding.spUnidadUno.adapter = adapterMasa
                            binding.spUnidadDos.adapter = adapterMasa
                        }

                        2 -> {
                            binding.spUnidadUno.adapter = adapterVelocidad
                            binding.spUnidadDos.adapter = adapterVelocidad
                        }

                        3 -> {
                            binding.spUnidadUno.adapter = adapterTemperatura
                            binding.spUnidadDos.adapter = adapterTemperatura
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        binding.btnConvertir.setOnClickListener {
            val numeroStr = binding.edtNumber.text.toString()

            if (numeroStr.isEmpty()) {
                binding.tvRespuesta.text = ""
                return@setOnClickListener
            }

            val numero = binding.edtNumber.text.toString().toDouble()
            val unidadUno = binding.spUnidadUno.selectedItem.toString()
            val unidadDos = binding.spUnidadDos.selectedItem.toString()

            var resultado = 0.0
            if (unidadUno == unidadDos) {
                binding.tvRespuesta.text = numero.toString()
            } else {
                when (unidadUno) {
                    "Kilómetros" -> {
                        when (unidadDos) {
                            "Metros" -> resultado = numero * 1000
                            "Centímetros" -> resultado = numero * 100000
                            "Milímetros" -> resultado = numero * 1000000
                            "Millas" -> resultado = numero * 0.621371
                            "Yardas" -> resultado = numero * 1093.61
                            "Pies" -> resultado = numero * 3280.84
                            "Pulgadas" -> resultado = numero * 39370.1
                        }
                    }

                    "Metros" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 0.001
                            "Centímetros" -> resultado = numero * 100
                            "Milímetros" -> resultado = numero * 1000
                            "Millas" -> resultado = numero * 0.000621371
                            "Yardas" -> resultado = numero * 1.09361
                            "Pies" -> resultado = numero * 3.28084
                            "Pulgadas" -> resultado = numero * 39.3701
                        }
                    }

                    "Centímetros" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 0.00001
                            "Metros" -> resultado = numero * 0.01
                            "Milímetros" -> resultado = numero * 10
                            "Millas" -> resultado = numero * 0.0000062137
                            "Yardas" -> resultado = numero * 0.0109361
                            "Pies" -> resultado = numero * 0.0328084
                            "Pulgadas" -> resultado = numero * 0.393701
                        }
                    }

                    "Milímetros" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 0.000001
                            "Metros" -> resultado = numero * 0.001
                            "Centímetros" -> resultado = numero * 0.1
                            "Millas" -> resultado = numero * 0.00000062137
                            "Yardas" -> resultado = numero * 0.00109361
                            "Pies" -> resultado = numero * 0.00328084
                            "Pulgadas" -> resultado = numero * 0.0393701
                        }
                    }

                    "Millas" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 1.60934
                            "Metros" -> resultado = numero * 1609.34
                            "Centímetros" -> resultado = numero * 160934
                            "Milímetros" -> resultado = numero * 1609340
                            "Yardas" -> resultado = numero * 1760
                            "Pies" -> resultado = numero * 5280
                            "Pulgadas" -> resultado = numero * 63360
                        }
                    }

                    "Yardas" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 0.0009144
                            "Metros" -> resultado = numero * 0.9144
                            "Centímetros" -> resultado = numero * 91.44
                            "Milímetros" -> resultado = numero * 914.4
                            "Millas" -> resultado = numero * 0.000568182
                            "Pies" -> resultado = numero * 3
                            "Pulgadas" -> resultado = numero * 36
                        }
                    }

                    "Pies" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 0.0003048
                            "Metros" -> resultado = numero * 0.3048
                            "Centímetros" -> resultado = numero * 30.48
                            "Milímetros" -> resultado = numero * 304.8
                            "Millas" -> resultado = numero * 0.000189394
                            "Yardas" -> resultado = numero * 0.333333
                            "Pulgadas" -> resultado = numero * 12
                        }
                    }

                    "Pulgadas" -> {
                        when (unidadDos) {
                            "Kilómetros" -> resultado = numero * 0.0000254
                            "Metros" -> resultado = numero * 0.0254
                            "Centímetros" -> resultado = numero * 2.54
                            "Milímetros" -> resultado = numero * 25.4
                            "Millas" -> resultado = numero * 0.0000157828
                            "Yardas" -> resultado = numero * 0.0277778
                            "Pies" -> resultado = numero * 0.0833333
                        }
                    }

                    "Toneladas" -> {
                        when (unidadDos) {
                            "Kilogramos" -> resultado = numero * 1000
                            "Gramos" -> resultado = numero * 1000000
                            "Miligramos" -> resultado = numero * 1000000000
                            "Toneladas cortas" -> resultado = numero * 1.10231
                            "Toneladas largas" -> resultado = numero * 0.984207
                            "Libras" -> resultado = numero * 2204.62
                            "Onzas" -> resultado = numero * 35274
                        }
                    }

                    "Kilogramos" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 0.001
                            "Gramos" -> resultado = numero * 1000
                            "Miligramos" -> resultado = numero * 1000000
                            "Toneladas cortas" -> resultado = numero * 0.00110231
                            "Toneladas largas" -> resultado = numero * 0.000984207
                            "Libras" -> resultado = numero * 2.20462
                            "Onzas" -> resultado = numero * 35.274
                        }
                    }

                    "Gramos" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 0.000001
                            "Kilogramos" -> resultado = numero * 0.001
                            "Miligramos" -> resultado = numero * 1000
                            "Toneladas cortas" -> resultado = numero * 0.0000011023
                            "Toneladas largas" -> resultado = numero * 0.00000098421
                            "Libras" -> resultado = numero * 0.00220462
                            "Onzas" -> resultado = numero * 0.035274
                        }
                    }

                    "Miligramos" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 0.000000001
                            "Kilogramos" -> resultado = numero * 0.000001
                            "Gramos" -> resultado = numero * 0.001
                            "Toneladas cortas" -> resultado = numero * 0.0000000011023
                            "Toneladas largas" -> resultado = numero * 0.00000000098421
                            "Libras" -> resultado = numero * 0.0000022046
                            "Onzas" -> resultado = numero * 0.000035274
                        }
                    }

                    "Toneladas cortas" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 0.907185
                            "Kilogramos" -> resultado = numero * 907.185
                            "Gramos" -> resultado = numero * 907185
                            "Miligramos" -> resultado = numero * 907185000
                            "Toneladas largas" -> resultado = numero * 0.892857
                            "Libras" -> resultado = numero * 2000
                            "Onzas" -> resultado = numero * 32000
                        }
                    }

                    "Toneladas largas" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 1.01605
                            "Kilogramos" -> resultado = numero * 1016.05
                            "Gramos" -> resultado = numero * 1016050
                            "Miligramos" -> resultado = numero * 1016050000
                            "Toneladas cortas" -> resultado = numero * 1.12
                            "Libras" -> resultado = numero * 2240
                            "Onzas" -> resultado = numero * 35840
                        }
                    }

                    "Libras" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 0.000453592
                            "Kilogramos" -> resultado = numero * 0.453592
                            "Gramos" -> resultado = numero * 453.592
                            "Miligramos" -> resultado = numero * 453592
                            "Toneladas cortas" -> resultado = numero * 0.0005
                            "Toneladas largas" -> resultado = numero * 0.000446429
                            "Onzas" -> resultado = numero * 16
                        }
                    }

                    "Onzas" -> {
                        when (unidadDos) {
                            "Toneladas" -> resultado = numero * 0.0000283495
                            "Kilogramos" -> resultado = numero * 0.0283495
                            "Gramos" -> resultado = numero * 28.3495
                            "Miligramos" -> resultado = numero * 28349.5
                            "Toneladas cortas" -> resultado = numero * 0.00003125
                            "Toneladas largas" -> resultado = numero * 0.0000279018
                            "Libras" -> resultado = numero * 0.0625
                        }
                    }

                    "Metros por segundo" -> {
                        when (unidadDos) {
                            "Kilómetros por hora" -> resultado = numero * 3.6
                            "Millas por hora" -> resultado = numero * 2.23694
                            "Nudos" -> resultado = numero * 1.94384
                            "Pies por segundo" -> resultado = numero * 3.28084
                        }
                    }

                    "Kilómetros por hora" -> {
                        when (unidadDos) {
                            "Metros por segundo" -> resultado = numero * 0.277778
                            "Millas por hora" -> resultado = numero * 0.621371
                            "Nudos" -> resultado = numero * 0.539957
                            "Pies por segundo" -> resultado = numero * 0.911344
                        }
                    }

                    "Millas por hora" -> {
                        when (unidadDos) {
                            "Metros por segundo" -> resultado = numero * 0.44704
                            "Kilómetros por hora" -> resultado = numero * 1.60934
                            "Nudos" -> resultado = numero * 0.868976
                            "Pies por segundo" -> resultado = numero * 1.46667
                        }
                    }

                    "Nudos" -> {
                        when (unidadDos) {
                            "Metros por segundo" -> resultado = numero * 0.514444
                            "Kilómetros por hora" -> resultado = numero * 1.852
                            "Millas por hora" -> resultado = numero * 1.15078
                            "Pies por segundo" -> resultado = numero * 1.68781
                        }
                    }

                    "Pies por segundo" -> {
                        when (unidadDos) {
                            "Metros por segundo" -> resultado = numero * 0.3048
                            "Kilómetros por hora" -> resultado = numero * 1.09728
                            "Millas por hora" -> resultado = numero * 0.681818
                            "Nudos" -> resultado = numero * 0.592484
                        }
                    }

                    "Celsius" -> {
                        when (unidadDos) {
                            "Fahrenheit" -> resultado = numero * 1.8 + 32
                            "Kelvin" -> resultado = numero + 273.15
                        }
                    }

                    "Fahrenheit" -> {
                        when (unidadDos) {
                            "Celsius" -> resultado = (numero - 32) / 1.8
                            "Kelvin" -> resultado = (numero + 459.67) / 1.8
                        }
                    }

                    "Kelvin" -> {
                        when (unidadDos) {
                            "Celsius" -> resultado = numero - 273.15
                            "Fahrenheit" -> resultado = numero * 1.8 - 459.67
                        }
                    }
                }
                binding.tvRespuesta.text = resultado.toString()
            }
        }
    }

}