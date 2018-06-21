/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import controller.ServerViewController;

/**
 *
 * @author Camilo
 */
public class ServerView extends javax.swing.JFrame {

    /**
     * Creates new form ServerView
     */
    public ServerView() {
        initComponents();
        ServerViewController.load(this);
    }

    public JButton getjBSend() {
        return jBSend;
    }

    public JTextField getjTFInput() {
        return jTFInput;
    }

    public JTextPane getjTPTerminal() {
        return jTPTerminal;
    }

    public JButton getjBAdminUsers() {
        return jBAdminUsers;
    }

    public JButton getjBStartServer() {
        return jBStartServer;
    }

    public JTextField getjTFPort() {
        return jTFPort;
    }

    public JButton getjBStartGame() {
        return jBStartGame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMain = new javax.swing.JPanel();
        jPCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPTerminal = new javax.swing.JTextPane();
        jTFInput = new javax.swing.JTextField();
        jBSend = new javax.swing.JButton();
        jPBottom = new javax.swing.JPanel();
        jPUserAdmin = new javax.swing.JPanel();
        jBAdminUsers = new javax.swing.JButton();
        jBStartGame = new javax.swing.JButton();
        jPServerAdmin = new javax.swing.JPanel();
        jTFPort = new javax.swing.JTextField();
        jBStartServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(370, 385));

        jPMain.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jTPTerminal);

        jTFInput.setText("jTextField1");

        jBSend.setText("jButton1");
        jBSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCenterLayout = new javax.swing.GroupLayout(jPCenter);
        jPCenter.setLayout(jPCenterLayout);
        jPCenterLayout.setHorizontalGroup(
            jPCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPCenterLayout.createSequentialGroup()
                        .addComponent(jTFInput, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSend)))
                .addContainerGap())
        );
        jPCenterLayout.setVerticalGroup(
            jPCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFInput)
                    .addComponent(jBSend, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPMain.add(jPCenter, java.awt.BorderLayout.CENTER);

        jPBottom.setLayout(new java.awt.GridLayout(0, 1));

        jBAdminUsers.setText("jButton1");
        jBAdminUsers.setMaximumSize(new java.awt.Dimension(80, 30));
        jBAdminUsers.setMinimumSize(new java.awt.Dimension(80, 30));
        jBAdminUsers.setPreferredSize(new java.awt.Dimension(80, 30));
        jPUserAdmin.add(jBAdminUsers);

        jBStartGame.setText("jButton1");
        jBStartGame.setMaximumSize(new java.awt.Dimension(120, 30));
        jBStartGame.setMinimumSize(new java.awt.Dimension(80, 30));
        jBStartGame.setPreferredSize(new java.awt.Dimension(120, 30));
        jPUserAdmin.add(jBStartGame);

        jPBottom.add(jPUserAdmin);

        jTFPort.setText("jTextField1");
        jTFPort.setMinimumSize(new java.awt.Dimension(6, 30));
        jTFPort.setPreferredSize(new java.awt.Dimension(80, 30));
        jPServerAdmin.add(jTFPort);

        jBStartServer.setText("jButton4");
        jBStartServer.setMaximumSize(new java.awt.Dimension(999999, 9999999));
        jBStartServer.setMinimumSize(new java.awt.Dimension(73, 30));
        jBStartServer.setPreferredSize(new java.awt.Dimension(90, 30));
        jPServerAdmin.add(jBStartServer);

        jPBottom.add(jPServerAdmin);

        jPMain.add(jPBottom, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSendActionPerformed
        //
    }//GEN-LAST:event_jBSendActionPerformed

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
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdminUsers;
    private javax.swing.JButton jBSend;
    private javax.swing.JButton jBStartGame;
    private javax.swing.JButton jBStartServer;
    private javax.swing.JPanel jPBottom;
    private javax.swing.JPanel jPCenter;
    private javax.swing.JPanel jPMain;
    private javax.swing.JPanel jPServerAdmin;
    private javax.swing.JPanel jPUserAdmin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFInput;
    private javax.swing.JTextField jTFPort;
    private javax.swing.JTextPane jTPTerminal;
    // End of variables declaration//GEN-END:variables
}
