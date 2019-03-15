package Model;

import Model.Item;
import Model.Denda;
import Model.Anggota;
import Model.Admin;
import java.util.Date;

public class Transaksi {
	private String idTransaksi;
	private Admin admin;
	private Anggota anggota;
	private Item item;
	private Date TglPinjam,TglKembali;
	private boolean SudahKembali;
	private Denda dendaOptional;
	
	public Transaksi(Admin admin,Anggota anggota,Item item){
		this.admin = admin;
		this.anggota = anggota;
		this.item = item;
	}

    
	public Admin getAdmin() {
		return admin;
	}
	public Anggota getAnggota() {
		return anggota;
	}
	public Item getItem() {
		return item;
	}
	public Date getTglPinjam() {
		return TglPinjam;
	}
	public Date getTglKembali() {
		return TglKembali;
	}
	public boolean getSudahKembali(){
		return SudahKembali;
	}
	public Denda getDendaOptional() {
		dendaOptional = new Denda();
		return dendaOptional;
	}
	
}
