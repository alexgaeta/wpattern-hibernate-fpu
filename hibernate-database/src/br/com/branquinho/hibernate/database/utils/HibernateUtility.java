package br.com.branquinho.hibernate.database.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private static SessionFactory sessionFactory;

	private static final ThreadLocal<Session> sessionThread;

	static {
		sessionThread = new ThreadLocal<Session>();
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		Session session = sessionThread.get();

		if (session == null) {
			session = sessionFactory.openSession();
			sessionThread.set(session);
		}

		return session;
	}

	public static void closeSession() {
		Session session = sessionThread.get();
		sessionThread.set(null);

		if (session != null && session.isOpen()) {
			session.flush();
			session.close();
		}
	}

}
