package tr.com.burak.types;

import java.sql.Date;

public class StockContract {

	private int id;
	private int personelId;
	private int urunId;
	private String tarih;
	private int adet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public int getUrunId() {
		return urunId;
	}

	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String date) {
		this.tarih = date;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + personelId + " " + urunId + " " + adet + " " + tarih;
	}

}
