/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class Conexion {
    private static final String URL = "jdbc:postgresql://ec2-3-228-235-79.compute-1.amazonaws.com:5432/d3dcjfsk34b3tp";
	private static final String USER = "lizqzlcyjvyimw";
	private static final String PASS = "4cf0f9481ede00dbd49dc44f61e0c7d86095493e4037d81c59e2fc378483680b";
	private static final String DRIVER= "org.postgresql.Driver";
	private static Connection cx = null;
	
	public static Connection getConexion() {		
		try {
			Class.forName(DRIVER);
			if(cx==null) {
				cx = DriverManager.getConnection(URL, USER, PASS);
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
		return cx;
	}	
}
