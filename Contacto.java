public class Contacto {
    private String nombre;
    private String numero;

    /**
     * Constructor que crea un nuevo contacto con el nombre y número proporcionados.
     *
     * @param nombre El nombre del contacto.
     * @param numero El número de teléfono del contacto.
     */

    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    /**
     * Obtiene el nombre del contacto.
     *
     * @return El nombre del contacto.
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de teléfono del contacto.
     *
     * @return El número de teléfono del contacto.
     */

    public String getNumero() {
        return numero;
    }

    /**
     * Devuelve una representación en cadena del contacto.
     *
     * @return Una cadena que contiene el nombre y número del contacto.
     */

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
