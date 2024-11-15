public interface RadioUniversal {
    void encender();
    void apagar();
    void subirVolumen();
    void bajarVolumen();
    void cambiarBanda();
    void siguienteEstacion();
    void anteriorEstacion();
    void guardarEstacion(double frecuencia);
    void cargarEstacion(int posicion);
    void seleccionarListaReproduccion(String nombreLista);
    void siguienteCancion();
    void anteriorCancion();
    void reproducirCancion();
    void mostrarInformacionCancionActual();
    void conectarTelefono();
    void desconectarTelefono();
    void mostrarContactos();
    void llamarContacto(String nombreContacto);
    void finalizarLlamada();
    void cambiarAuriculares();
    void planificarViaje();
    void mostrarEstado();
}
