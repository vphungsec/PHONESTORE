package web.bean;

public class Pagination {
	
	private Integer maxColumn;
	private Integer maxRow;
	private Integer maxLinkedPages;
	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pagination(Integer maxColumn, Integer maxRow, Integer maxLinkedPages) {
		super();
		this.maxColumn = maxColumn;
		this.maxRow = maxRow;
		this.maxLinkedPages = maxLinkedPages;
	}
	public Integer getMaxColumn() {
		return maxColumn;
	}
	public void setMaxColumn(Integer maxColumn) {
		this.maxColumn = maxColumn;
	}
	public Integer getMaxRow() {
		return maxRow;
	}
	public void setMaxRow(Integer maxRow) {
		this.maxRow = maxRow;
	}
	public Integer getMaxLinkedPages() {
		return maxLinkedPages;
	}
	public void setMaxLinkedPages(Integer maxLinkedPages) {
		this.maxLinkedPages = maxLinkedPages;
	}
	
	
}
