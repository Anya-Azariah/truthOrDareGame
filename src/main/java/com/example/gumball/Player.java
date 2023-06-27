package com.example.gumball;

public class Player {
    String username;

    int skipsLeft;

    public Player(String name, int skips) {
        username = name;

        skipsLeft = Math.max(skips, 0);
    }

    public String toString() {
        return "Player: " + username + " has " + skipsLeft + " skips ";
    }
}
