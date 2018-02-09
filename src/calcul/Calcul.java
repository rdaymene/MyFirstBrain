package calcul;

import Menu.MenuForm;
import Question.MyButton;
import static java.lang.Math.abs;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Rachid
 */
public class Calcul extends BorderPane {

    //attributs
    //Image et Background
    private final Image mathclassic = new Image(getClass().getResourceAsStream("backgroundmathclassic.png"));
    private final BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private final Background backgroundmathclassic = new Background(new BackgroundImage(mathclassic,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));
    private final Image mathexpert = new Image(getClass().getResourceAsStream("backgroundmathexpert.png"));
    private final Background backgroundmathexpert = new Background(new BackgroundImage(mathexpert,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));
    private int reponseSaisi;
    private int positionX = 0;
    private int positionY = 0;
    private int note = 0;
    private int typeOp;
    private int number1;
    private int number2;
    private int resultat;
    private String signeOperation;
    private String lettre;
    private Text tCalcul;
    private TextField screenCalcul;
    private Text answer;
    private TextField tfInput;
    private MyButton btegale;
    private MyButton btReponse;
    private MyButton btOtherCalcul;
    private VBox vbText;
    private VBox vbCalcul;
    private HBox hbButton;//contient les 2 boutons réponse et solution 
    private DoCalcul calculAtrouver;
    
    //----- Génération des chiffres et le type d'opération à éxécuter aléatoirement--------
    Text lettre_touche;

    //Avec les 2 niveaux :
    /*--constructeur par défaut--*/
    public Calcul() {
        typeOp  = getRandomOpertaion();
        number1 = getRandomChiffre();
        number2 = getRandomChiffre();
        signeOperation = new String();
        resultat = 0;
        /*---------------------Le contenaire principal de type: VBox---------------*/
        //Le padding du container parent
        this.setPadding(new Insets(15, 10, 15, 10));
        VBox vBox1 = new VBox(20);
        vBox1.setSpacing(80);
        vBox1.setAlignment(Pos.CENTER);
        //Initialisation: affichage de l'opération à faire
        String questionCalcul = getRandomCalcul(number1, number2, typeOp);        
        Label afficheurCalcul = new Label(questionCalcul + " = ?");
        afficheurCalcul.setFont(new Font("Verdana", 75));
        afficheurCalcul.setWrapText(true);
        
        TextField saisirResultat = new TextField();
        saisirResultat.setPromptText("Entrez votre réponse");
        saisirResultat.setPrefHeight(80);
        saisirResultat.setPrefWidth(25);
        saisirResultat.getStyleClass().add("TextField");// css pour le textfield 
        //Autofocus
        //saisirResultat.setFocusTraversable(false);
        //saisirResultat.requestFocus();
        // on ajoute les boutons au vBox1
        vBox1.getChildren().addAll(afficheurCalcul, saisirResultat);
        this.setCenter(vBox1);

        /*---------------------Le contenaire bas de la page de type HBox----------*/
        hbButton = new HBox(20);
        hbButton.setSpacing(150);

        // on instancie les boutons
        btReponse = new MyButton("Solution");
        btOtherCalcul = new MyButton("Autre Calcul");
        btReponse.setMinSize(100, 50);
        btOtherCalcul.setMinSize(100, 50);
        hbButton.setAlignment(Pos.CENTER);

        // on ajoute les boutons au hbox
        hbButton.getChildren().addAll(btReponse, btOtherCalcul);

        // on ajoute les 2 box au container parent 
        this.setTop(vbCalcul);
        this.setBottom(hbButton);
        //ajout du backgroundmath
        this.setBackground(MenuForm.level == 1 ? backgroundmathclassic : backgroundmathexpert);

        //-------------------- gestion evenementielle--------------------------
        /*--bouton Solution--*/
        btReponse.setOnAction(e -> {
            int reponseCandidat = 0;
            //Récupération réponse candidat en string
            String reponseCandidatStr = saisirResultat.getText();
            //Convérsion réponse candidat en int
            int result = 0;
            try{
                 //géstions les erreurs de saisi
                 this.reponseSaisi = Integer.parseInt(reponseCandidatStr);
            }catch (Exception e2) {
                System.out.println("Erreur de saisie, Veuillez saisissez un entier.");
            }finally{
                //System.out.println("Fin");                
            }
            String otherCalcul = getRandomCalcul(number1, number2, typeOp);
            if (typeOp == 0) {
                result = number1 + number2;
            }
            if (typeOp == 1) {
                if (MenuForm.level == 1) {
                    result = abs(number1 - number2);
                } else {
                    result = number1 - number2;
                }
            }
            if (typeOp == 2) {
                result = number1 * number2;
            }
            if (reponseSaisi == result) {
                //btReponse.setStyle("-fx-background-color : #3A9D23");    //on colorie le bouton Solution en vert
                saisirResultat.setStyle("-fx-background-color : #3A9D23"); // on colorie la zone réponse en vert
                // on affiche : bonne réponse + toute l'opération
                //saisirResultat.setText("Bonne réponse : " + otherCalcul + " = " + result);
                saisirResultat.setText("Bonne réponse : " + otherCalcul + " = " + result);
            } else {
                //btReponse.setStyle("-fx-background-color : #FF0000;");        //on colorie le bouton Solution en rouge
                saisirResultat.setStyle("-fx-background-color : #FF0000;");     //on colorie la zone réponse en rouge
                //saisirResultat.setText("Mauvaise réponse : " + otherCalcul + " = " + result);
                saisirResultat.setText("Mauvaise réponse : " + otherCalcul + " = " + result);
            }
            
        });

        /*--bouton Autre Calcul--*/
        btOtherCalcul.setOnAction(e -> {
            this.setBackground(MenuForm.level == 1 ? backgroundmathclassic : backgroundmathexpert);
            saisirResultat.clear();
            saisirResultat.setStyle("-fx-background-color : #FFFFFF"); // on colorie la zone réponse en blanc
            // génération de nouveaux nombres aléatoires
            typeOp = getRandomOpertaion();
            number1 = getRandomChiffre();
            number2 = getRandomChiffre();
            // Nouvelle opération 
            afficheurCalcul.setText(getRandomCalcul(number1,number2,typeOp) + " = ?"); 
            /*
            //debug      
            String nb1 = Integer.toString(number1);
            String nb2 = Integer.toString(number2);
            String nb3 = Integer.toString(typeOp);
            String nb4 = Integer.toString(MenuForm.level);
            afficheurCalcul.setText(" opération : " + getRandomCalcul(number1, number2, typeOp)
                    + "\n number1 : " + number1 + " number2 : " + number2 + "\n typeOp : " + typeOp
                    + " MenuForm.level : " + MenuForm.level);
             */
        });
    }

