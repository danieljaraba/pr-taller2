package provider;

import db.DbConn;
import entity.Article;

import java.sql.SQLException;

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

}
