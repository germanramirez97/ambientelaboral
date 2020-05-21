/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.dto.Administrador;
import co.dto.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Operaciones {
    
    public int loguear(String us, String pass){
        Connection con = new Conexion().getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int nivel=0;
        
          String sql= "select nivel from usuario where usuario=? and contra=?";
                   
        try {
           ps=con.prepareStatement(sql);
            ps.setString(1, us);
            ps.setString(2, pass);
           
           rs=ps.executeQuery();
           
            if (rs.next()) { 
                
                nivel=rs.getInt(1);
            }
        } catch ( SQLException ex) {
          
        }
        finally{  
            new Conexion().desConexion(con);
        }
        
        return nivel;
    }
    
    public int guardaUsu(Usuario u){
        Connection c = new Conexion().getConnection();
        if (c != null) {
            PreparedStatement ps;
            try {
                ps = c.prepareStatement("INSERT INTO Usuario (usuario, nombre, apellido, cedula, contra,nivel) VALUES (?, ?, ?, ?, ?,?)");
                ps.setString(1, u.getUsuario());
                ps.setString(2, u.getNombre());
                ps.setString(3, u.getApellido());
                ps.setInt(4, u.getCedula());
                ps.setString(5, u.getContra());
                ps.setInt(6,u.getNivel());
                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al insertar Usuario", ex);
            } finally {
                new Conexion().desConexion(c);
            }
        }
        return 0;
    }
    
    public int guardaAdm(Administrador dato){
        Connection ac = new Conexion().getConnection();
        if (ac != null) {
            PreparedStatement ps;
            try {
                ps = ac.prepareStatement("INSERT INTO administrador (usuarioadm, contraadm, nombreadm, apellidoadm, cedula) VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, dato.getUsuarioadm());
                ps.setString(2, dato.getContraadm());
                ps.setString(3, dato.getNombreadm());
                ps.setString(4, dato.getApellidoadm());
                ps.setInt(5, dato.getCedula());
                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al insertar Administrador", ex);
            } finally {
                new Conexion().desConexion(ac);
            }
        }
    return 0;
    }
}
