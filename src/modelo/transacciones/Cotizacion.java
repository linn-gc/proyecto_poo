package modelo.transacciones;

import modelo.personas.Cliente;
import modelo.personas.Vendedor;
import modelo.vehiculos.Vehiculo;
import modelo.promociones.Promocion;
import modelo.abstracto.ItemInventario;
import java.util.Date;
import java.util.ArrayList;

public class Cotizacion {
    private String codigo;
    private Date fecha;
    private Cliente cliente;
    private Vendedor vendedor;
    private Vehiculo vehiculo;
    private ArrayList<ItemInventario> items;
    private ArrayList<Integer> cantidades;
    private Promocion promocion;
    private double montoSubtotal;
    private double montoDescuento;
    private double montoTotal;
    private String estado;
    
    public Cotizacion() {
        this.codigo = generarCodigo();
        this.fecha = new Date();
        this.items = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.montoSubtotal = 0.0;
        this.montoDescuento = 0.0;
        this.montoTotal = 0.0;
        this.estado = "PENDIENTE";
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public Date getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public double getMontoTotal() { return montoTotal; }
    public String getEstado() { return estado; }
    
    // Setters
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public double calcularTotal() {
        montoSubtotal = 0.0;
        
        if (vehiculo != null) {
            montoSubtotal += vehiculo.getPrecioBase();
        }
        
        for (int i = 0; i < items.size(); i++) {
            ItemInventario item = items.get(i);
            int cantidad = cantidades.get(i);
            montoSubtotal += item.calcularCostoTotal(cantidad);
        }
        
        montoDescuento = 0.0;
        if (promocion != null) {
            double montoConPromo = promocion.aplicarDescuento(montoSubtotal);
            montoDescuento = montoSubtotal - montoConPromo;
        }
        
        montoTotal = montoSubtotal - montoDescuento;
        return montoTotal;
    }
    
    public void aplicarPromocion(Promocion promo) {
        this.promocion = promo;
        calcularTotal();
    }
    
    public void agregarItem(ItemInventario item, int cantidad) {
        if (item.verificarDisponibilidad(cantidad)) {
            items.add(item);
            cantidades.add(cantidad);
            calcularTotal();
        } else {
            System.out.println("Stock insuficiente para: " + item.getNombre());
        }
    }
    
    public Venta aprobar() {
        if (vehiculo == null || cliente == null || vendedor == null) {
            System.out.println("Error: Datos incompletos en la cotización");
            return null;
        }
        
        this.estado = "APROBADA";
        Venta venta = new Venta();
        venta.setCotizacion(this);
        venta.setCliente(cliente);
        venta.setVendedor(vendedor);
        venta.setVehiculo(vehiculo);
        venta.setMontoTotal(montoTotal);
        
        return venta;
    }
    
    public void rechazar() {
        this.estado = "RECHAZADA";
    }
    
    private String generarCodigo() {
        return "COT-" + System.currentTimeMillis();
    }
    
    @Override
    public String toString() {
        return codigo + " - Cliente: " + (cliente != null ? cliente.getNombreCompleto() : "N/A") +
               " - Total: S/. " + montoTotal + " - Estado: " + estado;
    }
}