package web.entity;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BILL")
public class BillEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private CustomerEntity customer;

	@Column(name = "CREATEDAT", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="STAFFID")
	private StaffEntity staff;
	
	@OneToMany(mappedBy="bill", fetch=FetchType.EAGER)
	private Collection<BillDetailEntity> billDetails;

	public BillEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillEntity(Integer id, CustomerEntity customer, Date createdAt, StaffEntity staff, Collection<BillDetailEntity> billDetails) {
		super();
		this.id = id;
		this.customer = customer;
		this.createdAt = createdAt;
		this.staff = staff;
		this.billDetails = billDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public StaffEntity getCreatedBy() {
		return staff;
	}

	public void setCreatedBy(StaffEntity staff) {
		this.staff = staff;
	}

	public Collection<BillDetailEntity> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(Collection<BillDetailEntity> billDetails) {
		this.billDetails = billDetails;
	}
	
}
