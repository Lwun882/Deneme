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
import tr.com.burak.types.YetkilerContract;
import tr.com.burak.types.YetkilerContract;

public class YetkilerDAL extends ObjectHelper implements DALInterfaces<YetkilerContract> {

	@Override
	public void Insert(YetkilerContract entity) {
Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Yetkiler (Adi) VALUES('" + entity.getAdi()+ "')");
			connection.close();
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public List<YetkilerContract> GetAll() {
		List<YetkilerContract> datacontract = new ArrayList<YetkilerContract>();
		
		Connection connection = getConnection();
		YetkilerContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Yetkiler");
			while(resultset.next()){
				contract = new YetkilerContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("Adi"));
				datacontract.add(contract);
			}
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return datacontract;
	}

	@Override
	public YetkilerContract Delete(YetkilerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(YetkilerContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<YetkilerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

}
