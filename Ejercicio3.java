import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Deque<String> pendientes = new ArrayDeque<>();
        Deque<String> historial = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("--- Seguimiento del Gestor de Impresiones ---");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar documento");
            System.out.println("2. Imprimir siguiente");
            System.out.println("3. Recuperar ultima impresion");
            System.out.println("4. Mostrar pendientes");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del documento: ");
                    String nombre = scanner.nextLine();
                    registrarDocumento(pendientes, nombre);
                    break;

                case 2:
                    imprimirSiguiente(pendientes, historial);
                    break;

                case 3:
                    recuperarUltima(pendientes, historial);
                    break;

                case 4:
                    mostrarPendientes(pendientes);
                    break;

                case 5:
                    mostrarHistorial(historial);
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }

    public static void registrarDocumento(Deque<String> pendientes, String nombre) {
        pendientes.offerLast(nombre);
        System.out.println("[Registro] -> Entra a pendientes: " + nombre);
    }

    public static void imprimirSiguiente(Deque<String> pendientes, Deque<String> historial) {
        if (pendientes.isEmpty()) {
            System.out.println("[Impresion] -> Denegado: no hay documentos esperando.");
            return;
        }

        String documento = pendientes.pollFirst();
        historial.push(documento);
        System.out.println("[Impresion] -> Impreso y guardado en historial: " + documento);
    }

    public static void recuperarUltima(Deque<String> pendientes, Deque<String> historial) {
        if (historial.isEmpty()) {
            System.out.println("[Recuperacion] -> Denegado: todavia no hay nada impreso.");
            return;
        }

        String documento = historial.pop();
        pendientes.addFirst(documento);
        System.out.println("[Recuperacion] -> Devuelto al inicio de pendientes: " + documento);
    }

    public static void mostrarPendientes(Deque<String> pendientes) {
        if (pendientes.isEmpty()) {
            System.out.println("No hay documentos pendientes.");
            return;
        }

        System.out.println("Documentos pendientes:");
        for (String documento : pendientes) {
            System.out.println("- " + documento);
        }
    }

    public static void mostrarHistorial(Deque<String> historial) {
        if (historial.isEmpty()) {
            System.out.println("No hay historial de impresion.");
            return;
        }

        System.out.println("Historial de impresion:");
        for (String documento : historial) {
            System.out.println("- " + documento);
        }
    }
}
