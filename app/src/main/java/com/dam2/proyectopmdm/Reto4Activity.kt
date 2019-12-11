package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto4.*

class Reto4Activity : AppCompatActivity() {
    val pregunta1="¿Esto es una pregunta?"
    val pregunta2="¿La app esta compuesta de 3 restos?"
    val pregunta3="¿El fondo de la pantalla principal es negro?"
    val mensajeFinal ="Ya puede darle a volver"
    val mensajeFinal2 ="Insisto puede darle a volver"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)
        var respuesta =""
        si.setOnClickListener{
            when(preguntasReto4.text){
                pregunta1 -> {
                    preguntasReto4.setText(pregunta2)
                }
                pregunta2 -> {
                    preguntasReto4.setText(pregunta1)
                }
                pregunta3 -> {
                    preguntasReto4.setText(pregunta1)
                }
                mensajeFinal -> {
                    preguntasReto4.setText(mensajeFinal2)
                }
                mensajeFinal2 -> {
                    preguntasReto4.setText(mensajeFinal2)
                }
            }
        }

        no.setOnClickListener{
            when(preguntasReto4.text){
                pregunta1 ->{
                    preguntasReto4.setText(pregunta1)
                }
                pregunta2 -> {
                    preguntasReto4.setText(pregunta3)
                }
                pregunta3 -> {
                    preguntasReto4.setText(mensajeFinal)
                    respuesta ="pasado"
                }
                mensajeFinal -> {
                    preguntasReto4.setText(mensajeFinal2)
                }
                mensajeFinal2 -> {
                    preguntasReto4.setText(mensajeFinal2)
                }
            }
        }

        volverReto4.setOnClickListener{
            val data= Intent()
            data.putExtra("result4",respuesta)
            setResult(Activity.RESULT_OK,data)
            finish()
        }
    }
}

