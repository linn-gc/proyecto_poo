/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.promociones;

import java.util.Date;

public class Promocion {
    private String codigo;
    private String nombre;
    private String tipo;
    private double valor;
    private Date fechaInicio;
    private Date fechaFin;
    
    public Promocion() {
        this.codigo = "";
        this.nombre = "";
        this.tipo = "PORCENTAJE";
        this.valor = 0.0;
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
    }
    
    public Promocion(String codigo, String nombre, String tipo, double valor,
                     Date inicio, Date fin) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
    
    // Setters
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setValor(double valor) { this.valor = valor; }
    
    public double aplicarDescuento(double monto) {
        if (!estaVigente()) return monto;
        
        if (tipo.equals("PORCENTAJE")) {
            return monto * (1 - valor / 100);
        } else if (tipo.equals("MONTO_FIJO")) {
            return Math.max(0, monto - valor);
        }
        return monto;
    }
    
    public boolean estaVigente() {
        Date ahora = new Date();
        return !ahora.before(fechaInicio) && !ahora.after(fechaFin);
    }
    
    @Override
    public String toString() {
        return codigo + " - " + nombre + " (" + valor + 
               (tipo.equals("PORCENTAJE") ? "%" : " S/.") + ")";
    }
}
