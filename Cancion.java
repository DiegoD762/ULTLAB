public class Cancion {
    private String nombre;
    private String autor;
    private String genero;
    private int duracion; 

    /**
     * Constructor que crea una nueva canción con el nombre, autor, género y duración
     *
     * @param nombre   El nombre
     * @param autor    El autor
     * @param genero   El género
     * @param duracion La duración
     */

    public Cancion(String nombre, String autor, String genero, int duracion) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.duracion = duracion;
    }
    /**
     * Obtiene el nombre de la canción
     *
     * @return El nombre de la canción
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene el autor de la canción
     *
     * @return El autor de la canción.
     */

    public String getAutor() {
        return autor;
    }
    /**
     * Obtiene el género musical de la canción.
     *
     * @return El género de la canción.
     */

    public String getGenero() {
        return genero;
    }
    /**
     * Obtiene la duración de la canción en segundos.
     *
     * @return La duración de la canción en segundos.
     */

    public int getDuracion() {
        return duracion;
    }
    /**
     * Devuelve una representación en cadena de la canción.
     *
     * @return Una cadena que contiene el nombre, autor, género y duración de la canción.
     */

    @Override
    public String toString() {
        return "Cancion{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
