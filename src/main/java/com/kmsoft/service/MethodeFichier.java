package com.kmsoft.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MethodeFichier {
    public void ecrire(String path, String text) {
        PrintWriter ecri;
        try {
            ecri = new PrintWriter(new FileWriter(path));
            ecri.println(text);// ecri.print(text);
            ecri.flush();
            ecri.close();
        } // try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
    }// ecrire

    public String lire(String path) {
        BufferedReader lect;
        String tmp = "";
        try {
            lect = new BufferedReader(new FileReader(path));
            while (lect.ready() == true) {
                tmp += "\r\n" + lect.readLine();
                if (tmp.length() > 7) {
                    ecrire("mot8.txt", tmp);
                } else {
                    ecrire("mot7.txt", tmp);
                }

            } // while
        } // try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
        return tmp;
    }// lecture

    // verifier le mot jouer
    public String VerifierMot() {
        BufferedReader lect;
        String path = "mots.txt";
        String mlu = "";
        ArrayList<String> li = new ArrayList<String>();
        try {
            lect = new BufferedReader(new FileReader(path));
            while (lect.ready() == true) {
                mlu = lect.readLine();
                li.add(mlu);
            } // while
        } // try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
        return mlu;
    }

    // charger dans unarray liste
    public ArrayList<String> ListeMot() {
        BufferedReader lect;
        String path = "mots.txt";
        String mlu = "";
        ArrayList<String> li = new ArrayList<String>();
        try {
            lect = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource(path).getFile()));

            while (lect.ready() == true) {
                mlu = lect.readLine();
                li.add(mlu);

            } // while
            System.out.println(li.size());
        } // try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
        return li;
    }

    public ArrayList<String> VerifEtAddListeMotPossible(String mots) {
        BufferedReader lect;
        String path = "mots.txt";
        String mlu = "";
        ArrayList<String> li = new ArrayList<String>();
        try {
            lect = new BufferedReader(new FileReader(path));

            while (lect.ready() == true) {
                mlu = lect.readLine();
                if (mlu.equals(mots)) {
                    li.add(mlu);
                }
            } // while
            System.out.println(li.size());
        } // try
        catch (NullPointerException a) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException a) {
            System.out.println("Problème d'IO");
        }
        return li;
    }
}// class