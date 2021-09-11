/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.MdEmpleado;
import excepciones.*;
import java.util.*;

/**
 *
 * @author USUARIO
 */
public interface AccesoDatos {
    boolean existe(String JDBC_URL) throws AccesoDatosEx;
    public List<MdEmpleado> listar(String JDBC_URL) throws LecturaDatosEx;
    void escribir(MdEmpleado empleado, String JDBC_URL, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String JDBC_URL, Double buscar) throws LecturaDatosEx;
    public void crear(String JDBC_URL) throws AccesoDatosEx;
    public void borrar(String JDBC_URL) throws AccesoDatosEx;
}
