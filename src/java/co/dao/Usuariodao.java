/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Usuariodao implements validar{
    Connection c;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;

    @Override
    public int validar(Usuario usu) {
        
        int r=0;
       String sql="Select * from login where usuario=? and contraseña=? ";
        try {
           c=cn.getConnection();
           ps=c.prepareStatement(sql);
           ps.setString(1, usu.getUsuario());
           ps.setString(2,usu.getContra());
           rs=ps.executeQuery();
           
            while (rs.next()) {
                
                r=r+1;
                usu.setUsuario(rs.getString("usuario"));
                usu.setContra(rs.getString("contraseña"));
            }
            
            if(r==1){
                
                return 1;
            }else{
                return 0;
            }
                
           
        } catch (Exception e) {
            
           return 0;
        
        }
    
    
    } 
    
    
    
}
