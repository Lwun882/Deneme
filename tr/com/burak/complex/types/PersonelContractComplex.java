package tr.com.burak.complex.types;

public class PersonelContractComplex {

	private int id;
	private String adiSoyadi;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object[] getVeriler(){
		Object[] veriler = {adiSoyadi,email};
		return veriler;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  adiSoyadi ;
	}


}
