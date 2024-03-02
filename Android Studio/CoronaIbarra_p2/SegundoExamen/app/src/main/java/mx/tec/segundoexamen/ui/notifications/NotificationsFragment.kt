package mx.tec.segundoexamen.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mx.tec.segundoexamen.R
import mx.tec.segundoexamen.adapter.CustomAdapter
import mx.tec.segundoexamen.databinding.FragmentNotificationsBinding
import mx.tec.segundoexamen.model.Recordatorio
import mx.tec.segundoexamen.utility.AppDataBase
import org.json.JSONObject

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var reminderAdapter: CustomAdapter
    private lateinit var listView : ListView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val db = AppDataBase.getInstance(requireContext())!!

        val queue = Volley.newRequestQueue(requireContext())
        val url = "https://apideluna-production.up.railway.app/recordatorio"
        val list = mutableListOf<Recordatorio>()


        binding.btnSync.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
            val localReminders = db.recordatorioDao().obtenerRecordatorios()
            for (reminder in localReminders) {
                val json = JSONObject()
                json.put("titulo", reminder.titulo)
                json.put("descripcion", reminder.descripcion)
                json.put("categoria", reminder.categoria)

                val request = JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    json,
                    Response.Listener { response ->
                        Log.d("RESPONSE", response.toString())
                        Thread {
                            db.recordatorioDao().deleteAll()
                        }.start()
                    },
                    Response.ErrorListener { error ->
                        Log.e("ERROR", error.message.toString())
                    }
                )
                queue.add(request)
            }
        }
    }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}