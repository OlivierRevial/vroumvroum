package fr.ingesup.vroumvroum.ws.models.user;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.ingesup.vroumvroum.ws.models.events.Event;
import fr.ingesup.vroumvroum.ws.models.localization.Address;
import fr.ingesup.vroumvroum.ws.utils.SQL;


@Entity
@Table(name=SQL.User.TABLE.NAME)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.User.COLUMN._ID, nullable=false)
	private int id;

	@Column(name=SQL.User.COLUMN.FACEBOOK_ID, nullable=false)
	private String facebookId;

	@Column(name=SQL.User.COLUMN.FIRST_NAME, nullable=false)
	private String firstName;

	@Column(name=SQL.User.COLUMN.LAST_NAME)
	private String lastName;

	@Column(name=SQL.User.COLUMN.PHONE_NUMBER)
	private String phoneNumber;

	@Column(name=SQL.User.COLUMN.EMAIL)
	private String email;

	@Column(name=SQL.User.COLUMN.BIRTHDATE)
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	/**
	 * User's password, encoded in MD5
	 */
	@Column(name=SQL.User.COLUMN.PASSWORD)
	private String password;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn (
			name=SQL.User.COLUMN.ADDRESS,
			referencedColumnName=SQL.Address.COLUMN._ID)
	private Address address;

	@ManyToMany(mappedBy="participants")
	private Set<Event> participatingEvents;
	
	@ManyToMany(mappedBy="organisers")
	private Set<Event> organisingEvents;
	
	@ManyToMany(mappedBy="guests")
	private Set<Event> invitedEvents;

	@OneToMany(mappedBy="owner")
	private Set<Event> createdEvents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Event> getParticipatingEvents() {
		return participatingEvents;
	}

	public void setParticipatingEvents(Set<Event> participatingEvents) {
		this.participatingEvents = participatingEvents;
	}

	public Set<Event> getOrganisingEvents() {
		return organisingEvents;
	}

	public void setOrganisingEvents(Set<Event> organisingEvents) {
		this.organisingEvents = organisingEvents;
	}

	public Set<Event> getInvitedEvents() {
		return invitedEvents;
	}

	public void setInvitedEvents(Set<Event> invitedEvents) {
		this.invitedEvents = invitedEvents;
	}

	public Set<Event> getCreatedEvents() {
		return createdEvents;
	}

	public void setCreatedEvents(Set<Event> createdEvents) {
		this.createdEvents = createdEvents;
	}
}