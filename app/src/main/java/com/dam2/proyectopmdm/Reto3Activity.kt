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
            val data= Intent()
            val texto=respuestaReto3.text
            data.putExtra("result3",texto.toString())
            setResult(Activity.RESULT_OK,data)
            finish()
        }
    }
}
