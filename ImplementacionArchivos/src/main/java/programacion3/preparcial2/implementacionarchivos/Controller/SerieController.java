package programacion3.preparcial2.implementacionarchivos.Controller;

import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Exceptions.SeriesException;
import programacion3.preparcial2.implementacionarchivos.Model.Series;

import java.util.ArrayList;

public class SerieController {

    ModelFactory modelFactory;

    public SerieController() {
        modelFactory = modelFactory.getInstance();
    }

    public int crearSerie(Series serie) throws SeriesException {

        if(modelFactory.addSerie(serie) == 1){
            return 1;
        }else {
            return 0;
        }
    }

    public int deleteSerie(Series serie) throws SeriesException {

        if(modelFactory.deleteSerie(serie) == 1){
            return 1;
        }else{
            return 0;
        }
    }

    public int modificarSerie(Series serie, String codigoPelicula) throws SeriesException {

        if(modelFactory.updateSerie(serie, codigoPelicula)){
            return 1;
        }else {
            return 0;
        }

    }

    public ArrayList<Series> mostrarSeries() throws SeriesException {

        return modelFactory.obtenerSeries();
    }


}
