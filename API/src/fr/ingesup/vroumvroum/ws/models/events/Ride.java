package fr.ingesup.vroumvroum.ws.models.events;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ride")
public class Ride {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@OneToMany(mappedBy="ride")
	private Set<EventRide> eventRides;

	@OneToMany(mappedBy="ride")
	private Set<RideAddress> ridesAddresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<EventRide> getEventRides() {
		return eventRides;
	}

	public void setEventRides(Set<EventRide> eventRides) {
		this.eventRides = eventRides;
	}

	public Set<RideAddress> getRidesAddresses() {
		return ridesAddresses;
	}

	public void setRidesAddresses(Set<RideAddress> ridesAddresses) {
		this.ridesAddresses = ridesAddresses;
	}
}
