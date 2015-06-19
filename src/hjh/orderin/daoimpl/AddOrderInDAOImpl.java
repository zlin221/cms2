package hjh.orderin.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import zlin.store.po.StorePO;

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
	public String addOrderIn(InOrder inOrder,int countSum) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			List<StorePO> storePO = session.createQuery("from StorePO where storename = :storename")
			    .setString("storename",inOrder.getRepertory()).list();
			if(storePO.size() == 1){
				StorePO so = storePO.get(0);
				so.setStoragevolume(Integer.valueOf(so.getStoragevolume()) + countSum + "");
				session.save(inOrder);
				session.saveOrUpdate(so);
				tx.commit();
				return "success";
			}else{
				tx.rollback();
				return "error";
			}
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
