package gui;

import com.jaunt.UserAgent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Christian on 2/21/2016.
 * this method will hold the GUI for the Housekeeping
 */


public class Housekeeping {

    UserAgent userAgent;
    public Housekeeping(UserAgent userAgent) {
        this.userAgent = userAgent;

    }

    /**
     * Create an new stage, to show our Housekeeping GUI
     * */
    public void display() {
        Stage window = new Stage();
        Label label_test = new Label("test");

        VBox layout1 = new VBox(20);

        layout1.getChildren().addAll(label_test);
        Scene mainScene = new Scene(layout1,220,260);
        window.setScene(mainScene);
        window.show();

    }
}
