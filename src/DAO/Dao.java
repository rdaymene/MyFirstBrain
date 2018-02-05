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
import java.util.ArrayList;

/**
 *
 * @author $céline
 */
public  class Dao {
    // objet de type connection :
     protected Connection connection = MySQLConnection.getInstance();
   
    public final String TABLE = "myfirstbrain";// nom de la table de la BD
    
    // methode de recherche d'un objet Question en fonction de son id
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
       // methode de cr&ation d'un objet question 
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
            // on récupère l'id crée
            int lastInsertedId;
           
            if (res.first()) {
                lastInsertedId = res.getInt(1);
                 System.out.println(lastInsertedId);
                qb2 = this.find(lastInsertedId);// permet de récupérer le nouvel objet crée
            }
    
        } catch (SQLException ex) {
            Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qb;
    }
    // mehode de mise a jour objet question
    public  QuestionBean update(QuestionBean qb){
        QuestionBean qb3 = null;
         try {
            String req = "UPDATE " + TABLE + " SET niveau = ? ,question = ?, reponse = ? " + " WHERE id = ?;";
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            
            pstmt.setInt(1, qb.getNiveau());
            pstmt.setString(2, qb.getQuestion());
            pstmt.setString(3, qb.getReponse());
            int res = pstmt.executeUpdate();
            qb3 = this.find(qb.getID());
        } catch (SQLException ex) {
            Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qb;
    }
    public void delete(QuestionBean qb){
         try {
            String req = "DELETE FROM " + TABLE + " WHERE id = ?; ";
            PreparedStatement pstmt = this.connection.prepareStatement(req);
            pstmt.setLong(1, qb.getID());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // methode pour remplir une collection avec les questions de meme niveau
    public ArrayList<QuestionBean> fillCollection(int level){
        ArrayList<QuestionBean> questionList = new ArrayList<>();
         try {
            String res = "SELECT * FROM " + TABLE + " WHERE niveau = ?;";
            PreparedStatement ptmt = this.connection.prepareStatement(res);
            ptmt.setInt(1, level);
            ResultSet res2 = ptmt.executeQuery();

            while (res2.next()) {

                int id = res2.getInt(1);// we get the id from the line
                int niveau = res2.getInt(2);
                String question = res2.getString(3);                
                String reponse = res2.getString(4);// we get the labfillColleel from the same line
                questionList.add(new QuestionBean(id,niveau, question, reponse));
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuestionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questionList;
    }
}
