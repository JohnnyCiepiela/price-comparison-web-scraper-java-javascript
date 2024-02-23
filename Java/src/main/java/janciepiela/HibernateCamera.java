package janciepiela;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 
 * @author Jan Ciepiela
 *
 */
public class HibernateCamera {

	private SessionFactory sessionFactory;

	HibernateCamera() {
	}

	/**
	 * Method that initializes the session
	 */
	public void init() {
		try {

			StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

			standardServiceRegistryBuilder.configure("resources/hibernate-annotations.cfg.xml");

			StandardServiceRegistry registry = standardServiceRegistryBuilder.build();

			try {

				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {

				System.err.println("Session Factory build failed.");
				e.printStackTrace();
				StandardServiceRegistryBuilder.destroy(registry);
			}

			System.out.println("Session factory built.");

		} catch (Throwable ex) {

			System.err.println("SessionFactory creation failed." + ex);
		}
	}

	/**
	 * Closing down the session
	 */
	public void shutDown() {
		sessionFactory.close();
	}

	/**
	 * Creating the camera object
	 * 
	 * @param a setting the id
	 * @param b setting the description
	 * @param c setting the price
	 * @param d setting the url
	 */
	public void addCamera(int a, String b, String c, String d) {

		Session session = sessionFactory.getCurrentSession();

		Camera c1 = new Camera();

		//Setting values of Camera class that we want to add
		c1.setId(a);
		c1.setDescription(b);
		c1.setPrice(c);
		c1.setUrl(d);

		session.beginTransaction();

		session.save(c1);

		//Committing the transaction to save object to the database
		session.getTransaction().commit();

		session.close();
		System.out.println("Camera added to database with ID: " + c1.getId());
	}

}
