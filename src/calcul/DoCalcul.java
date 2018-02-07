/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

/**
 *
 * @author stag
 */
public class DoCalcul{
    protected int number;

    //condtructeur par défaut
    public DoCalcul() {
    }
    
    //condtructeur par paramétres
    public DoCalcul(int number) {
        this.number = number;
    }

    
    //getters + setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //Affchage de toString
    @Override
    public String toString() {
        return "DoCalcul{" + "number=" + number + '}';
    }

    
    //méthode d'addition de 2 nombres
    public int addition(int a, int b){
        /*
        // génération d'un entier >= 0 et < 9
        a = (int)(Math.random() * 9);
        b = (int)(Math.random() * 9);
        */
        return a+b;
    }
    
    //méthode de substraction de 2 nombres
    public int substraction(int a, int b){
        /*
        // génération d'un entier >= 0 et < 9
        a = (int)(Math.random() * 9);
        b = (int)(Math.random() * 9);
        */        
        return a-b;
    }
       
    
    
}
