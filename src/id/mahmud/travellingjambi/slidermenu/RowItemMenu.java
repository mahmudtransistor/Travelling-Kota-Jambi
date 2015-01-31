package id.mahmud.travellingjambi.slidermenu;

public class RowItemMenu {

	private String mamber_name;
	private int poto;
	
	public RowItemMenu(String mamber_name, int poto){
		
		this.mamber_name = mamber_name;
		this.poto= poto;
		
		
	}

	public String getMamber_name() {
		return mamber_name;
	}

	public void setMamber_name(String mamber_name) {
		this.mamber_name = mamber_name;
	}

	public int getPoto() {
		return poto;
	}

	public void setPoto(int poto) {
		this.poto = poto;
	}

	
	
	
}
