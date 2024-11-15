package utlis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction 	    transaction = em.getTransaction();
		
		transaction.begin();
		// code here
		transaction.commit();
	}
}
