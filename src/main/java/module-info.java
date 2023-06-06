module com.example.sapper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sapper to javafx.fxml;
    exports com.example.sapper;
}