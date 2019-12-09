package com.dam2.proyectopmdm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto4.*

class Reto4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto4)
        var respuesta ="pepe"
        si.setOnClickListener{
            respuesta="si"
            respuestaDada.setText(respuesta)
        }

        no.setOnClickListener{
            respuesta="no"
            respuestaDada.setText(respuesta)
        }

        volverReto4.setOnClickListener{
            val data= Intent()
            data.putExtra("result4",respuesta)
            setResult(Activity.RESULT_OK,data)
            finish()
        }
    }
}

