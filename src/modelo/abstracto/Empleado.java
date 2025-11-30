/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstracto;

import modelo.abstracto.Persona;
import java.util.Date;
import java.util.Calendar;

/**
 * Clase abstracta Empleado
 * Hereda de Persona e implementa funcionalidad común para empleados
 */
public abstract class Empleado extends Persona {
    protected String usuario;
    protected String clave;
    protected String rol;
    protected Date fechaIngreso;
    protected boolean activo;
    
    public Empleado() {
        super();
        this.usuario = "";
        this.clave = "";
        this.rol = "";
        this.fechaIngreso = new Date();
        this.activo = true;
    }
    
    public Empleado(String dni, String nombres, String apellidos,
                    String usuario, String clave, String rol) {
        super(dni, nombres, apellidos);
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.fechaIngreso = new Date();
        this.activo = true;
    }
    
    // Getters
    public String getUsuario() { return usuario; }
    public String getClave() { return clave; }
    public String getRol() { return rol; }
    public Date getFechaIngreso() { return fechaIngreso; }
    public boolean isActivo() { return activo; }
    
    // Setters
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setClave(String clave) { this.clave = clave; }
    public void setRol(String rol) { this.rol = rol; }
    public void setActivo(boolean activo) { this.activo = activo; }
    
    // Método concreto para login
    public boolean login(String user, String password) {
        return this.usuario.equals(user) && this.clave.equals(password) && this.activo;
    }
    
    // Método concreto para calcular años de servicio
    public int calcularAniosServicio() {
        if (fechaIngreso == null) return 0;
        Calendar calIngreso = Calendar.getInstance();
        calIngreso.setTime(fechaIngreso);
        Calendar calActual = Calendar.getInstance();
        return calActual.get(Calendar.YEAR) - calIngreso.get(Calendar.YEAR);
    }
    
    // Método abstracto que cada tipo de empleado implementará
    public abstract void gestionarVehiculos();
    
    @Override
    public String toString() {
        return "Usuario: " + usuario + ", Rol: " + rol + 
               ", Estado: " + (activo ? "ACTIVO" : "INACTIVO");
    }
}