package Administration;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdministrationLogin {
    
    public AdministrationLogin(Stage primaryStage){
        
        //BorderPane administrationlogin
        
        VBox administrationlogin = new VBox();
        
        GridPane champloginetpass = new GridPane();
        
        Scene scene_formulaire = new Scene(administrationlogin, 350, 200);
        
        Stage stage_formulaire = new Stage();
        
        champloginetpass.setAlignment(Pos.CENTER);
        champloginetpass.setHgap(10);
        champloginetpass.setVgap(10);
        champloginetpass.setPadding(new Insets(25, 25, 25, 25));
        
        stage_formulaire.setTitle("Administration Login");
        stage_formulaire.setScene(scene_formulaire);
        
        stage_formulaire.initModality(Modality.APPLICATION_MODAL);
        
        Label login_label = new Label("Nom d'utilisateur");
        champloginetpass.add(login_label, 0, 1);
        
        Label pass_label = new Label("Mot de passe");
        champloginetpass.add(pass_label, 0, 2);
        
        TextField logintext = new TextField();
        champloginetpass.add(logintext, 1, 1);
        
        TextField passText = new TextField();
        champloginetpass.add(passText, 1, 2);
        
        GridPane annulerokGrid = new GridPane();
        Button btnannuler = new Button("Annuler");
        Button btnok = new Button("Ok");
        
        annulerokGrid.add(btnannuler,1,0);
        annulerokGrid.add(btnok,2,0);
        
        btnannuler.setAlignment(Pos.TOP_LEFT);
        btnok.setAlignment(Pos.TOP_LEFT);
        
        annulerokGrid.setAlignment(Pos.CENTER);
        
        annulerokGrid.setHgap(40);
        
        administrationlogin.getChildren().add(champloginetpass);
        administrationlogin.getChildren().add(annulerokGrid);
        
        stage_formulaire.initOwner(primaryStage);
        stage_formulaire.setX(primaryStage.getX() + 200);
        stage_formulaire.setY(primaryStage.getY() + 100);
        stage_formulaire.show();
    }
}