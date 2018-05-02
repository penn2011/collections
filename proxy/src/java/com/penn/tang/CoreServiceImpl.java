package com.penn.tang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class CoreServiceImpl implements  CoreService{

    SQLHelper sqlHelper = SQLHelper.getInstance();


    @Override
    public void insertCategorie() throws SQLException {
        sqlHelper.exeSql("insert into categorie(pid,cid) values(" + new Random().nextInt(1000) + ",98)");
        int i=5/0;
    }


}
