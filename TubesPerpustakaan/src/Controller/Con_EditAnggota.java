package Controller;

import GUI.EditAnggota;
import static Model.Koneksi.KoneksiDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Con_EditAnggota implements ActionListener {
    EditAnggota edit_anggota;
    Con_TambahAnggota tambah;
    Connection koneksi = null;
    ResultSet rs = null;
    
    PreparedStatement pst = null;
    public Con_EditAnggota(){
        koneksi = KoneksiDB();
        edit_anggota = new EditAnggota();
        edit_anggota.setLocationRelativeTo(null);
        edit_anggota.setVisible(true);
        edit_anggota.setActionListener(this);
        tampil_combo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(edit_anggota.getButtonOkAnggota())){
            btnOkAnggotaActionListener(e);
        }
        if(e.getSource().equals(edit_anggota.getButtonCancelEditAnggota())){
            btnCancelEditAnggotaActionListener(e);
        }
        if(e.getSource().equals(edit_anggota.getButtonDeleteAnggota())){
            btnDeleteAnggotaActionListener(e);
        }
    }

    private void btnOkAnggotaActionListener(ActionEvent ev) {
        try{
        String Gender = null;
        String nama = edit_anggota.getTextFieldEditNamaAnggota().getText();
        String id = edit_anggota.getComboBoxIDAnggota().getSelectedItem().toString();
        if(edit_anggota.getEditGenderLakiAnggota().isSelected()){
                Gender = "Laki";
            }
            if(edit_anggota.getEditGenderPerempuanAnggota().isSelected()){
                Gender = "Perempuan";
            }
        String alamat = edit_anggota.getTextFieldEditAlamatAnggota().getText();
        String email = edit_anggota.getTextFieldEmailAnggota().getText();
        String Notelp = edit_anggota.getTextFieldEditNoTelpAnggota().getText();
        
        if(id.length()==6){
             String sql = "UPDATE Anggota SET idagt='"+id+"',"
                    +"namaagt='"+nama+"',"
                    +"Genderagt='"+Gender+"',"+"emailagt='"+email+"',"
                   +"notelpagt='"+Notelp+"',"+"alamatagt='"+alamat+"' WHERE idagt='"+id+"'";
             pst = koneksi.prepareStatement(sql);
             pst.execute();
 
             JOptionPane.showMessageDialog(null, "Data Berhasil di Update !!!");
             edit_anggota.setVisible(false);
             tambah = new Con_TambahAnggota();
        }else if(id.isEmpty())
             JOptionPane.showMessageDialog(null, "ID Anggota tidak boleh kosong  !!!");
        else {
             JOptionPane.showMessageDialog(null, "id Anda Salah !!!");
             edit_anggota.getTextFieldEditNamaAnggota().grabFocus();
       }
  }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Data Gagal di Update !!!");
    }
    }
    private void btnCancelEditAnggotaActionListener(ActionEvent e) {
        edit_anggota.setVisible(false);
        tambah = new Con_TambahAnggota();
    }

    private void btnDeleteAnggotaActionListener(ActionEvent ex) {
        
        try{
            Object id = edit_anggota.getComboBoxIDAnggota().getSelectedItem();
            String sql = "DELETE FROM anggota WHERE IDAGT = ?";
             pst = koneksi.prepareStatement(sql);
             pst.setString(1 , (String) id);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus !!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus !!!");
        }
        
    }
    
    public void tampil_combo()
    {
        try {
        Connection con = KoneksiDB();
        Statement stt = con.createStatement();
        String sql = "select idagt from anggota order by idagt asc";
        ResultSet res = stt.executeQuery(sql);                               
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            edit_anggota.getComboBoxIDAnggota().addItem(ob[0]);                                      // fungsi ini bertugas menampung isi dari database
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
