/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskinterface;

/**
 *
 * @author Simon
 */
public class CreateNewPostFrame extends javax.swing.JFrame {

    static String temp;
    /**
     * Creates new form CreateNewPostFrame
     */
    public CreateNewPostFrame(String param) {
        initComponents();
        temp = param;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_CreateNewPostFrame_Post = new javax.swing.JButton();
        tf_CreateNewPostFrame_PostTitle = new javax.swing.JTextField();
        lbl_CreateNewPostFrame_PostTitle = new javax.swing.JLabel();
        lbl_CreateNewPostFrame_PostBody = new javax.swing.JLabel();
        btn_CreateNewPostFrame_Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_CreateNewPostFrame_PostBody = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 306));

        btn_CreateNewPostFrame_Post.setText("Skicka");
        btn_CreateNewPostFrame_Post.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateNewPostFrame_PostActionPerformed(evt);
            }
        });

        lbl_CreateNewPostFrame_PostTitle.setText("Rubrik");

        lbl_CreateNewPostFrame_PostBody.setText("Text");

        btn_CreateNewPostFrame_Back.setText("Tillbaka");
        btn_CreateNewPostFrame_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateNewPostFrame_BackActionPerformed(evt);
            }
        });

        tf_CreateNewPostFrame_PostBody.setColumns(20);
        tf_CreateNewPostFrame_PostBody.setLineWrap(true);
        tf_CreateNewPostFrame_PostBody.setRows(5);
        jScrollPane1.setViewportView(tf_CreateNewPostFrame_PostBody);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_CreateNewPostFrame_Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CreateNewPostFrame_Post))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_CreateNewPostFrame_PostTitle)
                            .addComponent(tf_CreateNewPostFrame_PostTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_CreateNewPostFrame_PostBody))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_CreateNewPostFrame_PostTitle)
                .addGap(1, 1, 1)
                .addComponent(tf_CreateNewPostFrame_PostTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_CreateNewPostFrame_PostBody)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CreateNewPostFrame_Post)
                    .addComponent(btn_CreateNewPostFrame_Back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CreateNewPostFrame_PostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateNewPostFrame_PostActionPerformed
        
        if (temp == "rGroup6")
        {
            
        }
        
        
        
    }//GEN-LAST:event_btn_CreateNewPostFrame_PostActionPerformed

    private void btn_CreateNewPostFrame_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateNewPostFrame_BackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CreateNewPostFrame_BackActionPerformed

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
            java.util.logging.Logger.getLogger(CreateNewPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewPostFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewPostFrame(temp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CreateNewPostFrame_Back;
    private javax.swing.JButton btn_CreateNewPostFrame_Post;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_CreateNewPostFrame_PostBody;
    private javax.swing.JLabel lbl_CreateNewPostFrame_PostTitle;
    private javax.swing.JTextArea tf_CreateNewPostFrame_PostBody;
    private javax.swing.JTextField tf_CreateNewPostFrame_PostTitle;
    // End of variables declaration//GEN-END:variables
}
