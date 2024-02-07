package ru.shishkin.maxim.newYearsRain;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String rez = JOptionPane.showInputDialog(null, "Enter difficulty from 1 to 9:", "Enter difficulty", 3);
        int slognost = rez.charAt(0) - '0';

        if ((slognost >= 1) && (slognost <= 9)) {
            Frame wind = new Frame(slognost);
        } else {
            JOptionPane.showMessageDialog(null, "Difficulty selected incorrectly", "Error", 0);
        }
    }
}
