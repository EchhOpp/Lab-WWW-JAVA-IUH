package utlis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
	EntityManagerFactory emf;
	EntityManager em;
	
	public ConnectDB() {
		this.emf = Persistence.createEntityManagerFactory("mssql");
		this.em = emf.createEntityManager();
	}	
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public void close() {
		em.close();
		emf.close();
	}
}
