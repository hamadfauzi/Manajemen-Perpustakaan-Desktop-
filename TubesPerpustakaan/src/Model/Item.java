package Model;

import java.util.Date;

public abstract class Item {
	protected String ID,Judul,Kategori,Penerbit;
	protected String Jumlah;
	protected Date TglInput;

    public Item(String ID,String Kategori , String Judul, String Penerbit, String Jumlah) {
        this.ID = ID;
        this.Judul = Judul;
        this.Kategori = Kategori;
        this.Penerbit = Penerbit;
        this.Jumlah = Jumlah;
        
    }
	
       
	public void setJudul(String judul) {
		Judul = judul;
	}
	public void setTglInput(Date tglInput) {
		TglInput = tglInput;
	}
	
	public String getJudul() {
		return Judul;
	}
	public String getJumlah() {
		return Jumlah;
	}
	public Date getTglInput() {
		return TglInput;
	}

    public String getID() {
        return ID;
    }
	

	
}