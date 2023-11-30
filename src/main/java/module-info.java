module com.mey.se420.se420_2023 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mey.se420.se420_2023 to javafx.fxml;
    exports com.mey.se420.se420_2023;
}