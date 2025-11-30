/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.inventario;

import modelo.abstracto.ItemInventario;
import modelo.vehiculos.Vehiculo;

public class Repuesto extends ItemInventario {
    private String compatibilidadVehiculo;
    private String categoria;
    
    public Repuesto() {
        super();
        this.compatibilidadVehiculo = "";
        this.categoria = "";
    }
    
    public Repuesto(String codigo, String nombre, double precio, int stock,
                    String compatibilidad, String categoria) {
        super(codigo, nombre, precio, stock);
        this.compatibilidadVehiculo = compatibilidad;
        this.categoria = categoria;
    }
    
    public String getCompatibilidadVehiculo() { return compatibilidadVehiculo; }
    public String getCategoria() { return categoria; }
    
    public void setCompatibilidadVehiculo(String comp) { 
        this.compatibilidadVehiculo = comp; 
    }
    public void setCategoria(String cat) { this.categoria = cat; }
    
    @Override
    public double calcularCostoTotal(int cantidad) {
        return this.precioUnitario * cantidad;
    }
    
    public boolean verificarCompatibilidad(Vehiculo vehiculo) {
        return this.compatibilidadVehiculo.contains(vehiculo.getMarca());
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Categoría: " + categoria;
    }
}
