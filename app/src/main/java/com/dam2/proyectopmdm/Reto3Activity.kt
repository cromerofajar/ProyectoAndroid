package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto3.*

class Reto3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto3)

        volverReto3.setOnClickListener{
            val data= Intent() //Crecion del intent
            val texto=respuestaReto3.text //Asignacion del codigo de la celda de escritura a una variable
            data.putExtra("result3",texto.toString()) //Asignacion de nombre y valor a devolver
            setResult(Activity.RESULT_OK,data) //Asignar el result
            finish() //Cerrar este intent para volver al main
        }
    }
}
