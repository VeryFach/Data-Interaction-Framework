package com.mycompany.projekbasdat;

import java.sql.*;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class DataBaseConnection {
    public static Connection gConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:sqlserver://LAPTOP-5NCSN9R1\\SQLEXPRESS01;databaseName=University;integratedSecurity=true;encrypt=false");
    }

    private static Connection connect() {
        try {
            Connection con = gConnection();
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected static DefaultListModel getName(DefaultListModel listModel) {
        try (Connection con = connect(); Statement stmt = con.createStatement()) {
            ResultSet result = stmt.executeQuery("select Name from Car");
            while (result.next()) {
                listModel.addElement(result.getString("Name"));
            }
            return listModel;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    protected static DefaultListModel getLoc(DefaultListModel listModel) {
        try (Connection con = connect(); Statement stmt = con.createStatement()) {
            ResultSet result = stmt.executeQuery("select Name, Loc from Loc join Car on Loc.Loc_id = Car.ID");
            while (result.next()) {
                String s = result.getString("Name") + " - " + result.getString("Loc");
                listModel.addElement(s);
            }
            return listModel;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    protected static DefaultListModel getEngine(DefaultListModel listModel) {
        try (Connection con = connect(); Statement stmt = con.createStatement()) {
            ResultSet result = stmt
                    .executeQuery("select Name, Engine from Car join Engine on Car.ID = Engine.Engine_id");
            while (result.next()) {
                String s = result.getString("Name") + " - " + result.getString("Engine");
                listModel.addElement(s);
            }
            return listModel;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    protected static DefaultTableModel search(DefaultTableModel listModel, String name, String price, String year) {
        try (Connection con = connect(); Statement stmt = con.createStatement()) {
            // Siapkan query SQL dengan parameter
            String query = "SELECT * FROM Car join Loc on Car.ID = Loc.Loc_id join Engine on Car.ID = Engine.Engine_id WHERE name LIKE ? AND price LIKE ? AND year LIKE ?";
            PreparedStatement pst = con.prepareStatement(query);

            // Set parameter untuk query
            pst.setString(1, name); // Untuk filter nama
            pst.setString(2, price); // Untuk filter harga
            pst.setString(3, year); // Untuk filter tahun
            ResultSet result = pst
                    .executeQuery();
            while (result.next()) {
                String s = result.getString("Name") + " - " + result.getString("Engine");
                listModel.addRow(
                        new Object[] { result.getString("Name"), result.getString("Loc"), result.getString("Year"),
                                result.getString("Kilometer"), result.getString("Fuel"),
                                result.getString("Transmission"), result.getString("Owner"),
                                result.getString("Mileage"), result.getString("Engine"), result.getString("Power"),
                                result.getString("Seats"), result.getString("Price") });
            }
            return listModel;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    protected static UserType validate(String username, String password) {
        try (Connection con = connect(); Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM account WHERE username = ? AND pass = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet result = pst.executeQuery();

            if (result.next()) {
                String userType = result.getString("user_type");

                if ("admin".equalsIgnoreCase(userType)) {
                    return UserType.ADMIN; // Admin user
                } else {
                    return UserType.USER; // Regular user
                }
            } else {
                return UserType.INVALID; // Invalid credentials
            }
        } catch (Exception e) {
            e.printStackTrace();
            return UserType.INVALID; // Error or invalid user
        }
    }

    protected static void insert() {

    }
}
