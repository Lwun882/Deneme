package tr.com.burak.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.burak.core.ObjectHelper;
import tr.com.burak.interfaces.DALInterfaces;
import tr.com.burak.types.KategoriContract;
import tr.com.burak.types.UrunlerContract;
import tr.com.burak.types.UrunlerContract;

public class UrunlerDAL extends ObjectHelper implements
		DALInterfaces<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("INSERT INTO Urunler(UrunAdi, KategoriId, Tarih, Fiyat) "
							+ "VALUES('"
							+ entity.getAdi()
							+ "',"
							+ entity.getKategoriId()
							+ ",'"
							+ entity.getTarih()
							+ "'," + entity.getFiyat() + ")");

			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<UrunlerContract> GetAll() {
		List<UrunlerContract> datacontract = new ArrayList<UrunlerContract>();
		
		Connection connection = getConnection();
		UrunlerContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Urunler");
			while(resultset.next()){
				contract = new UrunlerContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("UrunAdi"));
				contract.setKategoriId(resultset.getInt("KategoriId"));
				contract.setTarih(resultset.getString("Tarih"));
				contract.setFiyat(resultset.getFloat("Fiyat"));
				
				datacontract.add(contract);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;

		
	}

	@Override
	public UrunlerContract Delete(UrunlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(UrunlerContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

}
