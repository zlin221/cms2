package hjh.orderin.domain;

public class InOrder {
	private String repertory;
	private long receiptsNumber;
	private String inDate;
	private String operator;
	private String source;

	public InOrder() {
	}

	public InOrder(String repertory, long receiptsNumber, String inDate,
			String operator, String source) {
		super();
		this.repertory = repertory;
		this.receiptsNumber = receiptsNumber;
		this.inDate = inDate;
		this.operator = operator;
		this.source = source;
	}
	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}

	public long getReceiptsNumber() {
		return receiptsNumber;
	}

	public void setReceiptsNumber(long receiptsNumber) {
		this.receiptsNumber = receiptsNumber;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "InOrder [repertory=" + repertory + ", receiptsNumber="
				+ receiptsNumber + ", inDate=" + inDate + ", operator="
				+ operator + ", source=" + source + "]";
	}

}
