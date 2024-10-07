module programacion3.preparcial2.implementacionarchivos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.xml.crypto;
    requires java.desktop;
    requires java.logging;



    opens programacion3.preparcial2.implementacionarchivos to javafx.fxml;
    exports programacion3.preparcial2.implementacionarchivos;

    exports programacion3.preparcial2.implementacionarchivos.Model;
    exports programacion3.preparcial2.implementacionarchivos.Controller;
    opens programacion3.preparcial2.implementacionarchivos.Controller to javafx.fxml;

    opens programacion3.preparcial2.implementacionarchivos.View to javafx.fxml;
    exports programacion3.preparcial2.implementacionarchivos.View;
}