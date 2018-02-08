package Draw;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class Draw extends BorderPane {
    
    //zone ou l'on va dessiner
    private final Canvas canvas;
    //slider qui va effacer l'ardoise
    private final Slider slidereffacer;
    
    //attributs images
    //<editor-fold>
    private final Image gomme = new Image(getClass().getResourceAsStream("gomme.png"));
    private final Image rond = new Image(getClass().getResourceAsStream("rond.png"));
    private final Image carre = new Image(getClass().getResourceAsStream("carre.png")); 
    private final Image crayon = new Image(getClass().getResourceAsStream("crayon.png"));
    private final Image ardoise = new Image(getClass().getResourceAsStream("backgroundclassic.png"));
    private final Image ardoisecar = new Image(getClass().getResourceAsStream("backgroundcars.png"));
    private final Image ardoisefrozen = new Image(getClass().getResourceAsStream("backgroundfrozen.png"));
    private final Image iconeelsa = new Image(getClass().getResourceAsStream("iconeelsa.png"));
    private final Image iconecars = new Image(getClass().getResourceAsStream("iconecars.png")); 
    private final Image iconeclassic = new Image(getClass().getResourceAsStream("iconeclassic.png")); 
    //</editor-fold>
    
    //attributs BackGround & BackGround Setting
    //<editor-fold>
    private final BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background backgroundardoiseclassic = new Background(new BackgroundImage(ardoise,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));
    private Background backgroundardoisecar = new Background(new BackgroundImage(ardoisecar,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));
    private Background backgroundardoisefrozen = new Background(new BackgroundImage(ardoisefrozen,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));
    //</editor-fold>
    
    //attributs menu general en haut de l'ardoise
    //<editor-fold>
    //containeur de l'ensemble de la barre du haut
    private final HBox choixardoiseetboiteoutilHBox;
    //bouton qui va effacer l'ensemble de l'ardoise
    private final Button btnEffacer;
    //containeur de toute la barre
    private final HBox boiteoutilsHBox;
    //containeur et bouton des formes
    private final HBox formeGrid;
    private final Button btnRond;
    private final Button btnCarre;
    //containeur couleur RVB et bouton des couleurs/
    private final GridPane couleurGrid;
    private final Button btnRouge;
    private final Button btnVert;
    private final Button btnBleu;
    //containeur et bouton des choix des background de l'ardoise
    private final GridPane buttonchoixardoiseGrid;
    private final Button buttonclassic;
    private final Button buttoncars;
    private final Button buttonfrozen;
    //elements colorpicker pour choisir parmis un panel
    private final VBox colorPickerandslider;
    private final Label colorpickerlabel;
    private final ColorPicker colorPicker;
    private final Label sliderepaisseurlabel;
    private final Slider sliderepaisseur;
    //</editor-fold>
    
    

    public Draw(){
//=============================== CREATION DU CANVAS =====================================================================
        //creation du canvas zone ou l'on pourra dessiner 
        canvas = new Canvas(795,370);
        canvas.setTranslateY(-2);
        canvas.setTranslateX(0);
//=============================== ELEMENT QUI VA DESSINER SUR L'ARDOISE ======================================        
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();
        //déclaration de la forme du pinceau , de la couleur et de son épaisseur.
        gc.setLineCap(StrokeLineCap.SQUARE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);        
//=============================== SLIDER QUI GERE L'EPAISSEUR DE NOTRE TRAIT ======================================        
        sliderepaisseur = new Slider();
        //la valeur minimum du slider
        sliderepaisseur.setMin(0);
        //la valeur maximum du slider
        sliderepaisseur.setMax(100);
        sliderepaisseur.setValue(10);
        //sliderepaisseur.setShowTickLabels(true);
        //sliderepaisseur.setShowTickMarks(true);
        sliderepaisseur.setBlockIncrement(10);
        sliderepaisseur.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            gc.setLineWidth((double) newValue);
        });
//=============================== CREATION DU COLORPICKER POUR CHOISIR UNE COULEUR PARMI UN PANEL ======================================        
        colorPicker = new ColorPicker(Color.BLACK);

