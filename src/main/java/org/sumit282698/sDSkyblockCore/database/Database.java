package org.sumit282698.sDSkyblockCore.database;

import org.sumit282698.sDSkyblockCore.SDSkyblockCore;
import org.sumit282698.sDSkyblockCore.api.PlayerSkills;

import java.io.File;
import java.sql.*;
import java.util.UUID;

public class Database {
    private Connection connection;

    public void connect() throws SQLException {
        // 1. Get the plugin data folder
        File folder = SDSkyblockCore.getInstance().getDataFolder();

        // 2. CREATE the folder if it's missing
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // 3. Create the file object
        File databaseFile = new File(folder, "data.db");

        // 4. Connect using a clean absolute path
        String url = "jdbc:sqlite:" + databaseFile.getAbsolutePath();
        connection = DriverManager.getConnection(url);

        // 5. Create the table
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS player_stats (" +
                    "uuid TEXT PRIMARY KEY," +
                    "strength REAL DEFAULT 0," +
                    "defense REAL DEFAULT 0," +
                    "max_health REAL DEFAULT 100," +
                    "max_mana REAL DEFAULT 100," +
                    "crit_chance REAL DEFAULT 1," +
                    "crit_damage REAL DEFAULT 1" +
                    ");");
        }
    }

    public void saveSPlayer(PlayerSkills PlayerSkills) {
        String sql = "REPLACE INTO player_stats(uuid, strength, defense, max_health, max_mana, crit_chance, crit_damage) VALUES(?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, PlayerSkills.getUuid().toString());
            pstmt.setDouble(2, PlayerSkills.getStrength());
            pstmt.setDouble(3, PlayerSkills.getDefense());
            pstmt.setDouble(4, PlayerSkills.getMaxHealth());
            pstmt.setDouble(5, PlayerSkills.getMaxMana());
            pstmt.setDouble(6, PlayerSkills.getCritChance());
            pstmt.setDouble(7, PlayerSkills.getCritDamage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadSPlayer(PlayerSkills sPlayer) {
        String sql = "SELECT * FROM player_stats WHERE uuid = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sPlayer.getUuid().toString());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                sPlayer.setStrength(rs.getDouble("strength"));
                sPlayer.setDefense(rs.getDouble("defense"));
                sPlayer.setMaxHealth(rs.getDouble("max_health"));
                sPlayer.setMaxMana(rs.getDouble("max_mana"));
                sPlayer.setCritChance(rs.getDouble("crit_chance"));
                sPlayer.setCritDamage(rs.getDouble("crit_damage"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}