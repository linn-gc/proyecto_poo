/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vehiculos;
import modelo.interfaces.IInventariable;
import modelo.promociones.Promocion;

public class Vehiculo implements IInventariable {
    private String codigo;
    private String marca;
    private String modelo;
    private String color;
    private int anioFabricacion;
    private String tipo;
    private double precioBase;
    private String estado;
    private int stockUnidades;
    
    public Vehiculo() {
        this.codigo = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.anioFabricacion = 2024;
        this.tipo = "SEDAN";
        this.precioBase = 0.0;
        this.estado = "DISPONIBLE";
        this.stockUnidades = 0;
    }
    
    public Vehiculo(String codigo, String marca, String modelo, String color,
                    int anio, String tipo, double precio, int stock) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anioFabricacion = anio;
        this.tipo = tipo;
        this.precioBase = precio;
        this.estado = "DISPONIBLE";
        this.stockUnidades = stock;
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public int getAnioFabricacion() { return anioFabricacion; }
    public String getTipo() { return tipo; }
    public double getPrecioBase() { return precioBase; }
    public String getEstado() { return estado; }
    
    // Setters
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setColor(String color) { this.color = color; }
    public void setAnioFabricacion(int anio) { this.anioFabricacion = anio; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPrecioBase(double precio) { this.precioBase = precio; }
    
    public void modificarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    public double calcularPrecioFinal(Promocion promocion) {
        if (promocion != null && promocion.estaVigente()) {
            return promocion.aplicarDescuento(this.precioBase);
        }
        return this.precioBase;
    }
    
    // Implementación de IInventariable
    @Override
    public boolean actualizarStock(int cantidad) {
        int nuevoStock = this.stockUnidades + cantidad;
        if (nuevoStock >= 0) {
            this.stockUnidades = nuevoStock;
            if (this.stockUnidades == 0) {
                this.estado = "AGOTADO";
            } else if (this.estado.equals("AGOTADO")) {
                this.estado = "DISPONIBLE";
            }
            return true;
        }
        return false;
    }
    
    @Override
    public int obtenerStock() {
        return this.stockUnidades;
    }
    
    @Override
    public boolean verificarDisponibilidad(int cantidad) {
        return this.stockUnidades >= cantidad && this.estado.equals("DISPONIBLE");
    }
    
    @Override
    public String toString() {
        return codigo + " - " + marca + " " + modelo + " " + anioFabricacion +
               " (" + color + ") - S/. " + precioBase + " - Stock: " + stockUnidades;
    }
}
