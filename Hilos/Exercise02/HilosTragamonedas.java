package Hilos.Exercise02;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HilosTragamonedas implements Runnable {
    private JLabel label;
    private Random random;
    private boolean isRolling;
    private ImageIcon[] images;
    
    public HilosTragamonedas(JLabel label, ImageIcon[] images) {
        this.label = label;
        this.isRolling = true;
        this.images = images;
        random = new Random();
    }

    public void stopRolling() {
        isRolling = false;
    }

    @Override
    public void run() {
        while (isRolling) {
            int randomIdex = random.nextInt(images.length);
            label.setIcon(images[randomIdex]);
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
       
    }

    
}
