import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RadioClaseA implements RadioUniversal {
    private boolean encendido;
    private int volumen;
    private String banda; // "AM" o "FM"
    private double frecuencia;
    private List<Emisora> emisorasGuardadas;
    private ListaReproduccion listaReproduccionActual;
    private List<ListaReproduccion> listasReproduccion;
    private int indiceCancionActual;
    private boolean telefonoConectado;
    private List<Contacto> contactos;
    private boolean enLlamada;
    private boolean enSpeaker;

    /**
     * Constructor que inicializa un objeto 
     */

    public RadioClaseA() {
        this.encendido = false;
        this.volumen = 5;
        this.banda = "FM";
        this.frecuencia = 88.0;
        this.emisorasGuardadas = new ArrayList<>();
        this.listasReproduccion = new ArrayList<>();
        this.indiceCancionActual = 0;
        this.telefonoConectado = false;
        this.contactos = new ArrayList<>();
        this.enLlamada = false;
        this.enSpeaker = false;
    }

    /**
     * Método para encender la radio.
     */

    public boolean isEncendido() {
        return encendido;
    }

    public boolean isTelefonoConectado() {
        return telefonoConectado;
    }

    public List<ListaReproduccion> getListasReproduccion() {
        return listasReproduccion;
    }

    public void agregarListaReproduccion(ListaReproduccion lista) {
        listasReproduccion.add(lista);
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void cargarListasReproduccionDesdeCSV(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                ListaReproduccion lista = new ListaReproduccion(datos[0]);
                try {
                    for (int i = 1; i < datos.length; i += 4) {
                        String nombre = datos[i];
                        String autor = datos[i + 1];
                        String genero = datos[i + 2];
                        int duracion = Integer.parseInt(datos[i + 3]);
                        lista.agregarCancion(new Cancion(nombre, autor, genero, duracion));
                    }
                    agregarListaReproduccion(lista);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error al procesar la línea: " + linea);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarListasReproduccionEnCSV(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (ListaReproduccion lista : listasReproduccion) {
                StringBuilder datos = new StringBuilder();
                datos.append(lista.getNombre());
                for (Cancion cancion : lista.getCanciones()) {
                    datos.append(",").append(cancion.getNombre());
                    datos.append(",").append(cancion.getAutor());
                    datos.append(",").append(cancion.getGenero());
                    datos.append(",").append(cancion.getDuracion());
                }
                writer.write(datos.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarContactosDesdeCSV(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                agregarContacto(new Contacto(datos[0], datos[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarContactosEnCSV(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Contacto contacto : contactos) {
                writer.write(contacto.getNombre() + "," + contacto.getNumero());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void encender() {
        encendido = true;
    }

    /**
     * Método para apagar la radio.
     */

    @Override
    public void apagar() {
        encendido = false;
    }

    /**
     * Sube el volumen de la radio.
     */

    @Override
    public void subirVolumen() {
        if (encendido) {
            volumen = Math.min(volumen + 1, 10);
        }
    }

    /**
     * Baja el volumen de la radio.
     */

    @Override
    public void bajarVolumen() {
        if (encendido) {
            volumen = Math.max(volumen - 1, 0);
        }
    }

    /**
     * Cambia la banda entre "AM" y "FM".
     */

    @Override
    public void cambiarBanda() {
        if (encendido) {
            banda = banda.equals("FM") ? "AM" : "FM";
        }
    }

    @Override
    public void siguienteEstacion() {
        if (encendido) {
            frecuencia += 0.5;
        }
    }

    @Override
    public void anteriorEstacion() {
        if (encendido) {
            frecuencia -= 0.5;
        }
    }

    /**
     * Guarda una nueva estación en la lista de emisoras guardadas.
     *
     * @param frecuencia La frecuencia de la emisora a guardar.
     */

    @Override
    public void guardarEstacion(double frecuencia) {
        if (encendido) {
            if (emisorasGuardadas.size() < 50) {
                emisorasGuardadas.add(new Emisora(frecuencia, "Emisora " + (emisorasGuardadas.size() + 1)));
            }
        }
    }

    /**
     * Carga una lista de reproducción desde un archivo CSV.
     *
     * @param archivo El archivo CSV que contiene la lista de reproducción.
     */

    @Override
    public void cargarEstacion(int posicion) {
        if (encendido) {
            if (posicion >= 0 && posicion < emisorasGuardadas.size()) {
                frecuencia = emisorasGuardadas.get(posicion).getFrecuencia();
            }
        }
    }

    @Override
    public void seleccionarListaReproduccion(String nombreLista) {
        if (encendido) {
            for (ListaReproduccion lista : listasReproduccion) {
                if (lista.getNombre().equals(nombreLista)) {
                    listaReproduccionActual = lista;
                    indiceCancionActual = 0;
                    return;
                }
            }
        }
    }

    @Override
    public void siguienteCancion() {
        if (encendido && listaReproduccionActual != null) {
            indiceCancionActual = (indiceCancionActual + 1) % listaReproduccionActual.getCanciones().size();
        }
    }

    @Override
    public void anteriorCancion() {
        if (encendido && listaReproduccionActual != null) {
            indiceCancionActual = (indiceCancionActual - 1 + listaReproduccionActual.getCanciones().size()) % listaReproduccionActual.getCanciones().size();
        }
    }

    @Override
    public void reproducirCancion() {
        // No se necesita implementación adicional aquí
    }

    @Override
    public void mostrarInformacionCancionActual() {
        if (encendido && listaReproduccionActual != null) {
            Cancion cancion = listaReproduccionActual.getCanciones().get(indiceCancionActual);
            System.out.println(cancion);
        } else {
            System.out.println("El radio está apagado o no hay lista de reproducción seleccionada.");
        }
    }

    @Override
    public void conectarTelefono() {
        if (encendido) {
            telefonoConectado = true;
        }
    }

    @Override
    public void desconectarTelefono() {
        if (encendido) {
            telefonoConectado = false;
        }
    }

    @Override
    public void mostrarContactos() {
        if (encendido && telefonoConectado) {
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        } else {
            System.out.println("El radio está apagado o el teléfono no está conectado.");
        }
    }

    @Override
    public void llamarContacto(String nombreContacto) {
        if (encendido && telefonoConectado) {
            for (Contacto contacto : contactos) {
                if (contacto.getNombre().equals(nombreContacto)) {
                    enLlamada = true;
                    return;
                }
            }
        }
    }

    @Override
    public void finalizarLlamada() {
        if (encendido && enLlamada) {
            enLlamada = false;
        }
    }

    @Override
    public void cambiarAuriculares() {
        if (encendido && telefonoConectado) {
            enSpeaker = !enSpeaker;
        }
    }

    @Override
    public void planificarViaje() {
        if (encendido) {
            System.out.println("Planificando viaje...");
        } else {
            System.out.println("El radio está apagado.");
        }
    }

    @Override
    public void mostrarEstado() {
        if (encendido) {
            System.out.println("Radio encendido");
            System.out.println("Volumen: " + volumen);
            System.out.println("Banda: " + banda);
            System.out.println("Frecuencia: " + frecuencia);
            if (listaReproduccionActual != null) {
                Cancion cancion = listaReproduccionActual.getCanciones().get(indiceCancionActual);
                System.out.println("Reproduciendo: " + cancion);
            }
            if (telefonoConectado) {
                System.out.println("Teléfono conectado");
                if (enLlamada) {
                    System.out.println("En llamada");
                }
                System.out.println("Modo: " + (enSpeaker ? "Altavoz" : "Auriculares"));
            }
        } else {
            System.out.println("Radio apagado");
        }
    }
}
