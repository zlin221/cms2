package hjh.orderin.action;

import hjh.orderin.service.DeleteOrderInService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteOrderInAction extends ActionSupport {
	private long receiptsNumber;
	private DeleteOrderInService deleteOrderInService;

	public DeleteOrderInService getDeleteOrderInService() {
		return deleteOrderInService;
	}

	public void setDeleteOrderInService(
			DeleteOrderInService deleteOrderInService) {
		this.deleteOrderInService = deleteOrderInService;
	}

	public long getReceiptsNumber() {
		return receiptsNumber;
	}

	public void setReceiptsNumber(long receiptsNumber) {
		this.receiptsNumber = receiptsNumber;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("receiptsNumber==="+receiptsNumber);
		if(deleteOrderInService.delOrderInService(receiptsNumber))
			return SUCCESS;
		else 
			return ERROR;
	}

}








