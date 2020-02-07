/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kmsoft.model;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Administrateur
 */
public class Chrono extends Observable
{
     private Timer timer;
    private static long nbsec;
    private boolean running = false;
    private TimerTask time = new TimerTask() {

        @Override
        /**
         * Tache a faire toute les seconde
         */
        public void run() {
            if (running) {
                nbsec++;
                notifyObservers();
            }
        }
    };

    /**
     * Constructeur du chronometre qui lance la tache
     */
    public Chrono() {
        timer = new Timer();
        timer.schedule(time, 0, 1000);

    }

    /**
     * Lance le chrono
     */
    public void start() {
        running = true;
    }

    /**
     * Arrete le chrono
     */
    public void stop() {
        running = false;

    }

    /**
     * Reset le chrono a zero
     */
    public void reset() {
        nbsec = 0;
        notifyObservers();
    }

    /**
     * Retourne le nombre de seconde
     * @return le nombre de seconde
     */
    public static long getNbSec() {
        return nbsec;
    }

    /**
     * Indique si le chrono est en marche
     * @return l'etat du chrono
     */
    public boolean isRunning() {
        return running;
    }


}
