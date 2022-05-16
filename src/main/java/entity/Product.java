package entity;

public class Product {

    private int id;
    private String nombre;
    private String tamano;
    private int precio;

    public Product(){}

    public Product(int id, String nombre, String tamano, int precio){
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
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

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
