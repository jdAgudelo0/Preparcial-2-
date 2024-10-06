package programacion3.preparcial2.implementacionarchivos.Controller;

import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Model.Netflix;
import programacion3.preparcial2.implementacionarchivos.Model.Personajes;

import static programacion3.preparcial2.implementacionarchivos.Utils.Persistencia.guardarLog;

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

    private ModelFactory(){
        netflix = new Netflix();

        guardarLog("inicio de sesion", 1, "la app se incio");
    }

    public int addPersonaje(Personajes personaje) throws PersonajeException {
        if(getNetflix().persoajeExist(personaje.getId())){
            getNetflix().addPersonaje(personaje);
            guardarLog("se esta agrgando un perosnaje", 1,"registro");
            return 1;
        }else {
            return 0;
        }
    }



}
