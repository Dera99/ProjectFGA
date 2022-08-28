/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.main;

import com.app.config.Configuration;
import com.app.config.SystemProperties;
import com.app.config.config;
import com.app.config.connection;
import com.app.event.EventColorChange;
import com.app.form.Settings;
import com.app.session.UserSession;
import com.app.theme.SystemTheme;
import com.app.theme.ThemeColor;
import com.app.theme.ThemeColorChange;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import notification.Notification;

public class Login extends javax.swing.JFrame {

    ResultSet rs = null;
    Connection CC = null;
    PreparedStatement pst = null;
    Statement stt;
    private Settings settingForm;
    public Login() {
        initComponents();
        CC = new connection().connect();
        checkConnection();
        setBackground(new Color(0,0,0,0));
        init();
        
        //login.repaint();
    }
    private void checkConnection(){
        try{
            stt=CC.createStatement();
            rs = stt.executeQuery("SELECT * FROM accounts");
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    private void init(){
        header.initMoving(this);
        header.initEvent(this,panelBackground1);
        User.setBackground(new Color(0,0,0,0));
        Pass.setBackground(new Color(0,0,0,0));    
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        login.setBackground(pro.getColor());
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
        
    }
    private void login(){
        Notification err= new Notification(this, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Username atau Password anda salah !");
        Notification err2= new Notification(this, Notification.Type.ERROR, Notification.Location.TOP_CENTER, "Username Tidak Ada");
        Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Login Berhasil !");
        try {
            Statement stat = CC.createStatement();
            String sql = "SELECT * FROM accounts WHERE Username = '"+User.getText()+
            "' and Password = '"+Pass.getText()+"'";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next())
            {
                String user = rs.getString("Username");
                String pass = rs.getString("Password");
                int UserId = rs.getInt("RoleId");
   
                if (Pass.getText().equals(pass) && User.getText().equals(user)){
                    //JOptionPane.showMessageDialog(this, "Login Berhasil");
                    UserSession.setUserId(UserId);
                    UserSession.setUserLogin(user);
                    
                    if(UserId == 1){
                        noti.showNotification();
                        Dashboard a = new Dashboard();
                        a.setVisible(true);
                        dispose();
                    }
                    else{
                        noti.showNotification();
                        Dashboard mu=new Dashboard();
                        mu.setVisible(true);
                        dispose();
                    }
                }
                else
                //JOptionPane.showMessageDialog(null, "Username atau Password anda salah");  
                err.showNotification();
            }
            else
            //JOptionPane.showMessageDialog(this, "Username Tidak Ada");
            err2.showNotification();
        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, "Ada Kesalahan");
            e.printStackTrace();
        }        
        User.setText("");
        Pass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new com.app.swing.PanelBackground();
        header = new com.app.component.Header();
        lbLogin = new javax.swing.JLabel();
        login = new com.app.swing.Button();
        Pass = new com.app.swing.PasswordField();
        User = new com.app.swing.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBackground1.setBackground(new java.awt.Color(25, 25, 25));

        lbLogin.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        lbLogin.setForeground(new java.awt.Color(230, 230, 230));
        lbLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogin.setText("Login");

        login.setForeground(new java.awt.Color(230, 230, 230));
        login.setText("Sign In");
        login.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        Pass.setBackground(new java.awt.Color(34, 34, 34));
        Pass.setForeground(new java.awt.Color(230, 230, 230));
        Pass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Pass.setLabelText("Password");
        Pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PassKeyPressed(evt);
            }
        });

        User.setBackground(new java.awt.Color(34, 34, 34));
        User.setForeground(new java.awt.Color(230, 230, 230));
        User.setLabelText("Username");

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(lbLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(lbLogin)
                .addGap(68, 68, 68)
                .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_loginActionPerformed

    private void PassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PassKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            login();
         }
    }//GEN-LAST:event_PassKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.PasswordField Pass;
    private com.app.swing.TextField User;
    private com.app.component.Header header;
    private javax.swing.JLabel lbLogin;
    private com.app.swing.Button login;
    private com.app.swing.PanelBackground panelBackground1;
    // End of variables declaration//GEN-END:variables
}
