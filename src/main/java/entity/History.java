package entity;

import java.util.ArrayList;

public class History {

    private String cedula_user;
    private ArrayList<Order> orders;

    public History(String cedula_user, ArrayList<Order> orders){
        this.cedula_user = cedula_user;
        this.orders = orders;
    }

    public String getCedula_user() {
        return cedula_user;
    }

    public void setCedula_user(String cedula_user) {
        this.cedula_user = cedula_user;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
