/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Anggota {
	private String idAnggota,Nama,gender,Alamat,Email,noTelp;
	//idAnggota diisi dibagian mana?
	public Anggota(String idAnggota,String nama,String Alamat,String gender,String Email,String noTelp){
            this.idAnggota = idAnggota;
            this.gender = gender;
            this.Nama = nama;
            this.Alamat = Alamat;
            this.Email = Email;
            this.noTelp = noTelp;
	}
	public String getNama() {
		return Nama;
	}

    public String getIdAnggota() {
        return idAnggota;
    }
        
	public String getNoTelp() {
		return noTelp;
	}
	public String getAlamat() {
		return Alamat;
	}
	public String getEmail() {
		return Email;
	}
	
}
