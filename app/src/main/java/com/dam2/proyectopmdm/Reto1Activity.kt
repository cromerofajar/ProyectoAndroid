package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto1.*
import org.jetbrains.anko.browse

class Reto1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto1)



        volverReto1.setOnClickListener{
            val data= Intent() //Crecion del intent
            val texto=respuestaReto1.text //Asignacion del codigo de la celda de escritura a una variable
            data.putExtra("result1",texto.toString()) //Asignacion de nombre y valor a devolver
            setResult(Activity.RESULT_OK,data) //Asignar el result
            finish() //Cerrar este intent para volver al main
        }

        ayuda.setOnClickListener{
            browse("https://es.wikipedia.org/wiki/Spyro_2:_En_busca_de_los_talismanes") //Enlace para la ayuda
        }
    }
}
