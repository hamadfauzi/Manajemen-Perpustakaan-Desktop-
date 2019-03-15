package Controller;

import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Con_MenuAdmin implements ActionListener{
    MenuAdmin menu;
    Con_LoginAdmin login;
    Con_TambahAnggota tambahanggota;
    Con_TambahItem tambahitem;
    Con_Transaksi transaksi;
    public Con_MenuAdmin(){
        menu = new MenuAdmin();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        menu.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(menu.getButtonLogout())){
            menu.setVisible(false);
            login = new Con_LoginAdmin();
        }
        if(e.getSource().equals(menu.getButtonTambahItem())){
            menu.setVisible(false);
            tambahitem = new Con_TambahItem();
        }
        if(e.getSource().equals(menu.getButtonTambahAnggota())){
            menu.setVisible(false);
            tambahanggota = new Con_TambahAnggota();
        }
        if(e.getSource().equals(menu.getButtonTransaksi())){
            menu.setVisible(false);
            transaksi = new Con_Transaksi();
        }
        
    }
}
