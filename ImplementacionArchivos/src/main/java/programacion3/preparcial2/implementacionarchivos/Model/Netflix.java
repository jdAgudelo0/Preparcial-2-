package programacion3.preparcial2.implementacionarchivos.Model;

import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Exceptions.SeriesException;


import java.io.Serializable;
import java.util.ArrayList;

public class Netflix implements Serializable {

    private static final long serialVersionUID = 1L;

    public Netflix() {}

    private ArrayList<Personajes> listaPersonajes = new ArrayList();
    private ArrayList<Series> listaSeries = new ArrayList();

    public ArrayList<Personajes> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    public ArrayList<Series> getListaSeries() {
        return listaSeries;
    }

    public void setListaSeries(ArrayList<Series> listaSeries) {
        this.listaSeries = listaSeries;
    }


    public void addPersonaje(Personajes personaje) throws PersonajeException {
        if(personaje == null){
            throw new PersonajeException("El personaje no puede ser nulo");
        }else {
            listaPersonajes.add(personaje);
        }
    }

    public void removePersonaje(Personajes personaje) throws PersonajeException {
        if(personaje == null){
            throw new PersonajeException("El personaje no puede ser nulo");
        }else{
            listaPersonajes.remove(personaje);
        }
    }

    public void updatePersonaje(Personajes personajeActualizado, String id) throws PersonajeException {
        if(personajeActualizado == null){
            throw new PersonajeException("El personaje no puede ser nulo");
        }else{
            for(Personajes personaje : listaPersonajes){
                if(personaje.getId().equals(id)){
                    listaPersonajes.set(listaPersonajes.indexOf(personaje), personajeActualizado);
                    break;
                }
            }
        }
    }

    public void addSerie(Series serie) throws SeriesException {
        if(serie == null){
            throw new SeriesException("El serie no puede ser nulo");
        }else{
            listaSeries.add(serie);
        }
    }

    public void removeSerie(Series serie) throws SeriesException {
        if(serie == null){
            throw new SeriesException("El serie no puede ser nulo");
        }else{
            listaSeries.remove(serie);
        }
    }

    public void updateSerie(Series serieActualizado, String codigo) throws SeriesException {
        if(serieActualizado == null){
            throw new SeriesException("El serie no puede ser nulo");
        }else{
            for(Series serie : listaSeries){
                if(serie.getCodigo().equals(codigo)){
                    listaSeries.set(listaSeries.indexOf(serie), serieActualizado);
                    break;
                }
            }
        }
    }

    public boolean persoajeExist(String id){
        return listaPersonajes.stream().anyMatch(p -> p.getId().equals(id));
    }

    public boolean serieExist(String codigo){
        return listaSeries.stream().anyMatch(p -> p.getCodigo().equals(codigo));
    }

    public ArrayList<Personajes> obtenerPersonajes() {
        return listaPersonajes;
    }

    public ArrayList<Series> obtenerSeries() {
        return listaSeries;
    }

    public Series hallarSerie(String codigo){
        return listaSeries.stream().filter(p -> p.getCodigo().equals(codigo)).findFirst().get();
    }

    public Personajes hallarPersonaje(String codigo){
        return listaPersonajes.stream().filter(p -> p.getId().equals(codigo)).findFirst().get();
    }

    public void agregrarPersonajeSerie(String id, String codigo){
        Series serie = hallarSerie(codigo);
        Personajes personaje = hallarPersonaje(id);
        serie.getPersonajes().add(personaje);
        personaje.getCodigoPelicula().add(serie.getCodigo());
    }
}
