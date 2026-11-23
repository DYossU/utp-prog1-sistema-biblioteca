/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * David Ureña , Yoselin Perez, Oliver Oses, Luis Montenegro, Pedro Zamora, Albis Castro
 */
package com.prog1.biblioteca;

import java.util.Scanner; // Importa la clase Scanner para poder leer datos desde la consola

public class Bibliotecario { // Declaración de la clase pública Bibliotecario
    
    // Atributos privados de la clase 
    private String idEmpleado; // Almacena el identificador único del empleado
    private String turno;      // Almacena el turno laboral del bibliotecario

    // Constructor vacío (sin parámetros) para instanciar el objeto sin valores iniciales
    public Bibliotecario() {
    }

    // Constructor con parámetros para inicializar el objeto directamente con su ID y turno
    public Bibliotecario(String idEmpleado, String turno) {
        this.idEmpleado = idEmpleado; // Asigna el parámetro al atributo de la clase
        this.turno = turno;          // Asigna el turno recibido al atributo de la clase
    }

    // Método para ingresar los datos del bibliotecario por consola utilizando un sub-menú
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in); // Crea una instancia de Scanner para leer la entrada del usuario
        System.out.println("=== REGISTRO DE BIBLIOTECARIO ==="); // Muestra el título de la sección
        System.out.print("Ingrese ID del Empleado: "); // Solicita el ID por pantalla
        this.idEmpleado = scanner.nextLine(); // Lee y guarda la línea de texto ingresada en idEmpleado

        int opcionTurno = 0; // Variable auxiliar para controlar la opción elegida en el sub-menú
        
        // Bucle do-while para asegurar que el usuario elija una opción válida (se repite si hay error)
        do {
            System.out.println("\n--- SELECCIONE EL TURNO ---"); // Muestra las opciones del sub-menú
            System.out.println("1. Matutino");
            System.out.println("2. Vespertino");
            System.out.println("3. Nocturno");
            System.out.print("Elija una opción (1-3): "); // Solicita la selección numérica

            // Verifica si lo que ingresó el usuario es un número entero
            if (scanner.hasNextInt()) {
                opcionTurno = scanner.nextInt(); // Lee el número entero ingresado
                scanner.nextLine(); // Limpia el buffer del teclado después de leer un entero

                // Estructura switch para asignar el texto del turno según la opción numérica elegida
                switch (opcionTurno) {
                    case 1:
                        this.turno = "Matutino"; // Asigna "Matutino" si eligió 1
                        break;
                    case 2:
                        this.turno = "Vespertino"; // Asigna "Vespertino" si eligió 2
                        break;
                    case 3:
                        this.turno = "Nocturno"; // Asigna "Nocturno" si eligió 3
                        break;
                    default:
                        System.out.println(" Opción inválida. Intente de nuevo."); // Mensaje si el número está fuera del rango (1-3)
                        opcionTurno = 0; // Restablece a 0 para forzar que el bucle se repita
                }
            } else {
                scanner.nextLine(); // Limpia la entrada inválida de texto para evitar bucles infinitos
                System.out.println(" Por favor, ingrese un número válido."); // Mensaje de advertencia
                opcionTurno = 0; // Restablece a 0 para repetir el bucle
            }
        } while (opcionTurno == 0); // El bucle se mantiene activo mientras opcionTurno sea 0 (inválido)
        
        System.out.println("¡Turno asignado correctamente: " + this.turno + "!"); // Confirma el éxito de la selección
    }

    // Método para simular el registro de un préstamo en el sistema
    public void registrarPrestamo() {
        System.out.println("El bibliotecario con ID " + idEmpleado + " ha registrado el préstamo.");
    }

    // Método para simular el registro de una devolución en el sistema
    public void registrarDevolucion() {
        System.out.println("El bibliotecario con ID " + idEmpleado + " ha registrado la devolución.");
    }

    // Método para mostrar en pantalla los datos actuales del bibliotecario
    public void mostrarDatos() {
        System.out.println("--- DATOS DEL BIBLIOTECARIO ---");
        System.out.println("ID Empleado: " + idEmpleado); // Imprime el ID
        System.out.println("Turno: " + turno);           // Imprime el turno asignado
    }

    // Métodos Getters y Setters para acceder y modificar los atributos privados de forma segura
    public String getIdEmpleado() { 
        return idEmpleado; // Retorna el ID del empleado
    }
    
    public void setIdEmpleado(String idEmpleado) { 
        this.idEmpleado = idEmpleado; // Permite actualizar el ID del empleado
    }
    
    public String getTurno() { 
        return turno; // Retorna el turno actual
    }
    
    public void setTurno(String turno) { 
        this.turno = turno; // Permite actualizar el turno
    }
}