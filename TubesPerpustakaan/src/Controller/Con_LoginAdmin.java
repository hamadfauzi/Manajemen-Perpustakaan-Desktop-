package Controller;

import GUI.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;

public class Con_LoginAdmin implements ActionListener {
    LoginAdmin login;
    List<Admin> listadmin = new ArrayList<Admin>();
    Koneksi db;
    Con_SignUpAdmin signup;
    Con_MenuAdmin menu;
    public Con_LoginAdmin(){
        login = new LoginAdmin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        login.setActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(login.getBtnLogin())){
            btnLoginActionListener(e);
        }
        if(e.getSource().equals(login.getBtnSignUp())){
            btnSignUpActionListener(e);
        }
    }

    private void btnSignUpActionListener(ActionEvent e) {
        login.setVisible(false);
        signup = new Con_SignUpAdmin();
    }

    private void btnLoginActionListener(ActionEvent e) {
        String username = login.getTextFieldUsername().getText();
        String Password = login.getTextFieldPassword().getText();
        listadmin = Koneksi.getAdminList();
        for(Admin p:listadmin){
            if(p.getUsername().equals(username)){
                if(p.getPassword().equals(Password)){
                    login.setVisible(false);
                    menu = new Con_MenuAdmin();
                }else{
                    JOptionPane.showMessageDialog(null,"Username dan Password Salah");
                }
                    
            }
            
        }
        
        /*if(username.equals("ADMIN")){
            if(Password.equals("ADMIN")){
                login.setVisible(false);
                menu = new Con_MenuAdmin();
            }
        }*/
        
    }
}
