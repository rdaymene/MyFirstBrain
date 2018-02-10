package Administration;

import DAO.Dao;
import DAO.QuestionBean;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import myfirstbrain.MyFirstBrain;

public class Administration extends VBox {

    private final Image administration = new Image(getClass().getResourceAsStream("backgroundadministration.png"));
    private final BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background backgroundadministration = new Background(new BackgroundImage(administration,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));

    private int localLevel = 2;
    private Dao adminDAO;
    private ComboBox comboListID;                      /////////COMBO TOOL
    private QuestionBean qb;
    private ArrayList<QuestionBean> listLevel;

    private final VBox radiovbox;

    private final GridPane radioGrid;
    private final ToggleGroup radioLevelGroup;

    private final Label radioText;
    private final RadioButton radioLevel1;
    private final RadioButton radioLevel2;
    private final GridPane gridModifyAdd;

    private final VBox vboxAdd;

    private final Label labelAdd;

    private final GridPane gridAddQA;
    private final Label labelAddQuest;
    private final TextArea textAddQuest;
    private final Label labelAddAnsw;
    private final TextArea textAddAnsw;
    //bouton du panneau modifier
    private final GridPane gridAddSaveCancel;
    private final Button btAddCancel;
    private final Button btAddSave;

    private final VBox vboxModify;

    private final Label labelModify;

    private final GridPane gridModifyQA;

    private final Label labelModifyComboBox; ///////////////COMBO LABEL

    private final Label labelModifyQuestion;
    private final TextArea textModifyQuestion;
    private final Label labelModifyAnsw;
    private final TextArea textModifyAnsw;
    //bouton du panneau modifier
    private final GridPane gridModifySaveCancel;
    private final Button btModifyCancel;
    private final Button btModifySave;
    private final Button btLogOff;

