module com.example.primeiraaplicacao {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.primeiraaplicacao to javafx.fxml;
    exports com.example.primeiraaplicacao;
}