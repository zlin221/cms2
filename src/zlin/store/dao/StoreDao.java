package zlin.store.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import zlin.clothing.po.ClothingPO;
import zlin.store.po.StorePO;

public class StoreDao extends HibernateDaoSupport
{
	//��ȡȫ����Ϣ
	public int getAllRowCount(String hql)
    {
			int allRows = 0;           
        	allRows = this.getHibernateTemplate().find(hql).size();
        
        	return allRows;
    }
	
	//����ҳ��ѯȫ���ֿ���Ϣ
	public List findAllStore(final int offset,final int pageSize)throws Exception
	{

	    List resultlist = new ArrayList<StorePO>();
	      
	    resultlist = (ArrayList<StorePO>) getHibernateTemplate().execute(new HibernateCallback(){   
			@Override
			public Object doInHibernate(Session session) throws HibernateException,SQLException{   
			Query query = session.createQuery("from StorePO as storepo order by storepo.storenum asc");   
			query.setFirstResult(offset);   
			query.setMaxResults(pageSize);   
			List list = query.list();   
			return list;}  
			});   

	    return resultlist;
	}
	
	
	//���������Ҳֿ���Ϣ
	public List findStore(final String STORENUM,final String STORENAME,final int offset,final int pageSize)throws Exception
	{
		List resultlist=new ArrayList<StorePO>();
		
		final String storenum=STORENUM;//�ֿ���
		final String storename=STORENAME;//�ֿ����

		 StorePO storepo=new StorePO();
		 resultlist = (ArrayList<StorePO>) getHibernateTemplate().execute(new HibernateCallback(){   
				@Override
				public Object doInHibernate(Session session) throws HibernateException,SQLException{   
				Query query = session.createQuery("from StorePO storepo where storepo.storenum=:storenum " +
							    		"and storepo.storename=:storename order by storepo.storenum asc").setFirstResult(offset).setMaxResults(pageSize);   
				query.setString("storenum", storenum);
				query.setString("storename",storename);
				List list = query.list();   
				return list;}  
				});   
		    	    
		    return resultlist;
		
		
	}
	
	//�½��ֿ�
	public Long newStore(StorePO STOREPO)throws Exception
	{
		StorePO storepo=new StorePO();
		storepo.setStorenum(STOREPO.getStorenum());
		storepo.setStorename(STOREPO.getStorename());
		storepo.setLinkman(STOREPO.getLinkman());
		storepo.setTele(STOREPO.getTele());
		storepo.setStoragevolume(STOREPO.getStoragevolume());
		
		Long id;
		id=(Long)this.getHibernateTemplate().save(storepo);

		return id;
		
	}
	
	
	//ɾ��ֿ�
	public void deleteStore(Long STOREID)throws Exception
	{		
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(StorePO.class, STOREID));
		
	}
	
	//����ID��ѯһ���ֿ�
	public StorePO findAStore(Long STOREID)throws Exception
	{
		StorePO storepo=new StorePO();
		storepo=(StorePO)this.getHibernateTemplate().get(StorePO.class,STOREID);
		return storepo;
	}
	
	//�޸Ĳֿ���Ϣ
	public void updateStore(StorePO storepo)throws Exception
	{
		 this.getHibernateTemplate().update(storepo);
	}
	
	public List<StorePO> findAllStore(){
		return (List<StorePO>)getHibernateTemplate().find("FROM StorePO");
	}
	
	
}
