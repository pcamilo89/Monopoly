/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TableroViewController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Ramiro
 */
public class TableroView extends javax.swing.JFrame {
    /**
     * Creates new form TableroView
     */
    public TableroView() {
        initComponents();
        TableroViewController.load(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Center = new javax.swing.JPanel();
        Panel_Tablero = new javax.swing.JPanel();
        Label_P1 = new javax.swing.JLabel();
        Label_P2 = new javax.swing.JLabel();
        Label_P3 = new javax.swing.JLabel();
        Label_P4 = new javax.swing.JLabel();
        Label_Tablero = new javax.swing.JLabel();
        Label_CGO = new javax.swing.JPanel();
        Label_CJail = new javax.swing.JPanel();
        Label_CFree = new javax.swing.JPanel();
        Label_CGoto = new javax.swing.JPanel();
        Panel_Left = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Player_lbl = new javax.swing.JLabel();
        Turno_lbl = new javax.swing.JLabel();
        Panel_Dados = new javax.swing.JPanel();
        Label_Dado1 = new javax.swing.JLabel();
        Label_Dado2 = new javax.swing.JLabel();
        Button_Throw = new javax.swing.JButton();
        Panel_ChatContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        Panel_Center.setPreferredSize(new java.awt.Dimension(674, 700));

        Panel_Tablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Panel_Tablero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_P1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/carr.png"))); // NOI18N
        Panel_Tablero.add(Label_P1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 40, 30));

        Label_P2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hat.png"))); // NOI18N
        Panel_Tablero.add(Label_P2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 40, 30));

