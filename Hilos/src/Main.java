import java.awt.Color;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import Hilos.Exercise02.TragaMonedas;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatAtomOneDarkIJTheme.setup();
        UIManager.put("Button.background", new Color(0, 0, 0, 0));
        UIManager.put("Button.borderWidth", -2);
        TragaMonedas juego = new TragaMonedas();

        SwingUtilities.updateComponentTreeUI(juego);
        juego.setVisible(true);
    }
}