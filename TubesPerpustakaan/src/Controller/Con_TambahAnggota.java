package Controller;

import GUI.*;

import Model.Koneksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Con_TambahAnggota implements ActionListener{
    TambahAnggota tambah_anggota;
    Con_MenuAdmin menu;
    Con_EditAnggota editanggota;
    String gender;
    Connection koneksi = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Con_TambahAnggota() {
        tambah_anggota = new TambahAnggota();
        tambah_anggota.setLocationRelativeTo(null);
        tambah_anggota.setVisible(true);
        tambah_anggota.setActionListener(this);
        koneksi = Koneksi.KoneksiDB();
        viewDataAnggota();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(tambah_anggota.getButtonAddAnggota())){
            btnAddAnggotaActionListener(e);
        }
        if(e.getSource().equals(tambah_anggota.getButtonCancelAnggota())){
            btnCancelAnggotaActionListener(e);
        }
        if(e.getSource().equals(tambah_anggota.getButtonEditAnggota())){
            btnEditAnggotaActionListener(e);
        }
    }

    private void btnCancelAnggotaActionListener(ActionEvent e) {
        tambah_anggota.setVisible(false);
        menu = new Con_MenuAdmin();
    }

    private void btnAddAnggotaActionListener(ActionEvent ex) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            
            koneksi = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tubespbo","tubespbo");
            String query = "insert into anggota(idagt,namaagt,alamatagt,genderagt,emailagt,notelpagt)values(?,?,?,?,?,?)";
            pst = koneksi.prepareStatement(query);
            pst.setString(1,tambah_anggota.getTextFieldIDAnggota().getText());
            pst.setString(2,tambah_anggota.getTextFieldNamaAnggota().getText());
            if(tambah_anggota.getRadioButtonLakiLaki().isSelected()){
                gender = "Laki";
            }
            if(tambah_anggota.getRadioButtonPerempuan().isSelected()){
                gender = "Perempuan";
            }
            pst.setString(3,tambah_anggota.getTextFieldAlamatAnggota().getText());
            pst.setString(4, gender);
            pst.setString(5, tambah_anggota.getTextFieldEmailAnggota().getText());
            pst.setString(6, tambah_anggota.getTextFieldNoTelpAnggota().getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di add");
            viewDataAnggota();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
           
        }
    }
    
    public void viewDataAnggota(){
        DefaultTableModel TabelAdmin = new DefaultTableModel();
        TabelAdmin.addColumn("ID Anggota");
        TabelAdmin.addColumn("Nama");
        TabelAdmin.addColumn("Alamat");
        TabelAdmin.addColumn("Gender");
        TabelAdmin.addColumn("Email");
        TabelAdmin.addColumn("NoTelp");
        
        
        try{
            String sql = "Select * From Anggota ORDER BY idAgt";
            pst = koneksi.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                TabelAdmin.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                });
            }
            tambah_anggota.getTabelAnggota().setModel(TabelAdmin);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada !!!!");
                    
        }
    }

    private void btnEditAnggotaActionListener(ActionEvent e) {
        tambah_anggota.setVisible(false);
        editanggota = new Con_EditAnggota();
    }
    
}
