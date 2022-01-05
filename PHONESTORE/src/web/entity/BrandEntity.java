package web.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BRAND")
public class BrandEntity {
	
	@Id
	@Column(name = "ID", nullable = false)
	private String id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="brand", fetch=FetchType.EAGER)
	private Collection<ProductEntity> products;

	public BrandEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BrandEntity(String id, String name, Collection<ProductEntity> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Collection<ProductEntity> products) {
		this.products = products;
	}	
		
}
