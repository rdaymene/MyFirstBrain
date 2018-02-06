/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import DAO.Dao;
import DAO.QuestionBean;
import Menu.MenuForm;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    private Label tQuestion;
    private TextField tfInput;
    private Text answer;
    private Button btCheck;
    private Button btSolution;
    private Button btOtherQuestion;
    private VBox vbText;//contient les 2 textfield (question et saisie réponse) 
    private VBox vbQuestion;
    private HBox hbButton;//contient les 3 boutons
    private QuestionBean questionBean;

    public Questions() {
        // on instancie l'objet Dao et les 2 listes d'objet question
        questionDAO = new Dao();
        ListNiveau1 = questionDAO.fillCollection(1);// remplit la collection avec les questions faciles
//         ListNiveau2 = questionDAO.fillCollection(2);// remplit la collection avec les questions difficiles

        this.setPadding(new Insets(15, 10, 15, 10));// on fait le padding du container parent
        vbText = new VBox(30);
        vbQuestion = new VBox();
        // on instancie le champ question
        tQuestion = new Label();
        tQuestion.setFont(new Font("Verdana", 30)); // grosse fonte pour la question 
        tQuestion.setTranslateY(20);
        tQuestion.setTranslateX(40);
        tQuestion.setWrapText(true);
        //on remplit le texte avec une question aléatoire
        this.questionBean = ListNiveau1.get(getRandomQuestionBean(1));
        tQuestion.setText(questionBean.getQuestion());

        vbQuestion.setAlignment(Pos.CENTER);// on centre la question
        //tQuestion.setTextAlignment(TextAlignment.LEFT);
        // on instancie le champ réponse
        tfInput = new TextField();
        tfInput.setPromptText("Entrez votre réponse");
        tfInput.setPrefHeight(70);
        tfInput.setPrefWidth(20);
        tfInput.setPrefColumnCount(35);
        tfInput.setTranslateY(170);
        tfInput.setFont(new Font("Verdana", 30));
        tfInput.setStyle("-fx-background-color: #FEC3AC;");
        // on instancie le text qui fera apparaitre la bonne réponse
        answer = new Text();
        answer.setTranslateY(200);
        answer.setFont(new Font("Verdana", 20));
        //answer.setText(ListNiveau1.get(getRandomQuestionBean(1)));
        // on ajoute ces éléments à la vbox
        vbQuestion.getChildren().add(tQuestion);
        vbText.getChildren().addAll(tfInput, answer);
        // on instancie la hbox qui contiendra les boutons:
        hbButton = new HBox(20);
        hbButton.setSpacing(150);
        // on instancie les boutons
        btCheck = new Button("Vérifier");
        //btCheck.setStyle("-fx-background-color: #FF6F7D;");
        btSolution = new Button("Solution");
        btSolution.setStyle("-fx-background-color: #FF6F7D;");
        btOtherQuestion = new Button("Autre question");
        btOtherQuestion.setStyle("-fx-background-color: #FF6F7D;");
        btCheck.setMinSize(130, 80);
        btSolution.setMinSize(130, 80);
        btOtherQuestion.setMinSize(130, 80);
        hbButton.setAlignment(Pos.CENTER);

        // on ajoute les boutons au hbox
        hbButton.getChildren().addAll(btCheck, btSolution, btOtherQuestion);

        // on ajoute les 2 box au container parent      
        this.setTop(vbQuestion);
        this.setCenter(vbText);
        this.setBottom(hbButton);
        this.setStyle("-fx-background-color: #D473D4;");

        // gestion evenementielle du bouton vérifier
        btCheck.setOnAction(e -> {
            answer.setText(null);
            tfInput.setStyle("-fx-background-color : #fff");
            // on appelle la methode booleenne de compraison question réponse
            if (getQuestionBeanFromList(tQuestion.getText(), tfInput.getText(), 1)) {
                // on colorie la zone réponse en vert
                tfInput.setStyle("-fx-background-color : #3A9D23");

            } else {
                //on colorie la zone réponse en rouge
                tfInput.setStyle("-fx-background-color : #FF0000;");

            }

        });
        // gestion évènement du bouton solution
        btSolution.setOnAction(e -> {
            answer.setText(null);
            tfInput.setStyle("-fx-background-color : #fff");
            if (getQuestionBeanFromList(tQuestion.getText(), tfInput.getText(), 1)) {
                // on colorie la zone réponse en vert
                tfInput.setStyle("-fx-background-color : #3A9D23");
                answer.setFill(Color.GREEN);
                answer.setText("Bonne réponse");// on affiche bonne réponse
            } else {
                //on colorie la zone réponse en rouge
               
                tfInput.setStyle("-fx-background-color : #FF0000;");
                // on affiche la bonne réponse
                answer.setFill(Color.RED);
                answer.setText("Mauvaise réponse. La réponse est : " + this.questionBean.getReponse());
            }
        });
        btOtherQuestion.setOnAction(e->{
            // on affecte a questionBean une nouvelle question
            tfInput.clear();
            
            this.questionBean = ListNiveau1.get(getRandomQuestionBean(1));
            tQuestion.setText(questionBean.getQuestion());
        });
    }
    // methode qui rend le questionBean de la collection en fonction de l'attribut question

    public boolean getQuestionBeanFromList(String question, String reponse, int niveau) {

        if (niveau == 1) {
            for (QuestionBean qb : this.ListNiveau1) {// on parcourt la collection de liste facile
                // on compare la question à sa réponse            
                if (qb.getQuestion().equals(question) && qb.getReponse().equals(reponse)) {
                    return true;// la réponse est juste
                }
            }
        } else {// on parcourt la collection de liste difficile
            for (QuestionBean qb : this.ListNiveau1) {
                if (qb.getQuestion().equals(question) && qb.getReponse().equals(reponse)) {
                    return true;// la réponse est juste

                }
            }
        }
        return false;

    }

    // generation d'un nombre aleatoire pour charger une question
    public int getRandomQuestionBean(int level) {
        Random rand = new Random();
        int min = 0;
        int randomNum = 0;
        if (level == 1) {// si niveau 1 on prend un numero de question en fonction de la liste facile

            randomNum = rand.nextInt((this.ListNiveau1.size() - min) + 1) + min;
            // numero aléatoire entre 0 et le nombre de max de question dans liste facile
        } else {
            randomNum = rand.nextInt((this.ListNiveau2.size() - min) + 1) + min;
            // numero aléatoire entre 0 et le nombre de max de question dans liste facile
        }
        return randomNum;
    }
}
