public class Emisora {
    private double frecuencia;
    private String nombre;

    /**
     * Constructor que crea una nueva emisora con la frecuencia y nombre
     *
     * @param frecuencia La frecuencia de la emisora
     * @param nombre     El nombre de la emisora
     */

    public Emisora(double frecuencia, String nombre) {
        this.frecuencia = frecuencia;
        this.nombre = nombre;
    }

    /**
     * la fercuencia de las emisora
     *
     * @return La frecuenci
     */

    public double getFrecuencia() {
        return frecuencia;
    }

    /**
     * Tiene el nombre de la emisorat
     *
     * @return El nombre
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve una representación de la emisora
     *
     * @return Una cadena que contiene la frecuencia y el nombre de la emisora
     */

    @Override
    public String toString() {
        return "Emisora{" +
                "frecuencia=" + frecuencia +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
