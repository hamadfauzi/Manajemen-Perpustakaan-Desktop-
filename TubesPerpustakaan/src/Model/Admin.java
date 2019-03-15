package Model;

public class Admin {
	private String idAdmin,namaAdmin,Password, Username;
	private boolean Active;
	
	public Admin(String idAdmin,String namaAdmin,String Username,String Password){
		this.idAdmin = idAdmin;
                this.namaAdmin = namaAdmin;
                this.Username = Username;
		setPassword(Password);
	}

    public String getIdAdmin() {
        return idAdmin;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return Username;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }
        
   
	public void setPassword(String Password){
		this.Password = Password;
	}
	
	public void Banned(boolean banned){
		Active = banned;
	}
	
}
