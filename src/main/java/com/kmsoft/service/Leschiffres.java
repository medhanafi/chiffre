package com.kmsoft.service;

public class Leschiffres {

    static int[] chiffres = new int[] {100, 5, 10, 75, 8, 7};

    public static void main(String[] args) {
        CalculDuCompteEstBon calcbon = new CalculDuCompteEstBon();
        calcbon.rempli(chiffres, 350);
        calcbon.compte(5);
        calcbon.affiche_soluce();
    }

}
