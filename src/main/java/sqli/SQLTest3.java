package sqli;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

public class SQLTest3 {

    public void sqlTest3(HttpServletRequest request) {
        String ip = request.getParameter("ip");
        try {
            String sql = "INSERT INTO banned_ip(id, ip) VALUE('" + UUID.randomUUID().toString() + "','" + ip + "')";
            getJDBCConnection().createStatement().execute(sql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        System.out.print("sdfdsf");
    }

    Connection getJDBCConnection() {
        return null;
    }
}