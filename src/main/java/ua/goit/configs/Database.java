package ua.goit.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ua.goit.configs.ConnectionConfig.*;

import org.flywaydb.core.Flyway;

public class Database {
    private static final Database instance = new Database();
    private Connection connection;
    Flyway flyway;

    private Database() {
    }

    public static Database getInstance() {
        return instance;
    }

    public void setConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            flyway = Flyway.configure()
                    .locations("filesystem:src/main/java/resources/db/migration")
                    .dataSource(URL_DB, USER, PASSWORD)
                    .load();
            flyway.migrate();

            Thread.sleep(1000);

            connection = DriverManager.getConnection(URL_DB, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            setConnection();
        }

        return connection;
    }
}
