package com.penn.tang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 模拟mysql连接器
 */
public class MysqlConecter implements DataSourceConecter{

    private String driver = "com.mysql.jdbc.Driver";

    private String url = "jdbc:mysql://localhost:3306/core";

    private String user = "root";

    private String passwd = "root";

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    @Override
    public Connection getConection() {
        if (connectionThreadLocal.get()!=null) {
            return connectionThreadLocal.get();
        }
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, passwd);
            //存储当前线程的connection
            connectionThreadLocal.set(connection);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
