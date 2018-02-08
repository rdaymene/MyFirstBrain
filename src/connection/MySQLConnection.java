/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author $céline
 */
public class MySQLConnection {

    /**
     * URL de connection
     */
    //private static final String HOST = "127.0.0.1";
    //private static final String PORT = "3306";
    //private static final String DATABASE = "testing";
    private static String URL;

    /**
     * Nom du user
     */
    //private static final String USER = "toto";
    /**
     * Mot de passe du user
     */
    //private static final String PASSWORD = "1234512345";
    /**
     * Objet Connection
     */
    private static Connection connection;

    private MySQLConnection() {
    }

    /**
     * Méthode qui va nous retourner notre instance et la créer si elle n'existe
     * pas...
     *
     * @return la connexion vers la base de donnée ou null
     */
    public static Connection getInstance() {

        // Crée un objet properties        
        Properties recup_info = new Properties();
        
        //INFO >> je cree une instance de type MySQLConnection, pour pouvoir utiliser 
        //
        MySQLConnection c = new MySQLConnection();

        InputStream in = c.getClass().getResourceAsStream("/ressources/SQLinfo");
        try {
            recup_info.load(in);

        } catch (IOException ex) {
             System.out.println("Fichier property SQLinfo n'a pas pu être lu");
        }

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(recup_info.getProperty("URL"), recup_info.getProperty("USER"), recup_info.getProperty("PASSWORD"));
            } catch (SQLException ex) {
                System.out.println("Connection ratée");
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}