/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bug;

import dataTypes.User;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.SessionStorage;
import utils.fileObj.CRUD.*;

/**
 *
 * @author ahmed
 */
public class BugsListJFrame extends javax.swing.JFrame {

    /**
     * Creates new form BugJFrame
     */
    public BugsListJFrame() {
        initComponents();
        checkAuth();
        initTable();
    }

    private static void removeAllRows() {
        int RowSize = jTable1.getRowCount();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < RowSize; i++) {
            model.removeRow(0);
        }

    }

    public static void initTable() {

        int nOfTotalBugs = 0;
        int nOfCheckedBugs = 0;

        removeAllRows();

        BugF BugFile = new BugF();

        ArrayList<dataTypes.Bug> bugsList = null;

        User userData = ((User) SessionStorage.getData());

        javax.swing.JTable jTableProjects = project.ProjectsListJFrame.jTable1;

        int sRow = jTableProjects.getSelectedRow();

        int projectId = (int) jTableProjects.getValueAt(sRow, 0);

        try {
            switch (userData.role) {
                case "Developer": {
                    bugsList = BugFile.get((bug) -> bug.developer_id.equals(userData.getId()), (bug) -> bug.project_id.equals(projectId));
                    break;
                }
                default: {
                    bugsList = BugFile.get((bug) -> bug.project_id.equals(projectId));
                }
            }

            for (dataTypes.Bug bug : bugsList) {
                if (bug.status) {
                    nOfCheckedBugs++;
                }
                nOfTotalBugs++;
                addTableRow(bug);
            }

            totalBugsJText.setText(String.valueOf(nOfTotalBugs));
            checkedBugsJText.setText(String.valueOf(nOfCheckedBugs));

        } catch (Exception e) {
            messages.JFrameMessage.showErr(e);
        }

    }

    public static void addTableRow(dataTypes.Bug bug) throws Exception {
        UserF userFile = new UserF();

        String devName = "";
        String testerName = "";

        dataTypes.User user = userFile.getByID(bug.developer_id);

        if (user != null) {
            devName = user.name;
        }

        user = userFile.getByID(bug.tester_id);

        if (user != null) {
            testerName = user.name;
        }

        if (user.getId().intValue() == ((User) SessionStorage.getData()).getId().intValue()) {
            testerName = "You";
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.addRow(new Object[]{bug.getId().intValue(), bug.name, bug.type, bug.priority, bug.level, bug.developer_id.intValue(), devName, bug.tester_id.intValue(), testerName, bug.createdAt, bug.img, bug.status});
    }

    private void checkAuth() {
        User u = ((User) SessionStorage.getData());

        if (!u.role.equals("Project Manager")) {
            jPanel2.remove(AdminJPanel);
        }

        switch (u.role) {
            case "Tester": {
                bugOperationsJPanel.remove(chStatBtn);
                break;
            }
            case "Developer": {
                bugOperationsJPanel.remove(creatBtn);
                bugOperationsJPanel.remove(updateBtn);
                break;
            }
            case "Project Manager": {
                jPanel2.remove(bugOperationsJPanel);
                break;
            }
            default: {
                jPanel2.removeAll();
                jPanel1.remove(jPanel2);
            }
        }
        revalidate();
        repaint();
    }

    ;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        AdminJPanel = new javax.swing.JPanel();
        totalBugsJText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkedBugsJText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bugOperationsJPanel = new javax.swing.JPanel();
        chStatBtn = new javax.swing.JButton();
        creatBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bugs");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Type", "Priority", "Level", "Developer_id", "Developer", "Tester_id", "Tester", "Date", "Photo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        totalBugsJText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalBugsJText.setText("totalNumber");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Checked:");
        jLabel2.setToolTipText("");

        checkedBugsJText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        checkedBugsJText.setText("checkedNumber");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Total:");

        javax.swing.GroupLayout AdminJPanelLayout = new javax.swing.GroupLayout(AdminJPanel);
        AdminJPanel.setLayout(AdminJPanelLayout);
        AdminJPanelLayout.setHorizontalGroup(
            AdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalBugsJText)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkedBugsJText)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        AdminJPanelLayout.setVerticalGroup(
            AdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AdminJPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(AdminJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkedBugsJText)
                    .addComponent(totalBugsJText)
                    .addComponent(jLabel1)))
        );

        chStatBtn.setText("Change status");
        chStatBtn.setEnabled(false);
        chStatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chStatBtnMouseClicked(evt);
            }
        });

        creatBtn.setText("Create");
        creatBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creatBtnMouseClicked(evt);
            }
        });
        creatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.setEnabled(false);
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bugOperationsJPanelLayout = new javax.swing.GroupLayout(bugOperationsJPanel);
        bugOperationsJPanel.setLayout(bugOperationsJPanelLayout);
        bugOperationsJPanelLayout.setHorizontalGroup(
            bugOperationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bugOperationsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chStatBtn)
                .addGap(20, 20, 20)
                .addComponent(creatBtn)
                .addGap(20, 20, 20)
                .addComponent(updateBtn)
                .addGap(0, 0, 0))
        );
        bugOperationsJPanelLayout.setVerticalGroup(
            bugOperationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bugOperationsJPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(bugOperationsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chStatBtn)
                    .addComponent(creatBtn)
                    .addComponent(updateBtn)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(bugOperationsJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AdminJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bugOperationsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void creatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creatBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 1) {
            if (chStatBtn.getParent() != null) {
                chStatBtn.setEnabled(true);
            }
            if (updateBtn.getParent() != null) {
                updateBtn.setEnabled(true);
            }
        } else if (evt.getClickCount() == 2) {

            String imagePath = "Images\\" + (String) jTable1.getValueAt(jTable1.getSelectedRow(), 10);

            ImageIcon originalIcon = new ImageIcon(imagePath);

            Image originalImage = originalIcon.getImage();

            Image scaledImage = originalImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(null, scaledIcon, "Image Viewer", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void creatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creatBtnMouseClicked

        new bugJframe(null).setVisible(true);


    }//GEN-LAST:event_creatBtnMouseClicked

    private void chStatBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chStatBtnMouseClicked
        if (chStatBtn.isEnabled()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int sRow = jTable1.getSelectedRow();
            int bugId = (int) jTable1.getValueAt(sRow, 0);
            boolean bugStatus = (boolean) jTable1.getValueAt(sRow, 11);

            int testerId = (int) jTable1.getValueAt(sRow, 7);

            dataTypes.User currDeveloperData = ((dataTypes.User) SessionStorage.getData());

            BugF bugFile = new BugF();

            try {
                bugFile.update(new Object[][]{{"status", !bugStatus}}, (bug) -> bug.getId().equals(bugId));

                jTable1.setValueAt(!bugStatus, sRow, 11);

                dataTypes.User testerData = new UserF().getByID(testerId);

                if (!bugStatus) {
                    String message
                            = "Developer with data\n"
                            + "   ID: " + currDeveloperData.getId()
                            + "\n   Name: " + currDeveloperData.name
                            + "\n has completed a bug with id: " + bugId;

                    utils.Email.send(testerData.email, "bug solved", message);
                }

            } catch (Exception e) {
                messages.JFrameMessage.showErr(e);
            }
        }
    }//GEN-LAST:event_chStatBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int sRow = jTable1.getSelectedRow();

        if (sRow == -1) {
            return;
        }

        int bugId = (int) jTable1.getValueAt(sRow, 0);

        BugF bugFile = new BugF();

        try {
            dataTypes.Bug bug = bugFile.getByID(bugId);

            if (bug.tester_id.intValue() != ((User) SessionStorage.getData()).getId().intValue()) {
                updateBtn.setEnabled(false);
                return;
            }

            new bugJframe(bug).setVisible(true);

        } catch (Exception e) {
            messages.JFrameMessage.showErr(e);
        }
    }//GEN-LAST:event_updateBtnMouseClicked

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
            java.util.logging.Logger.getLogger(BugsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BugsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BugsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BugsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BugsListJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminJPanel;
    private javax.swing.JPanel bugOperationsJPanel;
    private javax.swing.JButton chStatBtn;
    private static javax.swing.JLabel checkedBugsJText;
    private javax.swing.JButton creatBtn;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private static javax.swing.JLabel totalBugsJText;
    public static javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
