/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.ClientViewController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Camilo
 */
public class ClientView extends javax.swing.JFrame {

    /**
     * Creates new form ClientView
     */
    public ClientView() {
        initComponents();
        ClientViewController.load(this);
    }

    public JButton getjBLogin() {
        return jBLogin;
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

    public JTextField getjTFUsername() {
        return jTFUsername;
    }

    public JButton getjBConnect() {
        return jBConnect;
    }

    public JLabel getjLServerIP() {
        return jLServerIP;
    }

    public JLabel getjLServerPort() {
        return jLServerPort;
    }

    public JTextField getjTFServerIP() {
        return jTFServerIP;
    }

    public JTextField getjTFServerPort() {
        return jTFServerPort;
    }

    public JLabel getjLInfo() {
        return jLInfo;
    }

    public JButton getjBDisconnect() {
        return jBDisconnect;
    }

    public JPanel getjPChat() {
        return jPChat;
    }

    public JButton getjBLogout() {
        return jBLogout;
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
        jPEast = new javax.swing.JPanel();
        jPConnect = new javax.swing.JPanel();
        jLServerIP = new javax.swing.JLabel();
        jTFServerIP = new javax.swing.JTextField();
        jLServerPort = new javax.swing.JLabel();
        jTFServerPort = new javax.swing.JTextField();
        jPConnectButtons = new javax.swing.JPanel();
        jBConnect = new javax.swing.JButton();
        jBDisconnect = new javax.swing.JButton();
        jPLoginForm = new javax.swing.JPanel();
        jLUsername = new javax.swing.JLabel();
        jTFUsername = new javax.swing.JTextField();
        jLPassword = new javax.swing.JLabel();
        jPFPassword = new javax.swing.JPasswordField();
        jPLoginButtons = new javax.swing.JPanel();
        jBLogin = new javax.swing.JButton();
        jBLogout = new javax.swing.JButton();
        jPBottom = new javax.swing.JPanel();
        jLInfo = new javax.swing.JLabel();
        jPChat = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 350));
        setPreferredSize(new java.awt.Dimension(600, 360));

        jPMain.setMinimumSize(new java.awt.Dimension(0, 0));
        jPMain.setPreferredSize(new java.awt.Dimension(0, 0));
        jPMain.setLayout(new java.awt.BorderLayout(2, 2));

        jPEast.setMinimumSize(new java.awt.Dimension(210, 186));
        jPEast.setPreferredSize(new java.awt.Dimension(210, 186));
        jPEast.setLayout(new javax.swing.BoxLayout(jPEast, javax.swing.BoxLayout.PAGE_AXIS));

        java.awt.GridBagLayout jPConnectLayout = new java.awt.GridBagLayout();
        jPConnectLayout.columnWidths = new int[] {0, 6, 0};
        jPConnectLayout.rowHeights = new int[] {0, 6, 0, 6, 0};
        jPConnect.setLayout(jPConnectLayout);

