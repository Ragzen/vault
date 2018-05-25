package Dao;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import valuts.AbstractVaults;
import valuts.Vault;
import org.apache.logging.log4j.LogManager;

import valuts.Vault;

public class VaultsDao implements VaultDao {

	private static final Logger LOG = LogManager.getLogger(Vault.class);

	private static final String TABLE_NAME = "vault"; //$NON-NLS-1$
	private static final String COL_ID = "id"; //$NON-NLS-1$
	private static final String COL_CAPACITY = "capacity"; //$NON-NLS-1$
	private static final String COL_LOCATION = "location"; //$NON-NLS-1$
	private static final String COL_DEFENSELVL = "defenseLvl"; //$NON-NLS-1$
	private static final String COL_FOOD = "foodCap"; //$NON-NLS-1$
	private static final String COL_WATER = "waterCap"; //$NON-NLS-1$

	private String initFileName;

	public VaultsDao(String initFilename) {
		super();
		this.initFileName = initFilename;
	}

	public Vault findOne(Integer id) {
		Vault vault = null;
		try (Connection connection = this.createConnection()) {
			String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + "=?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					vault = this.createInstance(resultSet);
				}
			}
		} catch (Exception e) {

			LOG.error("", e);
		}
		return vault;
	}

	private Vault createInstance(ResultSet resultSet) {
		Vault vault = null;
		try {
			int id = resultSet.getInt(COL_ID);
			int capacity = resultSet.getInt(COL_CAPACITY);
			String location = resultSet.getString(COL_LOCATION);
			int defenseLvl = resultSet.getInt(COL_DEFENSELVL);
			int foodCap = resultSet.getInt(COL_FOOD);
			int waterCap = resultSet.getInt(COL_WATER);

			vault = new AbstractVaults(id, capacity, location, defenseLvl, foodCap, waterCap);

			if (vault != null) {
				vault.setID(id);
			}

		} catch (Exception e) {
			LOG.error("", e);
		}

		return vault;
	}

	@SuppressWarnings("static-methold")
	private Connection createConnection() throws Exception {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		String url = "Dao";
		return DriverManager.getConnection(url, "sa", "");
	}

	public List<Vault> findAll() {
		List<Vault> vaults = new ArrayList<>();

		try (Connection connection = this.createConnection()) {
			try (Statement statement = connection.createStatement()) {
				String sql = "SELECT * FROM " + TABLE_NAME;
				try (ResultSet resultSet = statement.executeQuery(sql)) {
					while (resultSet.next()) {
						Vault vault = this.createInstance(resultSet);
						if (vault != null) {
							vaults.add(vault);
						}
					}
				}
			}
		} catch (Exception e) {
			LOG.error("", e);
		}

		return vaults;
	}

	public List<Vault> findByLocation(String location) {
		List<Vault> located = new ArrayList<>();
		if (findAll() != null) {
			List<Vault> vaults = findAll();
			for (Vault vault : vaults) {
				if (vault.getLocation() == location) {
					located.add(vault);
				}
			}
			return located;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Dao.VaultDao#findCaptive()
	 */
	public List<Vault> findCaptive() {
		List<Vault> captives = new ArrayList<>();
		if (findAll() != null) {
			List<Vault> vaults = findAll();
			for (Vault vault : vaults) {
				if (vault.isCapative()) {
					captives.add(vault);
				}
			}
			return captives;
		}
		return null;
	}

	public void initDb() {
		LOG.debug("checkTable()");
		try (Connection connection = this.createConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery("SELECT * FROM information_schema.tables")) {
					while (resultSet.next()) {
						String tableName = resultSet.getString("TABLE_NAME");
						if (tableName.equalsIgnoreCase(TABLE_NAME)) {
							return;
						}
					}
				}
			}
			LOG.info("Database is empty");
			URI uri = this.getClass().getResource(this.initFileName).toURI();
			Path path = Paths.get(uri);
			for (String sql : Files.readAllLines(path)) {
				try (Statement statement = connection.createStatement()) {
					statement.executeUpdate(sql);
				}
			}
		} catch (Exception e) {
			LOG.error("", e);
		}
	}

	public Vault persist(Vault vault) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Vault vault) {
		// TODO Auto-generated method stub
		return false;
	}

	private Vault update(Vault vault) {
		// TODO Auto-generated method stub
		return null;
	}
}
