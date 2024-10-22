package qldt.Utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class persistenceUtils {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public persistenceUtils() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("QLDienThoai_mssql");
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
