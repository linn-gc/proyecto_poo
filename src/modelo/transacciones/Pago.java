package modelo.transacciones;

import java.util.Date;

public class Pago {
    private String codigo;
    private Date fecha;
    private String metodoPago;
    private double montoAbonado;
    private int numeroCuota;
    
    public Pago() {
        this.codigo = generarCodigo();
        this.fecha = new Date();
        this.metodoPago = "EFECTIVO";
        this.montoAbonado = 0.0;
        this.numeroCuota = 0;
    }
    
    public Pago(String metodo, double monto, int cuota) {
        this.codigo = generarCodigo();
        this.fecha = new Date();
        this.metodoPago = metodo;
        this.montoAbonado = monto;
        this.numeroCuota = cuota;
    }
    
    // Getters
    public String getCodigo() { return codigo; }
    public Date getFecha() { return fecha; }
    public String getMetodoPago() { return metodoPago; }
    public double getMontoAbonado() { return montoAbonado; }
    public int getNumeroCuota() { return numeroCuota; }
    
    // Setters
    public void setMetodoPago(String metodo) { this.metodoPago = metodo; }
    public void setMontoAbonado(double monto) { this.montoAbonado = monto; }
    public void setNumeroCuota(int cuota) { this.numeroCuota = cuota; }
    
    public boolean procesarPago() {
        if (montoAbonado > 0) {
            System.out.println("Pago procesado: " + codigo);
            System.out.println("Método: " + metodoPago);
            System.out.println("Monto: S/. " + montoAbonado);
            return true;
        }
        return false;
    }
    
    public String generarRecibo() {
        return "===== RECIBO DE PAGO =====\n" +
               "Código: " + codigo + "\n" +
               "Fecha: " + fecha + "\n" +
               "Método: " + metodoPago + "\n" +
               "Monto: S/. " + montoAbonado + "\n" +
               (numeroCuota > 0 ? "Cuota Nº: " + numeroCuota + "\n" : "") +
               "==========================";
    }
    
    private String generarCodigo() {
        return "PAG-" + System.currentTimeMillis();
    }
    
    @Override
    public String toString() {
        return codigo + " - " + metodoPago + " - S/. " + montoAbonado;
    }
}
