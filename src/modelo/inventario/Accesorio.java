/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.inventario;

import modelo.abstracto.ItemInventario;

public class Accesorio extends ItemInventario {
    private boolean instalacionRequerida;
    private String tipo;
    
    public Accesorio() {
        super();
        this.instalacionRequerida = false;
        this.tipo = "";
    }
    
    public Accesorio(String codigo, String nombre, double precio, int stock,
                     boolean instalacion, String tipo) {
        super(codigo, nombre, precio, stock);
        this.instalacionRequerida = instalacion;
        this.tipo = tipo;
    }
    
    public boolean isInstalacionRequerida() { return instalacionRequerida; }
    public String getTipo() { return tipo; }
    
    public void setInstalacionRequerida(boolean req) { 
        this.instalacionRequerida = req; 
    }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    @Override
    public double calcularCostoTotal(int cantidad) {
        double costoBase = this.precioUnitario * cantidad;
        if (instalacionRequerida) {
            costoBase += 50.0 * cantidad; // Costo de instalación
        }
        return costoBase;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Tipo: " + tipo + 
               (instalacionRequerida ? " (Requiere instalación)" : "");
    }
}
