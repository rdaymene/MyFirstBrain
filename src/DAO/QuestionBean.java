/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author $céline
 */
public class QuestionBean {
    
    private int ID;
    private int niveau;
    private String question;
    private String reponse;
    // constructeur avec parametres
    public QuestionBean(int ID, int niveau, String question, String reponse) {
        this.ID = ID;
        this.niveau = niveau;
        this.question = question;
        this.reponse = reponse;
    }
    // getter et setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
    
}
