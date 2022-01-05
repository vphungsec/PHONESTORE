package web.model;

public class Gender {
	private Integer id;
	private String gen;
	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Gender(Integer id, String gen) {
		super();
		this.id = id;
		this.gen = gen;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	
}
