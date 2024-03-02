package mx.tec.calculadoradelunadaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import mx.tec.calculadoradelunadaz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var  binding: ActivityMainBinding
    var tempResult: Double = 0.0
    var currentOperator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCero.setOnClickListener(this)
        binding.btnUno.setOnClickListener(this)
        binding.btnDos.setOnClickListener(this)
        binding.btnTres.setOnClickListener(this)
        binding.btnCuatro.setOnClickListener(this)
        binding.btnCinco.setOnClickListener(this)
        binding.btnSeis.setOnClickListener(this)
        binding.btnSiete.setOnClickListener(this)
        binding.btnOcho.setOnClickListener(this)
        binding.btnNueve.setOnClickListener(this)
        binding.btnMas.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnMenos.setOnClickListener(this)
        binding.btnDivision.setOnClickListener(this)
        binding.btnMulti.setOnClickListener(this)
        binding.btnBorrar.setOnClickListener(this)
    }

    //view es la superclase de todos los elementos graficos
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnCero -> binding.txtResultado.append("0")
            R.id.btnUno -> binding.txtResultado.append("1")
            R.id.btnDos -> binding.txtResultado.append("2")
            R.id.btnTres -> binding.txtResultado.append("3")
            R.id.btnCuatro -> binding.txtResultado.append("4")
            R.id.btnCinco -> binding.txtResultado.append("5")
            R.id.btnSeis -> binding.txtResultado.append("6")
            R.id.btnSiete -> binding.txtResultado.append("7")
            R.id.btnOcho -> binding.txtResultado.append("8")
            R.id.btnNueve -> binding.txtResultado.append("9")
            R.id.btnMas -> {
                if (currentOperator == null) {
                    tempResult = binding.txtResultado.text.toString().toDouble()
                    binding.txtResultado.text = ""
                    currentOperator = "+"
                } else {
                    currentOperator = "+"
                }
            }
            R.id.btnIgual -> {
                val currentValue = binding.txtResultado.text.toString()
                if (currentValue.isNotEmpty()) {
                    val numValue = currentValue.toDouble()
                    when (currentOperator) {
                        "+" -> binding.txtResultado.text = (tempResult + numValue).toString()
                        "-" -> binding.txtResultado.text = (tempResult - numValue).toString()
                        "*" -> binding.txtResultado.text = (tempResult * numValue).toString()
                        "/" -> binding.txtResultado.text = (tempResult / numValue).toString()
                    }
                    currentOperator = null
                }
            }
            R.id.btnMenos -> {
                if(currentOperator == null){
                    tempResult = binding.txtResultado.text.toString().toDouble()
                    binding.txtResultado.text = ""
                    currentOperator = "-"
                } else{
                    currentOperator = "-"
                }
            }

            R.id.btnDivision -> {
                if (currentOperator == null){
                    tempResult = binding.txtResultado.text.toString().toDouble()
                    binding.txtResultado.text = ""
                    currentOperator = "/"
                } else{
                    currentOperator = "/"
                }
            }

            R.id.btnMulti -> {
                if (currentOperator == null){
                    tempResult = binding.txtResultado.text.toString().toDouble()
                    binding.txtResultado.text = ""
                    currentOperator = "*"
                } else{
                    currentOperator = "*"
                }
            }

            R.id.btnBorrar -> {
                binding.txtResultado.text = ""
                tempResult = 0.0
                currentOperator = null
            }
        }
    }
}