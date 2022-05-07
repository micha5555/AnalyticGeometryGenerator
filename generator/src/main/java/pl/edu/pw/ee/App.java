package pl.edu.pw.ee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App /*extends Application*/ {

    private static Scene scene;

    // @Override
    // public void start(Stage stage) throws IOException {
    //     scene = new Scene(loadFXML("primary"), 640, 480);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws Exception {
        //launch();
        // Point[] points = new Point[100];
        // for(int i = 0; i < 100; i++){
        //     points[i] = new Point();
        // }
        // for(int i = 0; i < 100; i++){
        //     System.out.println(points[i]);
        // }
        // Line l2 = new Line(new Point(-2, 0),new Point(2,4));
        // Line l = new Line();
        // System.out.println(l.getP1() + "\n" + l.getP2() + "\n" + l.getLength());
        // System.out.println(l.getCenter());
        // System.out.printf("y=%.2fx+%.2f", l.getFunc()[1], l.getFunc()[2]);

        // Triangle t = new Triangle(new Point(0, 0), new Point(0, 2), new Point(2, 0));
        // System.out.println(t.getArea());
        // System.out.println(t.getPerimeter());
        // System.out.println(t.getHeight(new Point(0,0)));
        // System.out.println(t.getHeight(new Point(0,2)));
        // System.out.println(t.getHeight(new Point(2,0)));
        //Triangle tr = new IsoscelesTriangle(new Point(0, 0), new Point(0, 2), new Point(5, 0));
        Line l1 = new Line(new Point(-2, 0), new Point(2, 0));
        Line l2 = new Line(new Point(0, 2), new Point(0, -2));
        System.out.printf("y=%.2fx+%.2f\n", l1.getFunc()[1], l1.getFunc()[2]);
        System.out.printf("y=%.2fx+%.2f\n", l2.getFunc()[1], l2.getFunc()[2]);
        System.out.println(l1.checkPerpendicularity(l2));
    }
}