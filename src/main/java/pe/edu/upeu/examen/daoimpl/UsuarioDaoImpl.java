/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.examen.config.Conexion;
import pe.edu.upeu.examen.dao.usuarioDao;
import pe.edu.upeu.examen.model.Usuario;

/**
 *
 * @author Usuario
 */
public class UsuarioDaoImpl implements usuarioDao{ 
    
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cx;
    
    @Override
    public int create(Usuario u) {
       String SQL = "insert into usuarios(username,password,idpersona,idrol,fechacreacion,estado) values (?,?,?,?,now(),true)";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getUsername());
            ps.setInt(3, u.getIdpersona());
            ps.setInt(4, u.getIdrol());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;   
    
    }

    @Override
    public int update(Usuario u) {
        String SQL = "update usuarios set username = ? , password = ? , idpersona = ?, idrol = ?   where idusuario = ?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getUsername());
            ps.setInt(3, u.getIdpersona());
            ps.setInt(4, u.getIdrol());
            ps.setInt(5, u.getIdusuario());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public int delete(int idusuario) {
        String SQL = "delete from usuarios where idusuario=?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idusuario);
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Usuario read(int idusuario) {
        String SQL = "select *from usuarios where idusuario=?";
        Usuario u = new Usuario();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idusuario);
            rs=ps.executeQuery();
            while (rs.next()) {                
                u.setIdusuario(rs.getInt("idusuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIdpersona(rs.getInt("idpersona"));
                u.setIdrol(rs.getInt("idrol"));
                u.setFechacreacion(rs.getString("fechacreacion"));
                u.setEstado(rs.getBoolean("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return u;
    }

    @Override
    public List<Usuario> readAll() {
        String SQL = "select * from usuarios";
        List<Usuario> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            rs=ps.executeQuery();
            while (rs.next()) {  
                Usuario u = new Usuario();
                u.setIdusuario(rs.getInt("idusuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setIdpersona(rs.getInt("idpersona"));
                u.setIdrol(rs.getInt("idrol"));
                u.setFechacreacion(rs.getString("fechacreacion"));
                u.setEstado(rs.getBoolean("estado"));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
