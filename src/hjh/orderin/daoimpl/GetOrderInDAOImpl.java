package hjh.orderin.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hjh.orderin.dao.GetOrderInDAO;
import hjh.orderin.domain.InOrder;

public class GetOrderInDAOImpl implements GetOrderInDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public InOrder getInOrderById(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			InOrder inOrder = (InOrder) session.get(InOrder.class, id);
			tx.commit();
			return inOrder;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}
