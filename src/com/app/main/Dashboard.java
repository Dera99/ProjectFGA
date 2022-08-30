/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.main;

import com.app.config.SystemProperties;
import com.app.config.connection;
import com.app.event.EventColorChange;
import com.app.form.Home;
import com.app.form.Settings;
import com.app.menu.EventMenu;
import com.app.session.UserSession;
import com.app.swing.Notifications;
import com.app.theme.SystemTheme;
import com.app.theme.ThemeColorChange;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import notification.Notification;

public class Dashboard extends javax.swing.JFrame {
    ResultSet rs = null;
    Connection CC = new connection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    
     public Dashboard() {
        initComponents();
        setBackground(new Color (0,0,0,0));
        init();
       
    }
    private Settings settingForm;

    private void init(){
        Notifications notf = new Notifications();
        notf.setFram(this);
        System.out.println(notf.getFram());
        header1.initMoving(this);
        header1.initEvent(this, panelBackground);
        menu.addEventMenu(new EventMenu() {
            @Override
            public void selectedMenu(int index) {
                if(index==0){
                    mainBody.displayForm(new Home(),"Data Barang");
                }else if(index == 1){
                    mainBody.displayForm(settingForm,"Settings");
                }    
                else if(index == 2){
                    Login a = new Login();
                    a.setVisible(true);
                    UserSession.setUserLogin("");
                    UserSession.setUserId(0);
                    dispose();  
                }    
            }
        });
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        SystemTheme.mainColor=pro.getColor();
        settingForm=new Settings();
        settingForm.setEventColorChange(new EventColorChange() {
            @Override
            public void colorChange(Color color) {
                SystemTheme.mainColor = color;
                ThemeColorChange.getInstance().ruenEventColorChange(color);
                repaint();
                pro.save("theme_color", color.getRGB() + "");
            }
        });
        settingForm.setSelectedThemeColor(pro.getColor());
        mainBody.displayForm(new Home());
    }
    public void notification(){
        Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Login Berhasil !");
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new com.app.swing.PanelBackground();
        header1 = new com.app.component.Header();
        menu = new com.app.menu.Menu();
        mainBody = new com.app.component.MainBody();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panelBackground.setBackground(new java.awt.Color(25, 25, 25));

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, 1114, Short.MAX_VALUE))
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addComponent(mainBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.component.Header header1;
    private com.app.component.MainBody mainBody;
    private com.app.menu.Menu menu;
    private com.app.swing.PanelBackground panelBackground;
    // End of variables declaration//GEN-END:variables
}
