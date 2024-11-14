/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String connectionUrl = 
            "jdbc:sqlserver://LAPTOP-5NCSN9R1\\SQLEXPRESS01;" +
            "database=AdventureWorks;" +
            "user=DataBaseFachru;" +
            "password=Badjingan;" +
            "encrypt=true;" +
            "trustServerCertificate=true;" +
            "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl)) {
            if (connection != null) {
                System.out.println("Koneksi ke database berhasil!");
            } else {
                System.out.println("Koneksi ke database gagal.");
            }
        } catch (SQLException e) {
            System.out.println("Error saat mencoba menghubungkan ke database.");
            e.printStackTrace();
        }
    }
}