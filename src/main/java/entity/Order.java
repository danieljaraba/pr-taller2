package entity;

public class Order {

    private int id;
    private long fecha_creacion;
    private boolean pago;
    private long fecha_pago;
    private String cedula_usuario;

    public Order(){}

    public Order(int id, int fecha_creacion, boolean pago, String cedula_usuario){
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.pago = pago;
        this.cedula_usuario =  cedula_usuario;
    }

    public Order(int id, int fecha_creacion, boolean pago, int fecha_pago, String cedula_usuario){
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.pago = pago;
        this.fecha_pago = fecha_pago;
        this.cedula_usuario =  cedula_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(long fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public long getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(long fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(String cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }
}
