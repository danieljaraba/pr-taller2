package provider;

import db.DbConn;
import entity.User;

import java.sql.SQLException;

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
}
