package myfirstbrain;

import Draw.Draw;
import Menu.MenuForm;
import Question.Questions;
import calcul.Calcul;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyFirstBrain extends Application {
    // attribut question
    Questions questions;
    Calcul calcul;      // attribut calcul
    @Override
    public void start(Stage primaryStage) {
        
        questions = new Questions();
        calcul = new Calcul();   //création d'un objet calcul
        BorderPane root = new BorderPane();
        MenuForm menuBar = new MenuForm();
        Draw my_draw = new Draw();
        //=============================== CREATION DE TAB DES FONCTIONS DU PROGRAMME ======================================
        Tab drawTab = new Tab("Dessin");
        Tab calculTab = new Tab("Calcul");
        calculTab.setContent(this.calcul);
        
        Tab questionTab = new Tab("Questions");        
        drawTab.setContent(my_draw);
        questionTab.setContent(this.questions);        
        Tab administrationTab = new Tab("Administration"); 
        
        drawTab.setClosable(false);
        calculTab.setClosable(false);
        questionTab.setClosable(false);
        administrationTab.setClosable(false);
        
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(drawTab);
        tabPane.getTabs().add(calculTab);
        tabPane.getTabs().add(questionTab);
        tabPane.getTabs().add(administrationTab);
       
        Scene scene = new Scene(root, 1000, 600);
        
        root.setCenter(tabPane);
        root.setTop(menuBar);
        
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
