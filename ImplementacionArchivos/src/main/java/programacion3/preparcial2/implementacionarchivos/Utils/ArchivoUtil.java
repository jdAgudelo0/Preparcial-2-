package programacion3.preparcial2.implementacionarchivos.Utils;

import java.io.IOException;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {

    static String fechaSistema = "";

    public static void guardarRegistroLOG(String mensajeLOG, int nivel, String accion, String rutaArchivo){

        String Log = "";
        Logger logger = Logger.getLogger(accion);
        FileHandler fh = null;
        cargarFechaSistema();

        try{
            fh = new FileHandler(rutaArchivo, true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

            switch(nivel){
                case 1:
                    logger.log(Level.INFO, accion+ " "+ mensajeLOG + " "+ fechaSistema);
                    break;

                case 2:
                    logger.log(Level.WARNING, accion+ " "+ mensajeLOG + " "+ fechaSistema);
                    break;

                case 3:
                    logger.log(Level.CONFIG, accion+ " "+ mensajeLOG + " "+ fechaSistema);
                    break;

                case 4:
                    logger.log(Level.SEVERE, accion+ " "+ mensajeLOG + " "+ fechaSistema);
            }
        }catch (SecurityException e){
            logger.log(Level.SEVERE, e.getMessage());
        }catch (IOException e){
            logger.log(Level.SEVERE, e.getMessage());
        }finally {
            fh.close();
        }

    }

    public static void cargarFechaSistema(){
        String dia_n = "";
        String mes_n = "";

        Calendar cal = Calendar.getInstance();

        int dia = cal.get(Calendar.DATE);
        int mes = cal.get(Calendar.MONTH);
        int anio = cal.get(Calendar.YEAR);
        int hora = cal.get(Calendar.HOUR);

        if(dia < 10 ){
            dia_n = "0"+dia;
        }else{
            dia_n = ""+dia;
        }
        if(mes < 10 ){
            mes_n = "0"+mes;
        }else{
            mes_n = ""+mes;
        }

        fechaSistema = dia_n+"/"+mes_n+"/"+anio+"/"+hora;
    }
}
