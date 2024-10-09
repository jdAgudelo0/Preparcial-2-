package programacion3.preparcial2.implementacionarchivos.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import programacion3.preparcial2.implementacionarchivos.Controller.PersonajeController;
import programacion3.preparcial2.implementacionarchivos.Exceptions.PersonajeException;
import programacion3.preparcial2.implementacionarchivos.Model.Personajes;

public class PersonajeViewController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TableColumn<Personajes, Integer> tcEdad;

    @FXML
    private TableColumn<Personajes, String> tcId;

    @FXML
    private TableColumn<Personajes, String> tcNombre;

    @FXML
    private TableColumn<Personajes, String> tcPais;

    @FXML
    private TableView<Personajes> tvTablaPersonajes;

    @FXML
    private TextField txfId;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPais;

    private PersonajeController personajeController;
    private ObservableList<Personajes> personajes = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws PersonajeException {
        personajeController = new PersonajeController();

        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        tcEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        personajes.addAll(personajeController.MostrarPersonajes());
        tvTablaPersonajes.setItems(personajes);

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
        if (validarCampos()){
            personajeController.CrearPersonaje(crearPersonaje());
            personajes.add(crearPersonaje());
            mostrarAlerta("Registro completo","El registro se llevo acabo");
            tvTablaPersonajes.refresh();
        }else{
            mostrarAlerta("Error mi perro","Llene datos pendejo");
        }

    }


    private boolean validarCampos(){
        return !txfId.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtEdad.getText().isEmpty()
                && !txtPais.getText().isEmpty();
    }


    private void mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void actualizarPersonaje(ActionEvent event) throws PersonajeException {

        Personajes personajeSeleccionado = tvTablaPersonajes.getSelectionModel().getSelectedItem();
        Personajes personajeACtualizado = crearPersonaje();

        if(personajeSeleccionado != null){
            if(validarCampos()){
                personajeController.ModificarPersonaje(personajeACtualizado, personajeSeleccionado.getId());
                personajes.set(personajes.indexOf(personajeSeleccionado), personajeACtualizado);
                mostrarAlerta("actualizar", "se actualizo el personaje");
                tvTablaPersonajes.refresh();
            }else{
                mostrarAlerta("Error mi perro","datos no validos");
            }
        }else{
            mostrarAlerta("Error mi perro","Llene datos pendejo");
        }


    }

    @FXML
    void eliminarPersonaje(ActionEvent event) throws PersonajeException {

        Personajes personaje = tvTablaPersonajes.getSelectionModel().getSelectedItem();
        if (personaje != null){
            personajeController.deletePersonaje(personaje);
            personajes.remove(personaje);
            mostrarAlerta("eliminar", "El personaje se eliminado correctamente");

        }else{
            mostrarAlerta("Error mi perro","Seleccione un personaje");
        }

    }

}
