//Axel Daniel Corona Ibarra - A01425010@tec.mx

package mx.tec.deluna

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso
import mx.tec.deluna.databinding.FragmentBottonSheetBinding
import mx.tec.deluna.model.BottonSheet
import mx.tec.deluna.ui.home.HomeFragment

class FragmentBottonSheet(
    private val titulo: String,
    private val descripcion: String,
    private val imgNegocio: String,
    private val tipoNegocio: String,
    private val horario: String,
    private val latitud: Double,
    private val longitud: Double,
    private val imgCategoria: Int
) : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentBottonSheetBinding
    private lateinit var bottomView : BottonSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogTheme)
        bottomView = ViewModelProvider(requireActivity()).get(BottonSheet::class.java)
        bottomView.tituloNegocio = titulo
        bottomView.descripcionNegocio = descripcion
        bottomView.imgNegocio = imgNegocio
        bottomView.tipoNegocio = tipoNegocio
        bottomView.horarioNegocio = horario
        bottomView.latitudNegocio = latitud
        bottomView.longitudNegocio = longitud
        bottomView.imgCategoria = imgCategoria


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        bottomView = ViewModelProvider(activity).get(BottonSheet::class.java)

        binding = FragmentBottonSheetBinding.bind(view)

        var titulo: TextView? = null
        var descripcion: TextView? = null
        var imgNegocio: ImageView? = null
        var tipoNegocio: TextView? = null
        var horario: TextView? = null
        var imgCategoria: ImageView? = null


        titulo = view.findViewById(R.id.tvTituloBottomSheet) as TextView
        descripcion = view.findViewById(R.id.tvDescripcionBottomSheet) as TextView
        imgNegocio = view.findViewById(R.id.imgRealBottomSheet) as ImageView
        tipoNegocio = view.findViewById(R.id.tvTipoBottomSheet) as TextView
        horario = view.findViewById(R.id.tvHorarioBottomSheet) as TextView
        imgCategoria = view.findViewById(R.id.imgCategoriaBottomSheet) as ImageView

        titulo.isSelected = true
        titulo!!.text = bottomView.tituloNegocio
        descripcion!!.text = bottomView.descripcionNegocio
        imgCategoria!!.setImageResource(bottomView.imgCategoria)

        Picasso.get().load(bottomView.imgNegocio).into(imgNegocio)
        tipoNegocio!!.text = bottomView.tipoNegocio
        horario!!.text = bottomView.horarioNegocio
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentBottonSheetBinding.inflate(inflater, container, false)

       binding.btnIndication.setOnClickListener {

           val locationManager = requireActivity().getSystemService(LOCATION_SERVICE) as LocationManager

           if (ActivityCompat.checkSelfPermission(
                   requireContext(),
                   Manifest.permission.ACCESS_FINE_LOCATION
               ) == PackageManager.PERMISSION_GRANTED
           ) {
               locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f) { }
           }

           dismiss()
           val currentLocationLat = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.latitude
           val currentLocationLng = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.longitude

           val associationLat = latitud
           val associationLng = longitud

           val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=$currentLocationLat,$currentLocationLng&destination=$associationLat,$associationLng")
           val intent = Intent(Intent.ACTION_VIEW, uri)
           intent.setPackage("com.google.android.apps.maps")

           if (intent.resolveActivity(requireActivity().packageManager) != null) {
               startActivity(intent)
           } else {
               Toast.makeText(requireContext(), "La aplicación de Google Maps no está instalada. Para recibir indicaciones precisa favor de instalarla", Toast.LENGTH_SHORT).show()
           }
         }

        return binding.root
    }
}