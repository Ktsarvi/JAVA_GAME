package main;

import javax.swing.JFrame;
import utils.SoundManager; // Ensure this import exists!

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dungeon Crawler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        // Music initialization
        SoundManager sound = new SoundManager();
        sound.playMusic("bella_ciao.wav");
        
        // Start the game loop
        gamePanel.startGameThread();
    }
}
