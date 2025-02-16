package com.mycompany.projekbasdat;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author User
 */
public class SearchCar extends javax.swing.JDialog {
        private DataBaseConnection connection;
        /**
         * Creates new form SearchCar
         */
        Connection con;
        PreparedStatement pst;
        DataBaseConnection DB;

        public SearchCar(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
                connection = new DataBaseConnection();
                DB = new DataBaseConnection();
                // loadEngineData();
        }

        // private void loadEngineData() {
        // // Mendapatkan data dari connection dan menampilkan ke tabel
        // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // model.setRowCount(0); // Reset data di tabel
        //
        // for (String engine : connection.getEngines()) {
        // model.addRow(new Object[]{engine});
        // }
        // }
        //
        // @Override
        // public void dispose() {
        // connection.closeConnection();
        // super.dispose();
        // }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jScrollBar1 = new javax.swing.JScrollBar();
                label1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                txtPname = new javax.swing.JTextField();
                jLabel4 = new javax.swing.JLabel();
                txtPprice = new javax.swing.JTextField();
                txtYear = new javax.swing.JTextField();
                txtPid = new javax.swing.JComboBox<>();
                jLabel5 = new javax.swing.JLabel();
                btnSearch = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jLabel3 = new javax.swing.JLabel();
                btPrint = new javax.swing.JButton();
                btnDelete = new javax.swing.JButton();
                btBack = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                label1.setText("Product Name :");

                jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                jLabel2.setText("Product Year :");

                jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                jLabel4.setText("Product Price :");

                txtYear.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtYearActionPerformed(evt);
                        }
                });

                txtPid.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                txtPid.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtPidActionPerformed(evt);
                        }
                });

                jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
                jLabel5.setText("Product id :");

                btnSearch.setText("Search");
                btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSearchActionPerformed(evt);
                        }
                });

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null, null, null, null, null, null, null, null,
                                                                null, null },
                                                { null, null, null, null, null, null, null, null, null, null, null,
                                                                null, null },
                                                { null, null, null, null, null, null, null, null, null, null, null,
                                                                null, null },
                                                { null, null, null, null, null, null, null, null, null, null, null,
                                                                null, null }
                                },
                                new String[] {
                                                "Nama Produk", "Lokasi Dealer", "Tahun", "Kilometer", "Jenis Bensin",
                                                "Transmisi", "Owner Type",
                                                "Mileage", "Jenis Mesin", "Power", "Bangku", "Harga Jual", "Harga Asli"
                                }));
                jScrollPane1.setViewportView(jTable1);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                1197,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                jLabel3.setText("Cari Mobil Web");

                btPrint.setText("print");
                btPrint.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btPrintActionPerformed(evt);
                        }
                });

                btnDelete.setBackground(new java.awt.Color(255, 0, 51));
                btnDelete.setForeground(new java.awt.Color(255, 255, 255));
                btnDelete.setText("Delete");
                btnDelete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDeleteActionPerformed(evt);
                        }
                });

                btBack.setText("Back");
                btBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btBackActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(526, 526, 526)
                                                                                                .addComponent(jLabel3))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(29, 29, 29)
                                                                                                .addGroup(layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGap(6, 6, 6)
                                                                                                                                .addComponent(btBack)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(btPrint,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                93,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(9, 9, 9))
                                                                                                                .addComponent(jPanel2,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jLabel2)
                                                                                                                                                .addComponent(jLabel4,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                97,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(label1))
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(txtPprice)
                                                                                                                                                .addComponent(txtYear)
                                                                                                                                                .addComponent(txtPname))
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jLabel5,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                69,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                                .addGroup(layout.createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                                .addComponent(txtPid,
                                                                                                                                                                0,
                                                                                                                                                                194,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(btnSearch,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(btnDelete,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                .addGap(14, 14, 14)))))
                                                                .addContainerGap(22, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(label1)
                                                                                .addComponent(txtPname,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtPid,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel5))
                                                                .addGap(19, 19, 19)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel4)
                                                                                .addComponent(txtPprice,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnSearch))
                                                                .addGap(21, 21, 21)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(txtYear,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(btnDelete))
                                                                .addGap(26, 26, 26)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btPrint)
                                                                                .addComponent(btBack))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtYearActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_txtYearActionPerformed

        private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
                // TODO add your handling code here:

        }// GEN-LAST:event_btnDeleteActionPerformed

        private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchActionPerformed
                // TODO add your handling code here:
                jTable1ComponentAdded(null);
        }// GEN-LAST:event_btnSearchActionPerformed

        private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {
                // TODO add your handling code here:
                DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                tableModel.setRowCount(0);
                String Pname = txtPname.getText().trim();
                String Pprice = txtPprice.getText().trim();
                String Pyear = txtYear.getText().trim();

                // Gunakan wildcard "%" jika input kosong
                String nameFilter = Pname.isEmpty() ? "%" : "%" + Pname + "%";
                String priceFilter = Pprice.isEmpty() ? "%" : Pprice;
                String yearFilter = Pyear.isEmpty() ? "%" : Pyear;
                tableModel = DB.search(tableModel, nameFilter, priceFilter, yearFilter);
        }

        private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btPrintActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_btPrintActionPerformed

        private void txtPidActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtPidActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_txtPidActionPerformed

        private void btBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btBackActionPerformed
                // TODO add your handling code here:
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                if (parentFrame instanceof MainFrame) {
                        parentFrame.dispose();
                } else {
                        System.out.println("Not working");
                }
                MainFrame mainFrame = new MainFrame();
                mainFrame.switchPanel(new MainMenu());
        }// GEN-LAST:event_btBackActionPerformed

        /**
         * @param args the command line arguments
         */

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btBack;
        private javax.swing.JButton btPrint;
        private javax.swing.JButton btnDelete;
        private javax.swing.JButton btnSearch;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollBar jScrollBar1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JLabel label1;
        private javax.swing.JComboBox<String> txtPid;
        private javax.swing.JTextField txtPname;
        private javax.swing.JTextField txtPprice;
        private javax.swing.JTextField txtYear;
        // End of variables declaration//GEN-END:variables
}
