package Administration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public AdministrationLogin(Stage primaryStage) {

        //BorderPane administrationlogin
        VBox administrationlogin = new VBox();

        GridPane champloginetpass = new GridPane();

        Scene sceneLogin = new Scene(administrationlogin, 350, 200);

        Stage stageLogin = new Stage();

        champloginetpass.setAlignment(Pos.CENTER);
        champloginetpass.setHgap(10);
        champloginetpass.setVgap(10);
        champloginetpass.setPadding(new Insets(25, 25, 25, 25));

        stageLogin.setTitle("Administration Login");
        stageLogin.setScene(sceneLogin);

        stageLogin.initModality(Modality.APPLICATION_MODAL);

        Label login_label = new Label("Nom d'utilisateur");
        champloginetpass.add(login_label, 0, 1);

        Label pass_label = new Label("Mot de passe");
        champloginetpass.add(pass_label, 0, 2);

        TextField loginText = new TextField();
        champloginetpass.add(loginText, 1, 1);

        TextField pwdText = new TextField();
        champloginetpass.add(pwdText, 1, 2);

        GridPane annulerokGrid = new GridPane();
        Button btnannuler = new Button("Annuler");
        Button btnLogin = new Button("Login");

        annulerokGrid.add(btnannuler, 1, 0);
        annulerokGrid.add(btnLogin, 2, 0);

        btnannuler.setAlignment(Pos.TOP_LEFT);
        btnLogin.setAlignment(Pos.TOP_LEFT);

        annulerokGrid.setAlignment(Pos.CENTER);

        annulerokGrid.setHgap(40);

        administrationlogin.getChildren().add(champloginetpass);
        administrationlogin.getChildren().add(annulerokGrid);

        stageLogin.initOwner(primaryStage);
        stageLogin.setX(primaryStage.getX() + 200);
        stageLogin.setY(primaryStage.getY() + 100);
        stageLogin.show();

        //Chargement des variables 
        // Crée un objet properties        
        Properties recup_info = new Properties();

        //INFO >> je cree une instance de type MySQLConnection, pour pouvoir utiliser 
        //getClass, car la methode getClass ne fctionne qu avec des instances.
        try {
            recup_info.load(this.getClass().getResourceAsStream("/ressources/ManagementInfo"));

        } catch (IOException ex) {
            System.out.println("Fichier property << Management Info >> n'a pas pu être lu");
        }
        USER = recup_info.getProperty("USER");
        PASSWORD = recup_info.getProperty("PASSWORD");
        loginText.setText(USER);
        pwdText.setText(PASSWORD);

        btnLogin.setOnAction(e -> {

            if (recup_info.equals(loginText.getText())) {
//      //mettre un text rouge // ou logo 
//flagUser false
                flagUser = false;
            } else {
                //clear text rouge // ou logo 
                // mettre flagUser True
                flagUser = true;
            }
            if (!recup_info.get("PASSWORD").equals(pwdText.getText())) {
                //mettre un text rouge // ou logo
                // mettre flagPwd false
                flagPwd = false;
            } else {
                //clear text rouge // ou logo 
                // mettre flagPwd true
                flagPwd = true;
            }
            if (flagPwd && flagUser) {
                System.out.println("there is a match!!");
                Administration my_administration = new Administration();
                //Creation de l'onget tab avec un label Administration
                administrationTab = new Tab("Administration");
                administrationTab.setContent(my_administration);
                administrationTab.setClosable(false);
                
                MyFirstBrain.tabPane.getTabs().add(administrationTab);
                stageLogin.close();
                
            }

        });

    }

}
