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
import tr.com.burak.types.SehirlerContract;
import tr.com.burak.types.SehirlerContract;

public class SehirDAL extends ObjectHelper implements DALInterfaces<SehirlerContract> {

	@Override
	public void Insert(SehirlerContract entity) {
		
	}

	@Override
	public List<SehirlerContract> GetAll() {
		List<SehirlerContract> datacontract = new ArrayList<SehirlerContract>();
		
		Connection connection = getConnection();
		SehirlerContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Sehirler");
			while(resultset.next()){
				contract = new SehirlerContract();
				contract.setId(resultset.getInt("Id"));
				contract.setSehirAdi(resultset.getString("SehirAdi"));
				
		
				datacontract.add(contract);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	}

	@Override
	public SehirlerContract Delete(SehirlerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(SehirlerContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SehirlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}





}
