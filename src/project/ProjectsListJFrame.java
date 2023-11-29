/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import javax.swing.*;


import dataTypes.User;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import utils.SessionStorage;
import utils.fileObj.CRUD.*;


public class ProjectsListJFrame extends javax.swing.JFrame {

 
    public ProjectsListJFrame() {
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
        jPanel2 = new javax.swing.JPanel();
        NewBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        detailsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Projects list");

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
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        initTable();

        NewBtn.setText("New");
        if(((User)SessionStorage.getData()).is("Admin"))
        NewBtn.setEnabled(true);
        NewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewBtnMouseClicked(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.setEnabled(false);
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(deleteBtn))
        );

        detailsBtn.setText("Details");
        detailsBtn.setEnabled(false);
        detailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailsBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsBtn))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(detailsBtn)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void checkAuth(){
        if(!((User) SessionStorage.getData()).is("Admin")){
    
            jPanel2.removeAll();

            jPanel1.remove(jPanel2);

            revalidate();
            repaint();
}
    }
    
    private void initTable(){
    
        try{           
            User u = ((User)SessionStorage.getData());
            
            ArrayList<dataTypes.Project> projectsList;
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            
            if(u.role.equals("Admin")){
                ProjectF projectFile = new ProjectF();
                
                projectsList = projectFile.get((project)->project.admin_id.equals(u.getId()));
            }else{
                ProjectMemberF projectMembersFile  = new ProjectMemberF();
                
                projectsList = projectMembersFile.getProjects(u.getId());
            }
            
            for(dataTypes.Project project: projectsList){
                model.addRow(new Object[]{ project.getId().intValue(), project.name });
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    private void NewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewBtnMouseClicked
        new ProjectJFrame().setVisible(true);
    }//GEN-LAST:event_NewBtnMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        if(!detailsBtn.isEnabled() && evt.getClickCount() == 1) detailsBtn.setEnabled(true);
        
        if (evt.getClickCount() == 1) {
            deleteBtn.setEnabled(true);
        }else if(evt.getClickCount() == 2){
            new bug.BugsListJFrame().setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
            if(deleteBtn.isEnabled()){
                
                try{
                    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                
                    ProjectF projectFile = new ProjectF();
                    
                    int sRow = jTable1.getSelectedRow();
                    int sCol = jTable1.getSelectedColumn();
                    
                    
                    projectFile.delete((project) -> project.getId().equals(jTable1.getValueAt(sRow, 0)));
                    
                    model.removeRow(sRow);
            
                    deleteBtn.setEnabled(false);
                    detailsBtn.setEnabled(false);
                }catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }

    }//GEN-LAST:event_deleteBtnMouseClicked

    private void detailsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailsBtnMouseClicked
            if(detailsBtn.isEnabled()) new ProjectDetailsJFrame().setVisible(true);
    }//GEN-LAST:event_detailsBtnMouseClicked

    
    public static void addToTable(Object data[]){
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        model.addRow(data);
        
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
            java.util.logging.Logger.getLogger(ProjectsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectsListJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectsListJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NewBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton detailsBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
