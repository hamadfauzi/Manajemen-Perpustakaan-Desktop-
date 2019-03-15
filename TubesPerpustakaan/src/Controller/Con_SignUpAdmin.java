package Controller;

import GUI.SignUpAdmin;
import Model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Con_SignUpAdmin implements ActionListener{
    Connection koneksi = null;
    ResultSet rs = null;
    
    PreparedStatement pst = null;
    
    SignUpAdmin signup;
    Con_LoginAdmin login;
    public Con_SignUpAdmin(){
        signup = new SignUpAdmin();
        signup.setLocationRelativeTo(null);
        signup.setVisible(true);
        signup.setActionListener(this);
        koneksi = Koneksi.KoneksiDB();
        viewDataAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(signup.getBtnAddAdmin())){
            btnAddAdminActionListener(e);
        }
        if(e.getSource().equals(signup.getBtnCancelAdmin())){
            btnCancelAdminActionListener(e);
        }
    }

    private void btnAddAdminActionListener(ActionEvent evt) {       
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            
            koneksi = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tubespbo","tubespbo");
            String query = "insert into admin(idadm,namaadm,username,password)values(?,?,?,?)";
            pst = koneksi.prepareStatement(query);
            pst.setString(1,signup.getTextFieldIDAdmin().getText());
            pst.setString(2,signup.getTextFieldNamaAdmin().getText());
            
            pst.setString(3, signup.getTextFieldUsername().getText());
            pst.setString(4, signup.getTextFieldPassword().getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di add");
            viewDataAdmin();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
           
        }
    }

    private void btnCancelAdminActionListener(ActionEvent e) {
        signup.setVisible(false);
        login = new Con_LoginAdmin();
    }

    private void viewDataAdmin() {
        DefaultTableModel TabelAdmin = new DefaultTableModel();
        TabelAdmin.addColumn("ID ");
        TabelAdmin.addColumn("Nama");
        TabelAdmin.addColumn("Username");
        
        
        try{
            String sql = "Select * From Admin ORDER BY idAdm";
            pst = koneksi.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                TabelAdmin.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                });
            }
            signup.getTabelAdmin().setModel(TabelAdmin);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada !!!!");
                    
        }
    }
}
