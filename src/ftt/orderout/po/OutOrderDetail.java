package ftt.orderout.po;

public class OutOrderDetail {
	private Long id;
	private String goodsNo;
	private String brandName;
	private String colorName;
	private String size;
	private int number;
	
	private OutOrder outOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public OutOrder getOutOrder() {
		return outOrder;
	}

	public void setOutOrder(OutOrder outOrder) {
		this.outOrder = outOrder;
	}

	@Override
	public String toString() {
		return "OutOrderDetail [id=" + id + ", goodsNo=" + goodsNo
				+ ", brandName=" + brandName + ", colorName=" + colorName
				+ ", size=" + size + ", number=" + number + ", outOrder="
				+ outOrder + "]";
	}
	
}
