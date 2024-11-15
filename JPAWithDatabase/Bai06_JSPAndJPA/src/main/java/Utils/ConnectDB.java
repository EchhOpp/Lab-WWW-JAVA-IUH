package Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ConnectDB {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public ConnectDB() {
		this.entityManagerFactory = jakarta.persistence.Persistence.createEntityManagerFactory("mssql");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
