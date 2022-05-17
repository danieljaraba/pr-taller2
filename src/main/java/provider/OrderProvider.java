package provider;

import db.DbConn;
import entity.Article;
import entity.Order;
import entity.Product;
import entity.Report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public void changeStatus(int order) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        long time = System.currentTimeMillis();
        String sql = "UPDATE ordersA00368822 SET pagado = $PAGADO, fecha_pago = $FECHA_PAGO"
                +" WHERE id = $ID";
        sql = sql.replace("$ID",""+order);
        sql = sql.replace("$PAGADO",""+true);
        sql = sql.replace("$FECHA_PAGO",""+time);

        conn.runQuery(sql);
        conn.close();
    }

    public Report getInfo(int order) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        String sql = "SELECT * FROM articlesA00368822"
                +" WHERE id_orden = $ORDER";
        sql = sql.replace("$ORDER",""+order);

        ResultSet articles_result = conn.getData(sql);
        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        while(articles_result.next()){
            int cantidad = articles_result.getInt("cantidad");
            int id_orden = articles_result.getInt("id_orden");
            int id_producto = articles_result.getInt("id_producto");
            articles.add(new Article(cantidad,id_orden,id_producto));
        }

        for(int i = 0; i<articles.size(); i++){
            sql = "SELECT * FROM productsA00368822"
                    +" WHERE id = $ID";
            sql = sql.replace("$ID",""+articles.get(i).getId_producto());
            ResultSet product = conn.getData(sql);
            product.next();
            int id = product.getInt("id");
            String nombre = product.getString("nombre");
            String tamano = product.getString("tamano");
            int precio = product.getInt("precio");
            products.add(new Product(id,nombre,tamano,precio));
        }

        conn.close();

        return new Report(products,articles);
    }
}
