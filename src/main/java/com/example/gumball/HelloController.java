package com.example.gumball;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public static GameTracker gameTracker = new GameTracker();
    @FXML
    private Label text;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField nametext;
    @FXML
    private TextField skipstext;

    private final TruthOrDareDepartment truthAndDare = new TruthOrDareDepartment();


    @FXML
    protected void addPlayer() {
        String name = nametext.getText();
        String skips = skipstext.getText();
        // check that name is not a duplicate
        if (gameTracker.playerNames.contains(name)) {
            errorMessage.setText(" Sorry! Your name already exists, please choose another one.");
            return;
        }
        // check that skips is an integer :)
        try {
            int skipsLeft = Integer.parseInt(skips);
            Player player = new Player(name, skipsLeft);
            gameTracker.playerNames.add(name);
            gameTracker.players.add(player);
            errorMessage.setText("");
            text.setText(text.getText() + player.toString() + ", ");
        } catch (NumberFormatException e) {
            errorMessage.setText("Please enter a positive whole number. Example: 5");
            return;
        }
        nametext.setText("");
        skipstext.setText("");
    }


    //changes from the start screen to the game screen
    public void changeScene(ActionEvent event) throws IOException {
        FXMLLoader old = new FXMLLoader();
        old.setLocation(getClass().getResource("start-screen.fxml"));
        FXMLLoader temp = new FXMLLoader();
        temp.setLocation(getClass().getResource("game-screen.fxml"));
        root = FXMLLoader.load(getClass().getResource("game-screen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 320, 240);
        stage.setScene(scene);
        stage.show();
    }
}