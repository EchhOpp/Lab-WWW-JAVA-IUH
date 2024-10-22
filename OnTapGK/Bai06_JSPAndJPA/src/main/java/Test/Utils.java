package Test;

import Utils.ConnectDB;
import dao.GiangVienDao;
import daoimpl.GiangVienImpl;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Utils {
	public static void main(String[] args) {
		ConnectDB connectDB = new ConnectDB();
		
		GiangVienDao giangVienDao = new GiangVienImpl(connectDB.getEntityManager());
		System.out.println(giangVienDao.getAll());
	}
}
