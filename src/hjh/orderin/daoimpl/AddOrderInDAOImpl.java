package hjh.orderin.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hjh.orderin.dao.AddOrderInDAO;
import hjh.orderin.domain.InOrder;

public class AddOrderInDAOImpl implements AddOrderInDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String addOrderIn(InOrder inOrder) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(inOrder);
			tx.commit();
		 	return "success";
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return "error";
		} finally {
			session.close();
		}
	}

}
