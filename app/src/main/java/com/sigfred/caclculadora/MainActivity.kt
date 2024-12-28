package com.sigfred.caclculadora

import android.graphics.Typeface
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de las vistas (TextViews y operadores)
    private lateinit var resultTextView: TextView  // Muestra el resultado de la operación
    private lateinit var operationMessage: TextView  // Muestra el mensaje de la operación actual
    private var currentInput: String = ""  // Guarda el número o la cadena de entrada actual
    private var operator: String? = null  // Guarda el operador actual (+, -, *, /)
    private var firstOperand: Double? = null  // Guarda el primer operando para la operación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de las vistas (TextViews)
        resultTextView = findViewById(R.id.resultTextView)
        operationMessage = findViewById(R.id.operationMessage)
        operationMessage.typeface = Typeface.SERIF  // Establecer tipo de letra serif para el mensaje de operación

        // Lista de botones numéricos (0-9)
        val buttonNumbers = listOf(
            findViewById<Button>(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )

        // Mapa de botones de operaciones (suma, resta, multiplicación, división)
        val operators = mapOf(
            R.id.buttonAdd to "+",
            R.id.buttonSubtract to "-",
            R.id.buttonMultiply to "*",
            R.id.buttonDivide to "/"
        )

        // Función que asigna el evento a los botones numéricos
        buttonNumbers.forEachIndexed { index, button ->
            button.setOnClickListener {
                appendNumber(index.toString())  // Añadir el número a la entrada actual
            }
        }

        // Función que asigna el evento a los botones de operaciones
        operators.forEach { (buttonId, operatorSymbol) ->
            findViewById<Button>(buttonId).setOnClickListener {
                selectOperator(operatorSymbol)  // Seleccionar la operación correspondiente
            }
        }

        // Función para el botón "igual" (=) que calcula el resultado
        findViewById<Button>(R.id.buttonEquals).setOnClickListener {
            calculateResult()
        }

        // Función para el botón "C" que limpia la entrada y los resultados
        findViewById<Button>(R.id.buttonClear).setOnClickListener {
            clearInput()
        }
    }

    // Función que agrega un número a la entrada actual
    private fun appendNumber(number: String) {
        currentInput += number  // Añadir el número al final de la cadena actual
        resultTextView.text = currentInput  // Mostrar la entrada en el TextView de resultados
    }

    // Función que maneja la selección de un operador (+, -, *, /)
    private fun selectOperator(op: String) {
        firstOperand = currentInput.toDoubleOrNull()  // Guardar el primer operando
        operator = op  // Guardar el operador
        currentInput = ""  // Limpiar la entrada para el siguiente número

        // Mostrar un mensaje animado según la operación seleccionada
        val message = when (op) {
            "+" -> "Suma"
            "-" -> "Resta"
            "*" -> "Multiplicación"
            "/" -> "División"
            else -> ""
        }
        showOperationMessage(message)  // Mostrar el mensaje con la animación
    }

    // Función que muestra el mensaje de la operación con una animación de entrada
    private fun showOperationMessage(message: String) {
        operationMessage.text = message  // Establecer el texto del mensaje
        // Cargar y aplicar la animación
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        operationMessage.startAnimation(fadeIn)  // Aplicar la animación al mensaje
    }

    // Función que calcula el resultado de la operación
    private fun calculateResult() {
        val secondOperand = currentInput.toDoubleOrNull()  // Obtener el segundo operando
        if (firstOperand != null && secondOperand != null && operator != null) {
            // Realizar la operación según el operador seleccionado
            val result = when (operator) {
                "+" -> firstOperand!! + secondOperand
                "-" -> firstOperand!! - secondOperand
                "*" -> firstOperand!! * secondOperand
                "/" -> if (secondOperand != 0.0) firstOperand!! / secondOperand else "Error"  // Prevenir la división por cero
                else -> null
            }
            resultTextView.text = result.toString()  // Mostrar el resultado

            // Mostrar un mensaje de "Resultado" y limpiar la calculadora
            showOperationMessage("Resultado")
            clearCalculation()  // Limpiar los valores de la operación
        }
    }

    // Función que limpia la entrada y los resultados
    private fun clearInput() {
        currentInput = ""  // Limpiar la entrada actual
        resultTextView.text = "0"  // Resetear el resultado a 0
        operationMessage.text = ""  // Limpiar el mensaje de operación
    }

    // Función que limpia las variables de la operación y la entrada
    private fun clearCalculation() {
        firstOperand = null  // Limpiar el primer operando
        operator = null  // Limpiar el operador
        currentInput = ""  // Limpiar la entrada
    }
}


