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
import tr.com.burak.types.AccountsContract;
import tr.com.burak.types.KategoriContract;

public class AccountsDAL extends ObjectHelper implements
		DALInterfaces<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement
					.executeUpdate("INSERT INTO Accounts (YetkiId, PersonelId, Sifre) VALUES ("
							+ entity.getYetkiId()
							+ ","
							+ entity.getPersonelId()
							+ ",'"
							+ entity.getSifre()
							+ "')");
			connection.close();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public AccountsContract GetPersonelIdVeSifre(int personelId,
			String sifre) {
		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection baglanti = getConnection();

		try {
			Statement sorgu = baglanti.createStatement();
			Resultset rs = (Resultset) sorgu
					.executeQuery("SELECT *FROM accounts WHERE PersonelId="+personelId+" AND Sifre='"+sifre.trim()+"'");
			while(((ResultSet) rs).next()){
				
				contract.setId(((ResultSet) rs).getInt("Id"));
				contract.setPersonelId(((ResultSet) rs).getInt("PersonelId"));
				contract.setSifre(((ResultSet) rs).getString("Sifre"));
				contract.setYetkiId(((ResultSet) rs).getInt("YetkiId"));
			}
			
			sorgu.close();
			baglanti.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return contract;
	}
	public AccountsContract GetYetkiId(int personelId) {
		AccountsContract contract = new AccountsContract();
		List<AccountsContract> listele = new ArrayList<AccountsContract>();
		Connection baglanti = getConnection();

		try {
			Statement sorgu = baglanti.createStatement();
			Resultset rs = (Resultset) sorgu
					.executeQuery("SELECT *FROM accounts WHERE PersonelId="+personelId+ "");
			while(((ResultSet) rs).next()){
				
				contract.setId(((ResultSet) rs).getInt("Id"));
				contract.setPersonelId(((ResultSet) rs).getInt("PersonelId"));
				contract.setYetkiId(((ResultSet) rs).getInt("YetkiId"));
			}
			
			sorgu.close();
			baglanti.close();
		}

		catch (Exception e) {
			System.out.println(e);
		}

		return contract;}

	@Override
	public List<AccountsContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KategoriContract> GetAllParentId() {
		// TODO Auto-generated method stub
		return null;
	}

}
