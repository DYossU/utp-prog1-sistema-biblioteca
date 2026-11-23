/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * David Ureña , Yoselin Perez, Oliver Oses, Luis Montenegro, Pedro Zamora, Albis Castro
 */
package com.prog1.biblioteca;

import java.util.Scanner;

public class SistemaBiblioteca {

    // Método auxiliar para simular una "limpieza de pantalla" en la consola
    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    // Método auxiliar para "esperar tecla" (pausa)
    public static void pausar(Scanner scanner) {
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instanciamos los objetos principales de las clases
        Usuario usuario1 = new Usuario();
        Bibliotecario bibliotecario1 = new Bibliotecario();
        Prestamo prestamo1 = new Prestamo();

        // Creamos un ARREGLO UNIDIMENSIONAL para almacenar un catálogo de 3 libros
        int totalLibros = 3;
        Libro[] catalogoLibros = new Libro[totalLibros];

        int opcion = 0;
        boolean datosRegistrados = false; // Bandera para controlar si ya se llenó la información

        // Bucle principal del menú interactivo
        do {
            limpiarPantalla();
            System.out.println("=========================================");
            System.out.println("        SISTEMA DE BIBLIOTECA            ");
            System.out.println("=========================================");
            System.out.println(" 1. Registrar datos y catálogo de libros ");
            System.out.println(" 2. Mostrar resumen y catálogo completo  ");
            System.out.println(" 3. Realizar simulación de Préstamo      ");
            System.out.println(" 4. Salir                                ");
            System.out.println("=========================================");
            System.out.print("Seleccione una opción: ");

            // Validación de entrada numérica para el menú
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
            } else {
                scanner.nextLine(); // Limpiar texto inválido
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("=== 1. REGISTRO DE DATOS GENERALES ===");
                    usuario1.ingresarDatos();
                    System.out.println();
                    bibliotecario1.ingresarDatos();
                    System.out.println();
                    prestamo1.ingresarDatos();
                    System.out.println();

                    // Llenando el Arreglo Unidimensional de Libros por teclado
                    System.out.println("=== REGISTRO DEL CATÁLOGO DE LIBROS (" + totalLibros + " libros) ===");
                    for (int i = 0; i < catalogoLibros.length; i++) {
                        System.out.println("\nRegistrando libro #" + (i + 1));
                        catalogoLibros[i] = new Libro(); // Instanciamos el objeto en la posición 'i'
                        catalogoLibros[i].ingresarDatos(); // Pedimos sus datos por teclado
                    }

                    datosRegistrados = true; // Activamos la bandera
                    System.out.println("\n¡Todos los datos y el arreglo de libros se registraron con éxito!");
                    pausar(scanner);
                    break;

                case 2:
                    limpiarPantalla();
                    if (!datosRegistrados) {
                        System.out.println("Primero debe registrar los datos en la opción 1.");
                    } else {
                        System.out.println("=========================================");
                        System.out.println("      RESUMEN GENERAL DEL SISTEMA        ");
                        System.out.println("=========================================\n");
                        usuario1.mostrarDatos();
                        System.out.println();
                        bibliotecario1.mostrarDatos();
                        System.out.println();
                        prestamo1.mostrarDatos();
                        System.out.println();

                        // Recorremos el arreglo unidimensional para mostrar todos los libros
                        System.out.println("=== CATÁLOGO DE LIBROS (ARREGLO) ===");
                        for (int i = 0; i < catalogoLibros.length; i++) {
                            System.out.println("Libro en posición [" + i + "]:");
                            catalogoLibros[i].mostrarDatos();
                            System.out.println("----------------------------------");
                        }
                    }
                    pausar(scanner);
                    break;

                case 3:
                    limpiarPantalla();
                    if (!datosRegistrados) {
                        System.out.println("Debe registrar los datos y libros primero (Opción 1).");
                    } else {
                        System.out.println("=========================================");
                        System.out.println("         MÓDULO DE PRÉSTAMO              ");
                        System.out.println("=========================================\n");
                        
                        // Pregunta dinámica si desea realizar un préstamo
                        System.out.print("¿Desea realizar un préstamo de libro ahora? (s/n): ");
                        String respuesta = scanner.nextLine();

                        if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si")) {
                            System.out.println("\nSeleccione el libro que desea consultar/prestar ingresando su número (0 al " + (catalogoLibros.length - 1) + "):");
                            
                            // Mostramos los libros del arreglo con su índice
                            for (int i = 0; i < catalogoLibros.length; i++) {
                                System.out.println("[" + i + "] Título: " + catalogoLibros[i].getTitulo() + " | Disponible: " + (catalogoLibros[i].isDisponible() ? "Sí" : "No"));
                            }
                            
                            System.out.print("Ingrese el índice del libro: ");
                            if (scanner.hasNextInt()) {
                                int indiceLibro = scanner.nextInt();
                                scanner.nextLine(); // Limpiar buffer

                                // Validamos que el índice esté dentro del rango del arreglo
                                if (indiceLibro >= 0 && indiceLibro < catalogoLibros.length) {
                                    Libro libroSeleccionado = catalogoLibros[indiceLibro];

                                    // Consultamos disponibilidad usando el método de la clase Libro
                                    if (libroSeleccionado.consultarDisponibilidad()) {
                                        System.out.println("\n¡El libro '" + libroSeleccionado.getTitulo() + "' está disponible!");
                                        usuario1.solicitarPrestamo();
                                        bibliotecario1.registrarPrestamo();
                                        prestamo1.calcularMulta();

                                        // Cambiamos el estado del libro en el arreglo (pasa a no disponible)
                                        libroSeleccionado.actualizarEstado();
                                        System.out.println("\n¡Préstamo procesado exitosamente! El libro ahora figura como NO disponible.");
                                    } else {
                                        System.out.println("\n[Lo sentimos, el libro '" + libroSeleccionado.getTitulo() + "' NO se encuentra disponible.");
                                    }
                                } else {
                                    System.out.println("\nError El índice ingresado no existe en el catálogo.");
                                }
                            } else {
                                scanner.nextLine();
                                System.out.println("\nError: Debe ingresar un número válido.");
                            }
                        } else {
                            System.out.println("\nOperación de préstamo omitida. Volviendo al menú principal.");
                        }
                    }
                    pausar(scanner);
                    break;

                case 4:
                    limpiarPantalla();
                    System.out.println("Saliendo del Sistema de Biblioteca. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
                    pausar(scanner);
                    break;
            }

        } while (opcion != 4);

        scanner.close();
    }
}