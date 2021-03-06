package zlin.store.service;

import java.util.ArrayList;
import java.util.List;

import zlin.clothing.po.ClothingPO;
import zlin.clothing.vo.PageBean;
import zlin.store.dao.StoreDao;
import zlin.store.po.StorePO;


public class StoreService {

	private StoreDao storedao;
	private StorePO storepo;
	private ArrayList storelist;
	public StoreDao getStoredao() {
		return storedao;
	}
	public void setStoredao(StoreDao storedao) {
		this.storedao = storedao;
	}
	public StorePO getStorepo() {
		return storepo;
	}
	public void setStorepo(StorePO storepo) {
		this.storepo = storepo;
	}
	public ArrayList getStorelist() {
		return storelist;
	}
	public void setStorelist(ArrayList storelist) {
		this.storelist = storelist;
	}
	
	/**
     * pageSizeΪÿҳ��ʾ�ļ�¼��
     * pageΪ��ǰ��ʾ����ҳ
	 * @throws Exception 
     */
	public PageBean findAllStore(int pageSize, int page)
	{
		    PageBean pageBean = new PageBean();
	        String hql = "from StorePO";
	        
	        int allRows = storedao.getAllRowCount(hql);
	        
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        
	        int currentPage = pageBean.getCurPage(page);
	        
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        
	        try{
	        	ArrayList<StorePO> list = (ArrayList<StorePO>)storedao.findAllStore(offset, pageSize);
		        pageBean.setList(list);
		        pageBean.setAllRows(allRows);
		        pageBean.setCurrentPage(currentPage);
		        pageBean.setTotalPage(totalPage);
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }

	        
	        return pageBean;
		
	}
	
	//����������
	public PageBean findStore(String STORENUM,String STORENAME,int pageSize, int page)
	{
		PageBean pageBean=new PageBean();
		String storenum=STORENUM;
		String storename=STORENAME;
		
		 String hql = "from StorePO storepo where storepo.storenum='"+storenum+
		    		"' and storepo.storename='"+storename+"'";
		 
	        
	        int allRows = storedao.getAllRowCount(hql);
	        
	        int totalPage = pageBean.getTotalPages(pageSize, allRows);
	        
	        int currentPage = pageBean.getCurPage(page);
	        
	        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
	        
	        try{
	        	ArrayList<StorePO> list = (ArrayList<StorePO>)storedao.findStore(storenum,storename, offset, pageSize);
	        	pageBean.setList(list);
	        	pageBean.setAllRows(allRows);
	        	pageBean.setCurrentPage(currentPage);
	        	pageBean.setTotalPage(totalPage);
	        }
	        
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		
		return pageBean;
	}
	
	
	//�½��ֿ�
	public Long newStore(StorePO STOREPO)
	{
		StorePO storepo=new StorePO();
		storepo.setStorenum(STOREPO.getStorenum());
		storepo.setStorename(STOREPO.getStorename());
		storepo.setLinkman(STOREPO.getLinkman());
		storepo.setTele(STOREPO.getTele());
		storepo.setStoragevolume(STOREPO.getStoragevolume());
		
		Long id=null;
		try{
			id=storedao.newStore(storepo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	//ɾ��һ���ֿ�
	public void deleteStore(Long STOREID)
	{
		try{
			storedao.deleteStore(STOREID);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//����һ���ֿ���Ϣ
	public StorePO findAStore(Long STOREID)
	{
		try{
			storepo=storedao.findAStore(STOREID);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return storepo;
	}
	
	
	//����һ���ֿ���Ϣ
	public void updateStore(StorePO storepo)
	{
		try{
			storedao.updateStore(storepo);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public List<StorePO> findAllStore(){
		List<StorePO> storeLists = storedao.findAllStore();
		return storeLists;
	}
	
	
}
