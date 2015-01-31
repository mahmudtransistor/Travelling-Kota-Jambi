package id.mahmud.travellingjambi.slidermenu;

public class RowItemTravelling {
	private int gambar;
	private String nama_travelling;
	private String keterangan;
	
	public RowItemTravelling(){
		
	}
	public RowItemTravelling(int gambar, String nama_travelling, String keterangan){
		super();
		this.gambar = gambar;
		this.nama_travelling = nama_travelling;
		this.keterangan = keterangan;
	}
	public int getGambar() {
		return gambar;
	}
	public void setGambar(int gambar) {
		this.gambar = gambar;
	}
	public String getNama_travelling() {
		return nama_travelling;
	}
	public void setNama_travelling(String nama_travelling) {
		this.nama_travelling = nama_travelling;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	

}
