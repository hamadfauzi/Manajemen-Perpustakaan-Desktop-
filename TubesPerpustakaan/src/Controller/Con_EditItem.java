package Controller;

import GUI.*;
import static Model.Koneksi.KoneksiDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Con_EditItem implements ActionListener {
    EditItem editItem;
    Con_TambahItem tambahItem;
    Connection koneksi = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public Con_EditItem(){
        editItem = new EditItem();
        editItem.setLocationRelativeTo(null);
        editItem.setVisible(true);
        koneksi = KoneksiDB();
        editItem.setActionListener(this);
        tampil_combo();
    }

    private void tampil_combo() {
       try {
        Connection con = KoneksiDB();
        Statement stt = con.createStatement();
        String sql = "select iditm from item order by iditm asc";
        ResultSet res = stt.executeQuery(sql);                               
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            editItem.getComboBoxIDItem().addItem(ob[0]);                                      // fungsi ini bertugas menampung isi dari database
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(editItem.getButtonCancelEditItem())){
            btnCancelItemActionListener(e);
        }
        if(e.getSource().equals(editItem.getButtonDeleteItem())){
            btnDeleteItemActionListener(e);
        }
        if(e.getSource().equals(editItem.getButtonOkItem())){
            btnOkItemActionListener(e);
        }
    
    
    }

    private void btnOkItemActionListener(ActionEvent ex) {
        try{
        String kategori = null;
        String Judul = editItem.getTextFieldEditJudulItem().getText();
        String id = editItem.getComboBoxIDItem().getSelectedItem().toString();
        if(editItem.getRadioButtonEditBuku().isSelected()){
                kategori = "BUKU";
            }
            if(editItem.getRadioButtonEditCD().isSelected()){
                kategori = "CD";
            }
        String penerbit = editItem.getTextFieldEditPenerbitItem().getText();
        String Jumlah = editItem.getTextFieldEditJumlahItem().getText();
        String sql = "UPDATE item SET iditm='"+id+"',"
                    +"judul='"+Judul+"',"+"jumlah='"+Jumlah+"',"
                    +"kategori='"+kategori+"',"
                    +"penerbit='"+penerbit+"' WHERE iditm='"+id+"'";
        pst = koneksi.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Data Berhasil di Update !!!");
        editItem.setVisible(false);
        tambahItem = new Con_TambahItem();
        if(id.isEmpty())
             JOptionPane.showMessageDialog(null, "ID Anggota tidak boleh kosong  !!!");
        else {
             
             editItem.getTextFieldEditJudulItem().grabFocus();
       }
       }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Data Gagal di Update !!!");
    }
    }

    private void btnDeleteItemActionListener(ActionEvent ex) {
        try{
            Object id = editItem.getComboBoxIDItem().getSelectedItem();
            String sql = "DELETE FROM Item WHERE IDItm = ?";
             pst = koneksi.prepareStatement(sql);
             pst.setString(1 , (String) id);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus !!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus !!!");
        }
    }

    private void btnCancelItemActionListener(ActionEvent e) {
        editItem.setVisible(false);
        tambahItem = new Con_TambahItem();
    }
}