//=============================== CREATION DES CHOIX DE L'ARDOISE ========================================================
        //creation du container de la radio grid pour le changement de layout de l'ardoise
        buttonchoixardoiseGrid = new GridPane();
        //creation de chaque bouton avec leur label personnalisé.
        //bouton choix ardoise classique
        buttonclassic = new Button();
        buttonclassic.setPrefSize(50, 50);
        buttonclassic.setGraphic(new ImageView(iconeclassic));
        //bouton choix ardoise cars
        buttoncars = new Button();
        buttoncars.setPrefSize(50, 50);
        buttoncars.setGraphic(new ImageView(iconecars));
        //bouton choix ardoise frozen
        buttonfrozen = new Button();
        buttonfrozen.setPrefSize(50, 50);
        buttonfrozen.setGraphic(new ImageView(iconeelsa));
        //rajout dans le container grille de chaque bouton avec leur position
        buttonchoixardoiseGrid.add(buttonclassic,0,1);
        buttonchoixardoiseGrid.add(buttoncars,1,1);
        buttonchoixardoiseGrid.add(buttonfrozen,2,1); 
        
        buttonchoixardoiseGrid.setTranslateY(15);
//=============================== CREATION DU SLIDER QUI EFFACE L'ARDOISE ======================================
        slidereffacer = new Slider();
        //la valeur minimum du slider
        slidereffacer.setMin(0);
        //la valeur maximum du slider
        slidereffacer.setMax(800);
        slidereffacer.setValue(0);
        //slider.setShowTickLabels(true);
        //slider.setShowTickMarks(true);
        slidereffacer.setBlockIncrement(50);
        //On positionne le slider qui efface l'ardoise
        slidereffacer.setTranslateY(-15);
        slidereffacer.setTranslateX(325);
        //On donne une taille maximale au slider
        slidereffacer.setMaxSize(350, 100); 
//=============================== CREATION DES VARIABLES CONTAINER DE LA ZONE DE GAUCHE DU PANNEAU DRAW ======================================
        choixardoiseetboiteoutilHBox = new HBox();
//=============================== DECLARATION DU CONTENAIRE DE LA BOITE A OUTILS ==========================================================
        boiteoutilsHBox = new HBox();
//=============================== ESPACE ENTRE LES DIFFERENTES BOX DE LA BOITE A OUTILS===========================================
        boiteoutilsHBox.setSpacing(20);
//=============================== MENU BOITE A OUTILS 1 : BOUTON EFFACER ==================================================
        btnEffacer = new Button("",new ImageView(gomme));
        btnEffacer.setPrefSize(50,50);
//=============================== MENU BOITE A OUTILS 2 : BOX DES COULEURS R V B ======================================
        //Box des couleurs
        couleurGrid = new GridPane();
        //Bouton 1 des couleurs : couleur rouge avec taille et fond en rouge
        btnRouge = new Button();
        btnRouge.setStyle("-fx-base: #FF0000;");
        btnRouge.setPrefSize(50,50);
        //Bouton 2 des couleurs : couleur vert avec taille et fond en vert
        btnVert = new Button();
        btnVert.setStyle("-fx-base: #096A09;");
        btnVert.setPrefSize(50,50);
        //Bouton 2 des couleurs : couleur bleu avec taille et fond en bleu
        btnBleu = new Button();
        btnBleu.setStyle("-fx-base: #0000FF;");
        btnBleu.setPrefSize(50,50);
        //rajout à la grid couleur
        couleurGrid.add(btnRouge,0,1);
        couleurGrid.add(btnVert,1,1);
        couleurGrid.add(btnBleu,2,1);
        
        couleurGrid.setHgap(5);
       
        colorPickerandslider = new VBox();
        
        colorpickerlabel = new Label ("Palette de Couleur");
        colorpickerlabel.setTextFill(Color.web("#FFFFFF"));
        sliderepaisseurlabel = new Label ("Epaisseur Pinceau");
        sliderepaisseurlabel.setTextFill(Color.web("#FFFFFF"));
        colorPickerandslider.getChildren().add(colorpickerlabel);
        colorPickerandslider.getChildren().add(colorPicker);
        colorPickerandslider.getChildren().add(sliderepaisseurlabel);
        colorPickerandslider.getChildren().add(sliderepaisseur);
        colorPickerandslider.setAlignment(Pos.CENTER);
        
        
        //espace entre les boutons couleurs
        colorPicker.setOnAction((ActionEvent event) -> {
            gc.setStroke(colorPicker.getValue());
        });
        
