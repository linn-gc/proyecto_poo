/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.personas;

import modelo.abstracto.Empleado;
import modelo.negocio.Reporte;
import modelo.promociones.Promocion;

public class Administrador extends Empleado {
    private String nivelAcceso;
    
    public Administrador() {
        super();
        this.rol = "ADMINISTRADOR";
        this.nivelAcceso = "TOTAL";
    }
    
    public Administrador(String dni, String nombres, String apellidos,
                        String usuario, String clave) {
        super(dni, nombres, apellidos, usuario, clave, "ADMINISTRADOR");
        this.nivelAcceso = "TOTAL";
    }
    
    public String getNivelAcceso() { return nivelAcceso; }
    public void setNivelAcceso(String nivel) { this.nivelAcceso = nivel; }
    
    @Override
    public void gestionarVehiculos() {
        System.out.println("Administrador: Acceso completo a gestión de vehículos");
        System.out.println("Puede crear, modificar, eliminar y consultar vehículos");
    }
    
    @Override
    public String mostrarInfo() {
        return "=== INFORMACIÓN DEL ADMINISTRADOR ===\n" +
               "DNI: " + dni + "\n" +
               "Nombre: " + getNombreCompleto() + "\n" +
               "Usuario: " + usuario + "\n" +
               "Rol: " + rol + "\n" +
               "Nivel de acceso: " + nivelAcceso + "\n" +
               "Estado: " + (activo ? "ACTIVO" : "INACTIVO") + "\n" +
               "Años de servicio: " + calcularAniosServicio();
    }
    
    public void gestionarEmpleados() {
        System.out.println("Gestionando empleados...");
    }
    
    public void gestionarPromociones() {
        System.out.println("Gestionando promociones...");
    }
    
    public void gestionarInventario() {
        System.out.println("Gestionando inventario completo...");
    }
    
    public Reporte generarReportes(String tipo) {
        System.out.println("Generando reporte tipo: " + tipo);
        return new Reporte(tipo);
    }
}
