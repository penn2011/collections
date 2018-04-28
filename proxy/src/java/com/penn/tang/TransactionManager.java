package com.penn.tang;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 模拟事务管理器
 */
public class TransactionManager   implements DataSourceConecter{
    DataSourceConecter dataSourceConecter;

    public TransactionManager(DataSourceConecter dataSourceConecter) {
        this.dataSourceConecter = dataSourceConecter;
    }

    @Override
    public Connection getConection() {
        return dataSourceConecter.getConection();
    }


    @Override
    public Integer exeUpdateSql(String sql) {
        //禁用执行提交
        Connection conection = getConection();
        try {
            conection.setAutoCommit(false);
            Statement statement = conection.createStatement();
             statement.executeUpdate(sql);
             //提交事务
            conection.commit();

        } catch (SQLException e) {
            try {
                //回滚事务
                conection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}
