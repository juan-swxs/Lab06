package Hilos.Exercise02;

import javax.swing.JFrame;

import Hilos.Exercise02.AstheticProgram.BackgroundPanel;

public class TragaMonedas extends JFrame {

    private BackgroundPanel panelMain;

    public TragaMonedas() {
        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        changePanel();
    }

    private void changePanel() {
        panelMain = new BackgroundPanel("Images/TragaMonedas.png");
        panelMain.setLayout(null);
        this.getContentPane().add(panelMain);
    }
    
}
