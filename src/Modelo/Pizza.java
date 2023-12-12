package Modelo;

import java.util.Objects;

public class Pizza {
    //id, nombre, coste, precio, ingredientes
    private int id;
    private String nombre;
    private double coste;
    private double precio;
    private String ingredientes;

    public Pizza(){}

    public Pizza(String nombre, double coste, double precio, String ingredientes) {
        this.nombre = nombre;
        this.coste = coste;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public Pizza(int id, String nombre, double coste, double precio, String ingredientes) {
        this(nombre, coste, precio, ingredientes);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", coste=" + coste +
                ", precio=" + precio +
                ", ingredientes='" + ingredientes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id && Double.compare(coste, pizza.coste) == 0 && Double.compare(precio, pizza.precio) == 0 && Objects.equals(nombre, pizza.nombre) && Objects.equals(ingredientes, pizza.ingredientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, coste, precio, ingredientes);
    }


}
