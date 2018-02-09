package Grid;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Grid extends BorderPane{
    
    private final Image iconebatman = new Image(getClass().getResourceAsStream("iconebatman.png"));
    private final Image iconejoker = new Image(getClass().getResourceAsStream("iconejoker.png")); 
    private final Image batman = new Image(getClass().getResourceAsStream("backgroundgrid.png"));
    
    private final BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background backgroundbatman = new Background(new BackgroundImage(batman,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));
    
    private Random r;
    private int valeur;
    
    private final VBox vboxgame;
    
    private final Button buttonstart;
    
    private final GridPane buttongrid;
    
    private final GridButton buttonitem0;
    private final GridButton buttonitem1;
    private final GridButton buttonitem2;
    private final GridButton buttonitem3;
    private final GridButton buttonitem4;
    private final GridButton buttonitem5;
    private final GridButton buttonitem6;
    private final GridButton buttonitem7;
    private final GridButton buttonitem8;
    
    public Timeline timeline;
    
    public Grid(){
        
        vboxgame = new VBox();

        r = new Random();
        
        buttonstart = new Button();
        buttonstart.setMinSize(100,50);
        buttonstart.setText("Start");
        
        buttongrid = new GridPane();
        
        buttonitem0 = new GridButton(0);
        buttonitem1 = new GridButton(1);
        buttonitem2 = new GridButton(2);
        buttonitem3 = new GridButton(3);
        buttonitem4 = new GridButton(4);
        buttonitem5 = new GridButton(5);
        buttonitem6 = new GridButton(6);
        buttonitem7 = new GridButton(7);
        buttonitem8 = new GridButton(8);
        
        buttongrid.add(buttonitem0,0,1);
        buttongrid.add(buttonitem1,1,1);
        buttongrid.add(buttonitem2,2,1);
        buttongrid.add(buttonitem3,0,2);
        buttongrid.add(buttonitem4,1,2);
        buttongrid.add(buttonitem5,2,2);
        buttongrid.add(buttonitem6,0,3);
        buttongrid.add(buttonitem7,1,3);
        buttongrid.add(buttonitem8,2,3);
        
        buttongrid.setVgap(20);
        buttongrid.setHgap(20);

        vboxgame.getChildren().add(buttongrid);
        vboxgame.getChildren().add(buttonstart);

        
        //vboxgame.setSpacing(30);
        
        
        
        //this.setPrefSize(450, 450);
        
        timeline = new Timeline(new KeyFrame( Duration.millis(500),ae -> {
            valeur = 0 + r.nextInt(8 - 0);
            if(valeur == buttonitem0.getNumberbutton())
                buttonitem0.setGraphic(new ImageView(iconejoker));
                //buttonitem0.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem1.getNumberbutton())
                buttonitem1.setGraphic(new ImageView(iconejoker));
                //buttonitem1.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem2.getNumberbutton())
                buttonitem2.setGraphic(new ImageView(iconejoker));
                //buttonitem2.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem3.getNumberbutton())
                buttonitem3.setGraphic(new ImageView(iconejoker));
                //buttonitem3.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem4.getNumberbutton())
                buttonitem4.setGraphic(new ImageView(iconejoker));
                //buttonitem4.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem5.getNumberbutton())
                buttonitem5.setGraphic(new ImageView(iconejoker));
                //buttonitem5.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem6.getNumberbutton())
                buttonitem6.setGraphic(new ImageView(iconejoker));
                //buttonitem6.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem7.getNumberbutton())
                buttonitem7.setGraphic(new ImageView(iconejoker));
                //buttonitem7.setStyle("-fx-base: #120D16;");
            if(valeur == buttonitem8.getNumberbutton())
                buttonitem8.setGraphic(new ImageView(iconejoker));
                //buttonitem8.setStyle("-fx-base: #120D16;");
        }));
        timeline.setCycleCount(20);
        
        buttonstart.setOnAction((ActionEvent event) -> {
          timeline.play();
        });
        
        buttonitem0.setOnAction((ActionEvent event) -> {
            buttonitem0.setGraphic(new ImageView(iconebatman));
            //buttonitem0.setStyle("-fx-base: #FFF000;");
        });
        buttonitem1.setOnAction((ActionEvent event) -> {
            buttonitem1.setGraphic(new ImageView(iconebatman));
            //buttonitem1.setStyle("-fx-base: #FFF000;");
        });
        buttonitem2.setOnAction((ActionEvent event) -> {
            buttonitem2.setGraphic(new ImageView(iconebatman));
            //buttonitem2.setStyle("-fx-base: #FFF000;");
        });
        buttonitem3.setOnAction((ActionEvent event) -> {
            buttonitem3.setGraphic(new ImageView(iconebatman));
            //buttonitem3.setStyle("-fx-base: #FFF000;");
        });
        buttonitem4.setOnAction((ActionEvent event) -> {
            buttonitem4.setGraphic(new ImageView(iconebatman));
            //buttonitem4.setStyle("-fx-base: #FFF000;");
        });
        buttonitem5.setOnAction((ActionEvent event) -> {
            buttonitem5.setGraphic(new ImageView(iconebatman));
            //buttonitem5.setStyle("-fx-base: #FFF000;");
        });
        buttonitem6.setOnAction((ActionEvent event) -> {
            buttonitem6.setGraphic(new ImageView(iconebatman));
            //buttonitem6.setStyle("-fx-base: #FFF000;");
        });
        buttonitem7.setOnAction((ActionEvent event) -> {
            buttonitem7.setGraphic(new ImageView(iconebatman));
            //buttonitem7.setStyle("-fx-base: #FFF000;");
        });
        buttonitem8.setOnAction((ActionEvent event) -> {
            buttonitem8.setGraphic(new ImageView(iconebatman));
            //buttonitem8.setStyle("-fx-base: #FFF000;");
        });
        
        buttongrid.setTranslateY(100);
        buttongrid.setTranslateX(300);
        
        buttonstart.setTranslateY(-200);
        buttonstart.setTranslateX(800);
        
        buttonstart.getStyleClass().add("MyButton");
        
        this.setBackground(backgroundbatman);
        this.setCenter(buttongrid);
        this.setBottom(buttonstart);
        
    }
}