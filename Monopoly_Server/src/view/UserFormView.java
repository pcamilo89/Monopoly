/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.UserFormViewController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Camilo
 */
public class UserFormView extends javax.swing.JFrame {

    /**
     * Creates new form UserFormView
     */
    public UserFormView() {
        initComponents();
        UserFormViewController.load(this);
    }

    public JButton getjBCancel() {
        return jBCancel;
    }

    public JButton getjBSave() {
        return jBSave;
    }

    public JLabel getjLLastname() {
        return jLLastname;
    }

    public JLabel getjLName() {
        return jLName;
    }

    public JLabel getjLPassword() {
        return jLPassword;
    }

    public JLabel getjLUsername() {
        return jLUsername;
    }

    public JPasswordField getjPFPassword() {
        return jPFPassword;
    }

    public JTextField getjTFLastname() {
        return jTFLastname;
    }

    public JTextField getjTFName() {
        return jTFName;
    }

    public JTextField getjTFUsername() {
        return jTFUsername;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLName = new javax.swing.JLabel();
        jLLastname = new javax.swing.JLabel();
        jLUsername = new javax.swing.JLabel();
        jLPassword = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jTFLastname = new javax.swing.JTextField();
        jTFUsername = new javax.swing.JTextField();
        jPFPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jBSave = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPMain.setPreferredSize(new java.awt.Dimension(250, 250));

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 6, 0};
        jPanel2Layout.rowHeights = new int[] {0, 6, 0, 6, 0, 6, 0, 6, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLName.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 22;
        jPanel2.add(jLName, gridBagConstraints);

        jLLastname.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 22;
        jPanel2.add(jLLastname, gridBagConstraints);

        jLUsername.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 22;
        jPanel2.add(jLUsername, gridBagConstraints);

        jLPassword.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 22;
        jPanel2.add(jLPassword, gridBagConstraints);

        jTFName.setText("jTextField1");
        jTFName.setMinimumSize(new java.awt.Dimension(6, 30));
        jTFName.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        jPanel2.add(jTFName, gridBagConstraints);

        jTFLastname.setText("jTextField2");
        jTFLastname.setMinimumSize(new java.awt.Dimension(6, 30));
        jTFLastname.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 29;
        jPanel2.add(jTFLastname, gridBagConstraints);

        jTFUsername.setText("jTextField3");
        jTFUsername.setMinimumSize(new java.awt.Dimension(6, 30));
        jTFUsername.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 29;
        jPanel2.add(jTFUsername, gridBagConstraints);

        jPFPassword.setText("jPasswordField1");
        jPFPassword.setMinimumSize(new java.awt.Dimension(6, 30));
        jPFPassword.setPreferredSize(new java.awt.Dimension(6, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 29;
        jPanel2.add(jPFPassword, gridBagConstraints);

        jBSave.setText("jButton1");
        jBSave.setMaximumSize(new java.awt.Dimension(80, 30));
        jBSave.setMinimumSize(new java.awt.Dimension(80, 30));
        jBSave.setPreferredSize(new java.awt.Dimension(80, 30));
        jPanel1.add(jBSave);

        jBCancel.setText("jButton2");
        jBCancel.setMaximumSize(new java.awt.Dimension(80, 30));
        jBCancel.setMinimumSize(new java.awt.Dimension(80, 30));
        jBCancel.setPreferredSize(new java.awt.Dimension(80, 30));
        jPanel1.add(jBCancel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 26;
        jPanel2.add(jPanel1, gridBagConstraints);

        javax.swing.GroupLayout jPMainLayout = new javax.swing.GroupLayout(jPMain);
        jPMain.setLayout(jPMainLayout);
        jPMainLayout.setHorizontalGroup(
            jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPMainLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPMainLayout.setVerticalGroup(
            jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPMainLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jPMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UserFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFormView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBSave;
    private javax.swing.JLabel jLLastname;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLUsername;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JPanel jPMain;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFLastname;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFUsername;
    // End of variables declaration//GEN-END:variables
}
