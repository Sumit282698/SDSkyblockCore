package org.sumit282698.sDSkyblockCore.managers;

import org.sumit282698.sDSkyblockCore.SDSkyblockCore;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private Connection connection;

    public void connect() throws SQLException {
        // database creation
        File file = new File(SDSkyblockCore.getInstance().getDataFolder(), "data.db");
        String url = "jdbc:sqlite:" + file.getAbsolutePath();
        connection = DriverManager.getConnection(url);

        // Create the table if it doesn't exist
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS player_stats (" +
                "uuid TEXT PRIMARY KEY," +
                "strength REAL," +
                "defense REAL," +
                "max_health REAL," +
                "mana REAL" +
                ");");
    }

    public Connection getConnection() {
        return connection;
    }
}
