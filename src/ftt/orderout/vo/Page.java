package ftt.orderout.vo;

import java.util.List;

public class Page<T> {
	//当前第几页
	private int pageNo;
	
	//当前页的list
	private List<T> list;
	
	//每页显示多少条记录
	private int pageSize;
	
	//共有多少条记录
	private long totalRecodeNumber;
	
	public Page(int pageNo) {
		this.pageNo = pageNo;
	}
	
	//校验当前的页数是否合法
	public int getPageNo() {
		if(pageNo < 0 ){
			pageNo = 1;
		}
		if(pageNo > getTotalPageSize()){
			pageNo = getTotalPageSize();
		}
		return pageNo;
	}

	//获得一共有多少页
	public int getTotalPageSize(){
		int totalPageSize = (int) (totalRecodeNumber / pageSize);
		if((totalRecodeNumber % pageSize) != 0){
			totalPageSize++;
		}
		return totalPageSize;
	}
	
	//每页有多少条记录
	public int getPageSize() {
		return pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void setTotalRecodeNumber(long totalRecodeNumber) {
		this.totalRecodeNumber = totalRecodeNumber;
	}
	
	public boolean isHasNext() {
		if(getPageNo() < getTotalPageSize()){
			return true;
		}
		return false;
	}
	
	public boolean isHasPrev() {
		if(getPageNo() > 1){
			return true;
		}
		return false;
	}
	
	public int getPrevPage() {
		if(isHasPrev()){
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	
	public int getNextPage(){
		if(isHasNext()){
			return getPageNo()+1;
		}
		return getPageNo();
	}
}
