package controller_frontal;


import domains.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;



import database.Database;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import database.SECURIRY;

@WebListener
public class DefaultUserInitializer implements ServletContextListener {

	private EntityManagerFactory emf;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("initial context");
		
		emf = Database.getDatabase().getEntityManagerFactory();;
		EntityManager em = emf.createEntityManager();

		// Check if the default user exists in the database
		if (em.find(User.class, 1) == null) {
			// Create a new User object with the default values;
			// Persist the default user to the database
			User admin=SECURIRY.getAdmin();
			em.getTransaction().begin();
			em.persist(admin);
			em.getTransaction().commit();
		}

		em.close();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Database.getDatabase().closeDatabase();
	}
}
