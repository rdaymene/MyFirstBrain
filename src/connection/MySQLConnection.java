/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    private static final String HOST = "172.16.0.48";
    private static final String PORT = "3306";
    private static final String DATABASE = "dsig2";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
    /**
     * Nom du user
     */
    private static final String USER = "dsig2";
    /**
     * Mot de passe du user
     */
    private static final String PASSWORD = "dsig2";
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
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                System.out.println("Connection ratée");
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
