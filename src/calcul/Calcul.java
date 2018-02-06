/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author stag
 */
public class Calcul extends BorderPane{

    private Text tCalcul;
    private TextField screenCalcul;
    private Text answer;
    //private Button btCheck;
    private Button btReponse;
    private Button btOtherCalcul;
    private VBox vbText;
    private VBox vbCalcul;
    private HBox hbButton;//contient les 3 boutons
    
    
    //constructeur par défaut
    public Calcul() {
        this.setPadding(new Insets(15, 10, 15, 10));// on fait le padding du container parent
        //vbText = new VBox(30);
        vbText = new VBox();
        vbCalcul = new VBox();        
        
        // on instancie le champ afficheur de calcul
        screenCalcul = new TextField();
        /*
        screenCalcul.setPromptText("Afficheur de calcul");        
        screenCalcul.setPrefHeight(50);
        screenCalcul.setPrefWidth(25);
        screenCalcul.setPrefColumnCount(35);
        screenCalcul.setAlignment(Pos.CENTER);
        */
        // on instancie le champ question
        //tCalcul = new Text("Ici l'opération?");
        // on instancie le text qui fera apparaitre la bonne réponse
        //answer = new Text();
        // on ajoute ces éléments à la vbox
        //vbCalcul.getChildren().add(tCalcul);
        //vbText.getChildren().addAll(screenCalcul, answer);
        //screenCalcul.intersects(20, 20, 300, 500);
        vbText.getChildren().addAll(screenCalcul);
        
        // on instancie la hbox qui contiendra les boutons:
        hbButton = new HBox(20);
        hbButton.setSpacing(150);
        // on instancie les boutons
        //btCheck = new Button("Vérifier");
        btReponse = new Button("Solution");
        btOtherCalcul = new Button("Autre Calcul");
        //btCheck.setMinSize(100, 50);
        btReponse.setMinSize(100, 50);
        btOtherCalcul.setMinSize(100, 50);
        hbButton.setAlignment(Pos.CENTER);
        
        
        // on ajoute les boutons au hbox
        //hbButton.getChildren().addAll(btCheck, btReponse, btOtherCalcul);
        hbButton.getChildren().addAll(btReponse, btOtherCalcul);

        // on ajoute les 2 box au container parent      
        this.setTop(vbCalcul);
        this.setCenter(vbText);
        this.setBottom(hbButton);    
    
    }
    
    /*
    La fonction appuyer() qui serait appelée quand l'utilisateur clique sur la touche.
    //La fonction relacher() qui serait appelée quand l'utilisateur relâche son clic.  
    public void appuyer(){
    //instructions
    }    
    //public void relacher(){
    //instructions
    //}
    this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
    */
        
}
