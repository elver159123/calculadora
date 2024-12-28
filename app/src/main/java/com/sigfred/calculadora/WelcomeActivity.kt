package com.sigfred.calculadora

import android.content.Intent  // Importa la clase para gestionar los intents
import android.os.Bundle  // Importa la clase para manejar el estado de la actividad
import android.os.Handler  // Importa la clase para manejar la ejecución en segundo plano
import android.os.Looper  // Importa la clase que gestiona el hilo principal de la UI
import android.view.animation.AnimationUtils  // Importa la clase para cargar animaciones
import androidx.appcompat.app.AppCompatActivity  // Importa la clase base para actividades de Android
import com.sigfred.caclculadora.MainActivity  // Importa la actividad principal donde se hace el cálculo
import com.sigfred.caclculadora.R  // Importa los recursos de la app
import com.sigfred.caclculadora.databinding.ActivityWelcomeBinding  // Importa el binding generado por ViewBinding para enlazar las vistas

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding  // Declaración de la variable para el binding

    // Función que se llama cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enlazamos las vistas del layout mediante ViewBinding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)  // Establece el contenido de la actividad con el layout

        // Carga y aplica una animación "rebote" (bounce) al logo (o animación similar)
        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        binding.animationView.startAnimation(logoAnimation)  // Inicia la animación en el logo

        // Carga y aplica una animación de desvanecimiento (fade-in) al texto de bienvenida
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.welcomeText.startAnimation(textAnimation)  // Inicia la animación en el texto

        // Usa un Handler para ejecutar una acción después de un retardo de 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            // Después de 3 segundos, inicia la actividad principal (MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  // Inicia la nueva actividad
            finish()  // Finaliza la actividad de bienvenida para que no pueda ser accedida con el botón de retroceso
        }, 3000) // Establece el retardo en 3 segundos
    }
}
