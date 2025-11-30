/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.interfaces;

/**
 * Interfaz IInventariable
 * Define el contrato para objetos que manejan inventario
 * Implementada por Vehiculo e ItemInventario
 */
public interface IInventariable {
    
    /**
     * Actualiza el stock del item
     * @param cantidad Cantidad a agregar (positivo) o quitar (negativo)
     * @return true si la operación fue exitosa, false en caso contrario
     */
    boolean actualizarStock(int cantidad);
    
    /**
     * Obtiene la cantidad actual en stock
     * @return Cantidad disponible en inventario
     */
    int obtenerStock();
    
    /**
     * Verifica si hay suficiente stock disponible
     * @param cantidad Cantidad solicitada
     * @return true si hay stock suficiente, false en caso contrario
     */
    boolean verificarDisponibilidad(int cantidad);
}