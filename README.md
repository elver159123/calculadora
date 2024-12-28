# Calculadora Básica en Android

Esta es una aplicación Android de una **calculadora básica** desarrollada en Kotlin. La aplicación permite realizar operaciones matemáticas simples como suma, resta, multiplicación y división. A continuación se describe el funcionamiento de la aplicación y cómo ejecutarla en tu dispositivo Android.

## Características

- **Operaciones soportadas**:
  - Suma
  - Resta
  - Multiplicación
  - División
  
- **Funcionalidades**:
  - Ingreso de números mediante botones (0-9).
  - Selección de operaciones matemáticas (+, -, *, /).
  - Cálculo de resultados con el botón de "igual".
  - Limpieza de la entrada y los resultados con el botón "C".
  - Mensaje animado mostrando la operación seleccionada.

## Estructura del Código

La aplicación está construida utilizando Kotlin y la arquitectura básica de una actividad en Android. La lógica de la calculadora se maneja principalmente en `MainActivity.kt`, donde se gestionan las operaciones matemáticas y la interacción con el usuario a través de botones.

### MainActivity

- **resultTextView**: Muestra el número o el resultado de la operación.
- **operationMessage**: Muestra el mensaje de la operación seleccionada (como "Suma", "Resta", etc.).
- **currentInput**: Guarda el número o la cadena de entrada actual.
- **operator**: Guarda el operador matemático seleccionado.
- **firstOperand**: Guarda el primer operando para la operación.

### Funciones principales

- **appendNumber()**: Agrega un número a la entrada actual.
- **selectOperator()**: Establece el operador matemático y prepara la calculadora para la siguiente operación.
- **calculateResult()**: Realiza la operación seleccionada y muestra el resultado.
- **clearInput()**: Limpia la entrada y el resultado de la pantalla.
- **clearCalculation()**: Limpia las variables de la operación (operandos y operador).

## Requisitos

- **Android Studio**: La aplicación está desarrollada en **Android Studio**.
- **Versión mínima de Android**: La aplicación es compatible con dispositivos que ejecutan Android 5.0 (API 21) o superior.
- **Dependencias**: No requiere dependencias externas adicionales, solo las bibliotecas estándar de Android.

## Instalación

1. Clona o descarga este repositorio en tu máquina local.
   
   ```bash
   git clone https://github.com/tu-usuario/calculadora-basica-android.git
2. Abre el proyecto en Android Studio.

3. Conecta tu dispositivo Android o usa un emulador.

4. Ejecuta la aplicación desde Android Studio.

5. Disfruta de tu calculadora básica.

## Uso
Ingresa números utilizando los botones numéricos.
Selecciona una operación (suma, resta, multiplicación, división).
Haz clic en el botón "=" para obtener el resultado.
Si deseas comenzar de nuevo, presiona el botón "C" para borrar la entrada y los resultados.

## Capturas de pantalla
