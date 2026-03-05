package br.edu.fatecpg.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtU = findViewById<EditText>(R.id.edtTensao)
        val edtR = findViewById<EditText>(R.id.edtResistencia)
        val edtI = findViewById<EditText>(R.id.edtCorrente)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val btnAvancar = findViewById<Button>(R.id.btn_segundaTela)

        fun irParaSegundaTela(){
            val segundaTela = Intent(this, SegundaTela::class.java)
            startActivity(segundaTela)
        }

        btnAvancar.setOnClickListener {

            irParaSegundaTela()
        }





        btnCalcular.setOnClickListener {

            val u = edtU.text.toString()
            val r = edtR.text.toString()
            val i = edtI.text.toString()

            // Verifica se pelo menos 2 campos estão preenchidos
            val preenchidos = listOf(u, r, i).count { it.isNotEmpty() }
            if (preenchidos < 2) {
                Toast.makeText(this, "Preencha pelo menos 2 campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (preenchidos > 2) {
                Toast.makeText(this, "Deixe o campo que deseja calcular vazio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val resultado = when {
                    u.isEmpty() -> r.toDouble() * i.toDouble()
                    r.isEmpty() -> u.toDouble() / i.toDouble()
                    i.isEmpty() -> u.toDouble() / r.toDouble()
                    else -> 0.0
                }

                txtResultado.text = "Resultado: %.2f".format(resultado)

            } catch (e: Exception) {
                Toast.makeText(this, "Digite apenas números válidos e positivos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
