package web.model;

public class Account {
	private Integer id;
	private String phone;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Integer id, String phone) {
		super();
		this.id = id;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
