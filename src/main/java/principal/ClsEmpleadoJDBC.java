/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import conexion.ClsConexion;
import java.sql.*;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public class ClsEmpleadoJDBC {
    private static final String SQL_SELECT ="select * from tb_empleado";
    private static final String SQL_INSERT ="insert into tb_empleado (nombre,nota1,nota2) values(?,?,?)";
    private static final String SQL_UPDATE ="update tb_empleado set nombre =?,enero =?,febrero=?, marzo=? where codigo=?";
    private static final String SQL_DELETE="delete from tb_empleado where nnombre =?,enero =?,febrero=?, marzo=?  codigo=?";
    
    //hacer el delete
    
    
    
    //Seleccionar informacion
    public List<ClsEmpleado> seleccion(){
    
    Connection conn=null;
    PreparedStatement stmt=null;
    ResultSet rs= null;
    ClsEmpleado alumno=null;
    List <ClsEmpleado> empleado=new ArrayList<ClsEmpleado>();
    
        try {
            conn= ClsConexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            
            while(rs.next()){
            int codigo =rs.getInt("codigo");
            String nombre =rs.getString("nombre");
            int enero =rs.getInt("enero");
            int febrero =rs.getInt("febrero");
            int marzo=rs.gentInt("marzo");
            empleado=new ClsEmpleado();
            empleado.setCodigo(codigo);
            empleado.setNombre(nombre);
            empleado.setEnero(enero);
            empleado.setFebrero(febrero);
            empleado.setMarzo(marzo);
            empleados.add(empleado);
            }
        } catch (SQLException ex) {
          ex.printStackTrace(System.out);
        }
    finally {
        ClsConexion.close(rs);
        ClsConexion.close(stmt);
        ClsConexion.close(conn);
        
        }
        return empleados;
    }
    
    //Seleccionar informacion
    public int insert(Clsempleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombre());
            stmt.setInt(2, empleado.getEnerp());
            stmt.setInt(3, empleado.getFebrero());
            stmt.setInt(3, empleado.getMarzo());
         
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        
        return rows;
    }

}


