package tr.com.burak.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.burak.complex.types.StokContractComplex;
import tr.com.burak.complex.types.StokContractTotalComplex;
import tr.com.burak.core.ObjectHelper;
import tr.com.burak.interfaces.DALInterfaces;
import tr.com.burak.types.KategoriContract;
import tr.com.burak.types.StockContract;

public class StokDAL extends ObjectHelper implements DALInterfaces<StockContract> {

	@Override
	public void Insert(StockContract entity) {
Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Stok (PersonelId, UrunId, Tarih, Adet) VALUES ("+entity.getPersonelId()+","+entity.getUrunId()+",'"+entity.getTarih()+"',"+entity.getAdet()+")");
			connection.close();
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/*
	SELECT stok.Id,personel.AdiSoyadi,urunler.UrunAdi, Adet, stok.Tarih FROM stok
	LEFT JOIN urunler on stok.UrunId = urunler.Id
	LEFT JOIN personel on stok.PersonelId = personel.Id
	
	*/

	public List<StokContractComplex> GetAllStok(){
		List<StokContractComplex> datacontract = new ArrayList<StokContractComplex>();
		
		Connection connection = getConnection();
		StokContractComplex contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT stok.Id, AdiSoyadi, UrunAdi, Adet, stok.Tarih FROM stok"
					+ " LEFT JOIN urunler on stok.UrunId = urunler.Id"
					+ " LEFT JOIN personel on stok.PersonelId = personel.Id ORDER BY stok.Id DESC");//son eklenenin üstte görünmesi için
			while(resultset.next()){
				contract = new StokContractComplex();
				contract.setId(resultset.getInt("Id"));
				contract.setPersonelAdi(resultset.getString("AdiSoyadi"));
				contract.setUrunAdi(resultset.getString("urunler.UrunAdi"));
				contract.setAdet(resultset.getInt("Adet"));
				contract.setTarih(resultset.getString("stok.Tarih"));
				
				
				
				datacontract.add(contract);
				
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}
	
	public List<StokContractTotalComplex> GetTotalStok(){
		List<StokContractTotalComplex> datacontract = new ArrayList<StokContractTotalComplex>();
		
		Connection connection = getConnection();
		StokContractTotalComplex contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT SUM(Adet) as toplam, stok.Id, AdiSoyadi, UrunAdi, Adet, stok.Tarih FROM stok LEFT JOIN urunler on stok.UrunId = urunler.Id LEFT JOIN personel on stok.PersonelId = personel.Id GROUP BY UrunId");
			while(resultset.next()){
				contract = new StokContractTotalComplex();
				contract.setId(resultset.getInt("Id"));
				contract.setPersonelAdi(resultset.getString("AdiSoyadi"));
				contract.setUrunAdi(resultset.getString("urunler.UrunAdi"));
				contract.setAdet(resultset.getInt("Adet"));
				contract.setTarih(resultset.getString("stok.Tarih"));
				contract.setToplam(resultset.getInt("toplam"));
				
				
				datacontract.add(contract);
				
			}
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}
	
	@Override
	public List<StockContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void Update(StockContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StockContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockContract Delete(StockContract entity) {
		// TODO Auto-generated method stub
		return null;
	}
}


