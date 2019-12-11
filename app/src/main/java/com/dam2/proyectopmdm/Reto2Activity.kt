package com.dam2.proyectopmdm

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reto2.*
import org.jetbrains.anko.longToast

class Reto2Activity : Activity() {

    val IMAGEN_CAPTURADA=6


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto2)
        var foto=1

        sacarFoto.setOnClickListener{
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Permission is not granted
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CAMERA
                    )
                ) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    longToast("Permitido")
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.CAMERA),
                        9
                    )
                } else {
                    longToast("Rechazado permanentemente")

                }
            } else {
                longToast("Ya permitido")
                foto=foto+1
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                    takePictureIntent.resolveActivity(packageManager)?.also {
                        startActivityForResult(takePictureIntent, IMAGEN_CAPTURADA)
                    }
                }
            }
        }
        volverReto2.setOnClickListener{
            val data= Intent()  //Creacion del intent a devolver
            data.putExtra("result2",foto.toString()) //Asignacion de nombre y valor a devolver
            setResult(Activity.RESULT_OK,data) //Asignar el result
            finish() //Cerrar este intent para volver al main
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == IMAGEN_CAPTURADA && resultCode == Activity.RESULT_OK) {
            val imagenBitmap = data?.extras?.get("data") as Bitmap
            imagen.setImageBitmap(imagenBitmap)
        }
    }
}
