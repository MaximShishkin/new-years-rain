package ru.shishkin.newYearsRainGame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Graphics;

public class Podarok {
    Image img;
    int x, y;
    Boolean active_img;
    Timer TimerUpdate;
    int slognost;
    int updatespeed = 0;

    Podarok(Image img, int slognost) {
        TimerUpdate = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                vniz();
            }
        });

        this.slognost = slognost;
        this.img = img;
        active_img = false;
    }

    void start() {
        TimerUpdate.start();
        y = 0;
        x = (int) (Math.random() * 700);
        active_img = true;
    }

    void vniz() {
        if (active_img == true) {
            y = y + 10 + slognost * 2 + updatespeed;
        }
        if ((y + img.getHeight(null)) >= 470) {
            TimerUpdate.stop();
        }
    }

    void draw(Graphics g) {
        if (active_img == true) {
            g.drawImage(img, x, y, null);
        }
    }
}
