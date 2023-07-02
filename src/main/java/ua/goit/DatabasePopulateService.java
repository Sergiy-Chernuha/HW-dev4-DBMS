package ua.goit;

import ua.goit.configs.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        String sql = DBUtils.getSQL("src/main/java/resource/SQL/populate_db.sql");

        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("not correct query");
        }

        conn.close();
    }
}
