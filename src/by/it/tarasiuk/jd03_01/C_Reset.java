package by.it.tarasiuk.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class C_Reset {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    static void db_reset() {
        try (Connection connection =
                     DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `tarasiuk`;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
