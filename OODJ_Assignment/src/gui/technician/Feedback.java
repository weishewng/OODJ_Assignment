/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.technician;

/**
 *
 * @author USER
 */
// 1. 先在上面加这两个变量来“记住”数据
    public class Feedback extends javax.swing.JFrame {

    // 1. 先在上面加这两个变量来“记住”数据
    private String currentJobId;
    private String currentUser;

    // 2. 修改你的 Constructor
    public Feedback(String selectedApptId, String loggedInUser) {
        initComponents();
        this.currentJobId = selectedApptId; // 把传进来的 ID 存起来
        this.currentUser = loggedInUser;    // 把传进来的名字存起来
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setPreferredSize(new java.awt.Dimension(300, 84));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Technician Feedback Form");

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                            
        // 1. Create an instance of the Technician Dashboard
        // We pass 'currentUser' so the dashboard still knows who is logged in
        gui.technician.TechnicianDashboard dashboard = new gui.technician.TechnicianDashboard(currentUser);
        
        // 2. Make the dashboard visible
        dashboard.setVisible(true);
        
        // 3. Close the current JobStatus window
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                                
        // 1. Get the text from the feedback text area
        String feedbackText = jTextArea1.getText(); 
        
        // 2. Validation: Check if it's empty
        if (feedbackText.trim().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter your feedback before submitting!");
            return;
        }
        
        try {
            // 3. Open feedbacks.txt in APPEND mode
            java.io.FileWriter writer = new java.io.FileWriter("data/feedbacks.txt", true);
            
            // 4. Write data format: ApptID, Username, Feedback
            writer.write(currentJobId + "," + currentUser + "," + feedbackText + "\n");
            writer.close(); 
            
            // 5. Show success message
            javax.swing.JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");
            
            // === NEW LOGIC: GO BACK TO DASHBOARD ===
            // 6. Create the dashboard and pass the current user
            gui.technician.TechnicianDashboard dashboard = new gui.technician.TechnicianDashboard(currentUser);
            dashboard.setVisible(true);
            
            // 7. Close the feedback window
            this.dispose();
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error saving feedback: " + e.getMessage());
        }
    
    
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feedback("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
