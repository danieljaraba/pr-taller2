package provider;

import db.DbConn;
import entity.Product;

import java.sql.SQLException;

public class ProductProvider {

    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        String sql = "INSERT INTO productsA00368822(id,nombre,tamano,precio)"
                + "VALUES ($ID,'$NOMBRE','$TAMANO',$PRECIO)";
        sql = sql.replace("$ID",""+product.getId());
        sql = sql.replace("$NOMBRE", product.getNombre());
        sql = sql.replace("$TAMANO", product.getTamano());
        sql = sql.replace("$PRECIO",""+product.getPrecio());
        conn.runQuery(sql);
        conn.close();
    }
}
