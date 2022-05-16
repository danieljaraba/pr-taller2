package entity;

public class Article {

    private int cantidad;
    private int id_orden;
    private int id_producto;

    public Article(){}

    public Article(int cantidad, int id_orden, int id_producto){
        this.cantidad = cantidad;
        this.id_orden = id_orden;
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
}
