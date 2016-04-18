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
        fillBox();
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
        String datum1 = getChoosenDateFrom();
        String datum2 = getChoosenDateTill();
        System.out.println("Datumet är " + datum1);
        System.out.println("Sista datumet är " + datum2);
        String valtPersonID =  database.hamtaAnstalldPid(selectedDeltagare);
        System.out.println("pid är " +  valtPersonID );
        
        if(selectedDeltagare == "Alla")
        {
                sqlfraga = "select ROOM.RNAME, MEETING.TITLE, MEETING.DESCRIPTION, DATE_TIME.TIMECODE, PERSON.NAME, ATTENDEES.PERSONID\n"
                + "from MEETING JOIN ROOM\n"
                + "on ROOM.ROOMID = MEETING.ROOMID\n"
                + "join PERSON on \n"
                + "PERSON.PERSONID = MEETING.PERSONID\n"
                + "JOIN MEETING_TIME ON\n"
                + "MEETING_TIME.MEETING_TIMEID = MEETING.MEETING_TIMEID\n"
                + "JOIN DATE_TIME ON\n"
                + "DATE_TIME.DATE_TIMEID = MEETING_TIME.DATE_TIMEID\n"
                + "JOIN ATTENDEES ON\n"
                + "ATTENDEES.MEETINGID = MEETING.MEETINGID\n"
                + "WHERE DATE_TIME.TIMECODE > '" + datum1 + "' AND DATE_TIME.TIMECODE < '" + datum2 + "' ";        
                System.out.println(sqlfraga);
        }
        else{
                sqlfraga = "select ROOM.RNAME, MEETING.TITLE, MEETING.DESCRIPTION, DATE_TIME.TIMECODE, PERSON.NAME, ATTENDEES.PERSONID\n"
                + "from MEETING JOIN ROOM\n"
                + "on ROOM.ROOMID = MEETING.ROOMID\n"
                + "join PERSON on \n"
                + "PERSON.PERSONID = MEETING.PERSONID\n"
                + "JOIN MEETING_TIME ON\n"
                + "MEETING_TIME.MEETING_TIMEID = MEETING.MEETING_TIMEID\n"
                + "JOIN DATE_TIME ON\n"
                + "DATE_TIME.DATE_TIMEID = MEETING_TIME.DATE_TIMEID\n"
                + "JOIN ATTENDEES ON\n"
                + "ATTENDEES.MEETINGID = MEETING.MEETINGID\n" 
                + "WHERE DATE_TIME.TIMECODE = '" + datum1 + "' AND DATE_TIME.TIMECODE = '" + datum2 + "'  AND ATTENDEES.PERSONID = '" + valtPersonID + "' ";
        System.out.println(sqlfraga);
        }
        
        fillTable_GetGet(jtbl_seMoten_motesSchema, sqlfraga, "RNAME", "TITLE", "DESCRIPTION", "TIMECODE", "NAME", "PERSONID");
        domanTableModel = (DefaultTableModel) jtbl_seMoten_motesSchema.getModel();
    }
   public String getChoosenDateFrom() {
        
        //Get the choosen date.
        Date choosendate = dp_seMoten_datepicker1.getDate();
        Calendar cal = Calendar.getInstance();        
        cal.setTime(choosendate);
        
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH); //0-11
        month = month + 1;
        int year = cal.get(Calendar.YEAR);
        //String hour = cb_SkapaMote_Timmar.getSelectedItem().toString();
        //String minute = cb_SkapaMote_Minuter.getSelectedItem().toString();
        //String seconds = "00";
        
        //Timeformat: YYYY-MM-dd HH:mm:ss
        String finalDate = year + "-" + month + "-" + day;
        
        //Day and month will print out 1, 2, 3... we want 01,02,03...
        if (day < 10 && month < 10) {
            finalDate = year + "-0" + month + "-0" + day;
        }
        if (day < 10 && month >= 10) {
            finalDate = year + "-" + month + "-0" + day;
        }
        if (day >= 10 && month < 10) {
            finalDate = year + "-0" + month + "-" + day;
        }  
        return finalDate;   
    }
   
   public String getChoosenDateTill() {
        
        //Get the choosen date.
        Date choosendate = dp_seMoten_datepicker2.getDate();
        Calendar cal = Calendar.getInstance();        
        cal.setTime(choosendate);
        
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH); //0-11
        month = month + 1;
        int year = cal.get(Calendar.YEAR);
        //String hour = cb_SkapaMote_Timmar.getSelectedItem().toString();
        //String minute = cb_SkapaMote_Minuter.getSelectedItem().toString();
        //String seconds = "00";
        
        //Timeformat: YYYY-MM-dd HH:mm:ss
        String finalDate = year + "-" + month + "-" + day;
        
        //Day and month will print out 1, 2, 3... we want 01,02,03...
        if (day < 10 && month < 10) {
            finalDate = year + "-0" + month + "-0" + day;
        }
        if (day < 10 && month >= 10) {
            finalDate = year + "-" + month + "-0" + day;
        }
        if (day >= 10 && month < 10) {
            finalDate = year + "-0" + month + "-" + day;
        }  
        return finalDate;  
   }
   
   public void fillTable_GetGet(JTable thisTable, String sql, String column1, String column2, String column3, String column4, String column5, String column6) {

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
                dtm.addRow(new Object[]{row.get(column1), row.get(column2), row.get(column3), row.get(column4), row.get(column5), row.get(column6)});
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
    
    public void fillBox() {
        ArrayList<HashMap<String, String>> lista = database.hamtaAllNamnPid();

        String namn = "";
        String namnAid = ""; 
        String aid = "";
        if (lista != null) {
            
            for (int i = 0; i < lista.size(); i++) {
                
                aid = lista.get(i).get("PERSONID");
                namn = lista.get(i).get("NAME");
                
                namnAid += ""+ aid + " = " + namn + "\n";
                   
                
                
          }

            TA_seMote_Personer.setText(namnAid);

        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp_seMoten_datepicker1 = new org.jdesktop.swingx.JXDatePicker();
        dp_seMoten_datepicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btn_seMoten_stang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_seMoten_motesSchema = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_seMote_Personer = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        jLabel1.setText("Möteskalender");

        jLabel2.setText("Deltagare");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alla" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btn_seMoten_stang.setText("Stäng");
        btn_seMoten_stang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seMoten_stangActionPerformed(evt);
            }
        });

        jtbl_seMoten_motesSchema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rum", "Titel", "Beskrivning", "Tid", "Mötesansvarig", "Deltagare"
            }
        ));
        jtbl_seMoten_motesSchema.setCellSelectionEnabled(true);
        jtbl_seMoten_motesSchema.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jtbl_seMoten_motesSchema);
        jtbl_seMoten_motesSchema.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jtbl_seMoten_motesSchema.getColumnModel().getColumnCount() > 0) {
            jtbl_seMoten_motesSchema.getColumnModel().getColumn(1).setResizable(false);
        }

        TA_seMote_Personer.setColumns(20);
        TA_seMote_Personer.setRows(5);
        jScrollPane1.setViewportView(TA_seMote_Personer);

        jLabel3.setText("Datum från");

        jLabel4.setText("Datum till");

        jLabel5.setText("Namnlista som visar ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_seMoten_stang)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(79, 79, 79))))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(dp_seMoten_datepicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dp_seMoten_datepicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 69, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dp_seMoten_datepicker2, jComboBox1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dp_seMoten_datepicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dp_seMoten_datepicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
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
    private javax.swing.JTextArea TA_seMote_Personer;
    private javax.swing.JButton btn_seMoten_stang;
    private org.jdesktop.swingx.JXDatePicker dp_seMoten_datepicker1;
    private org.jdesktop.swingx.JXDatePicker dp_seMoten_datepicker2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbl_seMoten_motesSchema;
    // End of variables declaration//GEN-END:variables
}
