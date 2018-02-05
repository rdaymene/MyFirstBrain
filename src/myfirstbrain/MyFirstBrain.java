/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstbrain;

import Menu.MenuForm;
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

/**
 *
 * @author stag
 */
public class MyFirstBrain extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        MenuForm menuBar = new MenuForm();
        //=============================== CREATION DE TAB DES FONCTIONS DU PROGRAMME ======================================
        Tab drawTab = new Tab("Dessin");
        Tab calculTab = new Tab("Calcul");
        Tab questionTab = new Tab("Questions");
        Tab administrationTab = new Tab("Administration");  
        
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
