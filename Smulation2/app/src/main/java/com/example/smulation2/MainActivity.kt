package com.example.smulation2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.smulation2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/*
1. Crea un proyecto que tenga dos activitys donde se cumpla la siguiente funcionalidad:
a. Primera activity: Muestre dos edittext para introducir nombre y edad (solo numeros) y un botón. Al pulsa el botón pasarán las siguientes acciones:
a.i. En el caso de que alguno de los edit no esté relleno saltará un Snackbar avisando de ello.
a.ii. En el caso de que ambos lo estén, se pasará a la segunda activity con los datos que tengan los edit
b. Segunda activity: Mostrará en un TextView el nombre y edad pasados desde la primera activity
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // acciones() y metemros ahí lo que sigue de aqui

        binding.btnEnviar.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val edad = binding.etEdad.text.toString().trim()

            if (nombre.isEmpty() || edad.isEmpty()) {
                Snackbar.make(binding.root, R.string.error_campos_vacios, Snackbar.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("edad", edad)
                startActivity(intent)
            }
        }
    }
}
