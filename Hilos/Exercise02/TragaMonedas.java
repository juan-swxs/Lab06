package Hilos.Exercise02;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Hilos.Exercise02.AstheticProgram.BackgroundPanel;
import Hilos.Exercise02.AstheticProgram.ImageResizer;

public class TragaMonedas extends JFrame {

    private BackgroundPanel panelMain;
    private JPanel panel;
    private JButton button;
    private Timer rollingTimer;
    private boolean verify = false;
    private boolean isRolling = false;

    public TragaMonedas() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        changePanel();
        slotMachines_images();
        changeButtons();
    }

    private void changePanel() {
        panelMain = new BackgroundPanel("Images/TragaMonedas.png");
        panelMain.setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(250, 274, 202, 119);

        panelMain.add(panel);
        this.getContentPane().add(panelMain);
    }

    private void changeButtons() {
        ImageIcon image = new ImageIcon("Images/Palanca.png");
        Image resizedImage = image.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);

        button = new JButton(new ImageIcon(resizedImage));
        button.setBounds(470, 350, 160, 150);
        button.addActionListener(e -> {
            startRolling();
            exchangeImage(); 
        });
        panelMain.add(button);
    }

    private void exchangeImage() {
        verify = !verify;
        if (verify) {
            verify = !verify;
            ImageIcon downImage = new ImageIcon("Images/PalancaInvertida.png");
            Image resizedDown = downImage.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(resizedDown));
            button.setBounds(470, 450, 160, 150);
        } else {
            ImageIcon upImage = new ImageIcon("Images/Palanca.png");
            Image resizedUp = upImage.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(resizedUp));
            button.setBounds(470, 350, 160, 150);
        }

        new Timer(200, e -> {   
            ImageIcon originalImage = new ImageIcon("Images/Palanca.png");
            Image resizedOriginal = originalImage.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(resizedOriginal));
            button.setBounds(470, 350, 160, 150);
            ((Timer) e.getSource()).stop();
        }).start();

    }

    private void startRolling() {
        if (!isRolling) {
            isRolling = true;
            rollingTimer = new Timer(6, this::moveImages); // Timer para mover las imágenes
            rollingTimer.start();
    
            // Detener el movimiento después de 2 segundos (2000 ms)
            new Timer(2000, e -> {
                rollingTimer.stop();
                isRolling = false;
            }).start();
        }
    }
    
    private void moveImages(ActionEvent e) {
        for (Component label : panel.getComponents()) {
            int newY = label.getY() + 10;
            if (newY > panel.getHeight()) {
                newY = -label.getHeight();
            }
            label.setLocation(label.getX(), newY);
        }
        panel.repaint(); // Asegura que el panel se redibuje
    }

    private void slotMachines_images() {
        ImageIcon ruby = ImageResizer.resizeIcon("Images/ruby.png", 45, 45);
        Image resizedRuby = ruby.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);

        ImageIcon heart = ImageResizer.resizeIcon("Images/corazon.png", 43, 43);
        Image resizedHeart = heart.getImage().getScaledInstance(43, 43, Image.SCALE_SMOOTH);

        ImageIcon number = ImageResizer.resizeIcon("Images/number.png", 40, 45);
        Image resizedNumber = number.getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH);

        ImageIcon orange = ImageResizer.resizeIcon("Images/Orange.png", 39, 45);
        Image resizedOrange = orange.getImage().getScaledInstance(39, 45, Image.SCALE_SMOOTH);

        ImageIcon timer = ImageResizer.resizeIcon("Images/Time.png", 43, 46);
        Image resizedTimer = timer.getImage().getScaledInstance(43, 46, Image.SCALE_SMOOTH);

        ImageIcon campaign = ImageResizer.resizeIcon("Images/Campana.png", 45, 45);
        Image resizedCampaign = campaign.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);

        JLabel labelRuby = new JLabel(new ImageIcon(resizedRuby));
        labelRuby.setBounds(10, 11, 43, 43);

        JLabel labelHeart = new JLabel(new ImageIcon(resizedHeart));
        labelHeart.setBounds(10, 66, 43, 43);

        JLabel labelNumber = new JLabel(new ImageIcon(resizedNumber));
        labelNumber.setBounds(80, 11, 40, 43);

        JLabel labelOrange = new JLabel(new ImageIcon(resizedOrange));
        labelOrange.setBounds(79, 66, 45, 43);

        JLabel labelTimer = new JLabel(new ImageIcon(resizedTimer));
        labelTimer.setBounds(144, 11, 45, 43);

        JLabel labelCampaign = new JLabel(new ImageIcon(resizedCampaign));
        labelCampaign.setBounds(144, 66, 45, 43);

        panel.add(labelRuby);
        panel.add(labelHeart);
        panel.add(labelNumber);
        panel.add(labelOrange);
        panel.add(labelTimer);
        panel.add(labelCampaign);
    }

}
