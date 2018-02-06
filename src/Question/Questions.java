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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author $céline
 */
public class Questions extends VBox {

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
    private HBox hbButton;//contient les 3 boutons

    public Questions() {
        // on instancie l'objet Dao et les 2 listes d'objet question
        // questionDAO = new Dao();
        // ListNiveau1 = questionDAO.fillCollection(1);// remplit la collection avec les questions faciles
        //  ListNiveau2 = questionDAO.fillCollection(2);// remplit la collection avec les questions difficiles
        // on instancie la vbox avec 10 d'écart entre les composants
        this.setSpacing(20);// on met un espace de 20 entre les éléments du container parent
        this.setPadding(new Insets(15, 10, 15, 10));// on fait le padding du container parent
        vbText = new VBox(30);
        // on instancie le champ question
        tQuestion = new Text("Ici la question ?");
        //tQuestion.setTextAlignment(TextAlignment.LEFT);
        // on instancie le champ réponse
        tfInput = new TextField();
        tfInput.setPromptText("Entrez votre réponse");
        tfInput.setPrefHeight(50);
        tfInput.setPrefWidth(25);
        tfInput.setTranslateY(100);
        // on instancie le text qui fera apparaitre la bonne réponse
        answer = new Text();
        // on ajoute ces éléments à la vbox
        vbText.getChildren().addAll(tQuestion, tfInput, answer);
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
        hbButton.setTranslateY(180);
        // on ajoute les boutons au hbox
        hbButton.getChildren().addAll(btCheck, btSolution, btOtherQuestion);

        // on ajoute les 2 box au container parent      
        this.getChildren().addAll(vbText, hbButton);
    }

}
