module com.lab.fangdou_comp228lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lab.fangdou_comp228lab4 to javafx.fxml;
    exports com.lab.fangdou_comp228lab4;
}