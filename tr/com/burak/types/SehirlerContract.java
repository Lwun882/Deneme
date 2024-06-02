package tr.com.burak.types;

public class SehirlerContract {

	private int id;
	private String sehirAdi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSehirAdi() {
		return sehirAdi;
	}
	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}
	@Override
	public String toString() {
		return "("+id+") "+sehirAdi;
	}
	
	
}
