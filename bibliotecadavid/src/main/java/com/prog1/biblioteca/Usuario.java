/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


/**
 *
 * David Ureña , Yoselin Perez, Oliver Oses, Luis Montenegro, Pedro Zamora, Albis Castro
 */
package com.prog1.biblioteca;

import java.util.Scanner;

public class Usuario {
    // Atributos privados 
    private String idUsuario;
    private String nombre;
    private String correo;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String idUsuario, String nombre, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Método para ingresar datos por consola
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== REGISTRO DE USUARIO ===");
        System.out.print("Ingrese ID de Usuario: ");
        this.idUsuario = scanner.nextLine();
        System.out.print("Ingrese Nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Ingrese Correo: ");
        this.correo = scanner.nextLine();
    }

    // Métodos propios de Usuario
    public void solicitarPrestamo() {
        System.out.println("El usuario " + nombre + " ha solicitado un préstamo de libro.");
    }

    public void devolverLibro() {
        System.out.println("El usuario " + nombre + " ha devuelto el libro.");
    }

    // Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("--- DATOS DEL USUARIO ---");
        System.out.println("ID Usuario: " + idUsuario);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
    }

    // Getters y Setters
    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}