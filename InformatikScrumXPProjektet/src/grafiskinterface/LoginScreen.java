/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskinterface;
//testar gitignore fil
/**
 *
 * @author Simon
 */

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.*;
import databas.DBClass;
import javax.swing.JOptionPane;


public class LoginScreen extends javax.swing.JFrame {
    
    private DBClass dataBase;
    private CurrentLogin currentUser;
    /**
     * Creates new form LogInRuta
     */
    public LoginScreen() {
        dataBase = new DBClass();
        currentUser = new CurrentLogin();
        this.setLocationRelativeTo(null);
        initComponents();
        
        lbl_LoginScreen_ErrorMessage.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_LoginScreen_Username = new javax.swing.JTextField();
        lbl_LoginScreen_Title = new javax.swing.JLabel();
        lbl_LoginScreen_Username = new javax.swing.JLabel();
        lbl_LoginScreen_Password = new javax.swing.JLabel();
        btn_LoginScreen_Exit = new javax.swing.JButton();
        btn_LoginScreen_LogIn = new javax.swing.JButton();
        pf_LoginScreen_Password = new javax.swing.JPasswordField();
        btn_LoginScreen_KontoHantering = new javax.swing.JButton();
        lbl_LoginScreen_ErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tf_LoginScreen_Username.setText("systemadmin");
        tf_LoginScreen_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_LoginScreen_UsernameActionPerformed(evt);
            }
        });

        lbl_LoginScreen_Title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_LoginScreen_Title.setText("Det otroliga Informatikprogrammet");

        lbl_LoginScreen_Username.setText("Användarnamn");

        lbl_LoginScreen_Password.setText("Lösenord");

        btn_LoginScreen_Exit.setText("Avsluta");
        btn_LoginScreen_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginScreen_ExitActionPerformed(evt);
            }
        });

        btn_LoginScreen_LogIn.setText("Logga in");
        btn_LoginScreen_LogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginScreen_LogInActionPerformed(evt);
            }
        });

        pf_LoginScreen_Password.setText("systemadmin");
        pf_LoginScreen_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_LoginScreen_PasswordActionPerformed(evt);
            }
        });

        btn_LoginScreen_KontoHantering.setText("Konto Hantering");
        btn_LoginScreen_KontoHantering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginScreen_KontoHanteringActionPerformed(evt);
            }
        });

        lbl_LoginScreen_ErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
        lbl_LoginScreen_ErrorMessage.setText("Inkorrekt användarnamn eller lösenord vänligen kontrollera uppgifter");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_LoginScreen_Exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LoginScreen_LogIn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_LoginScreen_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_LoginScreen_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_LoginScreen_Username))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_LoginScreen_Password)
                            .addComponent(pf_LoginScreen_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_LoginScreen_KontoHantering)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbl_LoginScreen_ErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_LoginScreen_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_LoginScreen_Username)
                    .addComponent(lbl_LoginScreen_Password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_LoginScreen_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pf_LoginScreen_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(lbl_LoginScreen_ErrorMessage)
                .addGap(18, 18, 18)
                .addComponent(btn_LoginScreen_KontoHantering)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_LoginScreen_Exit)
                    .addComponent(btn_LoginScreen_LogIn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Avslutar programmet från Log-In skärmen.
    private void btn_LoginScreen_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginScreen_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_LoginScreen_ExitActionPerformed

    private void btn_LoginScreen_LogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginScreen_LogInActionPerformed
        
        
       String username = tf_LoginScreen_Username.getText();
       String password = String.valueOf(pf_LoginScreen_Password.getPassword());
                dataBase.logIn(username, password);
        
                if (dataBase.logIn(username, password))
                {
                    CurrentLoginHolder.InitieraHoldern(currentUser, username, password);
                    GrafikHelper.DisposeFrame();
                    GrafikHelper.InitieraMain();
                    
                    
                    
                }
                else
                {
                    lbl_LoginScreen_ErrorMessage.setVisible(true);
                }
                
        
        
    }//GEN-LAST:event_btn_LoginScreen_LogInActionPerformed

    private void btn_LoginScreen_KontoHanteringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginScreen_KontoHanteringActionPerformed
        String GUIUsername = tf_LoginScreen_Username.getText();
        String GUIPassword = String.valueOf(pf_LoginScreen_Password.getPassword());
        
        if (GUIUsername.equals("systemadmin") && GUIPassword.equals("systemadmin")){
            GrafikHelper.DisposeFrame();
            GrafikHelper.InitieraAccountManagement();
        }
        else {
            JOptionPane.showMessageDialog(null, "The username or password is wrong");
        }
    }//GEN-LAST:event_btn_LoginScreen_KontoHanteringActionPerformed

    private void pf_LoginScreen_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_LoginScreen_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_LoginScreen_PasswordActionPerformed

    private void tf_LoginScreen_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_LoginScreen_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_LoginScreen_UsernameActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LoginScreen_Exit;
    private javax.swing.JButton btn_LoginScreen_KontoHantering;
    private javax.swing.JButton btn_LoginScreen_LogIn;
    private javax.swing.JLabel lbl_LoginScreen_ErrorMessage;
    private javax.swing.JLabel lbl_LoginScreen_Password;
    private javax.swing.JLabel lbl_LoginScreen_Title;
    private javax.swing.JLabel lbl_LoginScreen_Username;
    private javax.swing.JPasswordField pf_LoginScreen_Password;
    private javax.swing.JTextField tf_LoginScreen_Username;
    // End of variables declaration//GEN-END:variables
}