//=============================== MENU BOITE A OUTILS 3 : BOUTON DE FORME DU PINCEAU ======================================
        //creation de la grille des boutons des formes
        formeGrid = new HBox();
        //creation des boutons de la grille avec une image en icone
        btnRond = new Button("",new ImageView(rond));
        btnCarre = new Button("",new ImageView(carre));
        //Rajout dans une grid panne en colone
        formeGrid.getChildren().add(btnRond);
        formeGrid.getChildren().add(btnCarre);
//=============================== AJOUT DE L'ENSEMBLE DES ELEMENTS DE LA TOOLGRID ======================================
        boiteoutilsHBox.getChildren().add(btnEffacer);
        boiteoutilsHBox.getChildren().add(formeGrid);
        boiteoutilsHBox.getChildren().add(couleurGrid);
        //On centre l'ensemble des élements dans leurs propres box
        couleurGrid.setAlignment(Pos.CENTER);
        formeGrid.setAlignment(Pos.CENTER);
        //On centre les box qui composent la barre d'outil entre elle.
        boiteoutilsHBox.setAlignment(Pos.CENTER);
//=============================== EVENT SUR LES DIFFERENTS BOUTONS ======================================
        //evenement sur bouton effacer
        btnEffacer.setOnAction((ActionEvent event) -> {
            gc.clearRect(0, 0, 796, 370);
        });
        //evenement sur bouton rouge
        btnRouge.setOnAction((ActionEvent event) -> {
            gc.setStroke(Color.RED);
        });
        //evenement sur bouton vert
        btnVert.setOnAction((ActionEvent event) -> {
            gc.setStroke(Color.GREEN);
        });
        //evenement sur bouton bleu
        btnBleu.setOnAction((ActionEvent event) -> {
            gc.setStroke(Color.BLUE);
        });
        //evenement sur bouton rond
        btnRond.setOnAction((ActionEvent event) -> {
            gc.setLineCap(StrokeLineCap.ROUND);
        });
        //evenement sur bouton carre
        btnCarre.setOnAction((ActionEvent event) -> {
            gc.setLineCap(StrokeLineCap.SQUARE);
        });
        //gestion de l'effacement de l'ardoise en fonction de la position du slider
        slidereffacer.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            gc.setStroke(Color.WHITE);
            gc.strokeLine(-3, 560, -3, 0);
            gc.strokeLine((double) newValue, 560, (double) newValue, 0);
            //if ((double) newValue == 570)
            gc.setStroke(Color.BLACK);
        });
        //début du tracé dans la zone canvas avec la position de la souris
        canvas.setOnMousePressed(e->{
            canvas.setCursor(new ImageCursor(crayon));
            gc.beginPath();
            gc.lineTo(e.getSceneX()-100, e.getSceneY()-125);
            gc.stroke();
        });
        //arret du tracé dans la zone canvas avec la position de la souris
        canvas.setOnMouseDragged(e->{
            gc.lineTo(e.getSceneX()-100, e.getSceneY()-125);
            gc.stroke();
        });        
        //rajout à la barre latérale du choix du layout en haut 
        
        choixardoiseetboiteoutilHBox.getChildren().add(boiteoutilsHBox);
        choixardoiseetboiteoutilHBox.getChildren().add(colorPickerandslider);
        choixardoiseetboiteoutilHBox.getChildren().add(buttonchoixardoiseGrid);
        choixardoiseetboiteoutilHBox.setAlignment(Pos.CENTER);
        //choixardoiseetboiteoutilHBox.setPadding(new Insets(15,20, 10,10));
        choixardoiseetboiteoutilHBox.setSpacing(20);
        //Action sur les radio boutons pour changer le graphisme de l'ardoise
        buttonclassic.setOnAction((ActionEvent event) -> {
           this.setBackground(backgroundardoiseclassic);
        });
        
        buttoncars.setOnAction((ActionEvent event) -> {
           this.setBackground(backgroundardoisecar);
        });
        buttonfrozen.setOnAction((ActionEvent event) -> {
           this.setBackground(backgroundardoisefrozen);
        });        
        //rajout de chaque element dans notre objet principal Draw qui est un BorderPane
        this.setTop(choixardoiseetboiteoutilHBox);
        this.setCenter(canvas);   
        this.setBottom(slidereffacer); 
        this.setBackground(backgroundardoiseclassic);
    }            
    //methode qui gère le changement de Background de l'ardoise   
    public void changeLayout(Background back){
        this.setBackground(back);  
    }
}