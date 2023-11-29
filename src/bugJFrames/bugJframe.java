/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bugJFrames;

import dataTypes.User;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import utils.SessionStorage;
import messages.JFrameMessage;
import java.nio.file.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import utils.fileObj.CRUD.*;

/**
 *
 * @author ahmed
 */
public class bugJframe extends javax.swing.JFrame {

    /**
     * Creates new form bugJframe
     */
    public bugJframe(dataTypes.Bug bugDetails) {
        initComponents();

        initTable();

        if (bugDetails != null) {
            jPanel2.remove(createBtn);
            fillFields(bugDetails);
        } else {
            jPanel2.remove(updateBtn);
        }

    }

    private void fillFields(dataTypes.Bug bugDetails) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            nameField.setText(bugDetails.name);

            typeComBox.setSelectedItem(bugDetails.type);

            priorityComBox.setSelectedItem(bugDetails.priority);

            lvlComBox.setSelectedItem(bugDetails.level);

            imgPathField.setText(bugDetails.img);

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                int devId = (int) jTable1.getValueAt(i, 0);

                if (String.valueOf(devId).equals(String.valueOf(bugDetails.developer_id))) {
                    jTable1.setRowSelectionInterval(i, i);
                    break;
                }
            }
        } catch (Exception e) {
            messages.JFrameMessage.showErr(e);
        }

    }

    public void initTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        ProjectMemberF projectMemberFile = new ProjectMemberF();

        ArrayList<dataTypes.User> membersList = null;

        javax.swing.JTable jTableProjects = projectJFrames.ProjectsListJFrame.jTable1;

        int sRow = jTableProjects.getSelectedRow();

        int projectId = (int) jTableProjects.getValueAt(sRow, 0);

        try {
            membersList = projectMemberFile.getMembers(projectId, (member) -> member.role.equals("Developer"));

            for (dataTypes.User member : membersList) {
                model.addRow(new Object[]{member.getId().intValue(), member.name});
            }
        } catch (Exception e) {
            JFrameMessage.showErr(e);
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

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        typeComBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        priorityComBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lvlComBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        imgPathField = new javax.swing.JTextField();
        selectBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        createBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create bug");

        jLabel1.setText("Name");

        nameField.setToolTipText("Name");

        jLabel2.setText("Type");

        typeComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Functional", "Logical", "Workflow", "Unit Level", "System-Level Integration", "Out of Bound", "Security" }));
        typeComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("priority");

        priorityComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Mid", "High" }));

        jLabel4.setText("Level");

        lvlComBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Minor", "Major", "Critical" }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Developers");

        jLabel6.setText("Photo");

        imgPathField.setEditable(false);
        imgPathField.setToolTipText("File path");

        selectBtn.setText("Select");
        selectBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectBtnMouseClicked(evt);
            }
        });
        selectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectBtnActionPerformed(evt);
            }
        });

        createBtn.setText("Create");
        createBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createBtnMouseClicked(evt);
            }
        });
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameField)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeComBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priorityComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lvlComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(imgPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(selectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priorityComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lvlComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imgPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void typeComBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeComBoxActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createBtnActionPerformed

    private void selectBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectBtnMouseClicked

        JFileChooser fc = new JFileChooser();

        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());

        fc.setFileFilter(imageFilter);

        int action = fc.showOpenDialog(this);

        if (action == JFileChooser.APPROVE_OPTION) {
            imgPathField.setText(fc.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_selectBtnMouseClicked

    private void selectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectBtnActionPerformed

    private void createBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBtnMouseClicked
        if (validateData()) {

            String destImgName = utils.GenUniqueFName.generate(imgPathField.getText());

            Path srcImgPath = Paths.get(imgPathField.getText());

            Path destImgPath = Paths.get("Images\\" + destImgName);

            javax.swing.JTable projectsTable = projectJFrames.ProjectsListJFrame.jTable1;

            int CurrProjectId = (int) projectsTable.getValueAt(projectsTable.getSelectedRow(), 0);

            int assignedDevId = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            try {
                BugF bugFile = new BugF();

                dataTypes.Bug bug = bugFile.create(new dataTypes.Bug(null, nameField.getText(), (String) typeComBox.getSelectedItem(), (String) priorityComBox.getSelectedItem(), (String) lvlComBox.getSelectedItem(), CurrProjectId, assignedDevId, ((User) SessionStorage.getData()).getId(), destImgName));

                BugsListJFrame.addTableRow(bug);

                if (!new File("Images").isDirectory()) {
                    Files.createDirectory(Paths.get("Images"));
                }

                Files.copy(srcImgPath, destImgPath);

                dataTypes.User developerDetails = new UserF().getByID(assignedDevId);
                dataTypes.User testerDatails = ((dataTypes.User) SessionStorage.getData());

                JOptionPane.showMessageDialog(this, "Added successfully", "Added", JOptionPane.INFORMATION_MESSAGE);

                resetFields();

                // Send email to inform the developer about Bug details
                new Thread(() -> ((modules.Tester) SessionStorage.getData()).SendEmailToDev(developerDetails.email, bug)).start();

            } catch (Exception e) {
                messages.JFrameMessage.showErr(e);
            }
        } else
            messages.JFrameMessage.showErr(new Exception("Ensure that all fields are filled"));
    }//GEN-LAST:event_createBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        if (validateData()) {

            JTable bugsTable = BugsListJFrame.jTable1;

            int bugId = (int) bugsTable.getValueAt(bugsTable.getSelectedRow(), 0);

            int devId = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            String destImgName = imgPathField.getText();

            Path oldPath = Paths.get("Images\\" + bugsTable.getValueAt(bugsTable.getSelectedRow(), 10));

            boolean isImgSame = destImgName.equals(oldPath.getFileName().toString());

            if (!isImgSame) {
                destImgName = utils.GenUniqueFName.generate(destImgName);
            }

            try {
                BugF bugFile = new BugF();

                Object[][] newBugData = new Object[][]{{"name", nameField.getText()}, {"type", typeComBox.getSelectedItem().toString()}, {"priority", priorityComBox.getSelectedItem().toString()}, {"level", lvlComBox.getSelectedItem().toString()}, {"img", destImgName}, {"developer_id", devId}};

                bugFile.update(newBugData, (bug) -> bug.getId().equals(bugId));

                if (!isImgSame) {
                    Path srcPath = Paths.get(imgPathField.getText());
                    Path destPath = Paths.get("Images\\" + destImgName);

                    Files.deleteIfExists(oldPath);

                    Files.copy(srcPath, destPath);
                }

                BugsListJFrame.initTable();

                JOptionPane.showMessageDialog(null, "Updated successfully", "Updated", JOptionPane.INFORMATION_MESSAGE);

                BugsListJFrame.updateBtn.setEnabled(false);

                this.dispose();

            } catch (Exception e) {
                messages.JFrameMessage.showErr(e);
            }

        } else {
            messages.JFrameMessage.showErr(new Exception("Ensure that all fields are filled"));
        }
    }//GEN-LAST:event_updateBtnMouseClicked

    private boolean validateData() {
        if (nameField.getText().isBlank() || imgPathField.getText().isBlank() || jTable1.getSelectedRow() == -1) {
            return false;
        }

        return true;

    }

    private void resetFields() {
        nameField.setText("");
        typeComBox.setSelectedIndex(0);
        priorityComBox.setSelectedIndex(0);
        lvlComBox.setSelectedIndex(0);
        imgPathField.setText("");
        jTable1.clearSelection();
    }

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
            java.util.logging.Logger.getLogger(bugJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bugJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bugJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bugJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bugJframe(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField imgPathField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox<String> lvlComBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JComboBox<String> priorityComBox;
    private javax.swing.JButton selectBtn;
    private javax.swing.JComboBox<String> typeComBox;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}