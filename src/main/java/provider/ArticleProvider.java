package provider;

import db.DbConn;
import entity.Article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleProvider {

    public void createArticle(Article article) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();
        String sql = "INSERT INTO articlesA00368822(cantidad,id_orden,id_producto)"
                + "VALUES ($CANTIDAD,$ID_ORDEN,$ID_PRODUCTO)";
        sql = sql.replace("$CANTIDAD",""+article.getCantidad());
        sql = sql.replace("$ID_ORDEN",""+article.getId_orden());
        sql = sql.replace("$ID_PRODUCTO",""+article.getId_producto());
        conn.runQuery(sql);
        conn.close();
    }

    public void deleteProduct(int order, int product, int amount) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();

        String sql = "SELECT * FROM articlesA00368822"
                +" WHERE id_orden = $ORDER AND id_producto = $PRODUCT";

        sql = sql.replace("$ORDER",""+order);
        sql = sql.replace("$PRODUCT",""+product);

        ResultSet result = conn.getData(sql);

        result.next();
        int m_order = result.getInt("id_orden");
        int m_product = result.getInt("id_producto");
        int m_amount = result.getInt("cantidad");

        m_amount -= amount;

        if(m_amount > 0){
            sql = "UPDATE articlesA00368822 SET cantidad = $CANTIDAD"
                    + " WHERE id_orden = $ID_ORDEN AND id_producto = $ID_PRODUCTO";
            sql = sql.replace("$CANTIDAD",""+m_amount);
            sql = sql.replace("$ID_ORDEN",""+m_order);
            sql = sql.replace("$ID_PRODUCTO",""+m_product);
        }else{
            sql = "DELETE FROM articlesA00368822"
                    + " WHERE id_orden = $ID_ORDEN AND id_producto = $ID_PRODUCTO";
            sql = sql.replace("$ID_ORDEN",""+m_order);
            sql = sql.replace("$ID_PRODUCTO",""+m_product);
        }

        conn.runQuery(sql);

        conn.close();
    }

}
