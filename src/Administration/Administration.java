package Administration;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Administration extends VBox{
    
    public Administration(){

        //Choix du Niveau
        GridPane radioGrid = new GridPane();
        ToggleGroup radioniveauGroup = new ToggleGroup();
             
        Label radioText = new Label("Niveau de la question à modifier");
        RadioButton radioniveau1 = new RadioButton("1");
        RadioButton radioniveau2 = new RadioButton("2");
        
        radioniveau1.setToggleGroup(radioniveauGroup);
        radioniveau2.setToggleGroup(radioniveauGroup);
        
        radioGrid.add(radioText,1,0);
        radioGrid.add(radioniveau1,2,0);
        radioGrid.add(radioniveau2,3,0);
        
        //radioGrid.vgapProperty(20);
        //Choix modifier et ajouter
        GridPane modifierajouterGrid = new GridPane();
        
        Button btnmodifier = new Button("Modifier");
        Button btnajouter = new Button("Ajouter");
        modifierajouterGrid.add(btnmodifier, 1, 0);
        modifierajouterGrid.add(btnajouter, 2, 0);
        //Choix question et reponse
        GridPane questionreponseGrid = new GridPane();
        
        Label question_label = new Label("Question");
        questionreponseGrid.add(question_label, 0, 1);
        
        Label reponse_label = new Label("Reponse");
        questionreponseGrid.add(reponse_label, 0, 2);       
        
        TextField questiontext = new TextField();
        questionreponseGrid.add(questiontext, 1, 1);
        
        TextField reponseText = new TextField();
        questionreponseGrid.add(reponseText, 1, 2);
        
        //Choix bouton enregistrer
        Button btnenregistrer = new Button("Enregistrer");
        
        this.setSpacing(30);

        this.getChildren().add(radioGrid);
        this.getChildren().add(modifierajouterGrid);
        this.getChildren().add(questionreponseGrid);
        this.getChildren().add(btnenregistrer);
        
        radioGrid.setAlignment(Pos.TOP_CENTER);
        modifierajouterGrid.setAlignment(Pos.TOP_CENTER);
        questionreponseGrid.setAlignment(Pos.TOP_CENTER);
        btnenregistrer.setAlignment(Pos.TOP_CENTER);
        
        
        this.setAlignment(Pos.CENTER);
    }
}
