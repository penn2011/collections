package com.penn.tang;

import java.lang.reflect.Proxy;
import java.sql.SQLException;

public class MainTest {


    public static void main(String[] args) throws SQLException {
        TransactionManager tr = new TransactionManager();
        tr.setDataSourceConecter(new CoreServiceImpl());

        CoreService coreServiceProxy= (CoreService) Proxy.newProxyInstance(CoreService.class.getClassLoader(), CoreServiceImpl.class.getInterfaces(), tr);
        coreServiceProxy.insertCategorie();

    }


}
