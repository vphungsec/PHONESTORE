package web.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CUSTOMER")
public class CustomerEntity {
	
	@Id
	@GeneratedValue
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
	private Integer gen;
	
	@Column(name = "ADDRESS", nullable = false)
	private String address;
	
	@Column(name = "PHONE", nullable = false)
	private String phone;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private Collection<BillEntity> bills;

	public CustomerEntity() { }

	public CustomerEntity(Integer id, String fName, String lName, Date birthday, Integer gen, String address, String phone,
			String password, Collection<BillEntity> bills) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.birthday = birthday;
		this.gen = gen;
		this.address = address;
		this.phone = phone;
		this.password = password;
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

	public Integer getGen() {
		return gen;
	}

	public void setGen(Integer gen) {
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

	public Collection<BillEntity> getBills() {
		return bills;
	}

	public void setBills(Collection<BillEntity> bills) {
		this.bills = bills;
	}	
		
}
