package hjh.orderin.domain;

import java.sql.Date;

public class InOrder {
	private String repertory;
	private String inNumber;
	private Date inDate;
	private String operator;
	private String source;

	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}

	public String getInNumber() {
		return inNumber;
	}

	public void setInNumber(String inNumber) {
		this.inNumber = inNumber;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
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

}
