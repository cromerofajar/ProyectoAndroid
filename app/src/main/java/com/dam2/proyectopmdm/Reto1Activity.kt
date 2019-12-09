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
            val data= Intent()
            val texto=respuestaReto1.text
            data.putExtra("result1",texto.toString())
            setResult(Activity.RESULT_OK,data)
            finish()
        }

        ayuda.setOnClickListener{
            browse("https://es.wikipedia.org/wiki/Spyro_2:_En_busca_de_los_talismanes")
        }
    }
}
