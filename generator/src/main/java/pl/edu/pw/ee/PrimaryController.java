package pl.edu.pw.ee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pl.edu.pw.ee.exceptions.CannotPassException;
import pl.edu.pw.ee.services.Exercise;

public class PrimaryController {

    Generator gen = null;
    Exercise ex = null;

    @FXML
    void initialize(){
        gen = new Generator();
        
    }

    @FXML
    private Label ExerciseLabel;

    @FXML
    private Button showAnswerButton;

    @FXML
    private Button generateExerciseButton;

    @FXML
    private Label answerLabel;

    @FXML
    void generateExercise(ActionEvent event) {
        try {
            answerLabel.setText("");
            ex = gen.generateExercise();
            String exString = ex.whatToDo();
            int i = 0;
            while(i+91 < exString.length()){
                exString = exString.substring(0, i+91) + "\n" + exString.substring(i+91, exString.length());
                i += 91;
            }
            ExerciseLabel.setText(exString);
        } catch (CannotPassException e) {
            this.generateExercise(event);
        }
    }

    @FXML
    void showAnswer(ActionEvent event) {
        if(ex != null){
            answerLabel.setText("Odpowiedź: " + ex.getSolution().toString());
        }
    }

}