package fr.ingesup.vroumvroum.ws.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.Address.TABLE.NAME)
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Address.COLUMN._ID)
	private int id;

	@Column(name=SQL.Address.COLUMN.LINE_PRINCIPAL)
	private String linePrincipal;

	@Column(name=SQL.Address.COLUMN.LINE_COMPLEMENT)
	private String lineComplement;

	@ManyToOne(
			cascade={
					CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },
					fetch=FetchType.EAGER)
	@JoinColumn(name=SQL.Address.COLUMN.CITY)
	private City city;

	@ManyToOne(
			cascade={
					CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },
					fetch=FetchType.EAGER)
	@JoinColumn(name=SQL.Address.COLUMN.LOCATION)
	private Location location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinePrincipal() {
		return linePrincipal;
	}

	public void setLinePrincipal(String linePrincipal) {
		this.linePrincipal = linePrincipal;
	}

	public String getLineComplement() {
		return lineComplement;
	}

	public void setLineComplement(String lineComplement) {
		this.lineComplement = lineComplement;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public City getCity() {
		return city;
	}
}