        Label_P3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dog.png"))); // NOI18N
        Panel_Tablero.add(Label_P3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 40, 30));

        Label_P4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dedal.png"))); // NOI18N
        Panel_Tablero.add(Label_P4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 30, -1));

        Label_Tablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/tabmonpoly.png"))); // NOI18N
        Panel_Tablero.add(Label_Tablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout Label_CGOLayout = new javax.swing.GroupLayout(Label_CGO);
        Label_CGO.setLayout(Label_CGOLayout);
        Label_CGOLayout.setHorizontalGroup(
            Label_CGOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Label_CGOLayout.setVerticalGroup(
            Label_CGOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Panel_Tablero.add(Label_CGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 90, 90));

        javax.swing.GroupLayout Label_CJailLayout = new javax.swing.GroupLayout(Label_CJail);
        Label_CJail.setLayout(Label_CJailLayout);
        Label_CJailLayout.setHorizontalGroup(
            Label_CJailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Label_CJailLayout.setVerticalGroup(
            Label_CJailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Panel_Tablero.add(Label_CJail, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 90, 90));

        javax.swing.GroupLayout Label_CFreeLayout = new javax.swing.GroupLayout(Label_CFree);
        Label_CFree.setLayout(Label_CFreeLayout);
        Label_CFreeLayout.setHorizontalGroup(
            Label_CFreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Label_CFreeLayout.setVerticalGroup(
            Label_CFreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Panel_Tablero.add(Label_CFree, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 90, 90));

        javax.swing.GroupLayout Label_CGotoLayout = new javax.swing.GroupLayout(Label_CGoto);
        Label_CGoto.setLayout(Label_CGotoLayout);
        Label_CGotoLayout.setHorizontalGroup(
            Label_CGotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        Label_CGotoLayout.setVerticalGroup(
            Label_CGotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        Panel_Tablero.add(Label_CGoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 90));

        javax.swing.GroupLayout Panel_CenterLayout = new javax.swing.GroupLayout(Panel_Center);
        Panel_Center.setLayout(Panel_CenterLayout);
        Panel_CenterLayout.setHorizontalGroup(
            Panel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
            .addGroup(Panel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_CenterLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Panel_CenterLayout.setVerticalGroup(
            Panel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 938, Short.MAX_VALUE)
            .addGroup(Panel_CenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_CenterLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Panel_Tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(Panel_Center, java.awt.BorderLayout.CENTER);

        Panel_Left.setPreferredSize(new java.awt.Dimension(400, 650));
        Panel_Left.setLayout(new java.awt.BorderLayout());

        Player_lbl.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N

        Turno_lbl.setText("Es el turno de:");

        Label_Dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dado1.png"))); // NOI18N
        Panel_Dados.add(Label_Dado1);

        Label_Dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dado2.png"))); // NOI18N
        Panel_Dados.add(Label_Dado2);

        Button_Throw.setText("texto aqui");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Panel_Dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addComponent(Turno_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(Button_Throw)
                                    .addGap(91, 91, 91))
                                .addComponent(Player_lbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Player_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(105, 105, 105)
                    .addComponent(Button_Throw)
                    .addGap(18, 18, 18)
                    .addComponent(Panel_Dados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(82, 82, 82)
                    .addComponent(Turno_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        Panel_Left.add(jPanel1, java.awt.BorderLayout.CENTER);

        Panel_ChatContainer.setBackground(new java.awt.Color(245, 245, 245));
        Panel_ChatContainer.setPreferredSize(new java.awt.Dimension(400, 200));
        Panel_ChatContainer.setLayout(new java.awt.BorderLayout());
        Panel_Left.add(Panel_ChatContainer, java.awt.BorderLayout.SOUTH);

        getContentPane().add(Panel_Left, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JLabel GetPlayer(){
        return(Player_lbl);
    }
    
    public JLabel GetTurno(){
        return(Turno_lbl);
    }
    
    public JLabel GetDado1(){
        return(Label_Dado1);
    }
    
    public JLabel GetDado2(){
        return(Label_Dado2);
    }
    
    public JButton GetButton_Throw(){
        return(Button_Throw);
    }
    
    public JLabel GetP1()
    {
        return Label_P1;
    }
    
    public JLabel GetP2()
    {
        return Label_P2;
    }
    
    public JLabel GetP3()
    {
        return Label_P3;
    }
    
    public JLabel GetP4()
    {
        return Label_P4;
    }
    
    public JLabel getPlayerByIndex(int index){
        if (index == 1){
            return Label_P1;
        }
        else if (index == 2){
            return Label_P2;
        }
        else if (index == 3){
            return Label_P3;
        }
        else if (index == 4){
            return Label_P4;
        }
        return null;
    }
    
    public void SetP1Location(int x,int y)
    {
        Label_P1.setLocation(x,y);
    }
    
    public void SetP2Location(int x,int y)
    {
        Label_P2.setLocation(x,y);
    }
    
    public void SetP3Location(int x,int y)
    {
        Label_P3.setLocation(x,y);
    }
    
    public void SetP4Location(int x,int y)
    {
        Label_P4.setLocation(x,y);
    }    
    
    public int GetGox(){
        return(Label_CGO.getX());
    }
    
    public int GetGoy()
    {
        return(Label_CGO.getY());
    }
    
    public int GetFreex(){
        return(Label_CFree.getX());
    }
    public int GetFreey(){
        return(Label_CFree.getY());
    }
    
    public int GetGotox(){
        return(Label_CGoto.getX());
    }
    
    public int GetGotoy(){
        return(Label_CGoto.getY());
    }
    
    public int GetJailx(){
        return(Label_CJail.getX());
    }
    
    public int GetJaily(){
        return(Label_CJail.getY());
    }

    public JPanel getPanel_Tablero() {
        return Panel_Tablero;
    }

    public JPanel getPanel_ChatContainer() {
        return Panel_ChatContainer;
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Throw;
    private javax.swing.JPanel Label_CFree;
    private javax.swing.JPanel Label_CGO;
    private javax.swing.JPanel Label_CGoto;
    private javax.swing.JPanel Label_CJail;
    private javax.swing.JLabel Label_Dado1;
    private javax.swing.JLabel Label_Dado2;
    private javax.swing.JLabel Label_P1;
    private javax.swing.JLabel Label_P2;
    private javax.swing.JLabel Label_P3;
    private javax.swing.JLabel Label_P4;
    private javax.swing.JLabel Label_Tablero;
    private javax.swing.JPanel Panel_Center;
    private javax.swing.JPanel Panel_ChatContainer;
    private javax.swing.JPanel Panel_Dados;
    private javax.swing.JPanel Panel_Left;
    private javax.swing.JPanel Panel_Tablero;
    private javax.swing.JLabel Player_lbl;
    private javax.swing.JLabel Turno_lbl;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
