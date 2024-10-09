package programacion3.preparcial2.implementacionarchivos.Utils;

import programacion3.preparcial2.implementacionarchivos.Model.Enum.TipoGenero;
import programacion3.preparcial2.implementacionarchivos.Model.Netflix;
import programacion3.preparcial2.implementacionarchivos.Model.Personajes;
import programacion3.preparcial2.implementacionarchivos.Model.Series;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persistencia {

    public static final String rutaArchivoLog = "src/main/resources/Log/Log.txt";
    public static final String rutaPersonajesTxt = "src/main/resources/DataBase/personajes.txt";
    public static final String rutaSeriesTxt = "src/main/resources/DataBase/Series.txt";
    public static final  String rutaNetflixDat = "src/main/resources/DataBase/Netflix.dat";
    public static final String rutaNetflixXml = "src/main/resources/DataBase/Netflix.xml";



    public static void guardarLog(String msg, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLOG(msg, nivel, accion, rutaArchivoLog);
    }

    public static void guardarPersonajes(ArrayList<Personajes> personajesLista) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Personajes personaje : personajesLista) {
            contenido.append (personaje.getId()).append(" %% ")
                    .append(personaje.getNombre()).append(" %% ")
                    .append(personaje.getPais()).append(" %% ")
                    .append(personaje.getEdad()).append(" %% ");

            ArrayList<String> codigoPeliculas = personaje.getCodigoPelicula();
            for (String codigoPelicula : codigoPeliculas) {
                contenido.append(codigoPelicula).append(" %% ");
            }

            if(!codigoPeliculas.isEmpty()){
                contenido.setLength(contenido.length()-4);
            }

            contenido.append("\n");
        }

        ArchivoUtil.guardarArchivo(rutaPersonajesTxt, contenido.toString(), false);

    }

    public static ArrayList<Personajes> cargarPersonajes() throws IOException {
        ArrayList<Personajes> personajesLista = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(rutaPersonajesTxt);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            String[] elementos = linea.split(" %% ");


            Personajes personaje = new Personajes();
            personaje.setId(elementos[0]);
            personaje.setNombre(elementos[1]);
            personaje.setPais(elementos[2]);
            personaje.setEdad(Integer.parseInt(elementos[3]));


            if (elementos.length > 4) {
                ArrayList<String> codigoPelicus = new ArrayList<>();
                for (int j = 4; j < linea.length(); j++) {
                    codigoPelicus.add(elementos[j]);
                }

                personaje.setCodigoPelicula(codigoPelicus);
            }
            personajesLista.add(personaje);
        }
        return personajesLista;
    }

    public static void guardarSeries(ArrayList<Series> seriesLista) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (Series series : seriesLista) {
            contenido.append (series.getCodigo()).append(" %% ")
                    .append(series.toString()).append(" %% ")
                    .append(series.getSinopsis()).append(" %% ")
                    .append(series.getFechaInicio()).append(" %% ")
                    .append(series.getTipoGenero()).append(" %% ");

                    ArrayList<Personajes> codigosPersonajes = series.getPersonajes();
                    for (Personajes personaje : codigosPersonajes) {
                        contenido.append(personaje.getId()).append(" %% ");
                    }

                    if (!series.getPersonajes().isEmpty()) {
                        contenido.setLength(contenido.length()-4);
                    }
                    contenido.append("\n");
        }

        ArchivoUtil.guardarArchivo(rutaSeriesTxt, contenido.toString(), false);
    }

    public static ArrayList<Series> cargarSeries() throws IOException {
        ArrayList<Series> seriesLista = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(rutaSeriesTxt);
        String linea = "";

        for (String lineaContenido : contenido) {
            linea = lineaContenido;
            String[] elements = linea.split(" %% ");

            Series serie = new Series();
            serie.setCodigo(elements[0]);
            serie.setSinopsis(elements[1]);
            serie.setSinopsis(elements[2]);
            serie.setFechaInicio(LocalDate.parse(elements[3]));
            serie.setTipoGenero(TipoGenero.valueOf(elements[4]));

            ArrayList<Personajes> personajesLista = new ArrayList<>();
            for (int j = 5; j < elements.length; j++) {
                Personajes personaje = new Personajes();
                personaje.setId(elements[j]);
                personajesLista.add(personaje);
            }
            serie.setPersonajes(personajesLista);
            seriesLista.add(serie);
        }

        return seriesLista;
    }

    public static void guardarBinario(Netflix netflix) throws IOException {
        try{
            ArchivoUtil.salvarSerializable(rutaNetflixDat, netflix);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Netflix cargarBinario() throws IOException {

        Netflix netflix = null;
        try{
            netflix = (Netflix) ArchivoUtil.leerSerializable(rutaNetflixDat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return netflix;
    }

    public static void guardarArchivoXml(Netflix netflix) {

            try{
                ArchivoUtil.salvarArchivoXml(rutaNetflixXml, netflix);
            }catch(Exception e){
                e.printStackTrace();
            }

    }

    public static Netflix cargarArchivoXml() {
        Netflix netflix = null;

        try{
            netflix = (Netflix) ArchivoUtil.cargarArchivoXml(rutaNetflixXml);
        }catch(Exception e){
            e.printStackTrace();
        }
        return netflix;
    }



}
