package com.mycompany.projekbasdat;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MainFrame extends JFrame {
    private JPanel currentPanel;

    public MainFrame() {
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Car Check System");

        // Default panel
        currentPanel = new LandingPage();
        setContentPane(currentPanel);
        setVisible(true);

    }

    public void switchPanel(JPanel newPanel) {
        // Remove the current panel and add the new one
        getContentPane().removeAll(); // Hapus semua komponen di container
        currentPanel = newPanel; // Simpan panel baru
        setContentPane(currentPanel); // Tambahkan panel baru ke container
        revalidate(); // Validasi ulang layout
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(); // Launch the main frame
            }
        });
    }
}
