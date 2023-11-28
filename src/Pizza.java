public class Pizza {
    private String nombre;
    private double coste;
    private double precio;
    private String ingredientes;

    // Constructor
    public Pizza(String nombre, double coste, double precio, String ingredientes) {
        this.nombre = nombre;
        this.coste = coste;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    // Getters y Setters
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
}
