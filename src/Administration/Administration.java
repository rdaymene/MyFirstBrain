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
    
    private final VBox radiovbox;
    
    private final GridPane radioGrid;
    private final ToggleGroup radioniveauGroup;

    private final Label radioText;
    private final RadioButton radioniveau1;
    private final RadioButton radioniveau2;
    private final GridPane modifieretajoutergrid;
    
    private final VBox ajoutervbox ;
    
    private final Label labelajouter;
    
    private final GridPane questionreponsegridajoutergrid;
    private final Label question_label_ajouter ;
    private final TextField questionajoutertext ;
    private final Label reponse_label_ajouter ;
    private final TextField reponseajoutertext ;
    //bouton du panneau modifier
    private final GridPane annuleretenregisterajoutergrid;
    private final Button annulerajouter;
    private final Button enregistrerajouter;
    
    
    
    private final VBox modifiervbox ;
    
    private final Label labelmodifier;
    
    private final GridPane questionreponsemodifiergrid;
    private final Label question_label_modifier ;
    private final TextField questionmodifiertext ;
    private final Label reponse_label_modifier ;
    private final TextField reponsemodifiertext ;
    //bouton du panneau modifier
    private final GridPane annuleretenregistrermodifiergrid;
    private final Button annulermodifier;
    private final Button enregistrermodifier;
    
    private final Button btnsedeconnecter;
    
    public Administration(){
       
        //Choix du Niveau
        radiovbox = new VBox();
        
        radioGrid = new GridPane();
        radioniveauGroup = new ToggleGroup();
             
        radioText = new Label("Niveau de la question à modifier");
        radioniveau1 = new RadioButton("1");
        radioniveau2 = new RadioButton("2");
        
        radioniveau1.setToggleGroup(radioniveauGroup);
        radioniveau2.setToggleGroup(radioniveauGroup);
        
        radioGrid.add(radioniveau1,0,1);
        radioGrid.add(radioniveau2,1,1);
        radioGrid.setHgap(20);
        radioGrid.setAlignment(Pos.CENTER);
        
        radiovbox.getChildren().add(radioText);
        radiovbox.getChildren().add(radioGrid);
        
        //radioGrid.vgapProperty(20);
//=============================== CONTAINER DU PANNEAU MODIFIER ET AJOUTER ======================================
        modifieretajoutergrid = new GridPane();
//=============================== PANNEAU AJOUTER ==============================================================
        //Construction de l'affichage du panneau qui permet d'ajouter une question
        ajoutervbox = new VBox();
        
        labelajouter = new Label("Ajouter");
        labelajouter.setAlignment(Pos.CENTER);
        
        questionreponsegridajoutergrid = new GridPane();
        question_label_ajouter = new Label("Question");
        questionajoutertext = new TextField();
        reponse_label_ajouter = new Label("Réponse");
        reponseajoutertext = new TextField();
        questionreponsegridajoutergrid.add(question_label_ajouter, 0, 1);
        questionreponsegridajoutergrid.add(reponse_label_ajouter, 0, 2);
        questionreponsegridajoutergrid.add(questionajoutertext, 1, 1);
        questionreponsegridajoutergrid.add(reponseajoutertext, 1, 2);
        
        annuleretenregisterajoutergrid = new GridPane();
        annulerajouter = new Button("Annuler");
        enregistrerajouter = new Button("Enregistrer");
        annuleretenregisterajoutergrid.add(annulerajouter, 0, 1);
        annuleretenregisterajoutergrid.add(enregistrerajouter, 1, 1);
        
        ajoutervbox.getChildren().add(labelajouter);
        ajoutervbox.getChildren().add(questionreponsegridajoutergrid);
        ajoutervbox.getChildren().add(annuleretenregisterajoutergrid);
        
        ajoutervbox.setSpacing(20);
           
//=============================== PANNEAU MODIFIER ==============================================================        
        //Construction de l'affichage du panneau qui permet de modifier une question
        modifiervbox = new VBox();
        
        labelmodifier = new Label("Modifier");
        labelmodifier.setAlignment(Pos.CENTER);
        
        questionreponsemodifiergrid = new GridPane();
        question_label_modifier = new Label("Question");
        questionmodifiertext = new TextField();
        reponse_label_modifier = new Label("Réponse");
        reponsemodifiertext = new TextField();
        
        questionreponsemodifiergrid.add(question_label_modifier, 0, 1);
        questionreponsemodifiergrid.add(reponse_label_modifier, 0, 2);
        questionreponsemodifiergrid.add(questionmodifiertext, 1, 1);
        questionreponsemodifiergrid.add(reponsemodifiertext, 1,2);
        
        annuleretenregistrermodifiergrid = new GridPane();
        annulermodifier = new Button("Annuler");
        enregistrermodifier = new Button("Enregistrer");
        annuleretenregistrermodifiergrid.add(annulermodifier, 0, 1);
        annuleretenregistrermodifiergrid.add(enregistrermodifier,1, 1);
        
        modifiervbox.getChildren().add(labelmodifier);
        modifiervbox.getChildren().add(questionreponsemodifiergrid);
        modifiervbox.getChildren().add(annuleretenregistrermodifiergrid);
        
        modifiervbox.setSpacing(20);
        
        modifieretajoutergrid.add(ajoutervbox, 0, 1);
        modifieretajoutergrid.add(modifiervbox, 1, 1);
        
        modifieretajoutergrid.setHgap(30);
        
        btnsedeconnecter = new Button("Se déconnecter");
 
        this.setSpacing(50);

        this.getChildren().add(radiovbox);
        this.getChildren().add(modifieretajoutergrid);
        this.getChildren().add(btnsedeconnecter);
        
        radiovbox.setAlignment(Pos.TOP_CENTER);
        modifieretajoutergrid.setAlignment(Pos.TOP_CENTER);
        btnsedeconnecter.setAlignment(Pos.TOP_CENTER);
        
        this.setAlignment(Pos.CENTER);
    }
}
