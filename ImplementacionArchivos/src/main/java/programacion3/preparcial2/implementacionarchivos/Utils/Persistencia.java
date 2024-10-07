package programacion3.preparcial2.implementacionarchivos.Utils;

import programacion3.preparcial2.implementacionarchivos.Model.Personajes;

import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    public static final String rutaArchivoLog = "src/main/resources/Log/Log.txt";
    public static final String rutaPersonajesTxt = "src/main/resources/DataBase/personajes.txt";


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


}
