package com.kmsoft.service;
 /*
 * @(#)Le_compte_est_bon.java 1.0 02/03/2006
 */

import java.awt.*;
import java.awt.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.*;
import java.lang.String;
import java.util.*;

public class Le_compte_est_bon extends java.applet.Applet {
	public Le_compte_est_bon() {
	}
	boutonPerso boutonPlus =  new boutonPerso("+",Color.cyan);
	boutonPerso boutonMoins = new boutonPerso("-",Color.cyan);
	boutonPerso boutonMult = new boutonPerso("x",Color.cyan);
	boutonPerso boutonDiv = new boutonPerso("/",Color.cyan);
	boutonPerso tirage = new boutonPerso("Tirage Aléatoire");
	boutonPerso voirSolutions = new boutonPerso("Voir Les Solutions !");
	boutonPerso quitter = new boutonPerso("Quitter");
	boutonPerso droite = new boutonPerso(">");
	boutonPerso gauche = new boutonPerso("<");
	TextField indicateur = new TextField(6);
	TextField lab_p1 = new TextField(3);
	TextField lab_p2 = new TextField(3);
	TextField lab_p3 = new TextField(3);
	TextField lab_p4 = new TextField(3);
	TextField lab_p5 = new TextField(3);
	TextField lab_p6 = new TextField(3);
	TextField lab_resultat = new TextField(3);
	CalculDuCompteEstBon leCompte = new CalculDuCompteEstBon();
	List liste = new List(5,false);
	int solutionEnCours = 0;
	public void init() {
	//dessin de l'interface.
	setLayout(new GridLayout(6,1));
	Panel pan_resultat = new Panel();
	Panel pan_plaque = new Panel();
	Panel pan_operation = new Panel();
	Panel pan_tableau = new Panel();
	Panel pan_navig = new Panel();
	Panel pan_control = new Panel();
	pan_resultat.add(lab_resultat);
	pan_plaque.add(lab_p1);	pan_plaque.add(lab_p2);	pan_plaque.add(lab_p3);
	pan_plaque.add(lab_p4);	pan_plaque.add(lab_p5);	pan_plaque.add(lab_p6);
	
	pan_operation.add(boutonPlus);
	pan_operation.add(boutonMoins);
	pan_operation.add(boutonMult);
	pan_operation.add(boutonDiv);
	
	
	pan_tableau.add(liste);
	pan_navig.add(gauche);
	pan_navig.add(indicateur);
	pan_navig.add(droite);
	pan_control.add(tirage);
	pan_control.add(voirSolutions);
	pan_control.add(quitter);
	add(pan_resultat);
	add(pan_plaque);
	add(pan_operation);
	add(pan_tableau);
	add(pan_navig);
	add(pan_control);
	}

