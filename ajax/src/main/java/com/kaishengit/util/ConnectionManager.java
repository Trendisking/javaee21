package com.kaishengit.util;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by 20330 on 2016/6/12.
 */
public class ConnectionManager {

    private static BasicDataSource dataSource=new BasicDataSource();
    static{



        dataSource.setDriverClassName(Config.get("jdbc.driver"));
        dataSource.setUrl(Config.get("jdbc.url"));
        dataSource.setUsername(Config.get("jdbc.username"));
        dataSource.setPassword(Config.get("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(Config.get("jdbc.initialSize","5")));
        dataSource.setMaxTotal(Integer.parseInt(Config.get("jdbc.maxSize","20")));
        dataSource.setMaxWaitMillis(Integer.parseInt(Config.get("jdbc.maxWait","5000")));
        dataSource.setMaxIdle(Integer.parseInt(Config.get("jdbc.maxIdle","10")));
        dataSource.setMinIdle(Integer.parseInt(Config.get("jdbc.minIdle","5")));
    }

    public static BasicDataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection() throws DataAccessException{
        try {

            Connection connection = dataSource.getConnection();
            return connection;

        }catch (SQLException e){
            throw new DataAccessException("获取 数据库连接时异常",e);
        }


    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("数据库链接关闭异常",e);
        }
    }
}
