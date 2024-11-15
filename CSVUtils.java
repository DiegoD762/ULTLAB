import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    /**
     * Lee un archivo CSV
     * 
     * @param archivo El nombre del archivo CSV 
     * @return Una lista de arreglos de cadenas, donde cada arreglo representa una fila del archivo CSV
     */

    public static List<String[]> leerCSV(String archivo) {
        List<String[]> datos = new ArrayList<>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                datos.add(valores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    /**
     * Escribe una lista de datos en un archivo csv
     * 
     * @param archivo El nombre del archivo CSV donde se escribirá
     * @param datos Una lista de arreglos de cadenas, donde cada arreglo representa una fila a escribir
     */

    public static void escribirCSV(String archivo, List<String[]> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String[] fila : datos) {
                bw.write(String.join(",", fila));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
