package com.kmsoft.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.kmsoft.model.Chrono;
import com.kmsoft.service.Games;

public class Lettres extends JFrame implements ActionListener {
    /**
     * @param Declaration
     *            des paramtere
     */
    private static final long serialVersionUID = 1L;
    private JLabel titre;
    private JTextField chmot;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btLancement, btconsonne, btvoyelle, btjouer;
    private JButton btn1_h, btn2_h, btn3_h, btn4_h, btn5_h, btn6_h, btn7_h, btn8_h;
    private JTextField textField, temps;
    public int nblcique = 0;
    private Timer timer2;
    public ArrayList<String> liste;
    private TimerTask time2 = new TimerTask() {

        @Override
        /**
         * Tache a faire toute les seconde
         */
        public void run() {
            // a faire
            if (temps.getText().equals("10")) {
                JOptionPane.showMessageDialog(rootPane, "Temps imparti ecoulé");
                // dispose();
            }

            temps.setText("" + Chrono.getNbSec());

        }
    };

    // constructeur
    public Lettres() {
        // declaration des interface libelle et champ de saisie
        titre = new JLabel("LES LETTRES");
        chmot = new JTextField(30);
        chmot.setFont(new Font("Tahoma", Font.PLAIN, 30));
        temps = new JTextField(30);
        temps.setEditable(false);
        temps.setFont(new Font("Courier New", Font.PLAIN, 29));
        temps.setBorder(new LineBorder(SystemColor.inactiveCaption));
        temps.setBackground(SystemColor.cyan);
        temps.setText("0000");
        btn1 = new JButton("");
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn2 = new JButton("");
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn3 = new JButton("");
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn4 = new JButton("");
        btn4.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn5 = new JButton("");
        btn5.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn6 = new JButton("");
        btn6.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn7 = new JButton("");
        btn7.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn8 = new JButton("");
        btn8.setFont(new Font("Tahoma", Font.PLAIN, 50));

        btn1_h = new JButton("");
        btn1_h.setVisible(false);
        btn1_h.setEnabled(false);
        btn1_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn2_h = new JButton("");
        btn2_h.setVisible(false);
        btn2_h.setEnabled(false);
        btn2_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn3_h = new JButton("");
        btn3_h.setVisible(false);
        btn3_h.setEnabled(false);
        btn3_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn4_h = new JButton("");
        btn4_h.setVisible(false);
        btn4_h.setEnabled(false);
        btn4_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn5_h = new JButton("");
        btn5_h.setVisible(false);
        btn5_h.setEnabled(false);
        btn5_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn6_h = new JButton("");
        btn6_h.setVisible(false);
        btn6_h.setEnabled(false);
        btn6_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn7_h = new JButton("");
        btn7_h.setVisible(false);
        btn7_h.setEnabled(false);
        btn7_h.setFont(new Font("Tahoma", Font.PLAIN, 50));
        btn8_h = new JButton("");
        btn8_h.setVisible(false);
        btn8_h.setEnabled(false);
        btn8_h.setFont(new Font("Tahoma", Font.PLAIN, 50));

        btconsonne = new JButton("CONSONNE");
        btvoyelle = new JButton("VOYELLE");
        btjouer = new JButton("JE JOUE");

        btLancement = new JButton("Lancement automatique");
        getContentPane().setLayout(null);
        btn1.setBounds(13, 28, 86, 68);
        btn2.setBounds(109, 28, 86, 68);
        btn3.setBounds(205, 28, 86, 68);
        btn4.setBounds(301, 28, 86, 68);
        btn5.setBounds(397, 28, 86, 68);
        btn6.setBounds(493, 28, 86, 68);
        btn7.setBounds(589, 28, 86, 68);
        btn8.setBounds(685, 28, 86, 68);

        btn1_h.setBounds(13, 222, 86, 68);
        btn2_h.setBounds(109, 222, 86, 68);
        btn3_h.setBounds(205, 222, 86, 68);
        btn4_h.setBounds(301, 222, 86, 68);
        btn5_h.setBounds(397, 222, 86, 68);
        btn6_h.setBounds(493, 222, 86, 68);
        btn7_h.setBounds(589, 222, 86, 68);
        btn8_h.setBounds(685, 222, 86, 68);

        btLancement.setBounds(557, 161, 214, 43);
        btconsonne.setBounds(557, 107, 102, 43);
        btvoyelle.setBounds(669, 107, 102, 43);
        btjouer.setBounds(434, 161, 112, 43);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        getContentPane().add(btn3);
        getContentPane().add(btn4);
        getContentPane().add(btn5);
        getContentPane().add(btn6);
        getContentPane().add(btn7);
        getContentPane().add(btn8);

        getContentPane().add(btn1_h);
        getContentPane().add(btn2_h);
        getContentPane().add(btn3_h);
        getContentPane().add(btn4_h);
        getContentPane().add(btn5_h);
        getContentPane().add(btn6_h);
        getContentPane().add(btn7_h);
        getContentPane().add(btn8_h);

        getContentPane().add(btLancement);
        getContentPane().add(btconsonne);
        getContentPane().add(btvoyelle);
        getContentPane().add(btjouer);

        chmot.setBounds(13, 161, 390, 43);
        temps.setBounds(434, 113, 113, 31);
        getContentPane().add(chmot);
        getContentPane().add(temps);

        // ajout des ecouteurs sur les bouton
        btLancement.addActionListener(this);
        btconsonne.addActionListener(this);
        btvoyelle.addActionListener(this);
        btjouer.addActionListener(this);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);

