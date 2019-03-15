/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

public class Buku {
	private String Pengarang,Penerbit,ISBN;
	private int TahunTerbit;
	public Buku(String Pengarang,String Penerbit,String ISBN,int TahunTerbit,String Judul,int Jumlah,Date TglInput){
		this.Pengarang = Pengarang;
		this.Penerbit = Penerbit;
		this.ISBN = ISBN;
		this.TahunTerbit = TahunTerbit;
	
		
	}
	public String getPenerbit() {
		return Penerbit;
	}
	public String getPengarang() {
		return Pengarang;
	}
	public String getISBN() {
		return ISBN;
	}
	public int getTahunTerbit() {
		return TahunTerbit;
	}
}

