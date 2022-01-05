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
@Table(name="SALE")
public class SaleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private ProductEntity product;
	
	@Column(name = "DOWNPERCENT", nullable = false)
	private Integer downPercent;

	public SaleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleEntity(Integer id, ProductEntity product, Integer downPercent) {
		super();
		this.id = id;
		this.product = product;
		this.downPercent = downPercent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getDownPercent() {
		return downPercent;
	}

	public void setDownPercent(Integer downPercent) {
		this.downPercent = downPercent;
	}
	
	
}
