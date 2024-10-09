package programacion3.preparcial2.implementacionarchivos.Controller;

import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Model.Personajes;

import java.util.ArrayList;

public class PersonajeController {

    ModelFactory modelFactory;

    public PersonajeController() {
        modelFactory = ModelFactory.getInstance();
    }


    public int CrearPersonaje(Personajes personaje) throws PersonajeException {
        if(modelFactory.addPersonaje(personaje) == 1){
            return 1;
        }else{
            return 0;
        }

    }

    public int deletePersonaje(Personajes personaje) throws PersonajeException {

        if(modelFactory.deletePersonaje(personaje) == 1){
            return 1;
        }else {
            return 0;
        }
    }

    public int ModificarPersonaje(Personajes personaje, String idPersonajeAnterior) throws PersonajeException {

        if(modelFactory.updatePersonaje(personaje, idPersonajeAnterior)){
            return 1;
        } else{
            return 0;
        }
    }

    public ArrayList<Personajes> MostrarPersonajes() throws PersonajeException {

        return modelFactory.obtenerPersonajes();
    }
}
