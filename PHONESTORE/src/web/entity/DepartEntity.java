package web.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import web.entity.StaffEntity;

@Entity
@Table(name="DEPART")
public class DepartEntity {
	
	@Id
	@Column(name = "ID", nullable = false)
	private String id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="depart", fetch=FetchType.EAGER)
	private Collection<StaffEntity> staffs;

	public DepartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartEntity(String id, String name, Collection<StaffEntity> staffs) {
		super();
		this.id = id;
		this.name = name;
		this.staffs = staffs;
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

	public Collection<StaffEntity> getStaffs() {
		return staffs;
	}

	public void setStaffs(Collection<StaffEntity> staffs) {
		this.staffs = staffs;
	}
		
}