    public Administration() {

        //Choix du Niveau
        radiovbox = new VBox();

        radioGrid = new GridPane();
        radioLevelGroup = new ToggleGroup();

        radioText = new Label("Niveau de la question à modifier");
        radioText.setPadding(new Insets(10, 10, 10, 10));
        radioText.setFont(new Font("Verdana", 18));
        radioLevel1 = new RadioButton("1");
        radioLevel2 = new RadioButton("2");

        //set the value of my radio buttons       
        radioLevel1.setUserData("1");
        radioLevel2.setUserData("2");

        radioLevel1.setToggleGroup(radioLevelGroup);
        radioLevel2.setToggleGroup(radioLevelGroup);
        radioLevel2.setSelected(true); // set default to 2

        radioGrid.add(radioLevel1, 0, 1);
        radioGrid.add(radioLevel2, 1, 1);
        radioGrid.setHgap(20);
        radioGrid.setAlignment(Pos.CENTER);

        radiovbox.getChildren().add(radioText);
        radiovbox.getChildren().add(radioGrid);

        //radioGrid.vgapProperty(20);
//=============================== CONTAINER DU PANNEAU MODIFIER ET AJOUTER ======================================
        gridModifyAdd = new GridPane();
//=============================== PANNEAU AJOUTER ==============================================================
        //Construction de l'affichage du panneau qui permet d'ajouter une question
//<editor-fold>
        vboxAdd = new VBox();

        labelAdd = new Label("Ajouter");
        labelAdd.setFont(new Font("Verdana", 25));
        labelAdd.setAlignment(Pos.CENTER);

        gridAddQA = new GridPane();
        gridAddQA.setVgap(5);

        labelAddQuest = new Label("Question");
        textAddQuest = new TextArea();
        textAddQuest.setPrefRowCount(2);
        textAddQuest.setPrefColumnCount(15);
        textAddQuest.setWrapText(true);

        labelAddAnsw = new Label("Réponse");
        textAddAnsw = new TextArea();
        textAddAnsw.setPrefRowCount(2);
        textAddAnsw.setPrefColumnCount(15);
        textAddAnsw.setWrapText(true);
        Label vide = new Label("");
        vide.setPadding(new Insets(7, 7, 7, 7));
        gridAddQA.add(vide, 0, 1);
        gridAddQA.add(labelAddQuest, 0, 2);
        gridAddQA.add(labelAddAnsw, 0, 3);
        gridAddQA.add(textAddQuest, 1, 2);
        gridAddQA.add(textAddAnsw, 1, 3);

        gridAddSaveCancel = new GridPane();
        btAddCancel = new Button("Annuler");
        btAddSave = new Button("Enregistrer");
        gridAddSaveCancel.add(btAddCancel, 0, 1);
        gridAddSaveCancel.add(btAddSave, 1, 1);
        gridAddSaveCancel.setHgap(10);
        gridAddSaveCancel.setAlignment(Pos.CENTER);
        vboxAdd.getChildren().add(labelAdd);
        vboxAdd.getChildren().add(gridAddQA);
        vboxAdd.getChildren().add(gridAddSaveCancel);
        vboxAdd.setSpacing(10);

//</editor-fold>
//=============================== PANNEAU MODIFIER ==============================================================        
//<editor-fold>
        //Construction de l'affichage du panneau qui permet de modifier une question
        vboxModify = new VBox();

        labelModify = new Label("Modifier");
        labelModify.setFont(new Font("Verdana", 25));

        labelModify.setAlignment(Pos.CENTER);

        gridModifyQA = new GridPane();
        gridModifyQA.setVgap(5);
        labelModifyQuestion = new Label("Question");
        labelModifyComboBox = new Label("List id"); // info COMBOBOX
        comboListID = new ComboBox();
        textModifyQuestion = new TextArea();
        textModifyQuestion.setPrefRowCount(2);
        textModifyQuestion.setPrefColumnCount(15);
        textModifyQuestion.setWrapText(true);
        labelModifyAnsw = new Label("Réponse");
        textModifyAnsw = new TextArea();
        textModifyAnsw.setPrefRowCount(2);
        textModifyAnsw.setPrefColumnCount(15);
        textModifyAnsw.setWrapText(true);

        //addition de mon ComboBox qui n est pas top  :-/
        gridModifyQA.add(labelModifyComboBox, 0, 1);
        gridModifyQA.add(comboListID, 1, 1);

        gridModifyQA.add(labelModifyQuestion, 0, 2);
        gridModifyQA.add(labelModifyAnsw, 0, 3);
        gridModifyQA.add(textModifyQuestion, 1, 2);
        gridModifyQA.add(textModifyAnsw, 1, 3);

        gridModifySaveCancel = new GridPane();
        btModifyCancel = new Button("Annuler");
        btModifySave = new Button("Enregistrer");
        gridModifySaveCancel.add(btModifyCancel, 0, 1);
        gridModifySaveCancel.add(btModifySave, 1, 1);
        gridModifySaveCancel.setHgap(10);
        gridModifySaveCancel.setAlignment(Pos.CENTER);

        vboxModify.getChildren().add(labelModify);

        vboxModify.getChildren().add(gridModifyQA);
        vboxModify.getChildren().add(gridModifySaveCancel);

        vboxModify.setSpacing(10);

        gridModifyAdd.add(vboxAdd, 0, 1);
        gridModifyAdd.add(vboxModify, 1, 1);

        gridModifyAdd.setHgap(30);

        btLogOff = new Button("Se déconnecter");
//</editor-fold>

        //rajout du background administration
        this.setBackground(backgroundadministration);
        feedingComboBOX(comboListID);

        this.setSpacing(30);

        this.getChildren().add(radiovbox);
        this.getChildren().add(gridModifyAdd);
        this.getChildren().add(btLogOff);

        radiovbox.setAlignment(Pos.TOP_CENTER);
        gridModifyAdd.setAlignment(Pos.TOP_CENTER);
        btLogOff.setAlignment(Pos.TOP_CENTER);

        this.setAlignment(Pos.CENTER);

//========== EVENT SAVE MODIF BUTTON
//<editor-fold>
        btModifySave.setOnAction(e -> {

            if (!textModifyAnsw.getText().trim().isEmpty()) {
                qb = adminDAO.find((int) comboListID.getValue());
                qb.setQuestion(textModifyQuestion.getText());
                qb.setReponse(textModifyAnsw.getText());
                qb.setNiveau(localLevel);
                qb = adminDAO.update(qb);
                loadingCombo();
            }
        });
        //</editor-fold>
//========== EVENT LOGOFF 
//<editor-fold>
        btLogOff.setOnAction(e -> {
            MyFirstBrain.tabPane.getTabs().remove(AdministrationLogin.administrationTab);
            MyFirstBrain.selectionModel.select(0);
        });
        //</editor-fold>
//========== EVENT SAVE ADD BUTTON
//<editor-fold>
        btAddSave.setOnAction(e -> {

            if (!textAddAnsw.getText().trim().isEmpty()) {
                QuestionBean qbAjout = new QuestionBean(
                        0,
                        localLevel,
                        textAddQuest.getText(),
                        textAddAnsw.getText()
                );
                qb = adminDAO.create(qbAjout);
                loadingCombo();
                textAddAnsw.clear();
                textAddQuest.clear();

            }
        });
//</editor-fold>
//========== EVENT COMBOBOX
//<editor-fold>
        comboListID.setOnAction(e -> {

//            a ce moment la je ne connais que mon ID, je dois donc faire une recherche sur la base, pour me 
//            donner par rapport a l ID, quel est la question et reponse associe.
//            j appelle une fonction GETID de ma DAO, qui me retourne un oject de type QuestionDAO,
//            et grace a cet object je pourrais updater mes textfields
//            adminDAO est de type DAO
            if (comboListID.getValue() != null) {
                qb = adminDAO.find((int) comboListID.getValue());
                textModifyQuestion.setText(qb.getQuestion());
                textModifyAnsw.setText(qb.getReponse());
            }

        });
//</editor-fold>
//========== RADIO BUTTON
//<editor-fold>

        radioLevelGroup.selectedToggleProperty().addListener(e -> {

            String tmplevel = radioLevelGroup.getSelectedToggle().getUserData().toString();
            localLevel = Integer.valueOf(tmplevel);
            loadingCombo();
        });
//</editor-fold>
//=========== EVENT CANCEL ADD BUTTON
//<editor-fold>
        btAddCancel.setOnAction(e -> {
            textAddAnsw.clear();
            textAddQuest.clear();
            loadingCombo();
        });

//</editor-fold>
//=========== EVENT CANCEL MODIFY BUTTON
//<editor-fold>
        btModifyCancel.setOnAction(e -> {
            loadingCombo();
        });

//</editor-fold>
    }

    private void feedingComboBOX(ComboBox boxy) {
        adminDAO = new Dao();
        listLevel = adminDAO.fillCollection(localLevel);

        for (QuestionBean qb : listLevel) {
            boxy.getItems().add(qb.getID());
        }
    }

    private void loadingCombo() {
        comboListID.getSelectionModel().clearSelection();
        comboListID.getItems().clear();

        textModifyQuestion.clear();
        textModifyAnsw.clear();

        feedingComboBOX(comboListID);
    }

}
