package fr.ingesup.vroumvroum.ws.models.localization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.Coordinates.TABLE.NAME)
public class Coordinates {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Coordinates.COLUMN._ID)
	private int id;

	@Column(name=SQL.Coordinates.COLUMN.LATITUDE)
	private float latitude;

	@Column(name=SQL.Coordinates.COLUMN.LONGITUDE)
	private float longitude;

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
}