package myfirstbrain;

import Administration.Administration;
import Draw.Draw;
import Menu.MenuForm;
import Question.Questions;
import calcul.Calcul;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyFirstBrain extends Application {

    public static SingleSelectionModel<Tab> selectionModel;
    // attribut question
    public static Questions questions;
    public static Calcul calcul;
    // getter question
    public static Tab questionTab;
    public static Tab calculTab;
    Stage primaryStage;
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;  
        BorderPane root = new BorderPane();
        MenuForm menuBar = new MenuForm(primaryStage);
        questions = new Questions();
        //création d'un objet calcul
        calcul = new Calcul(); 
        Administration my_administration = new Administration();
        Draw my_draw = new Draw();
        //=============================== CREATION DE TAB DES FONCTIONS DU PROGRAMME ======================================
        //On crée un onglet pour chaque jeu de notre programme

        //Onglet 1 : L'ardoise magique
        //Creation de l'onget tab avec un label Dessin
        Tab drawTab = new Tab("Dessin");
        //On rajoute le contenu crée à partir de la classe Dessin
        drawTab.setContent(my_draw);

        //Creation de l'onget tab avec un label Calcul
        calculTab = new Tab("Calcul");
        //On rajoute le contenu crée à partir de la classe Calcul
        calculTab.setContent(this.calcul);

        //Creation de l'onget tab avec un label Questions
        questionTab = new Tab("Questions");
        //On rajoute le contenu crée à partir de la classe Questions
        questionTab.setContent(this.questions);
        
        //Creation de l'onget tab avec un label Administration
        Tab administrationTab = new Tab("Administration");
        //On rajoute le contenu crée à partir de la classe Administration
        administrationTab.setContent(my_administration);

        //enlever le bouton pour fermer un onglet
        drawTab.setClosable(false);
        calculTab.setClosable(false);
        questionTab.setClosable(false);
        administrationTab.setClosable(false);

        //creation du TabBane qui contiendra l'ensemble de nos onglets 
        TabPane tabPane = new TabPane();
        //ajout de chaque tab à la tabPane principale.
        tabPane.getTabs().add(drawTab);
        tabPane.getTabs().add(calculTab);
        tabPane.getTabs().add(questionTab);
        tabPane.getTabs().add(administrationTab);
        selectionModel = tabPane.getSelectionModel();
        selectionModel.select(0);
       MyFirstBrain.questions.getTfInput().requestFocus();
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> arg0, Tab arg1, Tab arg2) -> {
            if (arg2 == questionTab) {
                this.questions = new Questions();
                questionTab.setContent(questions);
                
            }
        });

        //creation de la scene principale de notre programme
        Scene scene = new Scene(root, 1000, 600);
        //on place le menuBar et la tabPane
        root.setCenter(tabPane);
        root.setTop(menuBar);
        root.getStylesheets().add("file:stylesheet.css");
        primaryStage.setResizable(false);
        primaryStage.setTitle("MyFirstBrain");
        primaryStage.setScene(scene);
         
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
