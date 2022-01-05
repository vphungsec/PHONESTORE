package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "PHONE", nullable = false)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private ProductEntity product;
	
	@Column(name = "AMOUNT", nullable = false)
	private Integer amount;

	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEntity(Integer id, String phone, ProductEntity product, Integer amount) {
		super();
		this.id = id;
		this.phone = phone;
		this.product = product;
		this.amount = amount;
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

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
