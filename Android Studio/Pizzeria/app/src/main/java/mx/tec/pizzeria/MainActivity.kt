package mx.tec.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tec.pizzeria.adapter.CustomAdapter
import mx.tec.pizzeria.databinding.ActivityMainBinding
import mx.tec.pizzeria.model.Elemento

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val datos = listOf(
            Elemento(R.drawable.pizza_pep, "Peperoni", 120.00),
            Elemento(R.drawable.pizza_jamon, "Jamón", 130.00),
            Elemento(R.drawable.pizza_champi, "Champiñones", 130.00),
            Elemento(R.drawable.pizza_hawai, "Hawaiana", 140.00),
            Elemento(R.drawable.pizza_salam, "Salami", 140.00)
        )

        val adaptador = CustomAdapter(this@MainActivity, R.layout.layout_pizza, datos)

        binding.lvLista.adapter = adaptador

        binding.lvLista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, PizzaActivity::class.java)
            intent.putExtra("imagen", datos[position].imagen)
            intent.putExtra("titulo", datos[position].titulo)
            intent.putExtra("precio", datos[position].precio)
            startActivity(intent)
        }
    }
}