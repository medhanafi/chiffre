package com.kmsoft.view;

import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class Chiffresk extends JFrame implements ActionListener {
    /**
     * @param Declaration
     *            des paramtere
     */
    private static final long serialVersionUID = 1L;
    private JButton btplus1, btmoins1, btfois1, btdivis1, plus2, moins2, fois2, divis2, plus3, moins3, fois3, divis3;
    private JButton plus4, moins4, fois4, divis4, plus5, moins5, fois5, divis5;
    private JTextField nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10, rep1, rep2, rep3, rep4, rep5;
    private JTextField txt_1, txt_2, txt_3, txt_4, txt_5, txt_6, txt_7, txtatrouver;
    private JTextField txt_1h, txt_2h, txt_3h, txt_4h, txt_5h, txt_6h, txt_7h;
    private JButton btLancement;
    private JLabel lblsigne1, lblsigne2, lblsigne3, lblsigne4, lblsigne5;
    private JTextField temps;
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
    private JLabel label_1;

    // constructeur
    public Chiffresk() {
        // declaration des interface libelle et champ de saisie
        btmoins1 = new JButton("-");
        btmoins1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep1.setText(SimpleCalcule(nb1, nb2, "-") + "");
                lblsigne1.setText("-");
            }
        });
        btmoins1.setMargin(new Insets(0, 0, 0, 0));
        btplus1 = new JButton("+");
        btplus1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep1.setText(SimpleCalcule(nb1, nb2, "+") + "");
                lblsigne1.setText("+");
            }
        });
        btplus1.setMargin(new Insets(0, 0, 0, 0));
        btfois1 = new JButton("x");
        btfois1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep1.setText(SimpleCalcule(nb1, nb2, "x") + "");
                lblsigne1.setText("x");
            }
        });
        btfois1.setMargin(new Insets(0, 0, 0, 0));
        btdivis1 = new JButton("/");
        btdivis1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep1.setText(SimpleCalcule(nb1, nb2, "/") + "");
                lblsigne1.setText("/");
            }
        });
        btdivis1.setMargin(new Insets(0, 0, 0, 0));
        nb1 = new JTextField(30);
        nb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb1);
            }
        });
        nb1.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb2 = new JTextField(30);
        nb2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb2);
            }
        });
        nb2.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb3 = new JTextField(30);
        nb3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb3);
            }
        });
        nb3.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb4 = new JTextField(30);
        nb4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb4);
            }
        });
        nb4.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb5 = new JTextField(30);
        nb5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb5);
            }
        });
        nb5.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb6 = new JTextField(30);
        nb6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb1);
            }
        });
        nb6.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb7 = new JTextField(30);
        nb7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb7);
            }
        });
        nb7.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb8 = new JTextField(30);
        nb8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb8);
            }
        });
        nb8.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb9 = new JTextField(30);
        nb9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb9);
            }
        });
        nb9.setFont(new Font("Dialog", Font.PLAIN, 13));
        nb10 = new JTextField(30);
        nb10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Deposerchiffre(nb10);
            }
        });
        nb10.setFont(new Font("Dialog", Font.PLAIN, 13));

        rep1 = new JTextField(30);
        rep2 = new JTextField(30);
        rep3 = new JTextField(30);
        rep4 = new JTextField(30);
        rep5 = new JTextField(30);
        temps = new JTextField(30);
        temps.setEditable(false);
        temps.setFont(new Font("Courier New", Font.PLAIN, 29));
        temps.setBorder(new LineBorder(SystemColor.inactiveCaption));
        temps.setBackground(SystemColor.inactiveCaptionText);
        temps.setText("0000");
        txt_1 = new JTextField("");
        txt_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_1);
            }
        });
        txt_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_2 = new JTextField("");
        txt_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_2);
            }
        });
        txt_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_3 = new JTextField("");
        txt_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_3);
            }
        });
        txt_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_4 = new JTextField("");
        txt_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_4);
            }
        });
        txt_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_5 = new JTextField("");
        txt_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_5);
            }
        });
        txt_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_6 = new JTextField("");
        txt_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_6);
            }
        });

        txt_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_7 = new JTextField("");
        txt_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Poserchiffre(txt_7);
            }
        });
        txt_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtatrouver = new JTextField("999");
        txtatrouver.setFont(new Font("Tahoma", Font.PLAIN, 35));

        txt_1h = new JTextField("");
        txt_1h.setEnabled(false);
        txt_1h.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_2h = new JTextField("");
        txt_2h.setEnabled(false);
        txt_2h.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_3h = new JTextField("");
        txt_3h.setEnabled(false);
        txt_3h.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_4h = new JTextField("");
        txt_4h.setEnabled(false);
        txt_4h.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_5h = new JTextField("");
        txt_5h.setEnabled(false);
        txt_5h.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_6h = new JTextField("");
        txt_6h.setEnabled(false);
        txt_6h.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_7h = new JTextField("");
        txt_7h.setEnabled(false);
        txt_7h.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblsigne1 = new JLabel("+");
        lblsigne2 = new JLabel("+");
        lblsigne3 = new JLabel("+");
        lblsigne4 = new JLabel("+");
        lblsigne5 = new JLabel("+");

        lblsigne1.setBounds(178, 112, 11, 14);
        lblsigne2.setBounds(178, 144, 11, 14);
        lblsigne3.setBounds(178, 177, 11, 14);
        lblsigne4.setBounds(178, 210, 11, 14);
        lblsigne5.setBounds(178, 243, 11, 14);

        getContentPane().add(lblsigne1);
        getContentPane().add(lblsigne2);
        getContentPane().add(lblsigne3);
        getContentPane().add(lblsigne4);
        getContentPane().add(lblsigne5);

        btLancement = new JButton("LANCER");
        getContentPane().setLayout(null);
        txt_1.setBounds(10, 43, 46, 28);
        txt_2.setBounds(66, 43, 46, 28);
        txt_3.setBounds(122, 43, 46, 28);
        txt_4.setBounds(178, 43, 46, 28);
        txt_5.setBounds(234, 43, 46, 28);
        txt_6.setBounds(290, 43, 46, 28);
        txt_7.setBounds(346, 43, 46, 28);
        txtatrouver.setBounds(407, 30, 95, 43);

        txt_1h.setBounds(10, 11, 46, 28);
        txt_2h.setBounds(66, 11, 46, 28);
        txt_3h.setBounds(122, 11, 46, 28);
        txt_4h.setBounds(178, 11, 46, 28);
        txt_5h.setBounds(234, 11, 46, 28);
        txt_6h.setBounds(290, 11, 46, 28);
        txt_7h.setBounds(346, 11, 46, 28);

        btLancement.setBounds(512, 30, 95, 43);
        getContentPane().add(txt_1);
        getContentPane().add(txt_2);
        getContentPane().add(txt_3);
        getContentPane().add(txt_4);
        getContentPane().add(txt_5);
        getContentPane().add(txt_6);
        getContentPane().add(txt_7);
        getContentPane().add(txtatrouver);

        getContentPane().add(txt_1h);
        getContentPane().add(txt_2h);
        getContentPane().add(txt_3h);
        getContentPane().add(txt_4h);
        getContentPane().add(txt_5h);
        getContentPane().add(txt_6h);
        getContentPane().add(txt_7h);

        getContentPane().add(btLancement);

        nb1.setBounds(135, 106, 33, 22);
        nb2.setBounds(195, 106, 33, 22);
        nb3.setBounds(135, 139, 33, 22);
        nb4.setBounds(195, 139, 33, 22);
        nb5.setBounds(135, 172, 33, 22);
        nb6.setBounds(195, 172, 33, 22);
        nb7.setBounds(135, 205, 33, 22);
        nb8.setBounds(195, 205, 33, 22);
        nb9.setBounds(135, 238, 33, 22);
        nb10.setBounds(195, 238, 33, 22);
        temps.setBounds(522, 84, 80, 31);

        rep1.setBounds(263, 106, 33, 22);
        rep2.setBounds(263, 139, 33, 22);
        rep3.setBounds(263, 172, 33, 22);
        rep4.setBounds(263, 205, 33, 22);
        rep5.setBounds(263, 238, 33, 22);

        btplus1.setBounds(10, 106, 26, 22);
        btmoins1.setBounds(35, 106, 26, 22);
        btfois1.setBounds(61, 106, 26, 22);
        btdivis1.setBounds(86, 106, 26, 22);

        getContentPane().add(nb1);
        getContentPane().add(nb2);
        getContentPane().add(nb3);
        getContentPane().add(nb4);
        getContentPane().add(nb5);
        getContentPane().add(nb6);
        getContentPane().add(nb7);
        getContentPane().add(nb8);
        getContentPane().add(nb9);
        getContentPane().add(nb10);
        getContentPane().add(temps);

        getContentPane().add(rep1);
        getContentPane().add(rep2);
        getContentPane().add(rep3);
        getContentPane().add(rep4);
        getContentPane().add(rep5);

        getContentPane().add(btplus1);
        getContentPane().add(btmoins1);
        getContentPane().add(btfois1);
        getContentPane().add(btdivis1);

        label_1 = new JLabel("=");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_1.setBounds(242, 107, 11, 19);
        getContentPane().add(label_1);

        JButton btplus2 = new JButton("+");
        btplus2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep2.setText(SimpleCalcule(nb1, nb2, "+") + "");
                lblsigne2.setText("+");
            }
        });
        btplus2.setMargin(new Insets(0, 0, 0, 0));
        btplus2.setBounds(10, 139, 26, 22);
        getContentPane().add(btplus2);

        JButton btmoins2 = new JButton("-");
        btmoins2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep2.setText(SimpleCalcule(nb1, nb2, "-") + "");
                lblsigne2.setText("-");
            }
        });
        btmoins2.setMargin(new Insets(0, 0, 0, 0));
        btmoins2.setBounds(35, 139, 26, 22);
        getContentPane().add(btmoins2);

        JButton btfois2 = new JButton("x");
        btfois2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep2.setText(SimpleCalcule(nb1, nb2, "x") + "");
                lblsigne2.setText("x");
            }
        });
        btfois2.setMargin(new Insets(0, 0, 0, 0));
        btfois2.setBounds(61, 139, 26, 22);
        getContentPane().add(btfois2);

        JButton btdivis2 = new JButton("/");
        btdivis2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                rep2.setText(SimpleCalcule(nb1, nb2, "/") + "");
                lblsigne2.setText("/");
            }
        });
        btdivis2.setMargin(new Insets(0, 0, 0, 0));
        btdivis2.setBounds(86, 139, 26, 22);
        getContentPane().add(btdivis2);

        JLabel label_3 = new JLabel("=");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_3.setBounds(242, 140, 11, 19);
        getContentPane().add(label_3);

        JButton btplus3 = new JButton("+");
        btplus3.setMargin(new Insets(0, 0, 0, 0));
        btplus3.setBounds(10, 172, 26, 22);
        getContentPane().add(btplus3);

        JButton btmoins3 = new JButton("-");
        btmoins3.setMargin(new Insets(0, 0, 0, 0));
        btmoins3.setBounds(35, 172, 26, 22);
        getContentPane().add(btmoins3);

        JButton btfois3 = new JButton("x");
        btfois3.setMargin(new Insets(0, 0, 0, 0));
        btfois3.setBounds(61, 172, 26, 22);
        getContentPane().add(btfois3);

        JButton btdivis3 = new JButton("/");
        btdivis3.setMargin(new Insets(0, 0, 0, 0));
        btdivis3.setBounds(86, 172, 26, 22);
        getContentPane().add(btdivis3);

        JLabel label_5 = new JLabel("=");
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_5.setBounds(242, 173, 11, 19);
        getContentPane().add(label_5);

        JButton btplus4 = new JButton("+");
        btplus4.setMargin(new Insets(0, 0, 0, 0));
        btplus4.setBounds(10, 205, 26, 22);
        getContentPane().add(btplus4);

        JButton btmoins4 = new JButton("-");
        btmoins4.setMargin(new Insets(0, 0, 0, 0));
        btmoins4.setBounds(35, 205, 26, 22);
        getContentPane().add(btmoins4);

        JButton btfois4 = new JButton("x");
        btfois4.setMargin(new Insets(0, 0, 0, 0));
        btfois4.setBounds(61, 205, 26, 22);
        getContentPane().add(btfois4);

        JButton btdivis4 = new JButton("/");
        btdivis4.setMargin(new Insets(0, 0, 0, 0));
        btdivis4.setBounds(86, 205, 26, 22);
        getContentPane().add(btdivis4);

        JLabel label_7 = new JLabel("=");
        label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_7.setBounds(242, 206, 11, 19);
        getContentPane().add(label_7);

        JButton btplus5 = new JButton("+");
        btplus5.setMargin(new Insets(0, 0, 0, 0));
        btplus5.setBounds(10, 238, 26, 22);
        getContentPane().add(btplus5);

        JButton btmoins5 = new JButton("-");
        btmoins5.setMargin(new Insets(0, 0, 0, 0));
        btmoins5.setBounds(35, 238, 26, 22);
        getContentPane().add(btmoins5);

        JButton btfois5 = new JButton("x");
        btfois5.setMargin(new Insets(0, 0, 0, 0));
        btfois5.setBounds(61, 238, 26, 22);
        getContentPane().add(btfois5);

        JButton btdivis5 = new JButton("/");
        btdivis5.setMargin(new Insets(0, 0, 0, 0));
        btdivis5.setBounds(86, 238, 26, 22);
        getContentPane().add(btdivis5);

        JLabel label_9 = new JLabel("=");
        label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_9.setBounds(242, 239, 11, 19);
        getContentPane().add(label_9);

        // ajout des ecouteurs sur les bouton
        btLancement.addActionListener(this);

        nb1.addActionListener(this);
        nb2.addActionListener(this);
        nb3.addActionListener(this);
        nb4.addActionListener(this);
        nb5.addActionListener(this);
        nb6.addActionListener(this);
        nb7.addActionListener(this);
        nb8.addActionListener(this);
        nb9.addActionListener(this);
        nb10.addActionListener(this);

        rep1.addActionListener(this);
        rep2.addActionListener(this);
        rep3.addActionListener(this);
        rep4.addActionListener(this);
        rep5.addActionListener(this);

        //

        setBounds(100, 100, 626, 350);
        setVisible(true);

    }

    public void Poserchiffre(JTextField txtchamp) {
        if (nb1.getText().equals("")) {
            nb1.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb2.getText().equals("")) {
            nb2.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb3.getText().equals("")) {
            nb3.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb4.getText().equals("")) {
            nb4.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb5.getText().equals("")) {
            nb5.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb6.getText().equals("")) {
            nb6.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb7.getText().equals("")) {
            nb7.setText(txtchamp.getText());
            txtchamp.setText("");
        } else if (nb8.getText().equals("")) {
            nb8.setText(txtchamp.getText());
        } else if (nb9.getText().equals("")) {
            nb9.setText(txtchamp.getText());
        } else if (nb10.getText().equals("")) {
            nb10.setText(txtchamp.getText());
        }
    }

    public void Deposerchiffre(JTextField txtchamp) {
        if (txt_1.getText().equals("")) {
            if (txt_1h.getText().equals(txtchamp.getText())) {
                txt_1.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }

        if (txt_2.getText().equals("")) {
            if (txt_2h.getText().equals(txtchamp.getText())) {
                txt_2.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }

        if (txt_3.getText().equals("")) {
            if (txt_3h.getText().equals(txtchamp.getText())) {
                txt_3.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }

        if (txt_4.getText().equals("")) {
            if (txt_4h.getText().equals(txtchamp.getText())) {
                txt_4.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }
        if (txt_5.getText().equals("")) {
            if (txt_5h.getText().equals(txtchamp.getText())) {
                txt_5.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }
        if (txt_6.getText().equals("")) {
            if (txt_6h.getText().equals(txtchamp.getText())) {
                txt_6.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }
        if (txt_7.getText().equals("")) {
            if (txt_7h.getText().equals(txtchamp.getText())) {
                txt_7.setText(txtchamp.getText());
                txtchamp.setText("");
            }
        }
    }

    public int SimpleCalcule(JTextField nb1, JTextField nb2, String signe) {
        int reponse = 0;
        int n1 = Integer.parseInt(nb1.getText());
        int n2 = Integer.parseInt(nb2.getText());
        if (signe.equals("+")) {
            reponse = n1 + n2;
        }
        if (signe.equals("-")) {
            reponse = n1 - n2;
        }
        if (signe.equals("x")) {
            reponse = n1 * n2;
        }
        if (signe.equals("/")) {
            if (n2 != 0)
                reponse = n1 / n2;
            else
                reponse = 0;
        }

        return reponse;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btLancement) {

            Random r = new Random();
            int valeur = 100 + r.nextInt(999 - 100);
            txtatrouver.setText(valeur + "");
            String[] chiffres = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "25", "50",
                    "75", "100"};

            Random random = new Random(System.currentTimeMillis());
            String mot = "";
            for (int i = 0; i < 7; ++i) {
                int indice = random.nextInt(chiffres.length);
                txt_1.setText(chiffres[random.nextInt(chiffres.length)]);
                txt_2.setText(chiffres[random.nextInt(chiffres.length)]);
                txt_3.setText(chiffres[random.nextInt(chiffres.length)]);
                txt_4.setText(chiffres[random.nextInt(chiffres.length)]);
                txt_5.setText(chiffres[random.nextInt(chiffres.length)]);
                txt_6.setText(chiffres[random.nextInt(chiffres.length)]);
                txt_7.setText(chiffres[random.nextInt(chiffres.length)]);

                txt_1h.setText(txt_1.getText());
                txt_2h.setText(txt_2.getText());
                txt_3h.setText(txt_3.getText());
                txt_4h.setText(txt_4.getText());
                txt_5h.setText(txt_5.getText());
                txt_6h.setText(txt_6.getText());
                txt_7h.setText(txt_7.getText());
            }

        }

        // FIN ACTION BOUTONS LETTRES
    }

    public static void main(String[] args) {
        new Chiffresk();
    }
}
