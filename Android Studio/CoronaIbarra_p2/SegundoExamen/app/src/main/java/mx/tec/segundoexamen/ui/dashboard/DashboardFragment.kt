package mx.tec.segundoexamen.ui.dashboard

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.tec.segundoexamen.databinding.FragmentDashboardBinding
import mx.tec.segundoexamen.model.Recordatorio
import mx.tec.segundoexamen.utility.AppDataBase

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listCategorias = listOf("Importante",   "Útil", "Irrelevante", "Casual")
        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, listCategorias)
        binding.spCategoria.adapter = adapter

        val db = AppDataBase.getInstance(requireContext())

        binding.btnAgregar.setOnClickListener {
            if(binding.edtTitulo.text.isEmpty() || binding.edtDescripcion.text.isEmpty()){
                Toast.makeText(requireContext(), "Favor de llenar todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val recordatorio = Recordatorio(
                    0,
                    binding.edtTitulo.text.toString(),
                    binding.edtDescripcion.text.toString(),
                    binding.spCategoria.selectedItem.toString(),
                )
                Thread {
                    db?.recordatorioDao()?.insertarRecordatorio(recordatorio)
                }.start()
                clearFields()
                Toast.makeText(requireContext(), "Recordatorio agregado", Toast.LENGTH_SHORT).show()
            }

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun clearFields(){
        binding.edtTitulo.text.clear()
        binding.edtDescripcion.text.clear()
        binding.spCategoria.setSelection(0)
    }


}