    /*-------------------------------------------------------------------------------------*/
    //Méthode qui retourne le type d'opération selon le niveau
    //0: corréspond à l'addition, 1: corréspond à la soustraction (pour les deux niveaux)
    //2: corréspond à la multiplication (uniquement pour le niveau 2)
    public int getRandomOpertaion() {
        int typeOperation = 0;
        if (MenuForm.level == 1) {
            typeOperation = (int) (Math.random() * 2); // 2 possibilités d'opérations (niveau 1)
        }
        if (MenuForm.level == 2) {
            typeOperation = (int) (Math.random() * 3); // 3 possibilités d'opérations (niveau 2)
        }
        return typeOperation;
    }
    //Méthode d'envoie de 1ér chiffre aléatoire selon le niveau  
    //niveau1 : Addition, Soustraction (nombres positifs à 1 chiffre)
    //niveau 2: Addition, Soustraction (nombres positifs à 3 chiffres), Multiplication (nombre positif à 1 chiffre) 
    public int getRandomChiffre() {

        int chiffre = 5;
        //level = MenuForm.level;
        if (MenuForm.level == 1) {
            chiffre = (int) (Math.random() * 9) + 1;      //chiffre aléatoire entre 1 et 9
        } 
        else {
            if (typeOp == 2) {
                chiffre = (int) (Math.random() * 9) + 1;   //chiffre aléatoire entre 1 et 9 
            } else {
                chiffre = (int) (Math.random() * 999) + 1; //chiffre aléatoire entre 1 et 999
            }
        }
        return chiffre;
    }
    // Méthode qui renvoie l'opération à résoudre sous type string   
    public String getRandomCalcul(int chif1, int chif2, int typeOpe) {
        if (MenuForm.level == 1) {
            //Niveau 1 : comparaison des 2 chiffres aléatoires, chif1 prend toujours la valeur max
            //afin d'avoir un résultat toujour positif si l'opération est la soustraction
            if (chif1 < chif2) {
                int temp = chif1;
                chif1 = chif2;
                chif2 = temp;
            }
        }
        //--conversions en string
        String ch1 = Integer.toString(chif1); //1ér chiffre aléatoire
        String ch2 = Integer.toString(chif2); //2éme chiffre aléatoire 
        // Déterminer le type d'opération selon le chiffre aléatoire retourné entre 0 et 2
        if (typeOpe == 0) {
            signeOperation = "+";        //signe de l'opération à exécuter
            resultat = chif1 + chif2;
        }
        if (typeOpe == 1) {
            signeOperation = "-";       //signe de l'opération à exécuter
            resultat = chif1 - chif2;
        }
        if (typeOpe == 2) {
            signeOperation = "*";       //signe de l'opération à exécuter
            resultat = chif1 * chif2;
        }
        //--conversions du résultat en string--//
        String ch3 = Integer.toString(resultat);
        //String questionCalcul = ch1 + " " + signeOperation + " " + ch2 + " = ?";
        String questionCalcul = ch1 + " " + signeOperation + " " + ch2 ;
        return questionCalcul;
    }

    public TextField getTfInput() {
        return this.tfInput;
    }
}
