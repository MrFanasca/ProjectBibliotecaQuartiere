package org.generation.italy.bibliotecaQuartiere.servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;

@Component
public class JdbcConnection {
	
	private Connection dbConnection;
	
	private static JdbcConnection jdbcConnectionSingletonInstance = null;
	
	private JdbcConnection() {}
	
	public Connection getDbConnection() {
		return dbConnection;
	}

	public 
    static 
    JdbcConnection readJdbcConnectionInstance(String _driverName
    										, String _driverClassPath
    										, String _serverName
    										, String _serverPort 
    										, String _databaseName
			                                , String _username
			                                , String _password) 
    											throws ServletException {

        if (jdbcConnectionSingletonInstance==null) {

        	jdbcConnectionSingletonInstance = new JdbcConnection();				
            
            String jdbcUrl = 													
        		String.format("jdbc:%s://%s:%s/%s"
        					, _driverName
        					, _serverName
        					, _serverPort
        					, _databaseName);

            try {
                Class.forName(_driverClassPath);								
                jdbcConnectionSingletonInstance.dbConnection
                        = DriverManager.getConnection(jdbcUrl,
                                                    _username,
                                                    _password);

            } catch (SQLException sqlException) {										
                throw new ServletException("JdbcConnection -> readJdbcConnectionInstance -> " + sqlException.getMessage());
            } catch (ClassNotFoundException classExcpetion) {					
                throw new ServletException("JdbcConnection -> readJdbcConnectionInstance -> " + classExcpetion.getMessage());
            }
        }
        
        return jdbcConnectionSingletonInstance;
    }

	public static void main(String[] args) {

    	try {
			JdbcConnection jdbcConnection1 = JdbcConnection.readJdbcConnectionInstance("mariadb", "org.mariadb.jdbc.Driver", "localhost", "3306", "biblioteca_quartiere", "root", "");
			System.out.println(jdbcConnection1);
    	} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
