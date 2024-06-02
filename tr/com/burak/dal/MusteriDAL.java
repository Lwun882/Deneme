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
import tr.com.burak.types.MusteriContract;

public class MusteriDAL extends ObjectHelper implements
		DALInterfaces<MusteriContract> {

	@Override
	public void Insert(MusteriContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("INSERT INTO Musteri (AdiSoyadi, Telefon, Adres, SehirId)"
							+ "VALUES ('"
							+ entity.getAdiSoyadi()
							+ "',"
							+ entity.getTelefon()
							+ ",'"
							+ entity.getAdres()
							+ "'," + entity.getSehirId() + ")");
			connection.close();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<MusteriContract> GetAll() {
		List<MusteriContract> datacontract = new ArrayList<MusteriContract>();
		
		Connection connection = getConnection();
		MusteriContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Musteri");
			while(resultset.next()){
				contract = new MusteriContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdiSoyadi(resultset.getString("AdiSoyadi"));
				contract.setAdres(resultset.getString("Adres"));
				contract.setSehirId(resultset.getInt("SehirId"));
				contract.setTelefon(resultset.getString("Telefon"));
		
				datacontract.add(contract);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;		
	}

	@Override
	public MusteriContract Delete(MusteriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(MusteriContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MusteriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

}
