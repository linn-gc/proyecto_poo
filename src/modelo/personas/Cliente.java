package modelo.personas;

import modelo.abstracto.Persona;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Clase Cliente
 * Hereda de Persona (clase abstracta)
 * Representa a los compradores de vehículos del concesionario
 */
public class Cliente extends Persona {
    // Atributos específicos del cliente
    private String apPaterno;
    private String apMaterno;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaRegistro;
    private boolean activo;
    private int comprasRealizadas;
    private String tipoCliente; // REGULAR, FRECUENTE, VIP
    
    // Constructor por defecto
    public Cliente() {
        super();
        this.apPaterno = "";
        this.apMaterno = "";
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.fechaRegistro = new Date();
        this.activo = true;
        this.comprasRealizadas = 0;
        this.tipoCliente = "REGULAR";
    }
    
    // Constructor con parámetros básicos
    public Cliente(String dni, String nombres, String apPaterno, String apMaterno) {
        super(dni, nombres, apPaterno + " " + apMaterno);
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.direccion = "";
        this.telefono = "";
        this.email = "";
        this.fechaRegistro = new Date();
        this.activo = true;
        this.comprasRealizadas = 0;
        this.tipoCliente = "REGULAR";
    }
    
    // Constructor completo
    public Cliente(String dni, String nombres, String apPaterno, String apMaterno,
                   String direccion, String telefono, String email) {
        super(dni, nombres, apPaterno + " " + apMaterno);
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = new Date();
        this.activo = true;
        this.comprasRealizadas = 0;
        actualizarTipoCliente();
    }
    
    // Getters
    public String getApPaterno() { return apPaterno; }
    public String getApMaterno() { return apMaterno; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public boolean isActivo() { return activo; }
    public int getComprasRealizadas() { return comprasRealizadas; }
    public String getTipoCliente() { return tipoCliente; }
    
    // Setters
    public void setApPaterno(String apPaterno) {
        if (apPaterno != null && !apPaterno.isEmpty()) {
            this.apPaterno = apPaterno;
            this.apellidos = apPaterno + " " + apMaterno;
        }
    }
    
    public void setApMaterno(String apMaterno) {
        if (apMaterno != null && !apMaterno.isEmpty()) {
            this.apMaterno = apMaterno;
            this.apellidos = apPaterno + " " + apMaterno;
        }
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setTelefono(String telefono) {
        if (validarFormatoTelefono(telefono)) {
            this.telefono = telefono;
        }
    }
    
    public void setEmail(String email) {
        if (validarFormatoEmail(email)) {
            this.email = email;
        }
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void setComprasRealizadas(int comprasRealizadas) {
        this.comprasRealizadas = comprasRealizadas;
        actualizarTipoCliente();
    }
    
    // Implementación del método abstracto de Persona
    @Override
    public String mostrarInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        return "=== INFORMACIÓN DEL CLIENTE ===\n" +
               "DNI: " + dni + "\n" +
               "Nombres: " + nombres + "\n" +
               "Apellido Paterno: " + apPaterno + "\n" +
               "Apellido Materno: " + apMaterno + "\n" +
               "Dirección: " + (direccion.isEmpty() ? "No registrada" : direccion) + "\n" +
               "Teléfono: " + (telefono.isEmpty() ? "No registrado" : telefono) + "\n" +
               "Email: " + (email.isEmpty() ? "No registrado" : email) + "\n" +
               "Fecha de registro: " + sdf.format(fechaRegistro) + "\n" +
               "Estado: " + (activo ? "ACTIVO" : "INACTIVO") + "\n" +
               "Compras realizadas: " + comprasRealizadas + "\n" +
               "Tipo de cliente: " + tipoCliente;
    }
    
    // Métodos específicos
    
    public void modificarDatos() {
        System.out.println("Modificando datos del cliente: " + getNombreCompleto());
    }
    
    public boolean actualizarContacto(String nuevaDireccion, String nuevoTelefono, String nuevoEmail) {
        boolean actualizado = false;
        
        if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) {
            this.direccion = nuevaDireccion;
            actualizado = true;
        }
        
        if (nuevoTelefono != null && validarFormatoTelefono(nuevoTelefono)) {
            this.telefono = nuevoTelefono;
            actualizado = true;
        }
        
        if (nuevoEmail != null && validarFormatoEmail(nuevoEmail)) {
            this.email = nuevoEmail;
            actualizado = true;
        }
        
        if (actualizado) {
            System.out.println("Datos de contacto actualizados correctamente.");
        }
        
        return actualizado;
    }
    
    private boolean validarFormatoEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        int posicionArroba = email.indexOf('@');
        int posicionPunto = email.lastIndexOf('.');
        return posicionArroba > 0 && posicionPunto > posicionArroba && 
               posicionPunto < email.length() - 1;
    }
    
    private boolean validarFormatoTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) return false;
        return telefono.length() == 9 && telefono.matches("\\d+");
    }
    
    public boolean validarEmail() {
        return validarFormatoEmail(this.email);
    }
    
    public boolean validarTelefono() {
        return validarFormatoTelefono(this.telefono);
    }
    
    public boolean datosCompletos() {
        return validarDni() && !nombres.isEmpty() && !apPaterno.isEmpty() && 
               !apMaterno.isEmpty() && !direccion.isEmpty() && 
               validarTelefono() && validarEmail();
    }
    
    public String getNombreCompletoOficial() {
        return nombres + " " + apPaterno + " " + apMaterno;
    }
    
    public void incrementarCompras() {
        this.comprasRealizadas++;
        actualizarTipoCliente();
    }
    
    private void actualizarTipoCliente() {
        if (comprasRealizadas >= 5) {
            this.tipoCliente = "VIP";
        } else if (comprasRealizadas >= 3) {
            this.tipoCliente = "FRECUENTE";
        } else {
            this.tipoCliente = "REGULAR";
        }
    }
    
    public double calcularDescuentoCliente() {
        switch (tipoCliente) {
            case "VIP": return 10.0;
            case "FRECUENTE": return 5.0;
            default: return 0.0;
        }
    }
    
    public boolean esClienteVIP() {
        return tipoCliente.equals("VIP");
    }
    
    public void desactivar() {
        this.activo = false;
    }
    
    public void reactivar() {
        this.activo = true;
    }
    
    public int calcularAniosCliente() {
        if (fechaRegistro == null) return 0;
        Calendar calRegistro = Calendar.getInstance();
        calRegistro.setTime(fechaRegistro);
        Calendar calActual = Calendar.getInstance();
        return calActual.get(Calendar.YEAR) - calRegistro.get(Calendar.YEAR);
    }
    
    @Override
    public String toString() {
        return "Cliente: " + getNombreCompletoOficial() + 
               " (DNI: " + dni + ") - " + tipoCliente + 
               " - Compras: " + comprasRealizadas;
    }
    
    public String generarCodigoCliente() {
        return "CLI-" + dni;
    }
}