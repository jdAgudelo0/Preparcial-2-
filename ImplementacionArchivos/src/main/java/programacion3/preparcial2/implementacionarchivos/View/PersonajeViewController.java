package programacion3.preparcial2.implementacionarchivos.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import programacion3.preparcial2.implementacionarchivos.Controller.PersonajeController;
import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Model.Personajes;

import java.util.ArrayList;

public class PersonajeViewController {

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txfId;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPais;

    private PersonajeController personajeController;

    @FXML
    public void initialize() {
        personajeController = new PersonajeController();
    }

    public Personajes crearPersonaje() {
        Personajes personaje = new Personajes();
        personaje.setId(txfId.getText());
        personaje.setEdad(Integer.parseInt(txtEdad.getText()));
        personaje.setNombre(txtNombre.getText());
        personaje.setPais(txtPais.getText());
        return personaje;
    }

    @FXML
    void registrarPersonaje(ActionEvent event) throws PersonajeException {
        if (validarCampor()){
            personajeController.CrearPersonaje(crearPersonaje());
            mostrarAletar("Registro completo","El registro se llevo acabo");
        }else{
            mostrarAletar("Error mi perro","Llene datos pendejo");
        }

    }


    private boolean validarCampor(){
        return !txfId.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtEdad.getText().isEmpty()
                && !txtPais.getText().isEmpty();
    }


    private void mostrarAletar(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
