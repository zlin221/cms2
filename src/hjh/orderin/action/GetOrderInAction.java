package hjh.orderin.action;

import hjh.orderin.domain.InOrder;
import hjh.orderin.service.GetOrderInService;

import com.opensymphony.xwork2.ActionSupport;

public class GetOrderInAction extends ActionSupport {
    private long orderInId;
    private InOrder inOrder;
    
    private GetOrderInService getOrderInService;
    

	public GetOrderInService getGetOrderInService() {
		return getOrderInService;
	}

	public void setGetOrderInService(GetOrderInService getOrderInService) {
		this.getOrderInService = getOrderInService;
	}

	public InOrder getInOrder() {
		return inOrder;
	}

	public void setInOrder(InOrder inOrder) {
		this.inOrder = inOrder;
	}

	public long getOrderInId() {
		return orderInId;
	}

	public void setOrderInId(long orderInId) {
		this.orderInId = orderInId;
	}

	@Override
	public String execute() throws Exception {
		inOrder = getOrderInService.getInOrderById(orderInId);
		if(inOrder != null) return SUCCESS;
		return ERROR;
	}
    
}
