package com.kmsoft.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.kmsoft.service.CalculDuCompteEstBon;
import com.kmsoft.service.Games;
import com.kmsoft.service.MethodeFichier;

public class Chargement {

    JProgressBar progress;
    Thread thread;

    public static JFrame frame;
    public static ArrayList<String> liste = new ArrayList<String>();

    public static void main(String[] args) {

        new Chargement("Les Lettres & Les chiffres Version 1.0 Chargement...");// Path
                                                                               // de
                                                                               // l'image
                                                                               // qu'on
                                                                               // veut
                                                                               // ,message,ainsi
                                                                               // que
                                                                               // l
                                                                               // icone
                                                                               // de
                                                                               // la
                                                                               // fenetre

    }

    public Chargement(String imgPath) {
        MethodeFichier met = new MethodeFichier();
        liste = met.ListeMot();
        int tailletotal = liste.size();

        frame = new JFrame("Chargement");
        // de la
        // Jframe
        JPanel panel = new JPanel();
        panel.setBackground(new Color(124, 125, 235));// Couleur de fond du
                                                      // Panel
        panel.setSize(450, 250);
        panel.setBounds(0, 0, 450, 250);

        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(imgPath));
        progress = new JProgressBar(0, 100);

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        progress.setStringPainted(true);

        // ajout des éléments
        panel.add("North", img);
        panel.add("East", progress);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(450, 250);
        // Pour définir le Splash au milieu de l'écran'
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screen.width - frame.getSize().width) / 2, (screen.height - frame.getSize().height) / 2);
        // pour que ca ai vraiement l air d un splash :p
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        // Retaillage de la barre pour qu elle corresponde a la taille de la
        // frame
        progress.setBounds(new Rectangle(10, 220, 430, 20));
        // Création de thread pour afficher la progression de la barre
        thread = new Thread(new Progression());
        thread.start();
        // On peut ajouter un Thread d'une classe de traitement qui implemente
        // un Runnable
        // et les switcher.

    }

    public class Progression implements Runnable {
        @SuppressWarnings("deprecation")
        public void run() {
            for (int j = 1; j < 100; j++) {
                progress.setValue(j);
                progress.setString(j + " %");
                try {
                    thread.sleep(40);// determination de la rapiditée de la
                                     // frame
                } catch (Exception e) {
                    e.printStackTrace();
                    frame.dispose();// en cas d' erreur pour pas rester bloqué
                                    // sur le splash
                }
            }

            // frame.dispose(); //fermeture de la frame lorsque le chargement
            // est teminé

            CalculDuCompteEstBon ctb = new CalculDuCompteEstBon();
            ctb.affiche_soluce();
            Games.setListeMot(liste);
            new Chiffresk().show();
            frame.dispose();

        }
    }
}
