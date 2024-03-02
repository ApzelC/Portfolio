package mx.tec.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.pizzeria.databinding.ActivityPizzaBinding

class PizzaActivity : AppCompatActivity() {
    lateinit var binding: ActivityPizzaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPizzaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgPizza2.setImageResource(intent.getIntExtra("imagen", 0))
        binding.txtTitulo2.text = intent.getStringExtra("titulo")
        binding.txtPrecio2.text = intent.getDoubleExtra("precio", 0.0).toString()

        when(binding.txtTitulo2.text) {
            "Peperoni" -> binding.txtDescripcion.text = "Peperoni, queso y salsa de tomate"
            "Jamón" -> binding.txtDescripcion.text = "Jamón, queso y salsa de tomate"
            "Champiñones" -> binding.txtDescripcion.text = "Champiñones, queso y salsa de tomate"
            "Hawaiana" -> binding.txtDescripcion.text = "Piña, jamón, queso y salsa de tomate"
            "Salami" -> binding.txtDescripcion.text = "Salami, queso y salsa de tomate"
            else -> binding.txtDescripcion.text = "Pizza inexistente"
        }

        binding.btnVolver.setOnClickListener{
            val intent = Intent(this@PizzaActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}