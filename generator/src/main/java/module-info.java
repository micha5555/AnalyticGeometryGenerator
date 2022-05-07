module pl.edu.pw.ee.controllers {
    requires javafx.controls;
    requires javafx.fxml;

    opens pl.edu.pw.ee.controllers to javafx.fxml;
    exports pl.edu.pw.ee;
}
