package br.edu.fatecpg.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda_tela)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

        val btnVoltar = findViewById<Button>(R.id.btn_voltarPrimeiraTela)

        fun VoltarPrimeiraTela(){
            val VoltarPraPrimeiraTela = Intent(this, MainActivity::class.java)
            startActivity(VoltarPraPrimeiraTela)
        }

        btnVoltar.setOnClickListener {

            VoltarPrimeiraTela()
        }

    }
}