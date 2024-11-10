package Hilos.Exercise02;

import java.awt.Component;
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
    private Timer rollingTimer;
    private boolean verify = false;
    private boolean isRolling = false;
    private ImageIcon[] images;

    public TragaMonedas() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        loadImages();
        changePanel();
        slotMachines_images();
        changeButtons();
    }

    private void loadImages() {
        images = new ImageIcon[] {
            ImageResizer.resizeIcon("Images/ruby.png", 45, 45),
            ImageResizer.resizeIcon("Images/corazon.png", 43, 43),
            ImageResizer.resizeIcon("Images/number.png", 40, 45),
            ImageResizer.resizeIcon("Images/orange.png", 39, 45),
            ImageResizer.resizeIcon("Images/Time.png", 43, 46),
            ImageResizer.resizeIcon("Images/Campana.png", 45, 45)
        };

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

            rollingTimer = new Timer(16, e -> moveImages());
            rollingTimer.start();

            new Timer(4000, e -> {
                rollingTimer.stop();
                isRolling = false;
                alignImages();
                ((Timer) e.getSource()).stop();
            }).start();
        }
    }

    private void moveImages() {
        int imageHeight = 90;
        int panelHeight = panel.getHeight();

        for (int n = 0; n < panel.getComponentCount(); n++) {
            Component label = panel.getComponent(n);
            int newY = label.getY() + 10;

            if (newY > panelHeight) {
                newY = -imageHeight;
            }

            label.setLocation(label.getX(), newY);
        }

        panel.repaint();
    }

    private void alignImages() {
        int[] initialPositions = { 11, 66, 11, 66, 11, 66 };
        int xPositions[] = { 10, 10, 80, 80, 144, 144 };

        Component[] components = panel.getComponents();

        for (int z = 0; z < components.length; z++) {
            components[z].setLocation(xPositions[z], initialPositions[z]);
        }

        panel.repaint();
    }

    private void slotMachines_images() {
        JLabel labelRuby = new JLabel(images[0]);
        labelRuby.setBounds(10, 11, 43, 43);

        JLabel labelHeart = new JLabel(images[1]);
        labelHeart.setBounds(10, 66, 43, 43);

        JLabel labelNumber = new JLabel(images[2]);
        labelNumber.setBounds(80, 11, 40, 43);

        JLabel labelOrange = new JLabel(images[3]);
        labelOrange.setBounds(79, 66, 45, 43);

        JLabel labelTimer = new JLabel(images[4]);
        labelTimer.setBounds(144, 11, 45, 43);

        JLabel labelCampaign = new JLabel(images[5]);
        labelCampaign.setBounds(144, 66, 45, 43);

        panel.add(labelRuby);
        panel.add(labelHeart);
        panel.add(labelNumber);
        panel.add(labelOrange);
        panel.add(labelTimer);
        panel.add(labelCampaign);
    }

}