	public void paint(Graphics g) {
		g.drawString("le compte est bon", 50, 60 );
	}
	class boutonPerso extends Button implements ActionListener {
		public boutonPerso(String nom,Color couleur){
			super(nom);
			this.setBackground(couleur);
			this.setSize(300,300);
			addActionListener(this);	
		}
		public boutonPerso(String nom){
			super(nom);
			this.setSize(300,300);
			addActionListener(this);
		}
		public void actionPerformed(ActionEvent e) {
			Object oBouton = e.getSource();
			if (oBouton == boutonPlus ) {
					System.out.println("+++++++");
			}
			if (oBouton == boutonMoins ) {
					System.out.println("------");
			}
			if (oBouton == boutonMult ) {
					System.out.println("xxxxxxx");
			}
			if (oBouton == boutonDiv ) {
					System.out.println("////////");
			}
			if (oBouton == tirage ) {
				Random r = new Random();
				int plak;
				Integer chiffre = new Integer(Math.abs(r.nextInt() % 898) + 101); //tirage du resultat à trouver
				lab_resultat.setText(chiffre.toString());
				int plaquette[][] = {{1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,25,50,75,100},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
				plak = Math.abs(r.nextInt() % 23);
				lab_p1.setText(chiffre.toString(plaquette[0][plak]));
				int j=0;
				for (int i=0;i<23;i++){if (i == plak) continue;plaquette[1][j] = plaquette[0][i];j++;}
				plak = Math.abs(r.nextInt() % 22);
				lab_p2.setText(chiffre.toString(plaquette[1][plak]));
				j=0;
				for (int i=0;i<22;i++){if (i == plak) continue;plaquette[2][j] = plaquette[1][i];j++;}
				plak = Math.abs(r.nextInt() % 21);
				lab_p3.setText(chiffre.toString(plaquette[2][plak]));
				j=0;
				for (int i=0;i<21;i++){if (i == plak) continue;plaquette[3][j] = plaquette[2][i];j++;}
				plak = Math.abs(r.nextInt() % 20);
				lab_p4.setText(chiffre.toString(plaquette[3][plak]));
				j=0;
				for (int i=0;i<20;i++){if (i == plak) continue;plaquette[4][j] = plaquette[3][i];j++;}
				plak = Math.abs(r.nextInt() % 19);
				lab_p5.setText(chiffre.toString(plaquette[4][plak]));
				j=0;
				for (int i=0;i<19;i++){if (i == plak) continue;plaquette[5][j] = plaquette[4][i];j++;}
				plak = Math.abs(r.nextInt() % 18);
				lab_p6.setText(chiffre.toString(plaquette[5][plak]));
				liste.removeAll();
				indicateur.setText(" ");
				solutionEnCours = 0;
			}
			if (oBouton == voirSolutions ) {
				Integer temp;
				int tirage[] = new int[6];		
				System.out.println("t"+ lab_p1.getText() +"t");		
				if (lab_p1.getText() == ""){liste.addItem("tt");return;}
				//return;
				temp = Integer.decode(lab_p1.getText());tirage[0] = temp.intValue();
				temp = Integer.decode(lab_p2.getText());tirage[1] = temp.intValue();
				temp = Integer.decode(lab_p3.getText());tirage[2] = temp.intValue();
				temp = Integer.decode(lab_p4.getText());tirage[3] = temp.intValue();
				temp = Integer.decode(lab_p5.getText());tirage[4] = temp.intValue();
				temp = Integer.decode(lab_p6.getText());tirage[5] = temp.intValue();
				temp = Integer.decode(lab_resultat.getText());
				for (int i=0;i<6;i++){if (tirage[i] == 0){liste.removeAll();liste.addItem("Les chiffres");liste.addItem("doivent être");liste.addItem("supérieur");liste.addItem("à 0");return;}}
				solutionEnCours = 0;
				liste.removeAll();
				liste.addItem("Veuillez");
				liste.addItem("patienter..");
				leCompte.rempli(tirage,temp.intValue());				
				leCompte.compte(5);
				liste.removeAll();
				if (leCompte.nbSolution() == 0) {liste.addItem("Pas de");liste.addItem("Solutions");return;}
				for (int i=5;i>0;i--){liste.addItem(leCompte.uneSolution(solutionEnCours,i));}
				solutionEnCours++;
				indicateur.setText(solutionEnCours+"/"+leCompte.nbSolution());
				
			}
			if (oBouton == quitter ) {
					System.out.println("////////");
			}
			if (oBouton == droite ) {
				if (solutionEnCours == 0) return;
				if (solutionEnCours == leCompte.nbSolution()) return;
				liste.removeAll();
				for (int i=5;i>0;i--){liste.addItem(leCompte.uneSolution(solutionEnCours,i));}
				solutionEnCours++;
				indicateur.setText(solutionEnCours+"/"+leCompte.nbSolution());
			}
			if (oBouton == gauche ) {
				if (solutionEnCours <= 1) return;
				liste.removeAll();
				solutionEnCours--;
				for (int i=5;i>0;i--){liste.addItem(leCompte.uneSolution(solutionEnCours-1,i));}
				
				indicateur.setText(solutionEnCours+"/"+leCompte.nbSolution());
			}
		}
	}
}


