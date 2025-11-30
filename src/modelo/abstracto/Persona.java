/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstracto;

/**
 * Clase abstracta Persona
 * Representa la entidad base para Empleados y Clientes
 * Implementa polimorfismo a través del método abstracto mostrarInfo()
 */
public abstract class Persona {
    // Atributos protegidos para que las clases hijas puedan acceder
    protected String dni;
    protected String nombres;
    protected String apellidos;
    
    // Constructor por defecto
    public Persona() {
        this.dni = "";
        this.nombres = "";
        this.apellidos = "";
    }
    
    // Constructor con parámetros
    public Persona(String dni, String nombres, String apellidos) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    
    // Métodos getter
    public String getDni() {
        return dni;
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    // Métodos setter
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    // Método concreto que puede ser usado por todas las clases hijas
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }
    
    // Método abstracto que debe ser implementado por las clases hijas
    // Esto garantiza que cada tipo de persona muestre su información específica
    public abstract String mostrarInfo();
    
    // Método toString concreto (puede ser sobrescrito)
    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + getNombreCompleto();
    }
    
    // Método para validar DNI (método concreto auxiliar)
    public boolean validarDni() {
        return dni != null && dni.length() == 8 && dni.matches("\\d+");
    }
}