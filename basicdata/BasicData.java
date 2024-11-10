/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basicdata;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BasicData {
    private String connectionUrl = 
            "jdbc:sqlserver://LAPTOP-5NCSN9R1\\\\SQLEXPRESS01;" +
            "database=AdventureWorks;" +
            "user=DataBaseFachru@LAPTOP-5NCSN9R1\\SQLEXPRESS01;" +
            "password=Badjingan;" +
            "encrypt=true;" +
            "trustServerCertificate=false;" +
            "loginTimeout=30;";

    public List<String[]> getCarData() {
        List<String[]> carDataList = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            Statement statement = connection.createStatement();
            String selectSql = "SELECT Car_Brand AS Brand, Car_Model AS Model, Year_of_Manufacture AS Year, Price FROM Cars";
            resultSet = statement.executeQuery(selectSql);
            
            while (resultSet.next()) {
                String brand = resultSet.getString("Brand");
                String model = resultSet.getString("Model");
                String year = resultSet.getString("Year");
                String price = resultSet.getString("Price");
                carDataList.add(new String[] { brand, model, year, price });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carDataList;
    }
}