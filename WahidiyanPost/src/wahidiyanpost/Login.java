/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wahidiyanpost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo - GK
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    public ResultSet rs;
    
    public Login() {
        initComponents();
    }
    
    public static int ID;
    public static String usern;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusername = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(400, 330));
        getContentPane().setLayout(null);
        getContentPane().add(txtusername);
        txtusername.setBounds(162, 91, 186, 22);

        btnlogin.setBackground(new java.awt.Color(0, 153, 204));
        btnlogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin);
        btnlogin.setBounds(276, 159, 72, 23);

        jLabel3.setText("Belum Punya Akun ?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 220, 160, 16);

        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("Daftar Disini");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 240, 90, 16);
        getContentPane().add(txtpassword);
        txtpassword.setBounds(162, 125, 186, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Username");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(57, 94, 80, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(57, 128, 70, 16);

        jPanel1.setBackground(java.awt.SystemColor.info);

        jLabel1.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("LOG IN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 300);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Username");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(57, 94, 80, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Username");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(57, 94, 80, 16);

        jLabel9.setText("Belum Punya Akun ?");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 220, 160, 16);

        jLabel10.setText("Belum Punya Akun ?");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 220, 160, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Register register = new Register();
        register.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        String usn,pw;
        
        usn = txtusername.getText();
        pw = new String(txtpassword.getPassword());
        
        try {
            Connection conn = koneksi.getConnection();
            String sql = "SELECT * FROM akun WHERE username = ? AND password = ? LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usn);
            stmt.setString(2, pw);

            rs = stmt.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("id_akun");
                usern = rs.getString("username");
                JOptionPane.showMessageDialog(this, "Selamat Datang " + usn.toUpperCase() + " !", "SQL Information", JOptionPane.INFORMATION_MESSAGE);
                if(rs.getBoolean("penulis") == true){
                    MenuAdmin MA = new MenuAdmin();
                    MA.setVisible(true);
                    dispose();
                    rs.close();
                    stmt.close();
                } else {
                    MenuUser MU = new MenuUser();
                    MU.setVisible(true);
                    dispose();
                    rs.close();
                    stmt.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnloginActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
