/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author German
 */
public class sql {
    public int auto_increm(String sql){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection c = new Conexion().getConnection();
        try{    
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    id = rs.getInt(1)+1;
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(c);

        }
        return id;
    }
    
}
