/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstracto;


import modelo.interfaces.IInventariable;

/**
 * Clase abstracta ItemInventario
 * Implementa la interfaz IInventariable
 * Representa items del inventario como Repuestos y Accesorios
 * Funcionalidad adicional del proyecto
 */
public abstract class ItemInventario implements IInventariable {
    // Atributos protegidos
    protected String codigo;
    protected String nombre;
    protected double precioUnitario;
    protected int stock;
    
    // Constructor por defecto
    public ItemInventario() {
        this.codigo = "";
        this.nombre = "";
        this.precioUnitario = 0.0;
        this.stock = 0;
    }
    
    // Constructor con parámetros
    public ItemInventario(String codigo, String nombre, 
                          double precioUnitario, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }
    
    // Métodos getter
    public String getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public int getStock() {
        return stock;
    }
    
    // Métodos setter
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0) {
            this.precioUnitario = precioUnitario;
        } else {
            System.out.println("El precio no puede ser negativo.");
        }
    }
    
    // Implementación de métodos de la interfaz IInventariable
    @Override
    public boolean actualizarStock(int cantidad) {
        int nuevoStock = this.stock + cantidad;
        if (nuevoStock >= 0) {
            this.stock = nuevoStock;
            return true;
        } else {
            System.out.println("Error: Stock insuficiente.");
            return false;
        }
    }
    
    @Override
    public int obtenerStock() {
        return this.stock;
    }
    
    @Override
    public boolean verificarDisponibilidad(int cantidad) {
        return this.stock >= cantidad;
    }
    
    // Método concreto para aumentar stock
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
            System.out.println("Stock aumentado. Nuevo stock: " + this.stock);
        }
    }
    
    // Método concreto para disminuir stock
    public boolean disminuirStock(int cantidad) {
        if (cantidad > 0 && this.stock >= cantidad) {
            this.stock -= cantidad;
            System.out.println("Stock reducido. Nuevo stock: " + this.stock);
            return true;
        } else {
            System.out.println("Stock insuficiente o cantidad inválida.");
            return false;
        }
    }
    
    // Método abstracto que cada tipo de item calculará diferente
    public abstract double calcularCostoTotal(int cantidad);
    
    // Método concreto para mostrar información básica
    public String informacionBasica() {
        return "Código: " + codigo + 
               "\nNombre: " + nombre + 
               "\nPrecio: S/. " + precioUnitario + 
               "\nStock: " + stock + " unidades";
    }
    
    @Override
    public String toString() {
        return codigo + " - " + nombre + " (Stock: " + stock + ")";
    }
    
    // Método para verificar si el item está agotado
    public boolean estaAgotado() {
        return this.stock == 0;
    }
    
    // Método para verificar stock bajo
    public boolean stockBajo() {
        return this.stock < 5 && this.stock > 0;
    }
}