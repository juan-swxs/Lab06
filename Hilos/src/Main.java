import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import Hilos.Exercise02.TragaMonedas;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatAtomOneDarkIJTheme.setup();
        TragaMonedas juego = new TragaMonedas();

        SwingUtilities.updateComponentTreeUI(juego);
        juego.setVisible(true);
    }
}