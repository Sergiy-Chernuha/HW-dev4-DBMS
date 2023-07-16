package ua.goit.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ua.goit.configs.ConnectionConfig.*;

public class Database {
    private static final Database instance = new Database();
    private Connection connection;

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    public void setConnection() {
              try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        if(connection==null) {
            setConnection();
        }

        return connection;
    }
}
