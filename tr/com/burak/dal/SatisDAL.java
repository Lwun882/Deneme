package tr.com.burak.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import tr.com.burak.complex.types.SatisContractComplex;
import tr.com.burak.core.ObjectHelper;
import tr.com.burak.interfaces.DALInterfaces;
import tr.com.burak.types.KategoriContract;
import tr.com.burak.types.SatisContract;

public class SatisDAL extends ObjectHelper implements
		DALInterfaces<SatisContract> {

	@Override
	public void Insert(SatisContract entity) {
	Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Satis (UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES ("
					+entity.getUrunId()+ "," +entity.getMusteriId()+",'"+entity.getTarih()+"',"
					+entity.getAdet()+","+entity.getPersonelId()+")");
			connection.close();
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<SatisContractComplex> GetAllSatis() {
		List<SatisContractComplex> dataContract = new ArrayList<SatisContractComplex>();
		
		Connection conn = getConnection();
		SatisContractComplex contract;
		
		try {
			Statement statment = conn.createStatement();
			Resultset rs = (Resultset) statment.executeQuery("SELECT satis.Id, personel.AdiSoyadi, musteri.AdiSoyadi,UrunAdi, Adet, satis.Tarih FROM satis "+
					"LEFT JOIN musteri on satis.MusteriId = musteri.Id " +
					"LEFT JOIN urunler on satis.UrunId = urunler.Id " +
					"LEFT JOIN personel on satis.PersonelId = personel.Id ORDER BY satis.Id DESC");
		
			while(((ResultSet) rs).next()){
				contract = new SatisContractComplex();
				
				contract.setId(((ResultSet) rs).getInt("satis.Id"));
				contract.setMusteriAdi(((ResultSet) rs).getString("musteri.AdiSoyadi"));
				contract.setPersonelAdi(((ResultSet) rs).getString("personel.AdiSoyadi"));
				contract.setTarih(((ResultSet) rs).getString("satis.Tarih"));
				contract.setUrunAdi(((ResultSet) rs).getString("UrunAdi"));
				contract.setAdet(((ResultSet) rs).getInt("Adet"));
			
			dataContract.add(contract);
			
			}
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dataContract;
	}

	@Override
	public List<SatisContract> GetAll() {
		
		
		return null;
	}

	@Override
	public SatisContract Delete(SatisContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(SatisContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SatisContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

}
