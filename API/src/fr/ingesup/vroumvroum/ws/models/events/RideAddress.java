package fr.ingesup.vroumvroum.ws.models.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.ingesup.vroumvroum.ws.models.localization.Address;

@Entity
@Table(name="ride_address")
public class RideAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ride_id")
	private Ride ride;

	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@Column(name="order_in_ride")
	private int orderInRide;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getOrderInRide() {
		return orderInRide;
	}

	public void setOrderInRide(int orderInRide) {
		this.orderInRide = orderInRide;
	}
}
