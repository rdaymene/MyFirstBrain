
package calcul;

/**
 *
 * @author Rachid
 */
public class DoCalcul{
    private int number;

    //constructeur par défaut
    public DoCalcul() {
    }
    
    //constructeur par paramétres
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
       return a+b;
    }
    
    //méthode de soustraction de 2 nombres
    public int substraction(int a, int b){
        return a-b;
    }
       
    
    
}
