package programacion3.preparcial2.implementacionarchivos.Model;

import programacion3.preparcial2.implementacionarchivos.Model.Enum.TipoGenero;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Series implements Serializable {

    private static final long serialVersionUID = 1L;
    private String codigo;
    private String titulo;
    private LocalDate fechaInicio;
    private String sinopsis;
    private TipoGenero tipoGenero;
    private ArrayList<Personajes> personajes;

    public Series(String codigo, String titulo, LocalDate fechaInicio, String sinopsis, TipoGenero tipoGenero, ArrayList<Personajes> personajes) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.sinopsis = sinopsis;
        this.tipoGenero = tipoGenero;
        this.personajes = personajes;
    }

    public Series() {}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public ArrayList<Personajes> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personajes> personajes) {
        this.personajes = personajes;
    }

    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(TipoGenero tipoGenero) {
        this.tipoGenero = tipoGenero;
    }
}