        jLServerIP.setText("jLabel1");
        jLServerIP.setMaximumSize(new java.awt.Dimension(99999999, 40));
        jLServerIP.setMinimumSize(new java.awt.Dimension(40, 30));
        jLServerIP.setPreferredSize(new java.awt.Dimension(40, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        jPConnect.add(jLServerIP, gridBagConstraints);

        jTFServerIP.setText("jTextField1");
        jTFServerIP.setMinimumSize(new java.awt.Dimension(60, 30));
        jTFServerIP.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        jPConnect.add(jTFServerIP, gridBagConstraints);

        jLServerPort.setText("jLabel2");
        jLServerPort.setMaximumSize(new java.awt.Dimension(99999999, 40));
        jLServerPort.setMinimumSize(new java.awt.Dimension(40, 30));
        jLServerPort.setPreferredSize(new java.awt.Dimension(40, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 40;
        jPConnect.add(jLServerPort, gridBagConstraints);

        jTFServerPort.setText("jTextField2");
        jTFServerPort.setMinimumSize(new java.awt.Dimension(60, 30));
        jTFServerPort.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 40;
        jPConnect.add(jTFServerPort, gridBagConstraints);

        jBConnect.setText("jButton1");
        jPConnectButtons.add(jBConnect);

        jBDisconnect.setText("jButton2");
        jPConnectButtons.add(jBDisconnect);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        jPConnect.add(jPConnectButtons, gridBagConstraints);

        jPEast.add(jPConnect);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 6, 0};
        jPanel1Layout.rowHeights = new int[] {0, 6, 0, 6, 0};
        jPLoginForm.setLayout(jPanel1Layout);

        jLUsername.setText("jLabel1");
        jLUsername.setMaximumSize(new java.awt.Dimension(60, 30));
        jLUsername.setMinimumSize(new java.awt.Dimension(40, 30));
        jLUsername.setPreferredSize(new java.awt.Dimension(40, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        jPLoginForm.add(jLUsername, gridBagConstraints);

        jTFUsername.setText("jTextField1");
        jTFUsername.setMaximumSize(new java.awt.Dimension(999999, 30));
        jTFUsername.setMinimumSize(new java.awt.Dimension(60, 30));
        jTFUsername.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        jPLoginForm.add(jTFUsername, gridBagConstraints);

        jLPassword.setText("jLabel2");
        jLPassword.setMaximumSize(new java.awt.Dimension(60, 30));
        jLPassword.setMinimumSize(new java.awt.Dimension(40, 30));
        jLPassword.setPreferredSize(new java.awt.Dimension(40, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 40;
        jPLoginForm.add(jLPassword, gridBagConstraints);

        jPFPassword.setText("jPasswordField1");
        jPFPassword.setMaximumSize(new java.awt.Dimension(60, 30));
        jPFPassword.setMinimumSize(new java.awt.Dimension(60, 30));
        jPFPassword.setPreferredSize(new java.awt.Dimension(60, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 39;
        jPLoginForm.add(jPFPassword, gridBagConstraints);

        jBLogin.setText("jButton1");
        jPLoginButtons.add(jBLogin);

        jBLogout.setText("jButton2");
        jPLoginButtons.add(jBLogout);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        jPLoginForm.add(jPLoginButtons, gridBagConstraints);

        jPEast.add(jPLoginForm);

        jPMain.add(jPEast, java.awt.BorderLayout.EAST);

        jLInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLInfo.setText("jLabel1");
        jLInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLInfo.setMaximumSize(new java.awt.Dimension(99999999, 40));
        jLInfo.setMinimumSize(new java.awt.Dimension(34, 30));
        jLInfo.setPreferredSize(new java.awt.Dimension(400, 30));
        jPBottom.add(jLInfo);

        jPMain.add(jPBottom, java.awt.BorderLayout.SOUTH);

        jPChat.setMinimumSize(new java.awt.Dimension(400, 0));
        jPChat.setPreferredSize(new java.awt.Dimension(400, 0));
        jPChat.setLayout(new java.awt.BorderLayout());
        jPMain.add(jPChat, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBConnect;
    private javax.swing.JButton jBDisconnect;
    private javax.swing.JButton jBLogin;
    private javax.swing.JButton jBLogout;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JLabel jLServerIP;
    private javax.swing.JLabel jLServerPort;
    private javax.swing.JLabel jLUsername;
    private javax.swing.JPanel jPBottom;
    private javax.swing.JPanel jPChat;
    private javax.swing.JPanel jPConnect;
    private javax.swing.JPanel jPConnectButtons;
    private javax.swing.JPanel jPEast;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JPanel jPLoginButtons;
    private javax.swing.JPanel jPLoginForm;
    private javax.swing.JPanel jPMain;
    private javax.swing.JTextField jTFServerIP;
    private javax.swing.JTextField jTFServerPort;
    private javax.swing.JTextField jTFUsername;
    // End of variables declaration//GEN-END:variables
}
