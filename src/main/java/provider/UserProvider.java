package provider;

import db.DbConn;
import entity.History;
import entity.Order;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserProvider {

    public void create(User user) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        String sql = "INSERT INTO usersA00368822(cedula, nombre) VALUES ('$CEDULA','$NOMBRE')";
        sql = sql.replace("$CEDULA",user.getCedula());
        sql = sql.replace("$NOMBRE",user.getNombre());
        System.out.println(sql);
        conn.runQuery(sql);
        conn.close();
    }

    public History getInfo(String user) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        String sql = "SELECT * FROM ordersA00368822"
                +" WHERE cedula_usuario = '$USER'";
        sql = sql.replace("$USER",user);

        ResultSet results = conn.getData(sql);
        ArrayList<Order> orders = new ArrayList<>();

        while(results.next()){
            int id = results.getInt("id");
            long fecha_creacion = results.getLong("fecha_creacion");
            boolean pagado = results.getBoolean("pagado");
            long fecha_pago = results.getLong("fecha_pago");
            String cedula_usuario = results.getString("cedula_usuario");
            orders.add(new Order(id,fecha_creacion,pagado,fecha_pago,cedula_usuario));
        }

        conn.close();

        return new History(user,orders);
    }
}
