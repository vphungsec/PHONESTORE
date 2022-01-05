package web.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "IMAGE", nullable = false)
	private String image;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name = "PRICE", nullable = false)
	private Integer price;

	@Column(name = "INVENTORYNUM", nullable = false)
	private Integer inventoryNum;
	
	@ManyToOne
	@JoinColumn(name="BRANDID")
	private BrandEntity brand;
	
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Collection<BillDetailEntity> billDetails;
	
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Collection<CartEntity> carts;
	
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Collection<SaleEntity> sales;

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(Integer id, String name, String image, String description, Integer price, Integer inventoryNum,
			BrandEntity brand, Collection<BillDetailEntity> billDetails) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.inventoryNum = inventoryNum;
		this.brand = brand;
		this.billDetails = billDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(Integer inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public Collection<BillDetailEntity> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(Collection<BillDetailEntity> billDetails) {
		this.billDetails = billDetails;
	}
		
}
