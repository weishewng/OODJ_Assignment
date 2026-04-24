/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.technician;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class TechnicianDashboard extends javax.swing.JFrame {

    
    public TechnicianDashboard() {
        initComponents(); // This is the default line that draws the window
    
        loadAppointments(); // ADD THIS LINE RIGHT HERE!

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Customer Name", "Vehicle Number", "Service Type", "Status", "Technician ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("welcome");

        jButton1.setText("view job");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("feedback");

        jButton3.setText("log out");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Technician Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 309, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    // 1. Get the index of the row the user clicked on
    // It returns -1 if they didn't click anything
    int selectedRow = jTable1.getSelectedRow();

    // 2. Data Validation: Did they actually select a row?
    if (selectedRow == -1) {
        // No row selected! Show an error message.
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a job from the table first!");
    } else {
        // 3. Row is selected! Grab the Appointment ID.
        // Assuming Appointment ID is in Column 0 (the very first column)
        String selectedApptId = jTable1.getValueAt(selectedRow, 0).toString();
        
        // 4. Open your JobStatus frame and pass the ID to it
        // (Make sure the name "JobStatus" matches your actual JFrame file name)
        JobStatus nextScreen = new JobStatus(selectedApptId);
        nextScreen.setVisible(true);
        
        // 5. Close the dashboard (optional, but keeps the screen clean)
        dispose(); 
    }

    }//GEN-LAST:event_jButton1ActionPerformed
    public void loadAppointments() {
    // 1. Get the data model of your table 
    // Make sure 'jTable1' matches the actual variable name of your table!
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // 2. Clear any empty rows that the GUI builder put there by default
    model.setRowCount(0); 

    try {
        // 3. Open the text file
        BufferedReader reader = new BufferedReader(new FileReader("Appointments.txt"));
        String line;

        // 4. Read the file line by line
        while ((line = reader.readLine()) != null) {
            
            // Split the line using your comma delimiter
            String[] rowData = line.split(","); 
            
            // 5. Add this row to the table
            model.addRow(rowData);
        }
        reader.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage());
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TechnicianDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
