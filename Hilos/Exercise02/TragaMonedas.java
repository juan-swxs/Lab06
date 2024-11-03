package Hilos.Exercise02;

import java.awt.Color;
import java.awt.Image;

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
    private boolean verify = false;

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
        panel.setBackground(new Color(255, 255, 255, 14));
        panel.setBounds(250, 271, 202, 123);

        panelMain.add(panel);
        this.getContentPane().add(panelMain);
    }

    private void changeButtons() {
        ImageIcon image = new ImageIcon("Images/Palanca.png");
        Image resizedImage = image.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);

        button = new JButton(new ImageIcon(resizedImage));
        button.setBounds(470, 350, 160, 150);
        button.addActionListener(e -> {
            exchangeImage();
            starRolling();
        });
        panelMain.add(button);
    }

    private void exchangeImage() {
        verify = !verify;
        if (verify) {
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
            verify = !verify;
            ImageIcon originalImage = new ImageIcon("Images/Palanca.png");
            Image resizedOriginal = originalImage.getImage().getScaledInstance(160, 150, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(resizedOriginal));
            button.setBounds(470, 350, 160, 150);
            ((Timer) e.getSource()).stop();
        }).start();

    }

    private void starRolling() {
        
        
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
