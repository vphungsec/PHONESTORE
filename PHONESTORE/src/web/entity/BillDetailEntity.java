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
@Table(name="BILLDETAIL")
public class BillDetailEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="BILLID")
	private BillEntity bill;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private ProductEntity product;

	@Column(name = "FNPRICE", nullable = false)
	private Integer fnPrice;

	public BillDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDetailEntity(Integer id, BillEntity bill, ProductEntity product, Integer fnPrice) {
		super();
		this.id = id;
		this.bill = bill;
		this.product = product;
		this.fnPrice = fnPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getFnPrice() {
		return fnPrice;
	}

	public void setFnPrice(Integer fnPrice) {
		this.fnPrice = fnPrice;
	}
	
}
