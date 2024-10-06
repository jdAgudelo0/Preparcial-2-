package programacion3.preparcial2.implementacionarchivos.Model;

import programacion3.preparcial2.implementacionarchivos.Model.Enum.TipoGenero;

import java.io.Serializable;
import java.util.ArrayList;

public class Personajes implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String pais;
    private int edad;
    private TipoGenero tipoGenero;
    private ArrayList<String> codigoPelicula;
    private String id;

    public Personajes(String nombre, String pais, int edad, TipoGenero tipoGenero, ArrayList<String> codigoPelicula, String id) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.tipoGenero = tipoGenero;
        this.codigoPelicula = codigoPelicula;
        this.id = id;
    }

    public Personajes() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(TipoGenero tipoGenero) {
        this.tipoGenero = tipoGenero;
    }

    public ArrayList<String> getCodigoPelicula() {
        return codigoPelicula;
    }

    public void setCodigoPelicula(ArrayList<String> codigoPelicula) {
        this.codigoPelicula = codigoPelicula;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
