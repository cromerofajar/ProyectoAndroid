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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if(requestCode== reto1Clave){
            if(resultCode== Activity.RESULT_OK){
                if(data.getStringExtra("result1").equals("1999")){
                    butReto1.setBackgroundColor(Color.GREEN)
                    toast("Correcto")
                    butReto1.setEnabled(false)
                }
                else{
                    toast("No es la respuesta correcta")
                }
            }
            else{
                toast("Error al pasar los datos")
            }
        }
        else if(requestCode== reto2Clave){
            if(resultCode== Activity.RESULT_OK){
                if(data.getStringExtra("result2").equals("2")){
                    butReto2.setBackgroundColor(Color.GREEN)
                    toast("Correcto")
                    butReto2.setEnabled(false)
                }
                else{
                    toast("No es la respuesta correcta")
                }
            }
            else{
                toast("Error al pasar los datos")
            }
        }
        else if(requestCode== reto3Clave){
            if(resultCode== Activity.RESULT_OK){
                if(data.getStringExtra("result3").equals("101")){
                    butReto3.setBackgroundColor(Color.GREEN)
                    toast("Correcto")
                    butReto3.setEnabled(false)
                }
                else{
                    toast("No es la respuesta correcta")
                }
            }
            else{
                toast("Error al pasar los datos")
            }
        }
        else if(requestCode== reto4Clave){
            if(resultCode== Activity.RESULT_OK){
                if(data.getStringExtra("result4").equals("si")){
                    butReto4.setBackgroundColor(Color.GREEN)
                    toast("Correcto")
                    butReto4.setEnabled(false)
                }
                else{
                    toast("No es la respuesta correcta")
                }
            }
            else{
                toast("Error al pasar los datos")
            }
        }
    }
}
