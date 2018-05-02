package com.penn.tang;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLHelper {
    DataSourceConecter dataSourceConecter = new MysqlConecter();

    private static  SQLHelper instance;

    private SQLHelper(){}

    public synchronized static SQLHelper getInstance() {
        if (instance==null) {
            return instance=new SQLHelper();
        }
        return instance;
    }

    public void exeSql(String sql) throws SQLException {
        dataSourceConecter.exeUpdateSql(sql);
        ResultSet resultSet = dataSourceConecter.exeQuerySql("select * from categorie");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
    }

    public Connection getCurrentConnection(){
        return dataSourceConecter.getConection();
    }


}
