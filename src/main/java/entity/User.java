package entity;

public class User {
    
    private String cedula;
    private String nombre;

    public User(){}

    public User(String cedula){
        this.cedula = cedula;
    }

    public User(String cedula, String nombre){
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
