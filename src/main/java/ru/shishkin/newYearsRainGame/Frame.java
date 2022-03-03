package ru.shishkin.newYearsRainGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Frame extends JFrame {

    private Panel game_Pole;

    private class MyKey implements KeyListener {
        public void keyPressed(KeyEvent arg0) {
            int key_code = arg0.getKeyCode();

            System.out.println(key_code);
            if (key_code == 37) {
                game_Pole.x = game_Pole.x - 30;
            }
            if (key_code == 39) {
                game_Pole.x = game_Pole.x + 30;
            }
            if (game_Pole.x > 751) {
                game_Pole.x = 0;
            }
            if (game_Pole.x < 0) {
                game_Pole.x = 750;
            }
        }

        public void keyReleased(KeyEvent arg0) {
        }

        public void keyTyped(KeyEvent arg0) {
        }
    }

    Frame(int slognost) {
        addKeyListener(new MyKey());
        setFocusable(true);

        setBounds(10, 10, 800, 600);
        setTitle("New Years Rain Game with complexity: " + slognost);

        game_Pole = new Panel(slognost);
        add(game_Pole);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
