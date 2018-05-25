package Dao;

import java.util.List;

import valuts.Vault;

public interface VaultDao {

	public Vault findOne(Integer id);
	
	public List<Vault> findAll();
	
	public List<Vault> findByLocation(String name);
	
	public List<Vault> findByInstanceName(String name);
	
	public Vault persist(Vault vault);
	
	public boolean delete(Vault vault);

	void initDb();
}
