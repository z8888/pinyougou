package com.nbsp.demo;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

public class OracleTest {

    @Test
    public void oracleConnection() throws Exception {
        // 加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.80.88:1521:orcl", "scott", "itcast");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from emp");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("job"));
        }
        connection.close();
        preparedStatement.close();
        resultSet.close();
    }

    @Test
    public void oracleFunction() throws Exception {
        // 加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.80.88:1521:orcl", "scott", "itcast");
        // call 代表返回值类型 没有只写一个call 即可
        CallableStatement callableStatement = connection.prepareCall("{? = call p2(?)}");
        callableStatement.setObject(2,7788);
        // 如果有返回值要用registerOutParemeter赋值
        callableStatement.registerOutParameter(1, OracleTypes.NUMBER);
        callableStatement.execute();
        // 获取值
        System.out.println(callableStatement.getObject(1));
    }
}
