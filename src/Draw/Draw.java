package Draw;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class Draw extends BorderPane{
    
    public Draw(){
        
        Image gomme = new Image(getClass().getResourceAsStream("ressources/gomme.png"));
        Image rond = new Image(getClass().getResourceAsStream("ressources/rond.png"));
        Image carre = new Image(getClass().getResourceAsStream("ressources/carre.png"));        
        //=============================== DECLARATION DU MENU TOOLS  ==========================================================
        VBox toolsGrid = new VBox();
        //=============================== ESPACE ENTRE LES DIFFERENTES BOX ===========================================
        toolsGrid.setSpacing(20);
        //=============================== MENU TOOLS 1 : BOUTON EFFACER ==================================================
        Button btnEffacer = new Button("",new ImageView(gomme));
        btnEffacer.setPrefSize(50,50);
        //=============================== MENU TOOLS 2 : BOX DES COULEURS R V B ======================================
        //Box des couleurs
        VBox colorGrid = new VBox();
        //Bouton 1 des couleurs : couleur rouge avec taille et fond en rouge
        Button btnRouge = new Button();
        btnRouge.setStyle("-fx-base: #FF0000;");
        btnRouge.setPrefSize(50,50);
        //Bouton 2 des couleurs : couleur vert avec taille et fond en vert
        Button btnVert = new Button();
        btnVert.setStyle("-fx-base: #096A09;");
        btnVert.setPrefSize(50,50);
        //Bouton 2 des couleurs : couleur bleu avec taille et fond en bleu
        Button btnBleu = new Button();
        btnBleu.setStyle("-fx-base: #0000FF;");
        btnBleu.setPrefSize(50,50);
        //rajout à la v box
        colorGrid.getChildren().add(btnRouge);
        colorGrid.getChildren().add(btnVert);
        colorGrid.getChildren().add(btnBleu);
        //espace entre les boutons couleurs
        colorGrid.setSpacing(20);
        //=============================== MENU TOOLS 2 : BOUTON DE FORME DU PINCEAU======================================
        Button btnRond = new Button("",new ImageView(rond));
        Button btnCarre = new Button("",new ImageView(carre));
        //Rajout dans une grid bane en colone
        VBox formeGrid = new VBox();
        formeGrid.getChildren().add(btnRond);
        formeGrid.getChildren().add(btnCarre);
        
        toolsGrid.getChildren().add(btnEffacer);
        toolsGrid.getChildren().add(formeGrid);
        toolsGrid.getChildren().add(colorGrid);
        //On centre l'ensemble des élements dans leurs propres box
        colorGrid.setAlignment(Pos.CENTER);
        formeGrid.setAlignment(Pos.CENTER);
        //On centre les box qui composent la barre d'outil entre elle.
        toolsGrid.setAlignment(Pos.CENTER);
        //=============================== ZONE DE DESSIN ======================================
        //zone de dessin
        Canvas canvas = new Canvas(700,500);
        GraphicsContext gc;
        gc = canvas.getGraphicsContext2D();
        //déclaration de la forme du pinceau , de la couleur et de son épaisseur.
        gc.setLineCap(StrokeLineCap.SQUARE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(10);
        //=============================== EVENT SUR LES DIFFERENTS BOUTONS ======================================
        //=============================== BOUTON EFFACER ======================================
        btnEffacer.setOnAction((ActionEvent event) -> {
            gc.clearRect(0, 0, 700, 500);
        });
        //=============================== BOUTON ROUGE ======================================
        btnRouge.setOnAction((ActionEvent event) -> {
            gc.setStroke(Color.RED);
        });
        //=============================== BOUTON VERT ======================================
        btnVert.setOnAction((ActionEvent event) -> {
            gc.setStroke(Color.GREEN);
        });
        //=============================== BOUTON BLUE ======================================
        btnBleu.setOnAction((ActionEvent event) -> {
            gc.setStroke(Color.BLUE);
        });
        //=============================== BOUTON ROND ======================================
        btnRond.setOnAction((ActionEvent event) -> {
            gc.setLineCap(StrokeLineCap.ROUND);
        });
        //=============================== BOUTON CARRE ======================================
        btnCarre.setOnAction((ActionEvent event) -> {
            gc.setLineCap(StrokeLineCap.SQUARE);
        });
        
        //Pane final pour l'ensemble.
        //Scene ou l'on va afficher la zone de canvas
        Scene scene = new Scene(this, 700, 500);
        
        //début du tracé dans la zone canvas avec la position de la souris
        scene.setOnMousePressed(e->{
            gc.beginPath();
            gc.lineTo(e.getSceneX()-100, e.getSceneY());
            gc.stroke();
        });
        //arret du tracé dans la zone canvas avec la position de la souris
        scene.setOnMouseDragged(e->{
            gc.lineTo(e.getSceneX()-100, e.getSceneY());
            gc.stroke();
        });
        toolsGrid.setBorder(Border.EMPTY);
        //rajout sur la gauche de la barre d'outils (toolbar)
        this.setLeft(toolsGrid);
        //rajout au centre de la zone de canvas
        this.setCenter(canvas);
        
    }

}