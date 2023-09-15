package common;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static final BasicDataSource bds = new BasicDataSource();
    static {
        bds.setUsername("root");
        bds.setPassword("Am311865186");
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setMaxTotal(10);
        bds.setUrl("jdbc:mysql://localhost:3306/abolfazl");
    }

    public static Connection getConnection() throws Exception{
        Connection connection = bds.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
