/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.*;
import negocio.*;

/**
 *
 * @author USUARIO
 */
public class ClsPrincipal {
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    
    private static final String JDBC_URL= "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER= "root";
    private static final String JDBC_PWD= "Holamundo1";
    
    private static final NominaEmpleados empleados = new NominaEmpleadosImpl();
    
    /**
     * @param args the commando line arguments
     */
    public static void main(String[] args) {
        while (opcion != 0) {
            try {
                System.out.println("Elegir opcion:\n1-. Iniciar Nomina de Empleados"
                        + "\n2-. Agregar empleado"
                        + "\n3-. Mayor y Menor Vendedor por Mes"
                        + "\n4-. Mayor Vendedor General"
                        + "\n5-. Editar Dato Especifico "
                        + "\n6-. Buscar por Cantidad"
                        + "\n7-. Listar Informacion"
                        + "\n0-. Salir");
                
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        empleados.iniciarArchivo(JDBC_URL);
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese enero: ");
                        Double enero = scanner.nextDouble();
                        System.out.println("Ingrese febrero: ");
                        Double febrero = scanner.nextDouble();
                        System.out.println("Ingrese marzo: ");
                        Double marzo = scanner.nextDouble();
                        empleados.agregarEmpleado(JDBC_URL, nombre, enero, febrero, marzo);
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("Ingrese el mes: "
                                + "\n<1>Enero <2>Febrero <3>Marzo");
                        int mes = Integer.parseInt(scanner.nextLine());
                        empleados.buscarMayorYMenorVendedorPorMes(JDBC_URL, mes);
                        break;
                    case 4:
                        empleados.buscarMayorVendedorGeneral(JDBC_URL);
                        break;
                    case 5:
                        System.out.println("Ingrese el numero de registro: ");
                        int registro = Integer.parseInt(scanner.nextLine());
                        System.out.println("Elija el dato que desea editar: "
                                + "\n<1>Nombre <2>Enero <3>Febrero <4>Marzo");
                        int columna = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingrese el nuevo dato: ");
                        String nuevoDato = scanner.nextLine();
                        empleados.editarDato(JDBC_URL, nuevoDato, registro, columna);
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad: ");
                        Double cantidad = scanner.nextDouble();
                        scanner.nextLine();
                        empleados.buscarPorCantidad(JDBC_URL, cantidad);
                        break;
                    case 7:
                        empleados.listarEmpleados(JDBC_URL);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.println("\n");
            } catch (Exception ex) {
                System.out.println("Error\n");
            }
        }
    }
}

