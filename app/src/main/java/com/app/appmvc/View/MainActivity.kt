package com.app.appmvc.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.app.appmvc.Model.CalculatorModel
import com.app.appmvc.R

class MainActivity : AppCompatActivity() {

    private lateinit var calculatorModel: CalculatorModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instanciation du modèle
        calculatorModel = CalculatorModel()

        // Récupération des vues
        val editTextNumber1: EditText = findViewById(R.id.editTextNumber1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumber2)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        // Gestion de l'événement du bouton d'addition
        buttonAdd.setOnClickListener {
            // Récupération des entrées utilisateur
            val number1 = editTextNumber1.text.toString().toDoubleOrNull()
            val number2 = editTextNumber2.text.toString().toDoubleOrNull()

            // Vérification que les entrées ne sont pas nulles
            if (number1 != null && number2 != null) {
                // Utilisation du modèle pour calculer le résultat
                val result = calculatorModel.addNumbers(number1, number2)

                // Mise à jour de la vue avec le résultat
                textViewResult.text = "Result: $result"
            } else {
                textViewResult.text = "Please enter valid numbers"
            }
        }
    }
}