        btn1_h.addActionListener(this);
        btn2_h.addActionListener(this);
        btn3_h.addActionListener(this);
        btn4_h.addActionListener(this);
        btn5_h.addActionListener(this);
        btn6_h.addActionListener(this);
        btn7_h.addActionListener(this);
        btn8_h.addActionListener(this);

        //

        setBounds(100, 100, 800, 350);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLancement) {

            // generation aleatoire des lettres
            String lettres = "EEEEEEEEEEEEEEEAAAAAAAAAIIIIIIIINNNNNNOOOOOOSSSSSSTTTTTTUUUUUULLLLL";
            lettres += "DDDMMMGGG";
            lettres += "BBCCPP";
            lettres += "FFHHVV";
            lettres += "JQ";
            lettres += "KWXYZ";
            Random random = new Random(System.currentTimeMillis());
            String mot = "";
            for (int i = 0; i < lettres.length() - 1; ++i) {
                if (mot.length() < 8) {
                    char lettre = lettres.charAt(random.nextInt(lettres.length() - 1));

                    if (i == 0) {
                        btn1.setText(lettre + "");
                        btn1_h.setText(lettre + "");
                    }
                    if (i == 1) {
                        btn2.setText(lettre + "");
                        btn2_h.setText(lettre + "");
                    }
                    if (i == 2) {
                        btn3.setText(lettre + "");
                        btn3_h.setText(lettre + "");
                    }
                    if (i == 3) {
                        btn4.setText(lettre + "");
                        btn4_h.setText(lettre + "");
                    }
                    if (i == 4) {
                        btn5.setText(lettre + "");
                        btn5_h.setText(lettre + "");
                    }
                    if (i == 5) {
                        btn6.setText(lettre + "");
                        btn6_h.setText(lettre + "");
                    }
                    if (i == 6) {
                        btn7.setText(lettre + "");
                        btn7_h.setText(lettre + "");
                    }
                    if (i == 7) {
                        btn8.setText(lettre + "");
                        btn8_h.setText(lettre + "");
                    }
                }

            }

            btLancement.setEnabled(false);
            btvoyelle.setEnabled(false);
            btconsonne.setEnabled(false);

            Chrono c = new Chrono();
            c.reset();
            c.start();
            timer2 = new Timer();
            timer2.schedule(time2, 0, 1000);

        }

        if (e.getSource() == btconsonne) {
            // generation aleatoire des lettres
            String consonne = "BCDEFGHJKLMNPQRSTVWXZ";
            Random random = new Random(System.currentTimeMillis());

            if (nblcique < 8) {
                char lettre = consonne.charAt(random.nextInt(consonne.length() - 1));
                if (nblcique == 0) {
                    btn1.setText(lettre + "");
                    btn1_h.setText(lettre + "");
                }
                if (nblcique == 1) {
                    btn2.setText(lettre + "");
                    btn2_h.setText(lettre + "");
                }
                if (nblcique == 2) {
                    btn3.setText(lettre + "");
                    btn3_h.setText(lettre + "");
                }
                if (nblcique == 3) {
                    btn4.setText(lettre + "");
                    btn4_h.setText(lettre + "");
                }
                if (nblcique == 4) {
                    btn5.setText(lettre + "");
                    btn5_h.setText(lettre + "");
                }
                if (nblcique == 5) {
                    btn6.setText(lettre + "");
                    btn6_h.setText(lettre + "");
                }
                if (nblcique == 6) {
                    btn7.setText(lettre + "");
                    btn7_h.setText(lettre + "");
                }
                if (nblcique == 7) {
                    btn8.setText(lettre + "");
                    btn8_h.setText(lettre + "");
                }
            }

            nblcique++;
            if (nblcique == 8) {
                btvoyelle.setEnabled(false);
                btconsonne.setEnabled(false);
                btLancement.setEnabled(false);
                Chrono c = new Chrono();
                c.reset();
                c.start();
                timer2 = new Timer();
                timer2.schedule(time2, 0, 1000);
            }
        }

        if (e.getSource() == btvoyelle) {
            // generation aleatoire des lettres
            String voyelle = "AEIOUY";
            Random random = new Random(System.currentTimeMillis());

            if (nblcique < 8) {
                char lettre = voyelle.charAt(random.nextInt(voyelle.length() - 1));
                if (nblcique == 0) {
                    btn1.setText(lettre + "");
                    btn1_h.setText(lettre + "");
                }
                if (nblcique == 1) {
                    btn2.setText(lettre + "");
                    btn2_h.setText(lettre + "");
                }
                if (nblcique == 2) {
                    btn3.setText(lettre + "");
                    btn3_h.setText(lettre + "");
                }
                if (nblcique == 3) {
                    btn4.setText(lettre + "");
                    btn4_h.setText(lettre + "");
                }
                if (nblcique == 4) {
                    btn5.setText(lettre + "");
                    btn5_h.setText(lettre + "");
                }
                if (nblcique == 5) {
                    btn6.setText(lettre + "");
                    btn6_h.setText(lettre + "");
                }
                if (nblcique == 6) {
                    btn7.setText(lettre + "");
                    btn7_h.setText(lettre + "");
                }
                if (nblcique == 7) {
                    btn8.setText(lettre + "");
                    btn8_h.setText(lettre + "");
                }
            }

            nblcique++;
            if (nblcique == 8) {
                btvoyelle.setEnabled(false);
                btconsonne.setEnabled(false);
                btLancement.setEnabled(false);
                Chrono c = new Chrono();
                c.reset();
                c.start();
                timer2 = new Timer();
                timer2.schedule(time2, 0, 1000);
            }
        }
        // DEBUT ACTIONS BOUTONS DES LETTRES
        String mot = chmot.getText();

        if (e.getSource() == btn1) {
            if (btn1.getText() != "") {
                chmot.setText(mot + btn1.getText());
                btn1.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn1_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn1.setText(lettre + "");
                    }
                }
            }

        }
        if (e.getSource() == btn2) {
            if (btn2.getText() != "") {
                chmot.setText(mot + btn2.getText());
                btn2.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn2_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn2.setText(lettre + "");
                    }
                }
            }

        }

        if (e.getSource() == btn3) {
            if (btn3.getText() != "") {
                chmot.setText(mot + btn3.getText());
                btn3.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn3_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn3.setText(lettre + "");
                    }
                }
            }

        }
        if (e.getSource() == btn4) {
            if (btn4.getText() != "") {
                chmot.setText(mot + btn4.getText());
                btn4.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn4_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn4.setText(lettre + "");
                    }
                }
            }

        }

        if (e.getSource() == btn5) {
            if (btn5.getText() != "") {
                chmot.setText(mot + btn5.getText());
                btn5.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn5_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn5.setText(lettre + "");
                    }
                }
            }

        }

        if (e.getSource() == btn6) {
            if (btn6.getText() != "") {
                chmot.setText(mot + btn6.getText());
                btn6.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn6_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn6.setText(lettre + "");
                    }
                }
            }

        }

        if (e.getSource() == btn7) {
            if (btn7.getText() != "") {
                chmot.setText(mot + btn7.getText());
                btn7.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn7_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn7.setText(lettre + "");
                    }
                }
            }

        }

        if (e.getSource() == btn8) {
            if (btn8.getText() != "") {
                chmot.setText(mot + btn8.getText());
                btn8.setText("");
            } else {
                String motCh = chmot.getText();
                char lettre = btn8_h.getText().charAt(0);
                for (int i = 0; i < motCh.length(); i++) {
                    if (motCh.charAt(i) == lettre) {
                        String motp1 = motCh.substring(0, i);
                        String motp2 = motCh.substring(i + 1);
                        chmot.setText(motp1 + motp2);
                        btn8.setText(lettre + "");
                    }
                }
            }

        }
        if (e.getSource() == btjouer) {

            Games g = new Games();
            liste = g.getListeMot();
            String mottrouver = "";
            String motsaisie = chmot.getText().toLowerCase();
            int trouve = 0;
            int i = 0;
            while (i < liste.size()) {
                mottrouver = liste.get(i);
                if (mottrouver.equals(motsaisie)) {
                    motsaisie = mottrouver;
                    i = liste.size();
                    trouve = 1;
                } else {
                    i++;
                }

            }
            if (trouve == 1) {
                JOptionPane.showMessageDialog(null, "GAGNER");
            } else {
                JOptionPane.showMessageDialog(null, "PERDU Ce mot n'existe pas dans le dictionnaire LA2014");
            }

        }

        // FIN ACTION BOUTONS LETTRES
    }

    public static void main(String[] args) {
        new Lettres();
    }
}
