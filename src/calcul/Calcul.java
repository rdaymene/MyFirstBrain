/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import static java.lang.Math.abs;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Rachid
 */
public class Calcul extends BorderPane{

    private Text tCalcul;
    private TextField screenCalcul;
    private Text answer;
    //private Button btCheck;
    private Button btegale;
    private Button btReponse;
    private Button btOtherCalcul;
    private VBox vbText;
    private VBox vbCalcul;
    private HBox hbButton;//contient les 2 boutons réponse et solution
    
    private TextField tfInput;
    
    private String lettre;
    private int positionX = 0;
    private int positionY = 0;
    private int note = 0;
    
    private  DoCalcul calculAtrouver;
    
    Text lettre_touche;
    
    //----- Génération des chiffres et le type d'opération à éxécuter aléatoirement--------
    int number1 = getRandomChiffre1();
    int number2 = getRandomChiffre1();
    int typeOp =  getRandomOpertaion(); 
    
    /*--constructeur par défaut--*/
   
    public Calcul() {
    
        /*---------------------Le contenaire principal de type: VBox---------------*/
        VBox vBox1 = new VBox(20);
        vBox1.setSpacing(80);
        vBox1.setAlignment(Pos.CENTER);
        
        //Initialisation: affichage de l'opération à faire
        String questionCalcul = getRandomCalcul(number1, number2, typeOp);
        
        Label afficheurCalcul = new Label(questionCalcul);
        afficheurCalcul.setFont(new Font("Verdana", 30)); 
        afficheurCalcul.setWrapText(true);        
        //le bouton de signe =
        btegale = new Button("=");        
        btegale.setMinSize(100, 50);
        //Le champs de saisir le résultat
        TextField saisirResultat = new TextField();
        saisirResultat.setPromptText("Entrez votre réponse");
        saisirResultat.setPrefHeight(80);
        saisirResultat.setPrefWidth(25);
        //saisirResultat.setPrefColumnCount(35);
        // on ajoute les boutons au vBox1
        vBox1.getChildren().addAll(afficheurCalcul,btegale,saisirResultat);
        this.setCenter(vBox1); 
        
        /*---------------------Le contenaire bas de la page de type HBox----------*/
        hbButton = new HBox(20);
        hbButton.setSpacing(150);
        
        // on instancie les boutons
        btReponse = new Button("Solution");
        btOtherCalcul = new Button("Autre Calcul");
        btReponse.setMinSize(100, 50);
        btOtherCalcul.setMinSize(100, 50);
        hbButton.setAlignment(Pos.CENTER);
        
        // on ajoute les boutons au hbox
        hbButton.getChildren().addAll(btReponse, btOtherCalcul);

        // on ajoute les 2 box au container parent 
        this.setTop(vbCalcul);
        this.setBottom(hbButton); 
        
        //-------------------- gestion evenementielle--------------------------
        /*--bouton Solution--*/
        btReponse.setOnAction(e -> {
            int reponseCandidat = 0;
            //Récupération réponse candidat en string
            String reponseCandidatStr =  saisirResultat.getText();
            //Convérsion réponse candidat en int
            int reponseSaisi = Integer.parseInt(reponseCandidatStr); 
            int result =0;
            String otherCalcul = getRandomCalcul(number1, number2, typeOp);
            if(typeOp == 0){
                result = number1 + number2;
            }
            else{
                result = abs(number1 - number2);
            }            
            if (reponseSaisi==result) {
                //btReponse.setStyle("-fx-background-color : #3A9D23");    //on colorie le bouton Solution en vert
                saisirResultat.setStyle("-fx-background-color : #3A9D23"); // on colorie la zone réponse en vert
                // on affiche : bonne réponse + toute l'opération
                saisirResultat.setText("Bonne réponse : "+ otherCalcul +" = "+result);
            } else {
                //btReponse.setStyle("-fx-background-color : #FF0000;");        //on colorie le bouton Solution en rouge
                saisirResultat.setStyle("-fx-background-color : #FF0000;");     //on colorie la zone réponse en rouge
                saisirResultat.setText("Mauvaise réponse : "+ otherCalcul +" = "+result);
              }
        });
        
        /*--bouton Autre Calcul--*/
        btOtherCalcul.setOnAction(e -> {
            saisirResultat.clear();
            // génération de nouveaux nombres aléatoires
            number1 = getRandomChiffre1();
            number2 = getRandomChiffre1();
            typeOp = getRandomOpertaion();
            // Nouvelle opération 
            afficheurCalcul.setText(getRandomCalcul(number1,number2,typeOp)); 
        });
               
    }
    
    //Méthode d'envoie de 1ér chiffre aléatoire    
    public int getRandomChiffre1() { 
      int chiffre1 = (int)(Math.random() * 9);
      return chiffre1;  
    }
  
    //Méthode d'envoie de 2éme chiffre aléatoire     
    public int getRandomChiffre2() { 
      int chiffre2 = (int)(Math.random() * 9);
      return chiffre2; 
    }
                    
    //Méthode qui retourne le type d'opération
    public int getRandomOpertaion() { 
      int typeOperation = (int)(Math.random() * 2);
      return typeOperation;  
    }
    
    // Méthode qui renvoie l'opération à résoudre sous type string   
    public String getRandomCalcul(int chif1, int chif2, int typeOpe) {      
        int resultat;    
        String signeOperation;    
        //comparaison des 2 chiffres aléatoires
        if(chif1 < chif2){
            int temp = chif1;
            chif1 = chif2;
            chif2 = temp;    
        }
        
        //--conversions en string
        String ch1 = Integer.toString(chif1); //1ér chiffre aléatoire
        String ch2 = Integer.toString(chif2); //2éme chiffre aléatoire 
                
        if(typeOpe == 0){
            signeOperation = "+";        //signe de notre opération
            resultat = chif1 + chif2;
        }
        else{
            signeOperation = "-";
            resultat = chif1 - chif2;
        }        
        //--conversions du résultat en string--//
        String ch3 = Integer.toString(resultat);      
        String questionCalcul = ch1+ " "+ signeOperation + " " +ch2;        
        return questionCalcul;
    }
    
}