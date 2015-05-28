package ftt.orderout.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OutOrder {
	private Long id;
	private String outNo;
	private String outStore;
	private String outDate;
	private String receivePerson;
	private String address;
	
	private Set<OutOrderDetail> outOrderDetails = new HashSet<OutOrderDetail>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOutNo() {
		return outNo;
	}
	public void setOutNo(String outNo) {
		this.outNo = outNo;
	}
	public String getOutStore() {
		return outStore;
	}
	public void setOutStore(String outStore) {
		this.outStore = outStore;
	}
	
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getReceivePerson() {
		return receivePerson;
	}
	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<OutOrderDetail> getOutOrderDetails() {
		return outOrderDetails;
	}
	public void setOutOrderDetails(Set<OutOrderDetail> outOrderDetails) {
		this.outOrderDetails = outOrderDetails;
	}
	@Override
	public String toString() {
		return "OutOrder [id=" + id + ", outNo=" + outNo + ", outStore="
				+ outStore + ", outDate=" + outDate + ", receivePerson="
				+ receivePerson + ", address=" + address + ", outOrderDetails="
				+ outOrderDetails + "]";
	}
}
