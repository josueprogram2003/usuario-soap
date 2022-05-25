/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.test;

import com.google.gson.Gson;
import pe.edu.upeu.examen.config.Conexion;
import pe.edu.upeu.examen.dao.usuarioDao;
import pe.edu.upeu.examen.daoimpl.UsuarioDaoImpl;

/**
 *
 * @author Usuario
 */
public class Test {
    static Gson gson = new Gson();
    static usuarioDao u = new UsuarioDaoImpl();
    
    
    public static void main(String[] args) {
        if(Conexion.getConexion()!=null) {
			System.out.println("conectado");
		}else {
			System.out.println("Error");
		}
        
        System.out.println(gson.toJson(u.readAll()));
    }
    
    
}

/*

 @WebMethod(operationName = "editarUsuario")
    public int editar(@WebParam(name = "idusuario") int idusuario,@WebParam(name = "username") String username , @WebParam(name = "password") String password , @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol) {
        Usuario u = new Usuario();
        u.setIdusuario(idusuario);
        u.setUsername(username);
        u.setPassword(password);
        u.setIdpersona(idpersona);
        u.setIdrol(idrol);
        return ud.update(u);
    }

   
    @WebMethod(operationName = "insertarUsuario")
    public int insertar(@WebParam(name = "username") String username , @WebParam(name = "password") String password , @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol) {
        //TODO write your implementation code here:
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setIdpersona(idpersona);
        u.setIdrol(idrol);
        return ud.create(u);
    }

  
    @WebMethod(operationName = "eliminarUsuario")
    public int eliminar(@WebParam(name = "idusuario") int idusuario) {
        //TODO write your implementation code here:
        return ud.delete(idusuario);
    }


   
    @WebMethod(operationName = "readAllUsuario")
    public List<Usuario> readAll() {
        //TODO write your implementation code here:
        return ud.readAll();
    }

    @WebMethod(operationName = "readUsuario")
    public Usuario read(@WebParam(name = "idusuario") int idusuario) {
        //TODO write your implementation code here:
        return ud.read(idusuario);
    }
*/
