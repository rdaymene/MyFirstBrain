package Grid;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GridButton extends Button{
    
    private final int numberbutton;
    private final Image iconebatman = new Image(getClass().getResourceAsStream("iconebatman.png"));
    

    GridButton(int num){  
        
        this.setGraphic(new ImageView(iconebatman));
        numberbutton = num;
        this.setMinSize(100,100);
        this.setStyle("-fx-base: #FFF000;");
    };
    
    public int getNumberbutton() {
        return numberbutton;
    }
}