package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {
    private static Connection koneksi;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/inventory_db";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(
            new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal");
            System.out.println(e);
        }
        return koneksi;
    }
}
