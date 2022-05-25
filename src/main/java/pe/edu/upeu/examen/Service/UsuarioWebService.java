/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.examen.Service;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.examen.dao.usuarioDao;
import pe.edu.upeu.examen.daoimpl.UsuarioDaoImpl;
import pe.edu.upeu.examen.model.Usuario;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "UsuarioWebService")
public class UsuarioWebService {
    usuarioDao ud = new UsuarioDaoImpl();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
     @WebMethod(operationName = "editarUsuario")
    public int editar(@WebParam(name = "username") String username , @WebParam(name = "password") String password , @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol,@WebParam(name = "idusuario") int idusuario) {
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setIdrol(idrol);
        u.setIdpersona(idpersona);
        u.setIdusuario(idusuario);
        return ud.update(u);
    }

   
    @WebMethod(operationName = "insertarUsuario")
    public int insertar(@WebParam(name = "username") String username , @WebParam(name = "password") String password , @WebParam(name = "idpersona") int idpersona, @WebParam(name = "idrol") int idrol) {
        //TODO write your implementation code here:
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(password);
        u.setIdrol(idrol);
        u.setIdpersona(idpersona);
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
}
