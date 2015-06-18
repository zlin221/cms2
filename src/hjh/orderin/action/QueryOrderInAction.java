package hjh.orderin.action;

import java.util.List;

import hjh.orderin.domain.InOrder;
import hjh.orderin.service.QueryOrderInService;

import com.opensymphony.xwork2.ActionSupport;

public class QueryOrderInAction extends ActionSupport {
	private String receiptsNumber;
	private String inDepot;
	private String dateStart;
	private String dateEnd;
	private List<InOrder> inOrders;
	private QueryOrderInService queryOrderInService;

	public List<InOrder> getInOrders() {
		return inOrders;
	}

	public void setInOrders(List<InOrder> inOrders) {
		this.inOrders = inOrders;
	}

	public String getInDepot() {
		return inDepot;
	}

	public void setInDepot(String inDepot) {
		this.inDepot = inDepot;
	}

	public String getReceiptsNumber() {
		return receiptsNumber;
	}

	public void setReceiptsNumber(String receiptsNumber) {
		this.receiptsNumber = receiptsNumber;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String execute() throws Exception {
		inOrders = queryOrderInService.queryOrderIn();
		if(inOrders != null){
//			for(int i = 0; i < inOrders.size();i++){
//				System.out.println(inOrders.get(i).toString());
//			}
			return SUCCESS;
		}
		else return ERROR;
	}

	public QueryOrderInService getQueryOrderInService() {
		return queryOrderInService;
	}

	public void setQueryOrderInService(QueryOrderInService queryOrderInService) {
		this.queryOrderInService = queryOrderInService;
	}

}







