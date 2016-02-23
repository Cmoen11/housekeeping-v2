package gui;

import javafx.application.Application;




import accountMangement.Login;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// the method that made the program able to perform http requests.
import com.jaunt.*;

/**
 * This class will be the main login site
 */

public class Main extends Application {

    // or main useragent.
    private static UserAgent userAgent = new UserAgent();
    // our login window
    Stage window;
    // our login scene
    Scene loginScene;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // create objects for out labels
        Label label_Username = new Label("Brukernavn:");
        Label label_Password = new Label("Passord:");
        // create textfield and passwordfield
        TextField textField_username = new TextField();
        PasswordField passwordField = new PasswordField();
        //create login button
        Button login_button = new Button("Logg inn på brukerkonto");

        // display only this if the password is entered wrong.
        Label statusText = new Label("Brukernavn eller passord er feil.");
        statusText.setVisible(false);

        // handle the login button for if the user hit the button
        login_button.setOnAction(e -> {
            Login login = new Login(textField_username.getText(),passwordField.getText());
            if (login.login()) {
                new Housekeeping(userAgent).display();
                window.close();
            }else
                statusText.setVisible(true);
        });
        // if the user hit enter (basically the same as if he pressed the login button.)
        window.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Login login = new Login(textField_username.getText(), passwordField.getText());
                if (login.login()) {
                    new Housekeeping(userAgent).display();
                    window.close();
                }
                else
                    statusText.setVisible(true);
        }
        });

        // login layout
        VBox layout1 = new VBox(20);
        layout1.setPadding(new Insets(20,20,20,20));

        // add our objects to the layout.
        layout1.getChildren().addAll(
                label_Username,
                textField_username,
                label_Password,
                passwordField,
                login_button,
                statusText
                );
        loginScene = new Scene(layout1,220,260);
        window.setMaxWidth(220);
        window.setMaxHeight(260);
        window.setTitle("Nordicmafia login");

        // display the login scene.
        window.setScene(loginScene);
        window.show();

        // just temp.
        new Housekeeping(userAgent).display();
        window.close();

        loginScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }

    public static UserAgent getUserAgent() {
        return Main.userAgent;
    }

    public static void setUserAgent(UserAgent userAgent) {
        Main.userAgent = userAgent;
    }
}
