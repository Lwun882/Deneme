package tr.com.burak.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import tr.com.burak.core.ObjectHelper;
import tr.com.burak.interfaces.DALInterfaces;
import tr.com.burak.types.KategoriContract;

public class KategoriDAL extends ObjectHelper  implements DALInterfaces<KategoriContract>{

	@Override
	public void Insert(KategoriContract entity) {
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Kategori (Adi, ParentId) VALUES ('" + entity.getAdi()+"'," +entity.getParentId()+ ")");
			connection.close();
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<KategoriContract> GetAll() {
		
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
	
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Kategori");
			while(resultset.next()){
				contract = new KategoriContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("Adi"));
				contract.setParentId(resultset.getInt("ParentId"));
		
				datacontract.add(contract);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	}
	public List<KategoriContract> GetAllParentId() {
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
		
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
		
			ResultSet resultset = statement.executeQuery("SELECT * FROM Kategori WHERE parentId=0");
			while(resultset.next()){
				contract = new KategoriContract();
				contract.setId(resultset.getInt("Id"));
				contract.setAdi(resultset.getString("Adi"));
				contract.setParentId(resultset.getInt("ParentId"));
		
				datacontract.add(contract);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	}

		@Override
	public void Update(KategoriContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KategoriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KategoriContract Delete(KategoriContract entity) {
		// TODO Auto-generated method stub
		return null;
	}





}
