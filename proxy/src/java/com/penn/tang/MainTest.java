package com.penn.tang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class MainTest {


    public static void main(String[] args) throws SQLException {
        DataSourceConecter dataSourceConecter = new TransactionManager(new MysqlConecter());

        dataSourceConecter.exeUpdateSql("insert into categorie(pid,cid) values("+ new Random().nextInt(1000)+",98)");

        ResultSet resultSet = dataSourceConecter.exeQuerySql("select * from categorie");
        int b = 5 / 0;

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }



    }


}
