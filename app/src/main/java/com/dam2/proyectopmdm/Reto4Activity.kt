package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto4.*

class Reto4Activity : AppCompatActivity() {
    val pregunta1="¿Esto es una pregunta?" //pregunta1
    val pregunta2="¿La app esta compuesta de 3 restos?" //pregunta2
    val pregunta3="¿El fondo de la pantalla principal es negro?" //pregunta3
    val mensajeFinal ="Ya puede darle a volver" //mensaje final
    val mensajeFinal2 ="Insisto puede darle a volver" //mensaje final 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)
        var respuesta =""
        si.setOnClickListener{
            when(preguntasReto4.text){ //comprobacion de que pregunta es y asignacion de la siguiente en caso de acertar o fallar en el boton si
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
            when(preguntasReto4.text){ //comprobacion de que pregunta es y asignacion de la siguiente en caso de acertar o fallar en el boton no
                pregunta1 ->{
                    preguntasReto4.setText(pregunta1)
                }
                pregunta2 -> {
                    preguntasReto4.setText(pregunta3)
                }
                pregunta3 -> {
                    preguntasReto4.setText(mensajeFinal)
                    respuesta ="pasado" //Al llegar a este punto se le puede dar a volver y ya abrias pasado el reto
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
            val data= Intent() //creacion del intent a devolver
            data.putExtra("result4",respuesta) //Asignacion de nombre y valor a devolver
            setResult(Activity.RESULT_OK,data) //Asignar el result
            finish() //Cerrar este intent para volver al main
        }
    }
}

