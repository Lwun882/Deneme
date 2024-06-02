package tr.com.burak.interfaces;

import java.util.List;

import tr.com.burak.types.KategoriContract;

public interface DALInterfaces<T> {

	void Insert(T entity);
	List<T> GetAll();
	T Delete(T entity);
	void Update(T entity);
	List<T> GetById(int id);
	List<KategoriContract> GetAllParentId();
	
}
