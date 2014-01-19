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
@Table(name=SQL.Location.TABLE.NAME)
public class Location {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Location.COLUMN._ID)
	private int id;

	@Column(name=SQL.Location.COLUMN.LATITUDE)
	private float latitude;

	@Column(name=SQL.Location.COLUMN.LONGITUDE)
	private float longitude;

	@OneToMany(mappedBy="location")
	private Set<Address> addresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}