package com.example.reparatec2.models;

public class Refaccion {
    private int id;
    private String nombre;
    private String categoria;
    private double precioUnitario;
    private int stockDisponible;
    private String proveedor;

    public Refaccion(int id, String nombre, String categoria, double precioUnitario, int stockDisponible, String proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
        this.proveedor = proveedor;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecioUnitario() { return precioUnitario; }
    public int getStockDisponible() { return stockDisponible; }
    public String getProveedor() { return proveedor; }

    // Setters (para actualizar el stock u otros campos)
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
    public void setStockDisponible(int stockDisponible) { this.stockDisponible = stockDisponible; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }
}
