package Controller;

import GUI.*;
import Model.*;
import static Model.Koneksi.KoneksiDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Con_Transaksi implements ActionListener {
    TransaksiF transaksi;
    Con_MenuAdmin menu;
    Connection koneksi = null;
    ResultSet rs = null;
    
    PreparedStatement pst = null;
    public Con_Transaksi() {
        transaksi = new TransaksiF(); 
        koneksi = KoneksiDB();
        transaksi.setLocationRelativeTo(null);
        transaksi.setVisible(true);
        transaksi.setActionListener(this);
        refreshComboBoxAll();
        viewDataTransaksi();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(transaksi.getButtonAddTransaksi())){
            btnAddTransaksiActionListener(e);
        }
        if(e.getSource().equals(transaksi.getButtonCancelTransaksi())){
            btnCancelTransaksiActionListener(e);
        }
    }

    private void btnAddTransaksiActionListener(ActionEvent ex) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            
            koneksi = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tubespbo","tubespbo");
            String query = "insert into transaksi(idtrn,idadm,idagt,iditm,tglpinjam,tglkembali,catatan)values(?,?,?,?,?,?,?)";
            pst = koneksi.prepareStatement(query);
            pst.setString(1,transaksi.getTextFieldIDTransaksi().getText());
            List<Anggota> daftarAnggota = Koneksi.getListAnggota();
            List<Admin> daftarAdmin = Koneksi.getAdminList();
            List<Item> daftarItem = Koneksi.getListItem();
            String namaAdmin = null;
            String namaAnggota = null;
            String namaBarang = null;
            for(Admin a : daftarAdmin){
                if(a.getIdAdmin().equals(transaksi.getComboBoxIDAdminTransaksi().getSelectedItem().toString())){
                    namaAdmin = a.getNamaAdmin();
                }
            }
            for(Anggota a : daftarAnggota){
                if(a.getIdAnggota().equals(transaksi.getComboBoxIDAnggotaTransaksi().getSelectedItem().toString())){
                    namaAnggota = a.getNama();
                }
            }
            for(Item i : daftarItem){
                if(i.getID().equals(transaksi.getComboBoxIDItemTransaksi().getSelectedItem().toString())){
                    namaBarang = i.getJudul();
                }
            }
            
            pst.setString(2,transaksi.getComboBoxIDAdminTransaksi().getSelectedItem().toString());
            pst.setString(3, transaksi.getComboBoxIDAnggotaTransaksi().getSelectedItem().toString());
            pst.setString(4, transaksi.getComboBoxIDItemTransaksi().getSelectedItem().toString());
            pst.setString(5, transaksi.getTextFieldTglPinjamTransaksi().getText());
            pst.setString(6, transaksi.getTextFieldTglKembaliTransaksi().getText());
            pst.setString(7, transaksi.getTextFieldCatatanTransasksi().getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di add");
            viewDataTransaksi();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
           
        }
    }

    private void btnCancelTransaksiActionListener(ActionEvent e) {
        transaksi.setVisible(false);
        menu = new Con_MenuAdmin();
    }

    private void viewDataTransaksi() {
        DefaultTableModel TabelAdmin = new DefaultTableModel();
        TabelAdmin.addColumn("ID Transaksi");
        TabelAdmin.addColumn("ID Admin");
        TabelAdmin.addColumn("ID Peminjam");
        TabelAdmin.addColumn("ID Item");
        TabelAdmin.addColumn("Tanggal Pinjam");
        TabelAdmin.addColumn("Tanggal Kembali");
        TabelAdmin.addColumn("Catatan");
        
        try{
            String sql = "Select * From transaksi ORDER BY idtrn";
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
                rs.getString(7),
               
                });
            }
            transaksi.getTabelTransaksi().setModel(TabelAdmin);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada !!!!");
                    
        }
    }

    private void refreshComboBoxAll() {
        refreshComboBoxIDAnggota();
        refreshComboBoxIDAdmin();
        refreshComboBoxIDItem();
    }

    private void refreshComboBoxIDItem() {
        try {
        Connection con = KoneksiDB();
        Statement stt = con.createStatement();
        String sql = "select iditm from item order by iditm asc";
        ResultSet res = stt.executeQuery(sql);                               
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            transaksi.getComboBoxIDItemTransaksi().addItem(ob[0]);                                      // fungsi ini bertugas menampung isi dari database
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void refreshComboBoxIDAdmin() {
        try {
        Connection con = KoneksiDB();
        Statement stt = con.createStatement();
        String sql = "select idadm from admin order by idadm asc";
        ResultSet res = stt.executeQuery(sql);                               
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            transaksi.getComboBoxIDAdminTransaksi().addItem(ob[0]);                                      // fungsi ini bertugas menampung isi dari database
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void refreshComboBoxIDAnggota() {
        try {
        Connection con = KoneksiDB();
        Statement stt = con.createStatement();
        String sql = "select idagt from anggota order by idagt asc";
        ResultSet res = stt.executeQuery(sql);                               
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            transaksi.getComboBoxIDAnggotaTransaksi().addItem(ob[0]);                                      // fungsi ini bertugas menampung isi dari database
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
