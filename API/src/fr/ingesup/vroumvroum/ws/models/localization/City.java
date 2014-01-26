package fr.ingesup.vroumvroum.ws.models.localization;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.City.TABLE.NAME)
public class City {
	@Id
	@Column(name=SQL.City.COLUMN._ID)
	private int id;
	
	@Column(name=SQL.City.COLUMN.INSEE_CODE)
	private int inseeCode;

	@Column(name=SQL.City.COLUMN.NAME)
	private String name;

	@Column(name=SQL.City.COLUMN.POSTAL_CODE)
	private String postalCode;

	@ManyToOne(
			cascade={
					CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },
					fetch=FetchType.LAZY)
	@JoinColumn(name=SQL.City.COLUMN.DEPARTMENT)
	private Department department;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="city")
	private Set<Address> addresses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInseeCode() {
		return inseeCode;
	}

	public void setInseeCode(int inseeCode) {
		this.inseeCode = inseeCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
