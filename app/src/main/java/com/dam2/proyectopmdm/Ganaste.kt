package com.dam2.proyectopmdm

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ganaste.*
import kotlinx.android.synthetic.main.activity_main.*

class Ganaste : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganaste)

        reiniciar.setOnClickListener{ //reinicio del juego restablece todos los valores a por defecto
            butReto1.setEnabled(true)
            butReto1.setBackgroundColor(Color.RED)
            butReto2.setEnabled(true)
            butReto2.setBackgroundColor(Color.RED)
            butReto3.setEnabled(true)
            butReto3.setBackgroundColor(Color.RED)
            butReto4.setEnabled(true)
            butReto4.setBackgroundColor(Color.RED)
            respuestasCorrectas=0;
            finish()
        }
    }
}
