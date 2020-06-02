/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.dao;

import co.dto.Administrador;
import co.dto.Guia;
import co.dto.Incentivo;
import co.dto.OpcionPregunta;
import co.dto.Pregunta;
import co.dto.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.List;

public class Operaciones {

    private static final String INSERT = "INSERT INTO public.\"incentivo\"(\n"
            + "	id, nombre, fecha,fechafinal)\n"
            + "	VALUES (?, ?, ?, ?)";

    public int loguear(String us, String pass) {
        Connection con = new Conexion().getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int nivel = 0;
        String sql = "select nivel from usuario where usuario=? and contra=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                nivel = rs.getInt(1);
            }
        } catch (SQLException ex) {
        } finally {
            new Conexion().desConexion(con);
        }
        return nivel;
    }

    public int guardaUsu(Usuario u) {
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
                ps.setInt(6, u.getNivel());
                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al insertar Usuario", ex);
            } finally {
                new Conexion().desConexion(c);
            }
        }
        return 0;
    }

    public int guardaAdm(Administrador dato) {
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

    public int guardaPregunta(Pregunta dato) {
        Connection pr = new Conexion().getConnection();
        if (pr != null) {
            PreparedStatement ps;
            try {
                ps = pr.prepareStatement("INSERT INTO public.pregunta(\n"
                        + "	textopregunta)\n"
                        + "	VALUES (?)");
                ps.setString(1, dato.getTextoPregunta());
                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al insertar Preguntas", ex);
            } finally {
                new Conexion().desConexion(pr);
            }
        }
        return 0;
    }

    public int guardaOpcionPregunta(OpcionPregunta dato) {
        Connection op = new Conexion().getConnection();
        if (op != null) {
            PreparedStatement ps;
            try {
                ps = op.prepareStatement("INSERT INTO public.opcionespreguntas(\n"
                        + "	opcionunica)\n"
                        + "	VALUES (?)");
                ps.setString(1, dato.getOpcionunica());
                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al insertar Preguntas", ex);
            } finally {
                new Conexion().desConexion(op);
            }
        }
        return 0;
    }

    /*Metodo listarguias*/
    public ArrayList<Guia> ListarGuias() {
        ArrayList<Guia> list = new ArrayList<Guia>();
        Connection con = new Conexion().getConnection();
        String sql = "SELECT * FROM guias";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Guia vo = new Guia();
                vo.setCodigoguia(rs.getInt(1));
                vo.setNombreguia(rs.getString(2));
                vo.setArchivoguia(rs.getBytes(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(con);

        }
        return list;
    }

    /*Metodo agregar*/
    public void AgregarGuias(Guia gu) {

        Connection con = new Conexion().getConnection();
        String sql = "INSERT INTO guias (codigoguia, nombreguia, archivopdf) VALUES(?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, gu.getCodigoguia());
            ps.setString(2, gu.getNombreguia());
            ps.setBlob(3, gu.getArchivoguias());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(con);

        }
    }

    /*Metodo Modificar*/
    public void ModificaRGUIA(Guia vo) {
        Connection con = new Conexion().getConnection();
        String sql = "UPDATE guias SET nombreguia = ?, archivopdf = ? WHERE codigoguia = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNombreguia());
            ps.setBlob(2, vo.getArchivoguias());
            ps.setInt(3, vo.getCodigoguia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(con);

        }
    }

    /*Metodo Modificar*/
    public void Modificar2(Guia co) {
        Connection con = new Conexion().getConnection();
        String sql = "UPDATE guias SET nombreguia = ? WHERE codigoguia = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, co.getNombreguia());
            ps.setInt(2, co.getCodigoguia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(con);

        }

    }

    /*Metodo Eliminar*/
    public void Eliminarguia(int id) {
        Connection con = new Conexion().getConnection();
        String sql = "DELETE FROM guias WHERE codigoguia = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(con);

        }
    }
    
    /*Metodo Consulta id*/
    
    public Guia getguiaId(int usuarioId) {
        Guia vo = new Guia();
        Connection con = new Conexion().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM guias WHERE codigoguia = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, usuarioId);
            rs = ps.executeQuery();
            while (rs.next()) {
                vo.setCodigoguia(rs.getInt(1));
                vo.setNombreguia(rs.getString(2));
                vo.setArchivoguia(rs.getBytes(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            new Conexion().desConexion(con);
        }
        return vo;
    }

    public int guardIncentivo(Incentivo I) {
        Connection c = new Conexion().getConnection();
        if (c != null) {
            PreparedStatement ps;
            try {
                // ps = c.prepareStatement("INSERT INTO Incentivo (id,incentivo,fecha) VALUES (?,?,?)");
                ps = c.prepareStatement(INSERT);

                //
                ps.setInt(1, I.getId());
                ps.setString(2, I.getIncentivo());
                ps.setDate(3, (java.sql.Date) I.getFechaincentivo());
                ps.setDate(4, (java.sql.Date) I.getFechafinal());
                
                return ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al insertar incentivo", ex);
            } finally {
                new Conexion().desConexion(c);
            }
        }
        return 0;
    }
    
     public List<Incentivo> ListarIncentivo() {
      List<Incentivo> dato = new ArrayList<>();
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT id,nombre,fecha,fechafinal FROM incentivo");
            
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                  int id = rs.getInt("id");
                  String nombre = rs.getString("nombre");
                  java.util.Date fecha = rs.getDate("fecha");
                  java.util.Date fechafinal = rs.getDate("fechafinal");
                  
                  Incentivo i = new Incentivo(id, nombre, (java.sql.Date) fecha ,(java.sql.Date)fechafinal);
                  dato.add(i);
               }
               
            
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al listar incentivo", ex);
            }finally{
                new Conexion().desConexion(cx);
            }
      }
      
      
      
      return dato;
   }
      public List<Usuario> ListarUsuario() {
      List<Usuario> usua = new ArrayList<>();
      Conexion ac = new Conexion();
      Connection cx = ac.getConnection();
      if (cx != null){
         PreparedStatement ps;
            try {
                ps = cx.prepareStatement("SELECT usuario,contra,nombre,apellido,cedula,nivel  FROM usuario");
            
               ResultSet rs = ps.executeQuery();
               while (rs.next()){
                 
                  String usu =rs.getString("usuario");
                  String contra =rs.getString("contra");
                  String nomb =rs.getString("nombre");
                  String apell =rs.getString("apellido");
                  int cedu =rs.getInt("cedula");
                  int nivel =rs.getInt("nivel");
                 
                  Usuario i = new Usuario(usu, contra, nomb, apell, cedu, nivel);
                  usua.add(i);
               }
               
            
            } catch (SQLException ex) {
                Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, "Error al listar usuarios", ex);
            }finally{
                new Conexion().desConexion(cx);
            }
      }
      
      
      
      return usua;
   }
}


