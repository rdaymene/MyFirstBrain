/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;

/**
 *
 * @author $céline
 */
public abstract class Dao <T> {
    //protected Connection connection = MySQLConnection.getInstance();
    
    public abstract T find(int id);
        // to implement in children
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(T obj);
}
