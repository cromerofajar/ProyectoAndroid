package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val reto1Clave=0
const val reto2Clave=1
const val reto3Clave=2
const val reto4Clave=3
var respuestasCorrectas=0
class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butReto1.setOnClickListener{
            val intent = Intent(this, Reto1Activity::class.java)
            startActivityForResult(intent, reto1Clave)
        }
        butReto2.setOnClickListener{
            val intent = Intent(this, Reto2Activity::class.java)
            startActivityForResult(intent, reto2Clave)
        }
        butReto3.setOnClickListener{
            val intent = Intent(this, Reto3Activity::class.java)
            startActivityForResult(intent, reto3Clave)
        }
        butReto4.setOnClickListener{
            val intent = Intent(this, Reto4Activity::class.java)
            startActivityForResult(intent, reto4Clave)
        }
    }

    override fun onResume() {
        super.onResume()
        when (respuestasCorrectas){
            1 -> toast("Primer Reto pasado")
            2 -> toast("Ya van dos")
            3 -> toast("Uno mas y listo")
            4 -> {
                toast("Listo pasado!")
                val intent = Intent(this, Ganaste::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        when (requestCode) {
            reto1Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result1").equals("1999")) {
                        butReto1.setBackgroundColor(Color.GREEN)
                        respuestasCorrectas=respuestasCorrectas+1
                        butReto1.setEnabled(false)
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo")
                    }
                } else {
                    toast("Error al pasar los datos")
                }
            }
            reto2Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result2").equals("2")) {
                        butReto2.setBackgroundColor(Color.GREEN)
                        respuestasCorrectas=respuestasCorrectas+1
                        butReto2.setEnabled(false)
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo")
                    }
                } else {
                    toast("Error al pasar los datos")
                }
            }
            reto3Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result3").equals("101")) {
                        butReto3.setBackgroundColor(Color.GREEN)
                        respuestasCorrectas=respuestasCorrectas+1
                        butReto3.setEnabled(false)
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo")
                    }
                } else {
                    toast("Error al pasar los datos")
                }
            }
            reto4Clave -> {
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra("result4").equals("pasado")) {
                        butReto4.setBackgroundColor(Color.GREEN)
                        respuestasCorrectas=respuestasCorrectas+1
                        butReto4.setEnabled(false)
                    } else {
                        toast("Reto no pasado\nVuelva a intentarlo")
                    }
                } else {
                    toast("Error al pasar los datos")
                }

            }
        }
    }
}
