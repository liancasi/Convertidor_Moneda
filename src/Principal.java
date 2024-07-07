import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        while (true) {
            System.out.println("**************************************");
            System.out.println("Sea Bienvenid@ al Conversor de Moneda");
            System.out.println("\n 1) Realizar una conversión" +
                    "\n 2) Ver historial de conversiones" +
                    "\n 3) Salir" +
                    "\n Elija una opción válida: " +
                    "\n *****************************************");

            int opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    realizarConversion(sc, consulta);
                    break;
                case 2:
                    mostrarHistorial(consulta);
                    break;
                case 3:
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void realizarConversion(Scanner sc, ConsultaMoneda consulta) {
        System.out.println("Monedas disponibles:");
        List<String> monedasDisponibles = consulta.obtenerMonedasDisponibles();
        for (int i = 0; i < monedasDisponibles.size(); i++) {
            System.out.println((i + 1) + ") " + monedasDisponibles.get(i));
        }

        System.out.println("Seleccione la moneda de origen (número):");
        int indexOrigen = sc.nextInt() - 1;
        String monedaOrigen = monedasDisponibles.get(indexOrigen);

        System.out.println("Seleccione la moneda de destino (número):");
        int indexDestino = sc.nextInt() - 1;
        String monedaDestino = monedasDisponibles.get(indexDestino);

        System.out.println("Ingrese el valor que deseas convertir: ");
        double valorMoneda = sc.nextDouble();

        Moneda resultado = consulta.convertirMoneda(valorMoneda, monedaOrigen, monedaDestino);
        System.out.println(resultado);
    }

    private static void mostrarHistorial(ConsultaMoneda consulta) {
        List<Moneda> historial = consulta.obtenerHistorial();
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("Historial de conversiones:");
            for (Moneda conversion : historial) {
                System.out.println(conversion);
            }
        }
    }

}
