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

    @Override
    public Connection getConection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,passwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}
