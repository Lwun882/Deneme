package tr.com.burak.types;

public class KategoriContract {

	private int id;
	private String Adi;
	private int ParentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return Adi;
	}

	public void setAdi(String Adi) {
		this.Adi = Adi;
	}

	public int getParentId() {
		return ParentId;
	}

	public void setParentId(int ParentId) {
		this.ParentId = ParentId;
	}

	@Override
	public String toString() {
		return Adi;
	}

}
