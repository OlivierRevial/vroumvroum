package fr.ingesup.vroumvroum.ws.models;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.Department.TABLE.NAME)
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Department.COLUMN._ID)
	private short id;

	@Column(name=SQL.Department.COLUMN.NAME)
	private String name;
	
	@OneToMany(mappedBy="department")
	private Set<City> cities;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
}