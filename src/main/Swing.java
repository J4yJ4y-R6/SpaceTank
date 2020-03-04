package main;

import backend.SpaceTank;
import name.panitz.game.framework.swing.SwingGame;

public class Swing {
    public static void main(String[] args) {
        SwingGame.startGame(new SpaceTank<>(800,600));
    }
}