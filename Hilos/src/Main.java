import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import Hilos.Exercise02.TragaMonedas;

public class Main {
    public static JFrame frame;
    public static JButton[] boton;

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatAtomOneDarkIJTheme.setup();
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Button.arc", 20);
        UIManager.put("Button.pressedBackground", new Color(72, 77, 89));

        String titulo = "Lab06: Hilos";

        String opciones[] = { "Juego de dados", "Tragamonedas" };

        final int nump = opciones.length;

        frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 200, 400, 110);
        frame.setLayout(new BorderLayout());

        JPanel Panelbuttons = new JPanel();
        Panelbuttons.setLayout(new GridLayout(nump, 1));

        boton = new JButton[nump];

        for (int n = 0; n < nump; n++) {
            final int index = n;
            boton[n] = new JButton(opciones[n]);
            boton[n].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (index) {
                        case 0:
                            boton[index].setEnabled(!boton[index].isEnabled());

                            break;

                        case 1:
                            boton[index].setEnabled(!boton[index].isEnabled());
                            FlatAtomOneDarkIJTheme.setup();
                            UIManager.put("Button.background", new Color(0, 0, 0, 0));
                            UIManager.put("Button.borderWidth", -2);
                            TragaMonedas juego = new TragaMonedas();

                            SwingUtilities.updateComponentTreeUI(juego);
                            juego.setVisible(true);
                            break;
                    }
                }
            });

            Panelbuttons.add(boton[n]);
        }

        frame.add(Panelbuttons, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}