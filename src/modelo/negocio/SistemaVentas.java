package modelo.negocio;

import java.util.ArrayList;
import modelo.abstracto.Empleado;
import modelo.abstracto.ItemInventario;
import modelo.personas.Administrador;
import modelo.personas.Cliente;
import modelo.personas.Vendedor;
import modelo.promociones.Promocion;
import modelo.transacciones.*;
import modelo.vehiculos.Vehiculo;

public class SistemaVentas {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Empleado> empleados;
    private ArrayList<Cliente> clientes;
    private ArrayList<Promocion> promociones;
    private ArrayList<ItemInventario> inventario;
    private ArrayList<Venta> ventas;
    private ArrayList<Cotizacion> cotizaciones;
    
    public SistemaVentas() {
        this.vehiculos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.promociones = new ArrayList<>();
        this.inventario = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.cotizaciones = new ArrayList<>();

        // Usuarios por defecto (ajustar si se requieren otros valores)
        try {
            Administrador admin = new Administrador("00000000", "Admin", "Sistema", "admin", "admin123");
            this.registrarEmpleado(admin);

            Vendedor vendedor = new Vendedor("11111111", "Juan", "Pérez", "vendedor", "vend123");
            this.registrarEmpleado(vendedor);

            System.out.println("Usuarios por defecto: admin/admin123  |  vendedor/vend123");
        } catch (Exception ex) {
            System.out.println("No se pudieron crear usuarios por defecto: " + ex.getMessage());
        }
    }
    
    // ========== AUTENTICACIÓN ==========
    public Empleado autenticar(String usuario, String clave) {
        for (Empleado emp : empleados) {
            if (emp.login(usuario, clave)) {
                System.out.println("Autenticación exitosa: " + emp.getNombreCompleto());
                return emp;
            }
        }
        System.out.println("Autenticación fallida");
        return null;
    }
    
    // ========== REGISTRO DE EMPLEADOS ==========
    public boolean registrarEmpleado(Empleado empleado) {
        if (empleado == null) return false;
        
        for (Empleado emp : empleados) {
            if (emp.getUsuario().equals(empleado.getUsuario())) {
                System.out.println("Error: Usuario ya existe");
                return false;
            }
        }
        
        empleados.add(empleado);
        System.out.println("Empleado registrado: " + empleado.getNombreCompleto());
        return true;
    }
    
    // ========== REGISTRO DE CLIENTES ==========
    public boolean registrarCliente(Cliente cliente) {
        if (cliente == null) return false;
        
        for (Cliente cli : clientes) {
            if (cli.getDni().equals(cliente.getDni())) {
                System.out.println("Error: Cliente ya existe");
                return false;
            }
        }
        
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombreCompleto());
        return true;
    }
    
    // ========== REGISTRO DE VEHÍCULOS ==========
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) return false;
        
        for (Vehiculo veh : vehiculos) {
            if (veh.getCodigo().equals(vehiculo.getCodigo())) {
                System.out.println("Error: Vehículo ya existe");
                return false;
            }
        }
        
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo);
        return true;
    }
    
    // ========== REGISTRO DE PROMOCIONES ==========
    public boolean registrarPromocion(Promocion promocion) {
        if (promocion == null) return false;
        
        for (Promocion promo : promociones) {
            if (promo.getCodigo().equals(promocion.getCodigo())) {
                System.out.println("Error: Promoción ya existe");
                return false;
            }
        }
        
        promociones.add(promocion);
        System.out.println("Promoción registrada: " + promocion);
        return true;
    }
    
    // ========== BÚSQUEDA DE VEHÍCULOS ==========
    public Vehiculo buscarVehiculo(String codigo) {
        for (Vehiculo veh : vehiculos) {
            if (veh.getCodigo().equals(codigo)) {
                return veh;
            }
        }
        System.out.println("Vehículo no encontrado: " + codigo);
        return null;
    }
    
    // ========== BÚSQUEDA DE CLIENTES ==========
    public Cliente buscarCliente(String dni) {
        for (Cliente cli : clientes) {
            if (cli.getDni().equals(dni)) {
                return cli;
            }
        }
        System.out.println("Cliente no encontrado: " + dni);
        return null;
    }
    
    // ========== BÚSQUEDA DE EMPLEADOS ==========
    public Empleado buscarEmpleado(String usuario) {
        for (Empleado emp : empleados) {
            if (emp.getUsuario().equals(usuario)) {
                return emp;
            }
        }
        System.out.println("Empleado no encontrado: " + usuario);
        return null;
    }
    
    // ========== GENERAR REPORTES ==========
    public Reporte generarReporte(String tipo) {
        Reporte reporte = new Reporte(tipo);
        
        switch (tipo.toUpperCase()) {
            case "VENTAS":
                reporte.generarReporteVentas(new java.util.Date(), new java.util.Date());
                break;
            case "INVENTARIO":
                reporte.generarReporteInventario();
                break;
            case "VENDEDORES":
                reporte.generarReporteVendedores();
                break;
            case "CLIENTES":
                reporte.generarReporteClientes();
                break;
            default:
                System.out.println("Tipo de reporte desconocido");
        }
        
        return reporte;
    }
    
    // ========== GESTIÓN DE VENTAS ==========
    public void registrarVenta(Venta venta) {
        if (venta != null) {
            ventas.add(venta);
            System.out.println("Venta registrada: " + venta.getCodigo());
        }
    }
    
    public void registrarCotizacion(Cotizacion cotizacion) {
        if (cotizacion != null) {
            cotizaciones.add(cotizacion);
            System.out.println("Cotización registrada: " + cotizacion.getCodigo());
        }
    }
    
    // ========== PERSISTENCIA DE DATOS ==========
    public void guardarDatos() {
        System.out.println("Guardando datos del sistema...");
        System.out.println("Vehículos: " + vehiculos.size());
        System.out.println("Empleados: " + empleados.size());
        System.out.println("Clientes: " + clientes.size());
        System.out.println("Ventas: " + ventas.size());
        System.out.println("(Implementación de persistencia pendiente)");
    }
    
    public void cargarDatos() {
        System.out.println("Cargando datos del sistema...");
        System.out.println("(Implementación de persistencia pendiente)");
    }
    
    // ========== MÉTODOS AUXILIARES ==========
    public void listarVehiculos() {
        System.out.println("\n=== LISTADO DE VEHÍCULOS ===");
        for (Vehiculo veh : vehiculos) {
            System.out.println(veh);
        }
    }
    
    public void listarClientes() {
        System.out.println("\n=== LISTADO DE CLIENTES ===");
        for (Cliente cli : clientes) {
            System.out.println(cli);
        }
    }
    
    public void listarEmpleados() {
        System.out.println("\n=== LISTADO DE EMPLEADOS ===");
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }
    
    public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }
    public ArrayList<Cliente> getClientes() { return clientes; }
    public ArrayList<Empleado> getEmpleados() { return empleados; }
    // Getter para promociones — permite obtener las promociones registradas
    public ArrayList<Promocion> getPromociones() { return promociones; }
    public ArrayList<Venta> getVentas() { return ventas; }
    public ArrayList<Cotizacion> getCotizaciones() { return cotizaciones; }
}