/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

/**
 *
 * @author Rachid
 */
public class SaisirResultatException extends Exception {
 
    public SaisirResultatException(int reponse) {
        System.out.println("Erreur de saisie, Veuillez saisissez un entier");
    }
}
    

