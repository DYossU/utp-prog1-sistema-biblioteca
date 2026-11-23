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

public class Libro {
    // Atributos 
    private String titulo;
    private String isbn;
    private String autor;
    private boolean disponible;

    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(String titulo, String isbn, String autor, boolean disponible) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.disponible = disponible;
    }

    // Método para ingresar datos por consola
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== REGISTRO DE LIBRO ===");
        System.out.print("Ingrese Título: ");
        this.titulo = scanner.nextLine();
        System.out.print("Ingrese ISBN: ");
        this.isbn = scanner.nextLine();
        System.out.print("Ingrese Autor: ");
        this.autor = scanner.nextLine();
        System.out.print("¿Está disponible? (true para sí / false para no): ");
        this.disponible = scanner.nextBoolean();
    }

    // Métodos según el diagrama UML
    public boolean consultarDisponibilidad() {
        return this.disponible;
    }

    public void actualizarEstado() {
        this.disponible = !this.disponible;
    }

    // Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("--- DATOS DEL LIBRO ---");
        System.out.println("Título: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Autor: " + autor);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}