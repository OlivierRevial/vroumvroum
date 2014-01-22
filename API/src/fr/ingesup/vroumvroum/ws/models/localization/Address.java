package fr.ingesup.vroumvroum.ws.models.localization;

import java.util.Set;

import javax.persistence.CascadeType;
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

import fr.ingesup.vroumvroum.ws.models.events.Event;
import fr.ingesup.vroumvroum.ws.models.events.RideAddress;
import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.Address.TABLE.NAME)
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Address.COLUMN._ID)
	private int id;

	@Column(name=SQL.Address.COLUMN.ADDRESS)
	private String address;

	@ManyToOne(
			cascade={
					CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },
					fetch=FetchType.LAZY)
	@JoinColumn(name="city")
	private City city;

	@ManyToOne(
			cascade={
					CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },
					fetch=FetchType.LAZY)
	@JoinColumn(name=SQL.Address.COLUMN.COORDINATES)
	private Coordinates coordinates;

	@OneToMany(mappedBy="address")
	private Set<RideAddress> ridesAddresses;
	
	@OneToMany(mappedBy="startAddress")
	private Set<Event> eventsStartingHere;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Set<RideAddress> getRidesAddresses() {
		return ridesAddresses;
	}

	public void setRidesAddresses(Set<RideAddress> ridesAddresses) {
		this.ridesAddresses = ridesAddresses;
	}

}
