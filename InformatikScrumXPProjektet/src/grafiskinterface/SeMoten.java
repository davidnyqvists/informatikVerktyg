/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskinterface;

/**
 *
 * @author David Nyqvist
 */
import databas.DBClass;
import java.awt.Color;
import java.io.File;
import java.nio.file.Paths;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SeMoten extends javax.swing.JFrame {
    private DBClass database = new DBClass(); 
    private InfDB idb;
    DefaultTableModel domanTableModel = new DefaultTableModel();
    int valueCheck;
    /**
     * Creates new form SeMoten
     */
    public SeMoten() {
        initComponents();
        laggTillNamn();
//kraschar när den inte är kommenterad        
//fillTable_PersonPlattform();
    valueCheck = 0;
        try {
            String path = Paths.get("").toAbsolutePath().toString() + File.separator + "BOOKFACE.FDB";
            idb = new InfDB(path);
            System.out.println("Fungera");
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.print("fel");
        }
    
   }
     // Lägger till namn i Comboboxen
    public void laggTillNamn() {
        String sql =  "Select NAME FROM PERSON";
        ArrayList<HashMap<String, String>> projektLista = database.hamtaAlla(sql);
        for (int i = 0; i < projektLista.size(); i++) {
          jComboBox1.addItem(projektLista.get(i).get("NAME"));
        }
        
       }
    public void fillTable_PersonPlattform() {
        emptyTable_PersonPlattform();
        String selectedDeltagare = jComboBox1.getSelectedItem().toString();
        String sqlfraga = "";
        if(selectedDeltagare == "Alla")
        {
                sqlfraga = "select ROOM.NAME, MEETING.TITLE, MEETING.DESCRIPTION, DATE_TIME.TIMECODE\n"
                + "from MEETING JOIN ROOM\n"
                + "on ROOM.ROOMID = MEETING.ROOMID\n"
                + "join PERSON on \n"
                + "PERSON.PERSONID = MEETING.PERSONID\n"
                + "JOIN MEETING_TIME ON\n"
                + "MEETING_TIME.MEETING_TIMEID = MEETING.MEETING_TIMEID\n"
                + "JOIN DATE_TIME ON\n"
                + "DATE_TIME.DATE_TIMEID = MEETING_TIME.DATE_TIMEID\n";
                    
                System.out.println(sqlfraga);
        }
        else{
                sqlfraga = "select ROOM.NAME, MEETING.TITLE, MEETING.DESCRIPTION, DATE_TIME.TIMECODE\n"
                + "from MEETING JOIN ROOM\n"
                + "on ROOM.ROOMID = MEETING.ROOMID\n"
                + "join PERSON on \n"
                + "PERSON.PERSONID = MEETING.PERSONID\n"
                + "JOIN MEETING_TIME ON\n"
                + "MEETING_TIME.MEETING_TIMEID = MEETING.MEETING_TIMEID\n"
                + "JOIN DATE_TIME ON\n"
                + "DATE_TIME.DATE_TIMEID = MEETING_TIME.DATE_TIMEID\n"
                + "WHERE PERSON.NAME = '" + selectedDeltagare + "' ";
        System.out.println(sqlfraga);
        }
        
        fillTable_GetGet(jtbl_seMoten_motesSchema, sqlfraga, "NAME", "TITLE", "DESCRIPTION", "TIMECODE");
        domanTableModel = (DefaultTableModel) jtbl_seMoten_motesSchema.getModel();
    }
   
    public void fillTable_GetGet(JTable thisTable, String sql, String column1, String column2, String column3, String column4) {

        DefaultTableModel dtm = (DefaultTableModel) thisTable.getModel();
        System.out.println("Fungerar i första stycket");
        thisTable.setModel(dtm);
        System.out.println("Fungerar i andra stycket");
        ArrayList<HashMap<String, String>> data = new ArrayList<>();
        System.out.println("Fungerar i tredje stycket");
        
        try {
            data = idb.fetchRows(sql);
            System.out.println("Datan här är + " + data);
        } catch (InfException e) {
            System.out.println("Fill Table Error");
        }

        if (data == null) {
        } else {
            for (HashMap<String, String> row : data) {
                dtm.addRow(new Object[]{row.get(column1), row.get(column2), row.get(column3), row.get(column4)});
            }
        }
        thisTable.setModel(dtm); 
        
        }
    
    public void emptyTable_PersonPlattform() {
       DefaultTableModel dtm = (DefaultTableModel) jtbl_seMoten_motesSchema.getModel();

        int rowCount = dtm.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        jtbl_seMoten_motesSchema.setModel(dtm);
    }
    
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btn_seMoten_stang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_seMoten_motesSchema = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Möteskalender");

        jLabel2.setText("Person");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alla", "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Sök");

        btn_seMoten_stang.setText("Stäng");
        btn_seMoten_stang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seMoten_stangActionPerformed(evt);
            }
        });

        jtbl_seMoten_motesSchema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rum", "Titel", "Beskrivning", "Tid"
            }
        ));
        jtbl_seMoten_motesSchema.setCellSelectionEnabled(true);
        jtbl_seMoten_motesSchema.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jtbl_seMoten_motesSchema);
        jtbl_seMoten_motesSchema.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jtbl_seMoten_motesSchema.getColumnModel().getColumnCount() > 0) {
            jtbl_seMoten_motesSchema.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(261, 261, 261)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_seMoten_stang))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(btn_seMoten_stang)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seMoten_stangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seMoten_stangActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_seMoten_stangActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        fillTable_PersonPlattform();
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(SeMoten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeMoten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeMoten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeMoten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeMoten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_seMoten_stang;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JTable jtbl_seMoten_motesSchema;
    // End of variables declaration//GEN-END:variables
}
