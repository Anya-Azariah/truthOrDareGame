package com.example.gumball;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static com.example.gumball.HelloController.gameTracker;

public class GameController {
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Label text;
    @FXML
    private Label nextPlayer;

    private final TruthOrDareDepartment truthAndDare = new TruthOrDareDepartment();

    private int curPlaNo = -1;

    public void initialize() {
        String message1 = gameTracker.players.get(0).username + "'s turn! " + gameTracker.players.get(0).username + " is next.";
        nextPlayer.setText(message1);
        setCurPlaNo();
    }

    //curPlaNo = current player number
    //current player number means that what number in the list the current player is in.
    //nextPlaNo = next Player Number. (Next player in the list of players)
    private void setCurPlaNo() {
        int numPlayers = gameTracker.players.size();
        if (numPlayers > 0) {
            curPlaNo = (curPlaNo + 1) % numPlayers;
            int nextPlaNo = (curPlaNo + 1) % numPlayers;
            String message1 = gameTracker.players.get(curPlaNo).username + "'s turn! " + gameTracker.players.get(nextPlaNo).username + " is next.";
            nextPlayer.setText(message1);
        }
    }

    @FXML
    protected void onTruthButtonClick() {
        text.setText(truthAndDare.pickRandom(TruthOrDareDepartment.GumballType.TRUTH));
        System.out.println(gameTracker.playerNames);
        setCurPlaNo();
    }

    @FXML
    protected void onDareButtonClick() {
        text.setText(truthAndDare.pickRandom(TruthOrDareDepartment.GumballType.DARE));
        setCurPlaNo();
    }


    //1. check if current player has skips left
    //2. if not, don't let them skip. Print out a text which tells then that they can't skip
    //3. if they do have skips left, reduce the number of skips left from the player and move to the next player.
    //curPla = current Player
    //curPla gives the coder a variable which can be easily accessed and used.
    @FXML
    protected void onSkipButtonClick() {
        Player curPla = gameTracker.players.get(curPlaNo);
        if (curPla.skipsLeft > 0) {
            curPla.skipsLeft = curPla.skipsLeft - 1;
            gameTracker.players.set(curPlaNo, curPla);
            text.setText(curPla.username + " used a skip, and now has " + curPla.skipsLeft + " skips left.");
            setCurPlaNo();
        } else {
            text.setText("Sorry " + curPla.username + ", you need to choose a truth or dare. You have no skips left. MWUAHAHAHHA!!!!!!");
        }
    }


}// TODO: Make this controller like the hello controller,
// and have the game-screen.fxml load this one in. The start

// screen will use the hello controller,

// and the game screen will use this new

// controller. The new controller will be

// responsible for saying whose turn it

// is/displaying when someone is out of skips

// we were trying to reuse a controller, but loading a new

// fxml creates a new object from the controller blueprint.

// The infrastructure was not there to reuse a controller for

// the new screen/fxml because controller reuse for new screens

//    is bad practice