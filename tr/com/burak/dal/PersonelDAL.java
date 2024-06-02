package tr.com.burak.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.burak.complex.types.PersonelContractComplex;
import tr.com.burak.complex.types.StokContractTotalComplex;
import tr.com.burak.core.ObjectHelper;
import tr.com.burak.interfaces.DALInterfaces;
import tr.com.burak.types.KategoriContract;
import tr.com.burak.types.PersonelContract;
import tr.com.burak.types.PersonelContract;

public class PersonelDAL extends ObjectHelper implements
		DALInterfaces<PersonelContract> {

	@Override
	public void Insert(PersonelContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("INSERT INTO Personel (AdiSoyadi, Email)"
							+"VALUES ('"
							+ entity.getAdiSoyadi()
							+ "','"
							+ entity.getEmail()
							+ "')");
			connection.close();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public List<PersonelContract> GetAll() {
		List<PersonelContract> datacontract = new ArrayList<PersonelContract>();
		
		Connection connection = getConnection();
		PersonelContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Personel");
			while(resultset.next()){
				contract = new PersonelContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdiSoyadi(resultset.getString("AdiSoyadi"));
				contract.setEmail(resultset.getString("Email"));
				datacontract.add(contract);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	}

	@Override
	public PersonelContract Delete(PersonelContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(PersonelContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PersonelContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}





}
