package com.penn.tang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接器
 */
public interface DataSourceConecter {

    /**
     * 获取一个连接
     */
    Connection getConection();


    /**
     * 执行一个sql
     */
    default ResultSet exeQuerySql(String sql) {
        try {
            return getConection().createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 执行一个sql
     */
    default Integer exeUpdateSql(String sql) {
        try {
            return getConection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
