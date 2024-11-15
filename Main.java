import java.util.Scanner;

public class Main {

    /**
     * Método principal que inicia el programa y presenta el menú principal.
     * 
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */

    public static void main(String[] args) {
        RadioClaseA radio = new RadioClaseA();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Cargar datos desde archivos CSV
        radio.cargarListasReproduccionDesdeCSV("listas_reproduccion.csv");
        radio.cargarContactosDesdeCSV("contactos.csv");

        while (!exit) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Controles de Radio");
            System.out.println("2. Modo Reproducción");
            System.out.println("3. Modo Teléfono");
            System.out.println("4. Modo Productividad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    menuRadio(radio, scanner);
                    break;
                case 2:
                    menuReproduccion(radio, scanner);
                    break;
                case 3:
                    menuTelefono(radio, scanner);
                    break;
                case 4:
                    menuProductividad(radio, scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        // Guardar datos en archivos CSV antes de salir
        radio.guardarListasReproduccionEnCSV("listas_reproduccion.csv");
        radio.guardarContactosEnCSV("contactos.csv");

        scanner.close();
    }

    /**
     * Muestra el menú de controles de radio y permite al usuario interactuar con la radio.
     *
     * @param radio   La instancia de {@code RadioClaseA}.
     * @param scanner El objeto {@code Scanner} para la entrada del usuario.
     */

    private static void menuRadio(RadioClaseA radio, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Radio:");
            System.out.println("1. Encender/Apagar radio");
            System.out.println("2. Ajustar volumen");
            System.out.println("3. Cambiar banda");
            System.out.println("4. Cambiar estación");
            System.out.println("5. Guardar estación");
            System.out.println("6. Cargar estación");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    if (radio.isEncendido()) {
                        radio.apagar();
                    } else {
                        radio.encender();
                    }
                    radio.mostrarEstado();
                    break;
                case 2:
                    System.out.print("Ingrese '+' para subir volumen o '-' para bajar volumen: ");
                    String vol = scanner.nextLine();
                    if (vol.equals("+")) {
                        radio.subirVolumen();
                    } else if (vol.equals("-")) {
                        radio.bajarVolumen();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    radio.mostrarEstado();
                    break;
                case 3:
                    radio.cambiarBanda();
                    radio.mostrarEstado();
                    break;
                case 4:
                    System.out.print("Ingrese '+' para siguiente estación o '-' para anterior estación: ");
                    String est = scanner.nextLine();
                    if (est.equals("+")) {
                        radio.siguienteEstacion();
                    } else if (est.equals("-")) {
                        radio.anteriorEstacion();
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    radio.mostrarEstado();
                    break;
                case 5:
                    System.out.print("Ingrese la frecuencia a guardar: ");
                    double frecuencia = scanner.nextDouble();
                    radio.guardarEstacion(frecuencia);
                    radio.mostrarEstado();
                    break;
                case 6:
                    System.out.print("Ingrese la posición de la estación a cargar: ");
                    int posicion = scanner.nextInt();
                    radio.cargarEstacion(posicion);
                    radio.mostrarEstado();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * Muestra el menú de reproducción de música.
     *
     * @param radio   La instancia de {@code RadioClaseA}.
     * @param scanner El objeto {@code Scanner} para la entrada del usuario.
     */

    private static void menuReproduccion(RadioClaseA radio, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Reproducción:");
            System.out.println("1. Seleccionar lista de reproducción");
            System.out.println("2. Siguiente canción");
            System.out.println("3. Anterior canción");
            System.out.println("4. Reproducir canción");
            System.out.println("5. Mostrar información de la canción actual");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("Listas de reproducción disponibles:");
                    for (ListaReproduccion lista : radio.getListasReproduccion()) {
                        System.out.println("- " + lista.getNombre());
                    }
                    System.out.print("Ingrese el nombre de la lista de reproducción: ");
                    String nombreLista = scanner.nextLine();
                    radio.seleccionarListaReproduccion(nombreLista);
                    radio.mostrarEstado();
                    break;
                case 2:
                    radio.siguienteCancion();
                    radio.mostrarEstado();
                    break;
                case 3:
                    radio.anteriorCancion();
                    radio.mostrarEstado();
                    break;
                case 4:
                    radio.reproducirCancion();
                    radio.mostrarEstado();
                    break;
                case 5:
                    radio.mostrarInformacionCancionActual();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuTelefono(RadioClaseA radio, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Teléfono:");
            System.out.println("1. Conectar/Desconectar teléfono");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Llamar a contacto");
            System.out.println("4. Finalizar llamada");
            System.out.println("5. Cambiar a altavoz/auriculares");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    if (radio.isTelefonoConectado()) {
                        radio.desconectarTelefono();
                    } else {
                        radio.conectarTelefono();
                    }
                    radio.mostrarEstado();
                    break;
                case 2:
                    radio.mostrarContactos();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a llamar: ");
                    String nombreContacto = scanner.nextLine();
                    radio.llamarContacto(nombreContacto);
                    radio.mostrarEstado();
                    break;
                case 4:
                    radio.finalizarLlamada();
                    radio.mostrarEstado();
                    break;
                case 5:
                    radio.cambiarAuriculares();
                    radio.mostrarEstado();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuProductividad(RadioClaseA radio, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenú Productividad:");
            System.out.println("1. Planificar viaje");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    radio.planificarViaje();
                    radio.mostrarEstado();
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
