package com.roberto.pruebatecnica;

import com.roberto.pruebatecnica.model.Empleado;
import com.roberto.pruebatecnica.persistence.ControladoraPersistencia;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PruebaTecnica {

    public static void main(String[] args) {

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n**********************************************");
            System.out.println("*     Menú de Mantenimiento de Empleados     *");
            System.out.println("**********************************************");
            System.out.println("* 1. Crear Empleado                          *");
            System.out.println("* 2. Listar Empleados                        *");
            System.out.println("* 3. Modificar Empleado                      *");
            System.out.println("* 4. Eliminar Empleado                       *");
            System.out.println("* 0. Salir                                   *");
            System.out.println("**********************************************");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearEmpleado(controlPersis, scanner);
                    break;
                case 2:
                    listarEmpleados(controlPersis);
                    break;
                case 3:
                    modificarEmpleado(controlPersis, scanner);
                    break;
                case 4:
                    eliminarEmpleado(controlPersis, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void crearEmpleado(ControladoraPersistencia controlPersis, Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del empleado: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el cargo del empleado: ");
        String cargo = scanner.nextLine();

        System.out.print("¿Desea ingresar la fecha manualmente? (S/N): ");
        char opcionFecha = scanner.nextLine().toUpperCase().charAt(0);

        LocalDateTime fechaContratacion;
        if (opcionFecha == 'S') {
            System.out.print("Ingrese la fecha de contratación (Formato: yyyy-MM-dd HH:mm:ss): ");
            String fechaString = scanner.nextLine();
            fechaContratacion = LocalDateTime.parse(fechaString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } else {
            fechaContratacion = LocalDateTime.now();
        }

        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();

        Empleado nuevoEmpleado = new Empleado(nombre, apellido, cargo, fechaContratacion, salario);
        if (controlPersis.crearEmpleado(nuevoEmpleado)) {
            System.out.println("Empleado creado exitosamente.");
        } else {
            System.out.println("Ocurrio un error al crear el empleado.");
        }
    }

    private static void listarEmpleados(ControladoraPersistencia controlPersis) {
        System.out.println("Listado de Empleados:\n");
        List<Empleado> listaEmpleados = controlPersis.listadoEmpleados();

        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                System.out.println(empleado.toString());
            }
        }
    }

    private static void modificarEmpleado(ControladoraPersistencia controlPersis, Scanner scanner) {
        System.out.print("Ingrese el ID del empleado a modificar: ");
        int idModificar = scanner.nextInt();
        scanner.nextLine();

        Empleado empleadoMod = controlPersis.buscarEmpleado(idModificar);

        if (empleadoMod != null) {
            System.out.println("Empleado encontrado. Campos actuales:");
            System.out.println(empleadoMod.toString());

            System.out.println("\nSeleccione los campos que desea modificar:");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Cargo");
            System.out.println("4. Fecha de Contratación");
            System.out.println("5. Salario");
            System.out.println("0. Cancelar o salir");

            int opcion = -1;
            do {
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nuevo nombre del empleado: ");
                        String nuevoNombre = scanner.nextLine();
                        empleadoMod.setNombre(nuevoNombre);
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo apellido del empleado: ");
                        String nuevoApellido = scanner.nextLine();
                        empleadoMod.setApellido(nuevoApellido);
                        break;
                    case 3:
                        System.out.print("Ingrese el nuevo cargo del empleado: ");
                        String nuevoCargo = scanner.nextLine();
                        empleadoMod.setCargo(nuevoCargo);
                        break;
                    case 4:
                        System.out.print("Ingrese la nueva fecha de contratación (Formato: yyyy-MM-dd HH:mm:ss): ");
                        String nuevaFechaString = scanner.nextLine();
                        LocalDateTime nuevaFecha = LocalDateTime.parse(nuevaFechaString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        empleadoMod.setFechaInicio(nuevaFecha);
                        break;
                    case 5:
                        System.out.print("Ingrese el nuevo salario del empleado: ");
                        double nuevoSalario = scanner.nextDouble();
                        empleadoMod.setSalario(nuevoSalario);
                        break;
                    case 0:
                        System.out.println("Operación cancelada o terminada");
                        return;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } while (opcion != 0);

            controlPersis.modificarEmpleado(empleadoMod);

            System.out.println("Empleado modificado exitosamente.");
        } else {
            System.out.println("No se encontró un empleado con el ID proporcionado.");
        }
    }

    private static void eliminarEmpleado(ControladoraPersistencia controlPersis, Scanner scanner) {
        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        if (controlPersis.eliminarEmpleado(idEliminar)) {
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un empleado con el ID proporcionado.");
        }
    }

}
