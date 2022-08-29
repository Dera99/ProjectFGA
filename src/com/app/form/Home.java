
package com.app.form;

import com.app.cell.CellAction;
import com.app.cell.CellBerat;
import com.app.cell.CellJenis;
import com.app.cell.CellKadar;
import com.app.cell.CellKodeBarang;
import com.app.cell.CellModel;
import com.app.cell.CellNamaBarang;
import com.app.component.Form;
import com.app.config.SystemProperties;
import com.app.config.connection;
import com.app.main.Insert;
import com.app.model.ModelData;
import com.app.services.ServiceData;
import com.app.swing.Button;
import com.app.swing.TextField;
import com.app.swing.table.Table;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Home extends Form {
    ResultSet rs = null;
    Connection CC = null;
    PreparedStatement pst = null;
    Statement stt;
    String sql;
    public Home() {
        initComponents();
        CC = new connection().connect();
        table1.addTableStyle(jScrollPane2);
        init();
        showTable();
   
    }
    private void init(){
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
         for(Component com : panelShadow2.getComponents()){  
            if(com instanceof TextField){
                 TextField txt = (TextField) com;
                 txt.setBackground(new Color(0,0,0,0));
            }
             if(com instanceof Button){
               Button btn = (Button) com;
               btn.setBackground(pro.getColor()); 
            }
   
         }
    }
    private void showTable(){
        table1.addTableCell(new CellKodeBarang(), 0);
        table1.addTableCell(new CellNamaBarang(), 1);
        table1.addTableCell(new CellModel(), 2);
        table1.addTableCell(new CellJenis(), 3);
        table1.addTableCell(new CellKadar(), 4);
        table1.addTableCell(new CellBerat(), 5);
        table1.addTableCell(new CellAction(), 6);
     
          new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (ModelData data : new ServiceData().getDataBarang()) {
                        table1.addRow(data, false);
                    }
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelShadow2 = new com.app.swing.PanelShadow();
        cmdSearch = new com.app.swing.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new com.app.swing.table.Table();
        button1 = new com.app.swing.Button();
        button2 = new com.app.swing.Button();
        lbBack1 = new javax.swing.JLabel();

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        panelShadow2.setBackground(new java.awt.Color(40, 40, 40));

        cmdSearch.setForeground(new java.awt.Color(230, 230, 230));
        cmdSearch.setLabelText("Search");
        cmdSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmdSearchKeyReleased(evt);
            }
        });

        table1.setBackground(new java.awt.Color(60, 60, 60));
        table1.setForeground(new java.awt.Color(230, 230, 230));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Model", "Jenis", "Kadar", "Berat", "Action"
            }
        ));
        table1.setAutoscrolls(false);
        table1.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 100));
        table1.setSelectionBackground(new java.awt.Color(50, 50, 50));
        table1.setSelectionForeground(new java.awt.Color(230, 230, 230));
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setResizable(false);
            table1.getColumnModel().getColumn(1).setResizable(false);
            table1.getColumnModel().getColumn(2).setResizable(false);
            table1.getColumnModel().getColumn(3).setResizable(false);
            table1.getColumnModel().getColumn(4).setResizable(false);
            table1.getColumnModel().getColumn(5).setResizable(false);
            table1.getColumnModel().getColumn(6).setResizable(false);
        }

        button1.setForeground(new java.awt.Color(230, 230, 230));
        button1.setText("+ Add New");
        button1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setForeground(new java.awt.Color(230, 230, 230));
        button2.setText("Search");
        button2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        lbBack1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbBack1.setForeground(new java.awt.Color(230, 230, 230));
        lbBack1.setText("Data Barang");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBack1)
                            .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbBack1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        Insert in = new Insert();
        in.setVisible(true);
        
    }//GEN-LAST:event_button1ActionPerformed

    private void cmdSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdSearchKeyReleased
        // TODO add your handling code here:
   
    }//GEN-LAST:event_cmdSearchKeyReleased

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button button1;
    private com.app.swing.Button button2;
    private com.app.swing.TextField cmdSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBack1;
    private com.app.swing.PanelShadow panelShadow2;
    private com.app.swing.table.Table table1;
    // End of variables declaration//GEN-END:variables
}
