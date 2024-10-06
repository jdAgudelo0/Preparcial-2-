package programacion3.preparcial2.implementacionarchivos.Utils;

public class Persistencia {

    public static final String rutaArchivoLog = "src/main/resources/Log/Log.txt";


    public static void guardarLog(String msg, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLOG(msg, nivel, accion, rutaArchivoLog);
    }

}
