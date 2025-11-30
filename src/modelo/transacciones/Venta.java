/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.transacciones;

import modelo.personas.Cliente;
import modelo.vehiculos.Vehiculo;
import java.util.Date;
import java.util.ArrayList;
import modelo.personas.Vendedor;

public class Venta {
    private String codigo;
    private Date fecha;
    private Cliente cliente;
    private Vendedor vendedor;
    private Vehiculo vehiculo;
    private Cotizacion cotizacion;
    private ArrayList<Pago> pagos;
    private double montoTotal;
    private double saldoPendiente;
    private String estadoPago;
    
    public Venta() {
        this.codigo = generarCodigo();
        this.fecha = new Date();
        this.pagos = new ArrayList<>();
        this.montoTotal = 0.0;
        this.saldoPendiente = 0.0;
        this.estadoPago = "PENDIENTE";
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public Date getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public double getMontoTotal() { return montoTotal; }
    public double getSaldoPendiente() { return saldoPendiente; }
    public String getEstadoPago() { return estadoPago; }
    
    // Setters
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public void setCotizacion(Cotizacion cot) { this.cotizacion = cot; }
    public void setMontoTotal(double monto) { 
        this.montoTotal = monto;
        this.saldoPendiente = monto;
    }
    
    public void registrarPago(Pago pago) {
        if (pago.procesarPago()) {
            pagos.add(pago);
            calcularSaldoPendiente();
        }
    }
    
    public double calcularSaldoPendiente() {
        double totalPagado = 0.0;
        for (Pago pago : pagos) {
            totalPagado += pago.getMontoAbonado();
        }
        
        saldoPendiente = montoTotal - totalPagado;
        
        if (saldoPendiente <= 0) {
            estadoPago = "PAGADO";
        } else if (totalPagado > 0) {
            estadoPago = "PAGO_PARCIAL";
        }
        
        return saldoPendiente;
    }
    
    public Comprobante generarComprobante() {
        Comprobante comp = new Comprobante();
        comp.setVenta(this);
        comp.setTipo("BOLETA");
        comp.setMontoTotal(montoTotal);
        return comp;
    }
    
    public void actualizarEstadoVehiculo() {
        if (vehiculo != null && estadoPago.equals("PAGADO")) {
            vehiculo.modificarEstado("VENDIDO");
            vehiculo.actualizarStock(-1);
        }
    }
    
    private String generarCodigo() {
        return "VTA-" + System.currentTimeMillis();
    }
    
    @Override
    public String toString() {
        return codigo + " - " + fecha + " - Cliente: " + 
               (cliente != null ? cliente.getNombreCompleto() : "N/A") +
               " - Total: S/. " + montoTotal + " - Estado: " + estadoPago;
    }
}
