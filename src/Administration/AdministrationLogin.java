package Administration;

import java.io.IOException;
import javafx.scene.paint.Color;
import java.util.Properties;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import myfirstbrain.MyFirstBrain;

public class AdministrationLogin {

    public static Tab administrationTab;
    private String USER;
    private String PASSWORD;
    private boolean flagPwd;
    private boolean flagUser;
    private GridPane gridLogin;

    private VBox administrationlogin;
    private Scene sceneLogin;
    private Stage stageLogin;

    private Label labelUser;
    private Label labelPwd;

    private TextField loginText;
    private PasswordField pwdText;

    private GridPane gridCancelLogin;
    private Button btCancel;
    private Button btLogin;
    private Label labelErrorUser;
    private Label labelErrorPwd;
    private Properties recup_info;

    private Administration my_administration;

    public AdministrationLogin(Stage primaryStage) {

        //BorderPane administrationlogin
        administrationlogin = new VBox();

        gridLogin = new GridPane();

        sceneLogin = new Scene(administrationlogin, 350, 200);

        stageLogin = new Stage();

        gridLogin.setAlignment(Pos.CENTER);
        gridLogin.setHgap(10);
        gridLogin.setVgap(10);
        gridLogin.setPadding(new Insets(25, 25, 25, 25));

        stageLogin.setTitle("Administration Login");
        stageLogin.setScene(sceneLogin);

        stageLogin.initModality(Modality.APPLICATION_MODAL);

        labelUser = new Label("Nom d'utilisateur");
        gridLogin.add(labelUser, 0, 1);

        labelPwd = new Label("Mot de passe");
        gridLogin.add(labelPwd, 0, 2);

        loginText = new TextField();
        gridLogin.add(loginText, 1, 1);

        pwdText = new PasswordField();
        gridLogin.add(pwdText, 1, 2);

        gridCancelLogin = new GridPane();
        btCancel = new Button("Annuler");
        btLogin = new Button("Login");

        GridPane gridError = new GridPane();
        labelErrorUser = new Label("");
        labelErrorPwd = new Label("");
        gridError.add(labelErrorUser, 1, 0);
        gridError.add(labelErrorPwd, 1, 1);

        gridError.setTranslateX(110);
        gridError.setTranslateY(10);

        gridCancelLogin.add(btCancel, 1, 0);
        gridCancelLogin.add(btLogin, 2, 0);

        btCancel.setAlignment(Pos.TOP_LEFT);
        btLogin.setAlignment(Pos.TOP_LEFT);

        gridCancelLogin.setAlignment(Pos.CENTER);

        gridCancelLogin.setHgap(40);

        administrationlogin.getChildren().add(gridLogin);
        administrationlogin.getChildren().add(gridCancelLogin);
        administrationlogin.getChildren().add(gridError);

        stageLogin.initOwner(primaryStage);
        stageLogin.setX(primaryStage.getX() + 200);
        stageLogin.setY(primaryStage.getY() + 100);
        stageLogin.show();

        //Chargement des variables 
        // Crée un objet properties        
        recup_info = new Properties();

        try {
            recup_info.load(this.getClass().getResourceAsStream("/ressources/ManagementInfo"));

        } catch (IOException ex) {
            System.out.println("Fichier property << Management Info >> n'a pas pu être lu");
        }

        USER = recup_info.getProperty("USER");
        PASSWORD = recup_info.getProperty("PASSWORD");

//==================  EVENT LOGIN BUTTON
//<editor-fold>
        btLogin.setOnAction(e -> {


            if (loginText.getText().equals(USER)) {
                labelErrorPwd.setText("");
                labelErrorUser.setText("");
                flagUser = true;
                
                if (PASSWORD.equals(pwdText.getText())) {
                    flagPwd = true;
                } else {
                    // text rouge // ou logo 
                    // mettre flagPwd false
                    labelErrorPwd.setText("Mot de passe erroné");
                    labelErrorPwd.setTextFill(Color.RED);
                    flagPwd = false;
                }
            } else {
                // text rouge // ou logo 
                // mettre flagUser True
                labelErrorUser.setText("Cet utilisateur n'existe pas");
                labelErrorUser.setTextFill(Color.RED);
                flagUser = false;

            }
            if (flagPwd && flagUser) {
                //System.out.println("there is a match!!");
                if(!MyFirstBrain.tabPane.getTabs().contains(administrationTab)){
                //Creation de l'onget tab avec un label Administration
                my_administration = new Administration();
                administrationTab = new Tab("Administration");
                administrationTab.setContent(my_administration);
                administrationTab.getStyleClass().add("Tab");
               
                administrationTab.setClosable(false);

                MyFirstBrain.tabPane.getTabs().add(administrationTab);
                MyFirstBrain.selectionModel.select(4);                
                stageLogin.close();
                }
            }

        });
//</editor-fold>
//=========== EVENT CANCEL 
//<editor-fold>
        btCancel.setOnAction(e -> {
            stageLogin.close();
        });

//</editor-fold>
    }

}
