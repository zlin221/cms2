package hjh.orderin.action;

import hjh.orderin.service.UpdateOrderInService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateOrderInAction extends ActionSupport {
    private String id_count;
    private String receiptsNumber;
    private String inDate;
    private String inDepot;
    private String source;
    private String note;

    private UpdateOrderInService updateOrderInService;
    
    
	public String getReceiptsNumber() {
		return receiptsNumber;
	}

	public void setReceiptsNumber(String receiptsNumber) {
		this.receiptsNumber = receiptsNumber;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getId_count() {
		return id_count;
	}

	public void setId_count(String id_count) {
		this.id_count = id_count;
	}

	
	public String getInDepot() {
		return inDepot;
	}

	public void setInDepot(String inDepot) {
		this.inDepot = inDepot;
	}

	public UpdateOrderInService getUpdateOrderInService() {
		return updateOrderInService;
	}

	public void setUpdateOrderInService(UpdateOrderInService updateOrderInService) {
		this.updateOrderInService = updateOrderInService;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(id_count);
		System.out.println(inDepot);
		updateOrderInService.update(id_count,receiptsNumber,inDate,inDepot,source,note);
		return super.execute();
	}
    
    
}
