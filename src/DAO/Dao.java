/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.MySQLConnection;
import java.sql.Statement;

/**
 *
 * @author $céline
 */
public  class Dao {
    // objet de type connection :
     protected Connection connection = MySQLConnection.getInstance();
    //protected Connection connection = MySQLConnection.getInstance();
    public final String TABLE = "myfirstbrain";
    public QuestionBean find(int id){
        QuestionBean qb = null;
        try {

            String req = "SELECT * FROM " + TABLE + " WHERE id = ? ";
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.first()) {
                qb = new QuestionBean(id, res.getInt("niveau"),res.getString("question"), res.getString("reponse"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qb;
    }
        
    public  QuestionBean create(QuestionBean qb){
        QuestionBean qb2 = null;
        try {
            String req = "insert INTO " + TABLE + " (niveau,question,reponse) VALUES (?, ? ,? );";
            PreparedStatement pstmt = this.connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, qb.getNiveau());
            pstmt.setString(2, qb.getQuestion());
            pstmt.setString(3,qb.getReponse());
            int nbLignesImpactees = pstmt.executeUpdate();
            ResultSet res = pstmt.getGeneratedKeys();
            
            int lastInsertedId;
           
            if (res.first()) {
                lastInsertedId = res.getInt(1);
                 System.out.println(lastInsertedId);
                qb2 = this.find(lastInsertedId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qb;
    }
    public  QuestionBean update(QuestionBean qb){
        QuestionBean qb3 = null;
        return qb;
    }
    public void delete(QuestionBean obj){
        
    }
}
