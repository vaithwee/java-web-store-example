package xyz.vaith.store.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class JdbcUitl {
    private static BasicDataSource dataSource;
    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/store");
        dataSource.setUsername("root");
        dataSource.setPassword("abcd1234");
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
