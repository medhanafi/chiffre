package com.kmsoft.service;

import java.util.Vector;

public final class CalculDuCompteEstBon {

    private int plaque[][] = new int[6][6]; // tableau pour traiter les plaques
    private int ecart; // ecart entre le resultat en cours et à trouver au cas
                       // ou le compte est impossible
    private int resultat; // resultat à trouver
    private long appel = 0; // nombre d'appel a la fonction recursive
    solution temp_soluce = new solution(); // sauvegarde de la solution en cours
    Vector lesSolutions = new Vector(); // vecteur contenant les solutions

    public long nb_appel() {
        return appel;
    }

    public void rempli(int pb[], int total) {
        for (int i = 0; i <= 5; i++)
            plaque[5][i] = pb[i];
        resultat = total;
        for (int h = 0; h < 6; h++)
            temp_soluce.reset(h);
        lesSolutions.removeAllElements();
    }

    public void affiche_soluce() {
        for (int i = 0; i < lesSolutions.size(); i++)
            ((solution) lesSolutions.elementAt(i)).affiche();
        System.out.println(lesSolutions.size());
    }

    public int nbSolution() {
        return lesSolutions.size();
    }

    public String uneSolution(int numero, int l) {
        if (numero > lesSolutions.size()) {
            return "Erreur";
        } else {
            String temp;
            solution ttt;
            ttt = (solution) lesSolutions.elementAt(numero);
            temp = ttt.ligne(l);
            return temp;
        }
    }

    public void compte(int niveau) {

        appel++; // Nombre d'appel de la fonction recursive.

        boolean t_resultat = false;
        /* comparaison de resultat */
        if (plaque[niveau][0] == resultat) { // le resultat est trouve
            t_resultat = true;
            solution rr = new solution();
            rr.egale(temp_soluce);
            if (lesSolutions.size() == 0) { // si aucune solution creation.
                solution tempp = new solution();
                tempp.egale(temp_soluce);
                lesSolutions.addElement(tempp);

            } else {
                boolean ajout = false;
                for (int i = 0; i < lesSolutions.size(); i++) {
                    boolean temp;
                    if (rr.niveau() >= ((solution) lesSolutions.elementAt(i)).niveau()) {
                        temp = rr.compare(rr, (solution) lesSolutions.elementAt(i));
                    } else {
                        temp = rr.compare((solution) lesSolutions.elementAt(i), rr);
                    }
                    if (temp) { // doit remplacer l'existant cas des solutions
                                // avec operations inutiles
                        if (rr.niveau() >= ((solution) lesSolutions.elementAt(i)).niveau()) {
                            lesSolutions.removeElementAt(i);
                            i--;
                            ajout = true;
                        } else {
                            rr.egale((solution) lesSolutions.elementAt(i));
                            i = 0;
                        }
                    } else {
                        ajout = true;
                    }
                }
                if (ajout)
                    lesSolutions.addElement(rr);
            }
        } else {
            if (Math.abs(plaque[niveau][0] - resultat) < ecart)
                ecart = Math.abs(plaque[niveau][0] - resultat);
        }
        if (t_resultat)
            return;
        if (niveau == 0)
            return; // si nous sommes au niveau 0 c'est que la solution n'a pas
                    // été trouvée

        /*
         * boucle for pour traiter toutes les combinaisons par niveau pour une
         * rangée de plaque si des plaques sont identiques on traite plusieurs
         * fois les même combinaiasons cette boucle a pour but de ne traiter par
         * la suite que les combinaisons interessantes à traiter, elle ralentit
         * le traitement de la boucle lorsque toutes les plaques sont
         * differentes mais l'accelere enormement lorsqu'elles sont identiques.
         * elle a aussi l'avantage de filtrer une premiere fois les solutions en
         * eliminant les solutions identiques
         */

        int combinaison[][] = new int[2][16];
        for (int a = 0; a <= (niveau - 1); a++) {
            for (int b = a + 1; b <= niveau; b++) {
                int c = 0;
                boolean existe = false;
                while (combinaison[0][c] != 0) {
                    if ((combinaison[0][c] == plaque[niveau][a] & combinaison[1][c] == plaque[niveau][b])
                            || (combinaison[1][c] == plaque[niveau][a] & combinaison[0][c] == plaque[niveau][b]))
                        existe = true;
                    c++;
                }
                if (!existe) {
                    if (plaque[niveau][a] > plaque[niveau][b]) {
                        combinaison[0][c] = plaque[niveau][a];
                        combinaison[1][c] = plaque[niveau][b];
                    } else {
                        combinaison[0][c] = plaque[niveau][b];
                        combinaison[1][c] = plaque[niveau][a];
                    }
                }
            }
        }

        // Début du traitement de toutes les combinaisons //
        int compt = 0;
        while (combinaison[0][compt] != 0) {
            /*
             * on choisit deux plaques qui vous nous servir pour les 4
             * CalculDuCompteEstBonDuCompteEstBons possibles
             */
            int P1 = combinaison[0][compt];
            int P2 = combinaison[1][compt];
            /*
             * je rempli le tableau du niveau inferieur avec les plaques
             * restantes le resultat de l'operation y sera insere en premiere
             * position par la suite
             */
            int pointeur = 1;
            boolean p_a = true;
            boolean p_b = true;
            for (int z = 0; z <= niveau; z++) {
                if (plaque[niveau][z] == P1 && p_a) {
                    p_a = false;
                    continue;
                }
                if (plaque[niveau][z] == P2 && p_b) {
                    p_b = false;
                    continue;
                }
                plaque[(niveau - 1)][pointeur] = plaque[niveau][z];
                pointeur++;
            }
            /*
             * maintenant on traite toutes les opérations possible sur les 2
             * plaques selectionnées precedement
             */
            // ADDITION
            plaque[(niveau - 1)][0] = (P1 + P2);
            temp_soluce.set(niveau, P1, '+', P2, P1 + P2);
            compte(niveau - 1);
            temp_soluce.reset(niveau);
            // SOUSTRACTION
            if ((P1 - P2) > 0) {
                plaque[(niveau - 1)][0] = (P1 - P2);
                temp_soluce.set(niveau, P1, '-', P2, P1 - P2);
                compte(niveau - 1);
                temp_soluce.reset(niveau);
            }
            if ((P2 - P1) > 0) {
                plaque[(niveau - 1)][0] = (P2 - P1);
                temp_soluce.set(niveau, P2, '-', P1, P2 - P1);
                compte(niveau - 1);
                temp_soluce.reset(niveau);
            }
            // MULTIPLICATION l'operation est inutile si p1 ou p2 est egale a 1
            if (!(P1 == 1) & !(P2 == 1)) {
                plaque[(niveau - 1)][0] = (P1 * P2);
                temp_soluce.set(niveau, P1, '*', P2, P1 * P2);
                compte(niveau - 1);
                temp_soluce.reset(niveau);
                // DIVISION
                if (P1 % P2 == 0) {
                    plaque[(niveau - 1)][0] = (P1 / P2);
                    temp_soluce.set(niveau, P1, '/', P2, P1 / P2);
                    compte(niveau - 1);
                    temp_soluce.reset(niveau);
                }
                if (P2 % P1 == 0) {
                    plaque[(niveau - 1)][0] = (P2 / P1);
                    temp_soluce.set(niveau, P2, '/', P1, P2 / P1);
                    compte(niveau - 1);
                    temp_soluce.reset(niveau);
                }
            }
            compt++;
        }
    }

