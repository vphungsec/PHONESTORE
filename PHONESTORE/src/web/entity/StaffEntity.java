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
@Table(name="STAFF")
public class StaffEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "FNAME", nullable = false)
	private String fName;
	
	@Column(name = "LNAME", nullable = false)
	private String lName;
	
	@Column(name = "BIRTHDAY", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date birthday;
	
	@Column(name = "GEN", nullable = false)
	private Boolean gen;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "PHONE", nullable = false)
	private String phone;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="DEPARTID")
	private DepartEntity depart;
	
	@OneToMany(mappedBy="staff", fetch=FetchType.EAGER)
	private Collection<BillEntity> bills;

	public StaffEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StaffEntity(Integer id, String fName, String lName, Boolean gen, String address, String phone, String password,
			DepartEntity depart, Collection<BillEntity> bills) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.gen = gen;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.depart = depart;
		this.bills = bills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getGen() {
		return gen;
	}

	public void setGen(Boolean gen) {
		this.gen = gen;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DepartEntity getDepart() {
		return depart;
	}

	public void setDepart(DepartEntity depart) {
		this.depart = depart;
	}

	public Collection<BillEntity> getBills() {
		return bills;
	}

	public void setBills(Collection<BillEntity> bills) {
		this.bills = bills;
	}		
		
}
