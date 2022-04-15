module com.example._7labfx_pp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example._7labfx_pp to javafx.fxml;
    exports com.example._7labfx_pp;
}