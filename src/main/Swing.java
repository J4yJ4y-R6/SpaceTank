package main;

import name.panitz.game.example.simple.SimpleGame;
import name.panitz.game.framework.swing.SwingGame;

public class Swing {
    public static void main(String[] args) {
        SwingGame.startGame(new SimpleGame<>());
    }
}