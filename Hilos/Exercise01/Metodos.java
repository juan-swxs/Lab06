package Hilos.Exercise01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Hilos.Exercise02.AstheticProgram.BackgroundPanel;

public class Metodos extends JFrame {
    private JButton Boton_D = new JButton(" ▶");
    private BackgroundPanel panel = new BackgroundPanel("Images/fondoDados-Photoroom.jpg");

    public Metodos(){
        this.setBounds(0, 0, 600, 600);
        this.setVisible(true);
        this.setContentPane(panel);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        inicializar_Metodos();
    }
    private void inicializar_Metodos(){
        Botones();
        label();
    }
    private void Botones(){
        Boton_D.setBounds(258, 310, 90, 90);
        Boton_D.setFont(new Font("serif", Font.ROMAN_BASELINE, 50));
        Boton_D.setForeground(new Color(33, 36, 63));
        Boton_D.setBackground(new Color(250, 250, 250, 90));
        panel.add(Boton_D);
        Boton_D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                Dados dados = new Dados();
                dados.setVisible(true); 
                dispose();                
            }
        });   
    }

    private void label() {
        JLabel title = new JLabel("G A M E");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Serif", Font.ROMAN_BASELINE, 26));
        title.setBounds(248, 200, 200, 50);

        JLabel subTitle = new JLabel("I N T O");
        subTitle.setForeground(Color.WHITE);
        subTitle.setFont(new Font("Serif", Font.ROMAN_BASELINE, 26));
        subTitle.setBounds(257, 230, 200, 50);
        
        panel.add(subTitle); 
        panel.add(title);
    }
    
}
