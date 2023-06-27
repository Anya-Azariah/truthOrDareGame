module com.example.gumball {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gumball to javafx.fxml;
    exports com.example.gumball;
}