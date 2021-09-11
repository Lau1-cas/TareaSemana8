/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;
import java.util.List;
/**
 *
 * @author USUARIO
 */
public class ClsConexion {
private static final String JDBC_URL= "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
private static final String JDBC_USER= "root";
private static final String JDBC_PWD= "Holamundo1";

   //Crear el metodo de conexion
public static Connection getConnection() throws SQLException{

return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PWD);

}
   public static void close(ResultSet rs){
       
    try {
        rs.close();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }
   }
   
   public static void close(PreparedStatement stms){
       
    try {
        stms.close();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }
   }
   
    public static void close(Connection cn){
       
    try {
        cn.close();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    }
   }
     public static void main (String [] args){
    
   // ej1();
    ClsEmpleadoJDBC alJDBC= new ClsEmpleadoJDBC();
    
    
    ClsEmpleado nuevo= new ClsEmpleado();
    nuevo.setNombre("Juan");
    nuevo.setNota1(80);
    nuevo.setNota2(76);
    
    alJDBC.insert(nuevo);
    
    
    //Seleccionar informacion
    List<ClsEmpleado> todos= alJDBC.seleccion();
    
    for (ClsEmpleado alumno : todos){
    
    System.out.println("Alumno= "+alumno);
    
    }
    
    }
}


