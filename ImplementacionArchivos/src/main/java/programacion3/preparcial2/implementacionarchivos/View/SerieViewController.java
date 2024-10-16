package programacion3.preparcial2.implementacionarchivos.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import programacion3.preparcial2.implementacionarchivos.Controller.SerieController;
import programacion3.preparcial2.implementacionarchivos.Exceptions.SeriesException;
import programacion3.preparcial2.implementacionarchivos.Model.Enum.TipoGenero;
import programacion3.preparcial2.implementacionarchivos.Model.Series;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SerieViewController {

    @FXML
    private TableColumn<Series, TipoGenero> tcGenero;
    @FXML
    private TableColumn<Series, String> tcSinopsis;
    @FXML
    private Button btnActualizarSerie;
    @FXML
    private Button btnAgregarSerie;
    @FXML
    private TableView<Series> tvTabalaSeriees;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableColumn<Series, String> tcCodigo;
    @FXML
    private TableColumn<Series, LocalDate> tcFechaEmision;
    @FXML
    private TableColumn<Series, String> tcTitulo;
    @FXML
    private TextField txtFechaLanzamiento;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtSinopsis;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtCodigoPelicula;

    private SerieController serieController;
    private ObservableList<Series> series = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws SeriesException {
        serieController = new SerieController();

        tcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tcFechaEmision.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));
        tcGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tcSinopsis.setCellValueFactory(new PropertyValueFactory<>("sinopsis"));

        series.addAll(serieController.mostrarSeries());
        tvTabalaSeriees.setItems(series);
    }

    public Series registrarSerie() {
        Series serie = new Series();
        serie.setCodigo(txtCodigoPelicula.getText());
        serie.setTitulo(txtTitulo.getText());
        serie.setFechaInicio(LocalDate.parse(txtFechaLanzamiento.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        serie.setSinopsis(txtSinopsis.getText());
        // Asumiendo que el género es un enum, debes convertir el texto a tipo `TipoGenero`
        serie.setTipoGenero(TipoGenero.valueOf(txtGenero.getText().toUpperCase()));
        return serie;
    }

    private boolean validarCampos() {
        return !txtCodigoPelicula.getText().isEmpty() && !txtTitulo.getText().isEmpty() && !txtGenero.getText().isEmpty()
                && !txtFechaLanzamiento.getText().isEmpty();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void addSerie(ActionEvent event) throws SeriesException {
        if (validarCampos()) {
            Series nuevaSerie = registrarSerie();
            serieController.crearSerie(nuevaSerie);
            series.add(nuevaSerie);
            mostrarAlerta("Registro completo", "El registro se llevó a cabo");
            tvTabalaSeriees.refresh();
        } else {
            mostrarAlerta("Error mi perro", "Llene datos pendejo");
        }
    }

    @FXML
    void deleteSerie(ActionEvent event) {
        // Implementar lógica para eliminar serie
    }

    @FXML
    void updateSerie(ActionEvent event) {
        // Implementar lógica para actualizar serie
    }
}
