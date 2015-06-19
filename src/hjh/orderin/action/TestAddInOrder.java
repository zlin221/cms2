package hjh.orderin.action;

import hjh.orderin.domain.InOrder;
import hjh.orderin.domain.InOrderDetail;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAddInOrder {
	
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	sessionFactory = (SessionFactory) ctx.getBean("sessionfactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			InOrder[] inOrders = new InOrder[10];
			
			for(int i = 0; i < 3;i++){
				InOrderDetail d = new InOrderDetail();
				InOrderDetail d2 = new InOrderDetail();
				d.setArticleNumber("fdsd");
				d.setColor("red");
				d.setCount(399);
				d.setSize("333");
				d.setType("older");
				d2.setArticleNumber("fdsd");
				d2.setColor("red");
				d2.setCount(399);
				d2.setSize("333");
				d2.setType("older");
				HashSet<InOrderDetail> set = new HashSet<InOrderDetail>();
				set.add(d);
				set.add(d2);
				
				inOrders[i] = new InOrder();
				inOrders[i].setInDate(new Date(2015-1900,10,15));
				inOrders[i].setOperator("hjh");
				inOrders[i].setRepertory("the first repertory" + i);
				inOrders[i].setSource("the third company");
				inOrders[i].setNote("done by hjh");
				inOrders[i].setInOrderDetails(set);
				session.save(inOrders[i]);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
