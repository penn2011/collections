package com.penn.tang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 模拟事务管理器
 */
public class TransactionManager implements InvocationHandler {

    Object service;


    public void setDataSourceConecter(Object dataSourceConecter) {
        this.service = dataSourceConecter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

        //有事务标注注解

        if (method.isAnnotationPresent(Transaction.class)) {
            //执行sql方法应该控制在一个事务里面
            Connection connection = SQLHelper.getInstance().getCurrentConnection();
            try {
                connection.setAutoCommit(false);
                Object invoke = method.invoke(service, args);
                connection.commit();
                return invoke;
            } catch (Exception e) {
                try {
                    //出现异常回滚事务
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                return null;
            }

        }
        //其他方法放行
        return method.invoke(service, args);
    }
}
