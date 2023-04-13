package database;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AuteurDao;
import dao.AuteurDaoImpl;
import dao.LivreDao;
import dao.LivreDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public final class Database {

	 static private Database instance;
	 
	 private static EntityManagerFactory emf;
	
	private Database() {}
	
	public static Database getDatabase(){
		if(instance==null) instance= new Database();
		return instance;
	}
	
	public  EntityManagerFactory getEntityManagerFactory() {
		if(emf==null) emf = Persistence.createEntityManagerFactory(PERSISTANCE.PERSISTENCE_NAME);	
		return emf;
	}
	
	public void closeDatabase() {
		if(emf!=null) emf.close(); 
	}
	
	//recuperer DAOs
	
	public LivreDao getLivreDao() {
		return new LivreDaoImpl(getEntityManagerFactory());
	}
	
	public AuteurDao getAuteurDao() {
		return new AuteurDaoImpl(getEntityManagerFactory());
	}
	
	public UserDao getUserDao() {
		return new UserDaoImpl(getEntityManagerFactory());
	}
	
	
	
}
