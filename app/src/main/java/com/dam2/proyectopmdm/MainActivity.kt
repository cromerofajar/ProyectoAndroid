package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val reto1Clave=0 //codigo del reto1
const val reto2Clave=1 //codigo del reto2
const val reto3Clave=2 //codigo del reto3
const val reto4Clave=3 //codigo del reto4
var respuestasCorrectas=0 //contador de retos pasados
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butReto1.setOnClickListener{
            val intent = Intent(this, Reto1Activity::class.java)
            startActivityForResult(intent, reto1Clave) //El boton 1 te abre el intent del reto1
        }
        butReto2.setOnClickListener{
            val intent = Intent(this, Reto2Activity::class.java)
            startActivityForResult(intent, reto2Clave) //El boton 2 te abre el intent del reto2
        }
        butReto3.setOnClickListener{
            val intent = Intent(this, Reto3Activity::class.java)
            startActivityForResult(intent, reto3Clave) //El boton 3 te abre el intent del reto3
        }
        butReto4.setOnClickListener{
            val intent = Intent(this, Reto4Activity::class.java)
            startActivityForResult(intent, reto4Clave) //El boton 4 te abre el intent del reto4
        }
0    }

    override fun onResume() {
        super.onResume()
        when (respuestasCorrectas){
            1 -> toast("Primer Reto pasado") //En caso de acertar un reto cada actualizacion te mostrar esta toast
            2 -> toast("Ya van dos") //En caso de acertar dos retos cada actualizacion te mostrar esta toast
            3 -> toast("Uno mas y listo") //En caso de acertar tres retos cada actualizacion te mostrar esta toast
            4 -> {
                toast("Listo pasado!") //En caso de acertar cuatro retos cada actualizacion te mostrar esta toast
                val intent = Intent(this, Ganaste::class.java) //Ademas en esta te llevara a un intent nuevo
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        when (requestCode) { //En el activi result comprueba los resultados de los retos segun el requestCode
            reto1Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result1").equals("1999")) { //Comprobacion de que el resultado del reto 1 sea la respuesta correcta
                        butReto1.setBackgroundColor(Color.GREEN) //Cambia el color del boton1 a verde
                        respuestasCorrectas=respuestasCorrectas+1 //Suma uno al contador de retos pasados
                        butReto1.setEnabled(false) //Deshabilita el boton1
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo") //Mensaje al no lograr el objetivo del reto
                    }
                } else {
                    toast("Error al pasar los datos") //Mensaje de error en caso de fallo de la aplicacion
                }
            }
            reto2Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result2").equals("2")) { //Comprobacion de que en el reto 2 sacases la foto
                        butReto2.setBackgroundColor(Color.GREEN) //Cambia el color del boton2 a verde
                        respuestasCorrectas=respuestasCorrectas+1 //Suma uno al contador de retos pasados
                        butReto2.setEnabled(false) //Deshabilita el boton2
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo") //Mensaje al no lograr el objetivo del reto
                    }
                } else {
                    toast("Error al pasar los datos") //Mensaje de error en caso de fallo de la aplicacion
                }
            }
            reto3Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result3").equals("101")) { //Comprobacion de que el resultado del reto 3 sea la respuesta correcta
                        butReto3.setBackgroundColor(Color.GREEN) //Cambia el color del boton3 a verde
                        respuestasCorrectas=respuestasCorrectas+1 //Suma uno al contador de retos pasados
                        butReto3.setEnabled(false) //Deshabilita el boton3
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo") //Mensaje al no lograr el objetivo del reto
                    }
                } else {
                    toast("Error al pasar los datos") //Mensaje de error en caso de fallo de la aplicacion
                }
            }
            reto4Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result4").equals("pasado")) { //Comprobacion de que en el reto 4 acertases todas las preguntas antes de volver
                        butReto4.setBackgroundColor(Color.GREEN) //Cambia el color del boton4 a verde
                        respuestasCorrectas=respuestasCorrectas+1 //Suma uno al contador de retos pasados
                        butReto4.setEnabled(false) //Deshabilita el boton4
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo") //Mensaje al no lograr el objetivo del reto
                    }
                } else {
                    toast("Error al pasar los datos") //Mensaje de error en caso de fallo de la aplicacion
                }

            }
        }
    }
}
