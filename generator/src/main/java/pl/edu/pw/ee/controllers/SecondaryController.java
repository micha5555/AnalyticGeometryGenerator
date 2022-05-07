package pl.edu.pw.ee.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import pl.edu.pw.ee.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}