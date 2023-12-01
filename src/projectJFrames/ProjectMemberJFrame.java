/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectJFrames;


import UserJFrames.CreateUserJFrame;
import dataTypes.User;
import java.util.ArrayList;
import java.util.function.Predicate;
import javax.swing.table.DefaultTableModel;
import utils.SessionStorage;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import messages.JFrameMessage;
import utils.fileObj.CRUD.*;

/**
 *
 * @author ahmed
 */
public class ProjectMemberJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ProjectDetailsJFrame
     */
    public ProjectMemberJFrame() {
        currUser = SessionStorage.getData();
        initComponents();
        checkAuth();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        idField = new javax.swing.JTextPane();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Project Members");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        ProjectMemberJFrame.initTable();

        jLabel1.setText("Members");

        deleteBtn.setText("Delete");
        deleteBtn.setEnabled(false);
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });

        jLabel2.setText("ID");

        idField.setToolTipText("ID");
        idField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idFieldKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(idField);

        addBtn.setText("Add");
        addBtn.setEnabled(false);
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addBtn))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteBtn)
                        .addComponent(jLabel2)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    ;
    
    private void checkAuth() {
        if (!((User) SessionStorage.getData()).is("Admin")) {

            jPanel2.removeAll();

            jPanel1.remove(jPanel2);

            revalidate();
            repaint();

        }

    }

    private static void initTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try {
            ArrayList<dataTypes.User>  members = null;
            ProjectMemberF projectMemberFile = new ProjectMemberF();

            javax.swing.JTable projectsT = ProjectsListJFrame.jTable1;

            members = projectMemberFile.getMembers((int)projectsT.getValueAt(projectsT.getSelectedRow(), 0));
                

            for (dataTypes.User member: members) {
                Object[] data = new Object[]{member.getId().intValue(), member.getName(), member.getEmail(), member.getRole()};

                model.addRow(data);
            }

            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 1 && ((User) SessionStorage.getData()).is("Admin")) {
            deleteBtn.setEnabled(true);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
        System.out.println("Changed");
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        if (addBtn.isEnabled()) {
            try {
                if(Integer.valueOf(idField.getText()).equals(((User) SessionStorage.getData()).getId()))
                    throw new Exception("This is your id");
                addUserToProject(Integer.valueOf(idField.getText()));
                idField.setText("");
                addBtn.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Added successfully", "Added", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JFrameMessage.showErr(e);
            }

        }
    }//GEN-LAST:event_addBtnMouseClicked

    private void idFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idFieldKeyReleased
        if (!idField.getText().equals("") && ((User) SessionStorage.getData()).is("Admin"))
            addBtn.setEnabled(true);
        else
            addBtn.setEnabled(false);
    }//GEN-LAST:event_idFieldKeyReleased

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int sRow = jTable1.getSelectedRow();

        String deletedRole = (String)jTable1.getValueAt(sRow, 3);
        
        
        if (deleteBtn.isEnabled() && !jTable1.getValueAt(sRow, 3).equals("Admin")) {
            try {

                ProjectMemberF projectMemberFile = new ProjectMemberF();
                BugF BugFile = new BugF();

                int sRowProject = ProjectsListJFrame.jTable1.getSelectedRow();
                
                int projectId = (int)ProjectsListJFrame.jTable1.getValueAt(sRowProject, 0);
                
                int deletedMemberId = (int)jTable1.getValueAt(sRow, 0);
                
                ((modules.Admin) currUser).deleteUserFromProject(deletedMemberId, projectId);

                model.removeRow(sRow);

                JOptionPane.showMessageDialog(null, "Deleted Successfully", "Added", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JFrameMessage.showErr(e);
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    public static void addUserToProject(Integer userId) throws Exception{
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int projectId = (int) ProjectsListJFrame.jTable1.getValueAt(ProjectsListJFrame.jTable1.getSelectedRow(), 0);
        
        ((modules.Admin)SessionStorage.getData()).addUserToProject(userId, projectId);
        
        dataTypes.User user = new UserF().getByID(userId);


        model.addRow(new Object[]{user.getId().intValue(), user.getName(), user.getEmail(), user.getRole()});
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
            java.util.logging.Logger.getLogger(ProjectMemberJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectMemberJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectMemberJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectMemberJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectMemberJFrame().setVisible(true);
            }
        });
    }

    
    private static Object currUser;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextPane idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
