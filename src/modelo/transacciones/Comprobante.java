package modelo.transacciones;

import java.util.Date;

public class Comprobante {
    private String numero;
    private String tipo;
    private Date fechaHora;
    private Venta venta;
    private double montoTotal;
    
    public Comprobante() {
        this.numero = generarNumero();
        this.tipo = "BOLETA";
        this.fechaHora = new Date();
        this.montoTotal = 0.0;
    }
    
    // Getters
    public String getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public Date getFechaHora() { return fechaHora; }
    public double getMontoTotal() { return montoTotal; }
    
    // Setters
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setVenta(Venta venta) { this.venta = venta; }
    public void setMontoTotal(double monto) { this.montoTotal = monto; }
    
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("      CONCESIONARIA DE VEHÍCULOS       \n");
        sb.append("========================================\n");
        sb.append(tipo).append(" Nº: ").append(numero).append("\n");
        sb.append("Fecha: ").append(fechaHora).append("\n");
        sb.append("----------------------------------------\n");
        
        if (venta != null) {
            sb.append("Cliente: ").append(venta.getCliente().getNombreCompleto()).append("\n");
            sb.append("DNI: ").append(venta.getCliente().getDni()).append("\n");
            sb.append("Vendedor: ").append(venta.getVendedor().getNombreCompleto()).append("\n");
            sb.append("----------------------------------------\n");
            sb.append("Vehículo: ").append(venta.getVehiculo().getMarca())
              .append(" ").append(venta.getVehiculo().getModelo()).append("\n");
        }
        
        sb.append("----------------------------------------\n");
        sb.append("TOTAL: S/. ").append(String.format("%.2f", montoTotal)).append("\n");
        sb.append("========================================\n");
        
        return sb.toString();
    }
    
    public void generarPDF() {
        System.out.println("Generando PDF del comprobante: " + numero);
        System.out.println("(Funcionalidad pendiente de implementar)");
    }
    
    private String generarNumero() {
        return "001-" + String.format("%08d", System.currentTimeMillis() % 100000000);
    }
    
    @Override
    public String toString() {
        return tipo + " " + numero + " - S/. " + montoTotal;
    }
}