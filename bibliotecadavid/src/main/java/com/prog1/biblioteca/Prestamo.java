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

public class Prestamo {
    // Atributos privados 
    private String idPrestamo;
    private String fechaPrestamo;
    private String fechaDevolucionEstimada;

    // Constructor vacío
    public Prestamo() {
    }

    // Constructor con parámetros
    public Prestamo(String idPrestamo, String fechaPrestamo, String fechaDevolucionEstimada) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionEstimada = fechaDevolucionEstimada;
    }

    // Método para ingresar datos por consola
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== REGISTRO DE PRÉSTAMO ===");
        System.out.print("Ingrese ID del Préstamo: ");
        this.idPrestamo = scanner.nextLine();
        System.out.print("Ingrese Fecha de Préstamo (ej. 24/9/2026): ");
        this.fechaPrestamo = scanner.nextLine();
        System.out.print("Ingrese Fecha Devolución Estimada (ej. 08/10/2026): ");
        this.fechaDevolucionEstimada = scanner.nextLine();
    }

    // Métodos según el diagrama UML
    public double calcularMulta() {
        double multa = 0.0;
        System.out.println("Calculando multa para el préstamo " + idPrestamo + "...");
        return multa;
    }

    public void finalizarPrestamo() {
        System.out.println("El préstamo " + idPrestamo + " ha sido finalizado con éxito.");
    }

    // Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("--- DATOS DEL PRÉSTAMO ---");
        System.out.println("ID Préstamo: " + idPrestamo);
        System.out.println("Fecha de Préstamo: " + fechaPrestamo);
        System.out.println("Fecha Devolución Estimada: " + fechaDevolucionEstimada);
    }

    // Getters y Setters
    public String getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(String idPrestamo) { this.idPrestamo = idPrestamo; }
    public String getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public String getFechaDevolucionEstimada() { return fechaDevolucionEstimada; }
    public void setFechaDevolucionEstimada(String fechaDevolucionEstimada) { this.fechaDevolucionEstimada = fechaDevolucionEstimada; }
}
