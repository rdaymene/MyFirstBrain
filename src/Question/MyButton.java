/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question;

import Menu.*;
import myfirstbrain.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author $céline
 */
public class MyButton extends Button {

   

    public MyButton(String label) {
        super(label);        
        //this.label.setStyle("-fx-effect: dropshadow( one-pass-box , white , 0, 0.0 , 0 , 1);");
        
        this.setMinSize(130, 80);
        // on lui donne le style d'une classe du fichier .css
        this.getStyleClass().add("MyButton");
    }
}
