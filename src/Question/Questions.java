/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import DAO.Dao;
import DAO.QuestionBean;
import java.util.ArrayList;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author $céline
 */
public class Questions extends BorderPane {

    private Dao questionDAO;
    private ArrayList<QuestionBean> ListNiveau1;
    private ArrayList<QuestionBean> ListNiveau2;
    private Text tQuestion;
    private TextField tfInput;
    private Text answer;
    private Button btCheck;
    private Button btSolution;
    private Button btOtherQuestion;
    private VBox vbText;//contient les 2 textfield (question et saisie réponse) 
    private VBox vbQuestion;
    private HBox hbButton;//contient les 3 boutons

    public Questions() {
        // on instancie l'objet Dao et les 2 listes d'objet question
        // questionDAO = new Dao();
        // ListNiveau1 = questionDAO.fillCollection(1);// remplit la collection avec les questions faciles
        //  ListNiveau2 = questionDAO.fillCollection(2);// remplit la collection avec les questions difficiles
        
        
        this.setPadding(new Insets(15, 10, 15, 10));// on fait le padding du container parent
        vbText = new VBox(30);
        vbQuestion = new VBox();
        // on instancie le champ question
        tQuestion = new Text("Ici la question ?");
        //tQuestion.setTextAlignment(TextAlignment.LEFT);
        // on instancie le champ réponse
        tfInput = new TextField();
        tfInput.setPromptText("Entrez votre réponse");
        tfInput.setPrefHeight(50);
        tfInput.setPrefWidth(25);
        tfInput.setPrefColumnCount(35);
        tfInput.setAlignment(Pos.CENTER);
        // on instancie le text qui fera apparaitre la bonne réponse
        answer = new Text();
        // on ajoute ces éléments à la vbox
        vbQuestion.getChildren().add(tQuestion);
        vbText.getChildren().addAll(tfInput, answer);
        // on instancie la hbox qui contiendra les boutons:
        hbButton = new HBox(20);
        hbButton.setSpacing(150);
        // on instancie les boutons
        btCheck = new Button("Vérifier");
        btSolution = new Button("Solution");
        btOtherQuestion = new Button("Autre question");
        btCheck.setMinSize(100, 50);
        btSolution.setMinSize(100, 50);
        btOtherQuestion.setMinSize(100, 50);
        hbButton.setAlignment(Pos.CENTER);
        
        // on ajoute les boutons au hbox
        hbButton.getChildren().addAll(btCheck, btSolution, btOtherQuestion);

        // on ajoute les 2 box au container parent      
        this.setTop(vbQuestion);
        this.setCenter(vbText);
        this.setBottom(hbButton);
    }

}
