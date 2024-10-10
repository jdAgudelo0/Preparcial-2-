package programacion3.preparcial2.implementacionarchivos.Controller;

import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Exceptions.SeriesException;
import programacion3.preparcial2.implementacionarchivos.Model.Netflix;
import programacion3.preparcial2.implementacionarchivos.Model.Personajes;
import programacion3.preparcial2.implementacionarchivos.Model.Series;
import programacion3.preparcial2.implementacionarchivos.Utils.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

import static programacion3.preparcial2.implementacionarchivos.Utils.Persistencia.*;

public class ModelFactory {

    Netflix netflix;

    public static class SingletonHolder {
        private final static ModelFactory INSTANCE;

        static {
            try{
                INSTANCE = new ModelFactory();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public static ModelFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public Netflix getNetflix(){
        return netflix;
    }

    private ModelFactory() throws IOException {
        netflix = new Netflix();

        cargarDatos();
        cargarBinario();
        guardarBinario();
        cargarArchivoXml();
        guardarArchivoXml();


        guardarLog("inicio de sesion", 1, "la app se incio");
    }

    public int addPersonaje(Personajes personaje) throws PersonajeException {
        if(!getNetflix().persoajeExist(personaje.getId())){
            getNetflix().addPersonaje(personaje);
            salvarDatos();
            guardarLog("se esta agrgando un perosnaje", 1,"registro");
            return 1;
        }else {
            return 0;
        }
    }

    public int deletePersonaje(Personajes personaje) throws PersonajeException {
        if(getNetflix().persoajeExist(personaje.getId())){
            getNetflix().removePersonaje(personaje);
            salvarDatos();
            guardarLog("se esta eliminando un perosnaje", 3,"eliminar");
            return 1;
        }else {
            return 0;
        }
    }

    public boolean updatePersonaje(Personajes personaje, String id) throws PersonajeException {
        getNetflix().updatePersonaje(personaje, id);
        salvarDatos();
        guardarLog("se esta actualizando el personaje", 2,"actualizar");
        return true;

    }

    public ArrayList<Personajes> obtenerPersonajes() throws PersonajeException {
        return getNetflix().obtenerPersonajes();
    }

    private void salvarDatos(){
        try{
            Persistencia.guardarPersonajes(getNetflix().obtenerPersonajes());
            Persistencia.guardarSeries(getNetflix().obtenerSeries());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void cargarDatos(){
        try{
            getNetflix().obtenerPersonajes().addAll(Persistencia.cargarPersonajes());
            getNetflix().obtenerSeries().addAll(Persistencia.cargarSeries());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public int addSerie(Series serie) throws SeriesException {

        if (!getNetflix().serieExist(serie.getCodigo())){
            getNetflix().addSerie(serie);
            salvarDatos();
            guardarLog("se esta agrgando un serie", 1,"registro");
            return 1;
        }else{
            return 0;
        }
    }

    public int deleteSerie(Series serie) throws SeriesException {
        if (getNetflix().serieExist(serie.getCodigo())){
            getNetflix().removeSerie(serie);
            salvarDatos();
            guardarLog("se esta eliminando un serie", 3,"eliminar");
            return 1;
        }else{
            return 0;
        }
    }

    public boolean updateSerie(Series serie, String codigoPelicula) throws SeriesException {
        getNetflix().updateSerie(serie, codigoPelicula);
        salvarDatos();
        guardarLog("se esta actualizando un serie", 2,"actualizar");
        return true;

    }

    public ArrayList<Series> obtenerSeries() throws SeriesException {
        return getNetflix().obtenerSeries();
    }

    private void guardarBinario() throws IOException {
        Persistencia.guardarBinario(netflix);
    }

    private void cargarBinario() throws IOException {
        netflix = Persistencia.cargarBinario();
    }

    public void guardarArchivoXml() throws IOException {
        Persistencia.guardarArchivoXml(netflix);
    }

    public void cargarArchivoXml() throws IOException {
        netflix= Persistencia.cargarArchivoXml();
    }



}
