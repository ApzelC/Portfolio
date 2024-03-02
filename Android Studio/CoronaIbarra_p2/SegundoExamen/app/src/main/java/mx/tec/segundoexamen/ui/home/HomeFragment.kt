package mx.tec.segundoexamen.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import mx.tec.segundoexamen.adapter.CustomAdapter
import mx.tec.segundoexamen.databinding.FragmentHomeBinding
import mx.tec.segundoexamen.model.Recordatorio
import mx.tec.segundoexamen.utility.AppDataBase
import org.json.JSONArray
import org.json.JSONObject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val db = AppDataBase.getInstance(requireContext())
        val url = "https://apideluna-production.up.railway.app/recordatorio"

        val queue = Volley.newRequestQueue(requireContext())
        val list = mutableListOf<Recordatorio>()

        val listener = Response.Listener<JSONArray> { response ->
            for (j in 0 until response.length()) {
                val jsonObject = response.getJSONObject(j)
                list.add(
                    Recordatorio(
                        jsonObject.getInt("id"),
                        jsonObject.getString("titulo"),
                        jsonObject.getString("descripcion"),
                        jsonObject.getString("categoria")
                    )
                )
            }
            Log.d("LISTA REMOTA", list.toString())
            Thread {
                val recordatorios = db?.recordatorioDao()?.obtenerRecordatorios()
                val listLocal = mutableListOf<Recordatorio>()
                if (recordatorios != null) {
                    for (i in recordatorios){
                        listLocal.add(i)
                    }
                    for (i in listLocal){
                        list.add(i)
                    }
                }
                Log.d("LISTA COMBINADA", list.toString())
                Log.d("LISTALOCAL", listLocal.toString())
                activity?.runOnUiThread {
                    binding.lvRecordatorio.adapter = CustomAdapter(requireContext(), mx.tec.segundoexamen.R.layout.layout_recordatorio_lv, list)
                }
            }.start()
        }


        val errorListener = Response.ErrorListener { error ->
            Log.e("dadada", error.message.toString())
        }

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null, listener, errorListener)
        queue.add(jsonArrayRequest)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}