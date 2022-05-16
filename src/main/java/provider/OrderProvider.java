package provider;

import db.DbConn;
import entity.Order;

import java.sql.SQLException;
import java.util.Objects;

public class OrderProvider {

    public void create(Order order) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        String sql = "INSERT INTO ordersA00368822(id,fecha_creacion,pagado,fecha_pago,cedula_usuario)"
                + "VALUES ($ID,$FECHA_CREACION,$PAGADO,$FECHA_PAGO,$CEDULA_USUARIO)";
        sql = sql.replace("$ID",""+order.getId());
        sql = sql.replace("$FECHA_CREACION",""+order.getFecha_creacion());
        sql = sql.replace("$PAGADO",""+order.isPago());
        if(order.isPago()){
            sql = sql.replace("$FECHA_PAGO",""+order.getFecha_pago());
        }else{
            sql = sql.replace("$FECHA_PAGO","null");
        }
        sql = sql.replace("$CEDULA_USUARIO",order.getCedula_usuario());
        conn.runQuery(sql);
        conn.close();
    }
}
