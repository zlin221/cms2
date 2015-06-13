package hjh.orderin.domain;

public class InOrderDetail {
	private long inorderdetail_id;
	
	public long getInorderdetail_id() {
		return inorderdetail_id;
	}

	public void setInorderdetail_id(long inorderdetail_id) {
		this.inorderdetail_id = inorderdetail_id;
	}

	private long receiptsNumber;
	private String articleNumber;
	private String type;
	private String color;
	private String size;
	private int count;

	public InOrderDetail() {
	}
	

	public InOrderDetail(long inorderdetail_id, long receiptsNumber,
			String articleNumber, String type, String color, String size,
			int count) {
		super();
		this.inorderdetail_id = inorderdetail_id;
		this.receiptsNumber = receiptsNumber;
		this.articleNumber = articleNumber;
		this.type = type;
		this.color = color;
		this.size = size;
		this.count = count;
	}

	public long getReceiptsNumber() {
		return receiptsNumber;
	}

	public void setReceiptsNumber(long receiptsNumber) {
		this.receiptsNumber = receiptsNumber;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
