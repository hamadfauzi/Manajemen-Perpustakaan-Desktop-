package Controller;

import GUI.*;
import Model.Admin;
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

public class Con_TambahItem implements ActionListener {
    TambahItem tambah_item;
    Con_MenuAdmin menu;
    Con_EditItem editItem;
    private String kategori;
    Connection koneksi = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Con_TambahItem() {
        tambah_item = new TambahItem();
        tambah_item.setLocationRelativeTo(null);
        tambah_item.setVisible(true);
        tambah_item.setActionListener(this);
        koneksi = Koneksi.KoneksiDB();
        viewDataItem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(tambah_item.getButtonAddItem())){
            btnAddItemActionListener(e);
        }
        if(e.getSource().equals(tambah_item.getButtonCancelItem())){
            btnCancelItemActionListener(e);
        }
        if(e.getSource().equals(tambah_item.getButtonEditItem())){
            tambah_item.setVisible(true);
            editItem = new Con_EditItem();
        }
    }

    private void btnAddItemActionListener(ActionEvent evt) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            koneksi = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tubespbo","tubespbo");
            String query = "insert into item(iditm,kategori,judul,penerbit,jumlah)values(?,?,?,?,?)";
            pst = koneksi.prepareStatement(query);
            pst.setString(1,tambah_item.getTextFieldIDItem().getText());
            if(tambah_item.getKategoriBukuItem().isSelected()){
                kategori = "Buku";
            }
            if(tambah_item.getKategoriCDItem().isSelected()){
                kategori = "CD";
            }
            pst.setString(2,kategori);
            
            pst.setString(3, tambah_item.getTextFieldJudulItem().getText());
            pst.setString(4, tambah_item.getTextFieldPenerbitItem().getText());
            pst.setString(5, tambah_item.gettextFieldJumlahItem().getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di add");
            viewDataItem();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
           
        }
    }

    private void btnCancelItemActionListener(ActionEvent e) {
        tambah_item.setVisible(false);
        menu = new Con_MenuAdmin();
    }

    private void viewDataItem() {
        DefaultTableModel TabelItem = new DefaultTableModel();
        TabelItem.addColumn("ID Item");
        TabelItem.addColumn("Kategori");
        TabelItem.addColumn("Judul");
        TabelItem.addColumn("Penerbit");
        TabelItem.addColumn("Jumlah");
        
        
        try{
            String sql = "Select * From item ORDER BY iditm";
            pst = koneksi.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next()){
                TabelItem.addRow(new Object[]{
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                });
            }
            tambah_item.getTabelItem().setModel(TabelItem);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data yang dicari tidak ada !!!!");
                    
        }
    }
    
}
