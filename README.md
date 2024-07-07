# Conversor de Moneda

## Descripción
Este proyecto es un Conversor de Moneda desarrollado en Java que permite a los usuarios realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real. El programa ofrece una interfaz de línea de comandos fácil de usar y proporciona funcionalidades adicionales como un historial de conversiones y soporte para múltiples monedas.

## Características
- Conversión entre múltiples monedas utilizando tasas de cambio en tiempo real.
- Historial de conversiones realizadas.
- Soporte dinámico para una amplia variedad de monedas.
- Registro de conversiones con marca de tiempo.
- Interfaz de usuario intuitiva en línea de comandos.

## Requisitos
- Java 11 o superior
- Biblioteca Gson (para el manejo de JSON)

## Instalación
1. Clone este repositorio:
git clone https://github.com/tu-usuario/conversor-de-moneda.git

2. Navegue al directorio del proyecto:
cd conversor-de-moneda

3. Asegúrese de tener la biblioteca Gson en su classpath. Puede agregarla usando Maven o descargando el JAR y agregándolo manualmente.

## Uso
1. Compile el proyecto:
javac *.java

2. Ejecute el programa:
java Principal

3. Siga las instrucciones en pantalla para realizar conversiones o ver el historial.

## Estructura del Proyecto
- `Principal.java`: Contiene el método main y maneja la interacción con el usuario.
- `Moneda.java`: Representa una conversión de moneda con sus detalles.
- `ConsultaMoneda.java`: Maneja la lógica de conversión y la comunicación con la API de tasas de cambio.

## API Utilizada
Este proyecto utiliza la API de ExchangeRate-API para obtener las tasas de cambio actualizadas. Asegúrese de tener una conexión a Internet activa para que el programa funcione correctamente.

## Contacto
Si tiene alguna pregunta o sugerencia, no dude en contactarme a través de [lacaro@ut.edu.co].
