import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String nombre;
    private List<Cancion> canciones;

    /**
     * Constructor que crea una nueva lista de reproducción con el nombre especificado.
     *
     * @param nombre El nombre de la lista de reproducción.
     */

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    /**
     * Agrega una canción a la lista de reproducción.
     *
     * @param cancion La canción a agregar.
     */

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    /**
     * Obtiene la lista de canciones en la lista de reproducción.
     *
     * @return Una lista de objetos {@code Cancion}.
     */

    public List<Cancion> getCanciones() {
        return canciones;
    }

    /**
     * Obtiene el nombre de la lista de reproducción.
     *
     * @return El nombre de la lista de reproducción.
     */

    public String getNombre() {
        return nombre;
    }
}
