
package com.app.config;

import com.app.main.Login;
import com.app.main.Login;
import com.app.swing.PasswordField;
import com.app.swing.TextField;
import com.app.theme.ThemeColorChange;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;


public class Configuration extends javax.swing.JFrame {

  
    config con = new config();
    public Configuration() {
       initComponents();
       init();
//       ip.setText(con.GetProp(lbl_ip.toString()));
//       dbname.setText(con.GetProp(lbl_db.toString()));
//       user.setText(con.GetProp(lbl_user.toString()));
//       pw.setText(con.GetProp(lbl_pass.toString()));
//        System.out.println(con.GetProp(lbl_pass.toString()));
    }
    private void init(){
        header1.initMoving(this);
        header1.initEvent(this, panelBackground1);
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        button1.setBackground(pro.getColor());
        button2.setBackground(pro.getColor());   
         if(!pro.isDarkMode()){
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackground1.setBackground(Color.WHITE); 
            for (Component com : panelBackground1.getComponents()){  
               if(com instanceof JLabel){
                JLabel lbl = (JLabel) com;
                    lbl.setForeground(new Color(80,80,80));
                }
                if(com instanceof TextField){
                    TextField txt = (TextField) com;
                    txt.setForeground(new Color(80,80,80));
                }
                if(com instanceof PasswordField){
                    PasswordField txt = (PasswordField) com;
                    txt.setForeground(new Color(80,80,80));
                }
                
            }
            
        }
         for(Component com : panelBackground1.getComponents()){
            if(com instanceof TextField){
                 TextField txt = (TextField) com;
                 txt.setBackground(new Color(0,0,0,0));
            }
            if(com instanceof PasswordField){
                PasswordField pass = (PasswordField) com;
                pass.setBackground(new Color(0,0,0,0));
            }
         }
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        panelBackground1 = new com.app.swing.PanelBackground();
        header1 = new com.app.component.Header();
        button1 = new com.app.swing.Button();
        button2 = new com.app.swing.Button();
        jLabel2 = new javax.swing.JLabel();
        lbBack = new javax.swing.JLabel();
        ip = new com.app.swing.TextField();
        dbname = new com.app.swing.TextField();
        user = new com.app.swing.TextField();
        pw = new com.app.swing.PasswordField();
        lbl_ip = new javax.swing.JLabel();
        lbl_db = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        lbl_pass = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Config");
        setUndecorated(true);

        panelBackground1.setBackground(new java.awt.Color(25, 25, 25));

        button1.setForeground(new java.awt.Color(230, 230, 230));
        button1.setText("Save");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setForeground(new java.awt.Color(230, 230, 230));
        button2.setText("Cancel");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(128, 128, 128));
        jLabel2.setText("Configure your connection here");

        lbBack.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lbBack.setForeground(new java.awt.Color(230, 230, 230));
        lbBack.setText("Configuration");

        ip.setForeground(new java.awt.Color(230, 230, 230));
        ip.setLabelText("");

        dbname.setForeground(new java.awt.Color(230, 230, 230));
        dbname.setLabelText("");

        user.setForeground(new java.awt.Color(230, 230, 230));
        user.setLabelText("");

        pw.setForeground(new java.awt.Color(230, 230, 230));
        pw.setLabelText("");

        lbl_ip.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_ip.setForeground(new java.awt.Color(128, 128, 128));
        lbl_ip.setText("IP Server :");

        lbl_db.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_db.setForeground(new java.awt.Color(128, 128, 128));
        lbl_db.setText("Database :");

        lbl_user.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(128, 128, 128));
        lbl_user.setText("Username :");

        lbl_pass.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_pass.setForeground(new java.awt.Color(128, 128, 128));
        lbl_pass.setText("Password :");

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbBack))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_db, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_user, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dbname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_db, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_user))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        String a = ip.getText();
        String b = dbname.getText();
        String c = user.getText();
        String d = pw.getText();
        String[] data = {a,b,c,d};
        for(String dat : data){
            if(dat==null){
                dat = "";
            }
        }
        con.SaveProp(lbl_ip.getText(),ip.getText());
        con.SaveProp(lbl_db.getText(),dbname.getText());
        con.SaveProp(lbl_user.getText(),user.getText());
        con.SaveProp(lbl_pass.getText(),pw.getText());
        this.dispose();
        Login obj = new Login();
        obj.setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.swing.Button button1;
    private com.app.swing.Button button2;
    private com.app.swing.TextField dbname;
    private com.app.component.Header header1;
    private com.app.swing.TextField ip;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lbBack;
    public javax.swing.JLabel lbl_db;
    public javax.swing.JLabel lbl_ip;
    public javax.swing.JLabel lbl_pass;
    public javax.swing.JLabel lbl_user;
    private com.app.swing.PanelBackground panelBackground1;
    private com.app.swing.PasswordField pw;
    private com.app.swing.TextField user;
    // End of variables declaration//GEN-END:variables
}