    class operation {
        int p1, p2, resultat;
        char op;

        operation() {
            p1 = 0;
            op = ' ';
            p2 = 0;
            resultat = 0;
        }

        operation(int a, char b, int c, int d) {
            p1 = a;
            op = b;
            p2 = c;
            resultat = d;
        }

        boolean compare(operation a) {
            if (this.p1 == a.p1 && this.p2 == a.p2 && this.op == a.op)
                return true;
            return false;
        }

        void egale(operation a) {
            this.p1 = a.p1;
            this.p2 = a.p2;
            this.op = a.op;
            this.resultat = a.resultat;
        }

        void reset() {
            p1 = 0;
            op = ' ';
            p2 = 0;
            resultat = 0;
        }

        void set(int a, char b, int c, int d) {
            p1 = a;
            op = b;
            p2 = c;
            resultat = d;
        }

        String op_affiche() {
            String pp1 = Integer.toString(p1);
            String pp2 = Integer.toString(p2);
            String presult = Integer.toString(resultat);
            return pp1 + op + pp2 + "=" + presult + "  ";
        }
    }

    class solution {
        operation soluce[] = new operation[6]; // = new operation();
        int niveau;

        solution() {
            for (int i = 0; i < 6; i++)
                soluce[i] = new operation();
        }

        void set(int niv, int p1, char op, int p2, int result) {
            soluce[niv].set(p1, op, p2, result);
            niveau = niv;
        }

        void reset(int niv) {
            soluce[niv].reset();
            this.niveau = niv;
        }

        void affiche() {
            for (int i = 5; i >= niveau; i--)
                System.out.print(soluce[i].op_affiche());
            System.out.println(" ");
        }

        String ligne(int l) {
            if (soluce[l].resultat == 0)
                return " ";
            return soluce[l].op_affiche();
        }

        operation retourne(int niv) {
            return soluce[niv];
        }

        void egale(solution a) {
            this.niveau = a.niveau();
            for (int i = 0; i < 6; i++)
                this.soluce[i].egale(a.retourne(i));
        }

        boolean compare(solution a, solution b) { // doit comparer deux
                                                  // solutions
            boolean trouve;
            for (int i = 5; i >= a.niveau(); i--) {
                trouve = false;
                for (int j = 5; j >= b.niveau(); j--) {
                    if (a.soluce[i].compare(b.soluce[j]))
                        trouve = true;
                }
                if (!trouve)
                    return false;
            }
            return true;
        }

        int niveau() {
            return this.niveau;
        }
    }

}
