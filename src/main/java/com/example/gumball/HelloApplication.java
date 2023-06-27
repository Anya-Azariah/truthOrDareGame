package com.example.gumball;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        TruthOrDareDepartment truthAndDare = new TruthOrDareDepartment();
        System.out.println(truthAndDare.pickRandom(TruthOrDareDepartment.GumballType.TRUTH));
        System.out.println(truthAndDare.pickRandom(TruthOrDareDepartment.GumballType.DARE));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}