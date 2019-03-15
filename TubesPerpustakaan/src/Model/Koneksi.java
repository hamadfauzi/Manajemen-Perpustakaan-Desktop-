/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hamad Fauzi J
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hamad Fauzi J
 */
public class Koneksi {

    private static ResultSet ExecuteQuery(String select__from_Classroom_ORDER_BY_idclass, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public Connection dbKoneksi;
   public Statement Statem;
   public PreparedStatement PStatem;
   
 
   private String url = "oracle.jdbc.driver.OracleDriver";
   private String database = "jdbc:oracle:thin:@localhost:1521:xe";
   private String username = "tubespbo";
   private String password = "tubespbo";
   
   public Koneksi() {
       this.dbKoneksi = null;
}
 
public static Connection KoneksiDB(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection koneksi = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","tubespbo","tubespbo");
            return koneksi;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
}
 
    public Connection BukaKoneksi() {
        try {
             Class.forName(url);
             dbKoneksi = DriverManager.getConnection(database, username, password);
             System.out.println("Berhasil Koneksi");
        }catch (Exception E) {
             E.printStackTrace();
        }
 
        return dbKoneksi;
    }
 
    public void TutupKoneksi() {
        try {
            if (Statem != null) Statem.close();
            if (PStatem != null) PStatem.close();
            if (dbKoneksi != null) dbKoneksi.close();
        }catch (Exception E) {
            throw new RuntimeException(E.getMessage());
        }
    }
    

    /**
     *
     * @return
     */
    public static List<Admin> getAdminList(){
        Connection conn = KoneksiDB();
        ResultSet rs = GetData("Admin", conn);
        List<Admin> listAdmin = new ArrayList<>();
        try {
            while(rs.next()){
                Admin a = new Admin(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4));
                listAdmin.add(a);
            }
            rs.close();
            conn.close();
        } catch (Exception e){
            System.out.println("admin list");
            JOptionPane.showMessageDialog(null, e);
        }
        return listAdmin;
    }
    public static List<Anggota> getListAnggota(){
        Connection conn = KoneksiDB();
        ResultSet rs = GetData("Anggota", conn);
        List<Anggota> listAnggota = new ArrayList<>();
        try {
            while(rs.next()){
                Anggota a = new Anggota(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                listAnggota.add(a);
            }
            rs.close();
            conn.close();
        } catch (Exception e){
            System.out.println("anggota list");
            JOptionPane.showMessageDialog(null, e);
        }
        return listAnggota;
    }
    public static List<Item> getListItem(){
        Connection conn = KoneksiDB();
        ResultSet rs = GetData("Item", conn);
        List<Item> listItem = new ArrayList<>();
        try {
            while(rs.next()){
                Item i = new Item(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)) {};
                listItem.add(i);
            }
            rs.close();
            conn.close();
        } catch (Exception e){
            System.out.println("item list");
            JOptionPane.showMessageDialog(null, e);
        }
        return listItem;
    }
    
    

    public static ResultSet GetData(String tableName, Connection conn){
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+tableName);
            //conn.close();
            return rs;
        } catch (Exception e){
            System.out.println("get data");
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
        
    }

}
