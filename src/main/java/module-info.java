module com.example.csc311_helperdemo_dealingwithcsvfiles {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;


    opens com.example.csc311_helperdemo_dealingwithcsvfiles to javafx.fxml;
    exports com.example.csc311_helperdemo_dealingwithcsvfiles;
}