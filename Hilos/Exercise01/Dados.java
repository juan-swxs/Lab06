package Hilos.Exercise01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dados extends JFrame {
    private JPanel Panel_Dados = new JPanel();
    private JButton Atras = new JButton("⬅️");
    private JButton Iniciar = new JButton("🎲");

    private ImageIcon Caras_Dados[] = new ImageIcon[6];
    private JLabel imagenes1 = new JLabel();
    private JLabel imagenes2 = new JLabel();

    public Dados() {
        for (int i = 0; i < 6; i++) {
            Caras_Dados[i] = new ImageIcon("Images/" + (i + 1) + ".png");
        }

        this.setBounds(0, 0, 500, 400);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Metods_Dados();
    }

    private void Metods_Dados() {
        Panel_Dados();
        Botones();
        setUpDiceImages();
    }

    private void Panel_Dados() {
        this.getContentPane().add(Panel_Dados);
        Panel_Dados.setLayout(null);
        Panel_Dados.setBackground(Color.darkGray);
    }

    private void Botones() {
        Atras.setBounds(10, 6, 60, 60);
        Panel_Dados.add(Atras);
        Iniciar.setBounds(100, 6,60, 60);
        Panel_Dados.add(Iniciar);

        Atras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Metodos metodos = new Metodos();
                metodos.setVisible(true);
                dispose();
            }
        });

        Iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startDiceRoll();
            }
        });
    }

    private void setUpDiceImages() {
        imagenes1.setBounds(60, 60, 190, 270);
        imagenes2.setBounds(260, 60, 190, 270);

        // Set initial images to the first face of the dice
        imagenes1.setIcon(Caras_Dados[0]);
        imagenes2.setIcon(Caras_Dados[0]);

        Panel_Dados.add(imagenes1);
        Panel_Dados.add(imagenes2);
    }

    private void startDiceRoll() {
        // Start the threads for both dice
        Thread dice1Thread = new Thread(new DiceRoller(imagenes1));
        Thread dice2Thread = new Thread(new DiceRoller(imagenes2));
        
        dice1Thread.start();
        dice2Thread.start();
    }

    // Inner class to handle dice rolling animation
    private class DiceRoller implements Runnable {
        private JLabel diceLabel;
        private int rollDuration = 1000; // Rolling duration in milliseconds

        public DiceRoller(JLabel diceLabel) {
            this.diceLabel = diceLabel;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < rollDuration) {
                int randomFace = (int) (Math.random() * 6); // Get a random dice face
                diceLabel.setIcon(Caras_Dados[randomFace]);
                try {
                    Thread.sleep(100); // Delay to simulate animation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
