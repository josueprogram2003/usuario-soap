/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.examen.dao;

import java.util.List;
import pe.edu.upeu.examen.model.Usuario;

/**
 *
 * @author Usuario
 */
public interface usuarioDao {
    int create(Usuario u);
    int update(Usuario u);
    int delete(int idusuario);
    Usuario read(int idusuario);
    List<Usuario> readAll();
}
