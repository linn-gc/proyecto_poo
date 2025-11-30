/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.personas;

import modelo.abstracto.Empleado;
import modelo.transacciones.Cotizacion;
import modelo.transacciones.Venta;
import modelo.vehiculos.Vehiculo;

/**
 * Clase Vendedor
 * Hereda de Empleado (clase abstracta)
 * Implementa los métodos abstractos con comportamiento específico
 */
public class Vendedor extends Empleado {
    // Atributos adicionales específicos del vendedor
    private int ventasRealizadas;
    
    // Constructor por defecto
    public Vendedor() {
        super();
        this.rol = "VENDEDOR";
        this.ventasRealizadas = 0;
    }
    
    // Constructor con parámetros
    public Vendedor(String dni, String nombres, String apellidos, 
                    String usuario, String clave) {
        super(dni, nombres, apellidos, usuario, clave, "VENDEDOR");
        this.ventasRealizadas = 0;
    }
    
    // Getter y Setter
    public int getVentasRealizadas() {
        return ventasRealizadas;
    }
    
    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }
    
    // Implementación del método abstracto de Empleado
    @Override
    public void gestionarVehiculos() {
        System.out.println("Vendedor puede consultar y mostrar vehículos disponibles.");
        System.out.println("No tiene permisos para crear, modificar o eliminar vehículos.");
    }
    
    // Implementación del método abstracto de Persona
    @Override
    public String mostrarInfo() {
        return "=== INFORMACIÓN DEL VENDEDOR ===\n" +
               "DNI: " + dni + "\n" +
               "Nombre: " + getNombreCompleto() + "\n" +
               "Usuario: " + usuario + "\n" +
               "Rol: " + rol + "\n" +
               "Estado: " + (activo ? "ACTIVO" : "INACTIVO") + "\n" +
               "Ventas realizadas: " + ventasRealizadas + "\n" +
               "Años de servicio: " + calcularAniosServicio();
    }
    
    // Métodos específicos del Vendedor
    
    /**
     * Crea una cotización para un cliente
     */
    public Cotizacion crearCotizacion(Cliente cliente, Vehiculo vehiculo) {
        System.out.println("Creando cotización...");
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setCliente(cliente);
        cotizacion.setVendedor(this);
        cotizacion.setVehiculo(vehiculo);
        cotizacion.calcularTotal();
        System.out.println("Cotización creada exitosamente.");
        return cotizacion;
    }
    
    /**
     * Registra una venta basada en una cotización aprobada
     */
    public Venta registrarVenta(Cotizacion cotizacion) {
        if (cotizacion.getEstado().equals("APROBADA")) {
            Venta venta = cotizacion.aprobar();
            this.ventasRealizadas++;
            System.out.println("Venta registrada exitosamente.");
            return venta;
        } else {
            System.out.println("Error: La cotización no está aprobada.");
            return null;
        }
    }
    
    /**
     * Gestiona clientes (crear, modificar, consultar)
     */
    public void gestionarClientes() {
        System.out.println("Gestionando clientes...");
        System.out.println("Vendedor: " + getNombreCompleto());
        System.out.println("Puede crear, modificar y consultar información de clientes.");
    }
    
    /**
     * Incrementa el contador de ventas
     */
    public void incrementarVentas() {
        this.ventasRealizadas++;
    }
    
    /**
     * Calcula comisión basada en ventas (ejemplo: 2% por venta)
     */
    public double calcularComision(double totalVentas) {
        return totalVentas * 0.02;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Ventas: " + ventasRealizadas;
    }
}