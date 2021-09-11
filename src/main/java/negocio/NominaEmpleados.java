/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author USUARIO
 */
public interface NominaEmpleados {
    public void iniciarArchivo(String JDBC_URL);
    public void agregarEmpleado(String JDBC_URL, String nombreEmpleado, Double enero, Double febrero, Double marzo);
    public void buscarMayorYMenorVendedorPorMes(String JDBC_URL, int mes);
    public void buscarMayorVendedorGeneral(String JDBC_URL);
    public void editarDato(String JDBC_URL, String nuevoDato, int registro, int columna);
    public void buscarPorCantidad(String JDBC_URL, Double cantidad);
    public void listarEmpleados(String JDBC_URL);
}
