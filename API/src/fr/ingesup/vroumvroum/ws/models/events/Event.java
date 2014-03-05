package fr.ingesup.vroumvroum.ws.models.events;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import fr.ingesup.vroumvroum.ws.models.JSONAble;
import fr.ingesup.vroumvroum.ws.models.localization.Address;
import fr.ingesup.vroumvroum.ws.models.user.User;
import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.Event.TABLE.NAME)
public class Event implements JSONAble {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Event.COLUMN._ID)
	private int id;
	
	@Column(name=SQL.Event.COLUMN.NAME)
	private String name;

	@Column(name=SQL.Event.COLUMN.DESCRIPTION)
	private String description;

	@Column(name=SQL.Event.COLUMN.PHONE_NUMBER)
	private String phoneNumber;

	@Column(name=SQL.Event.COLUMN.NUMBER_PARTICIPANTS)
	private int nbParticipants;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name=SQL.Event.COLUMN.DATE_START)
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name=SQL.Event.COLUMN.DATE_END)
	private Date endTime;
	
//	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
//	@JoinColumn(name="address_id")
//	private Address startAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name=SQL.Event.COLUMN.CREATED_AT)
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name=SQL.Event.COLUMN.UPDATED_AT)
	private Date updatedAt;
	
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="owner_id")
    @JsonIgnore
	private User owner;
	
	@ManyToMany(
			targetEntity=User.class,
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY
			)
	@JoinTable(
			name="event_participants",
			joinColumns=@JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	@JsonIgnore
	private Set<User> participants;
	
	@ManyToMany(
			targetEntity=User.class,
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY
			)
	@JoinTable(
			name="event_organisers",
			joinColumns=@JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	@JsonIgnore
	private Set<User> organisers;
	
	@ManyToMany(
			targetEntity=User.class,
			cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY
			)
	@JoinTable(
			name="event_guests",
			joinColumns=@JoinColumn(name="event_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	@JsonIgnore
	private Set<User> guests;
	
	@OneToMany(mappedBy="event", fetch=FetchType.EAGER)
	private Set<EventRide> rides;
	
	@OneToMany(mappedBy="event")
	@JsonIgnore
	private Set<Comment> comments;
	
	@OneToMany(mappedBy="event")
	@JsonIgnore
	private Set<Invitation> invitations;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getNbParticipants() {
		return nbParticipants;
	}
	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
//	public Address getStartPlace() {
//		return startAddress;
//	}
//	public void setStartPlace(Address startPlace) {
//		this.startAddress = startPlace;
//	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Set<User> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<User> participants) {
		this.participants = participants;
	}
	public Set<User> getOrganisers() {
		return organisers;
	}
	public void setOrganisers(Set<User> organisers) {
		this.organisers = organisers;
	}
	public Set<User> getGuests() {
		return guests;
	}
	public void setGuests(Set<User> guests) {
		this.guests = guests;
	}
	public Set<EventRide> getRides() {
		return rides;
	}
	public void setRides(Set<EventRide> rides) {
		this.rides = rides;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<Invitation> getInvitations() {
		return invitations;
	}
	public void setInvitations(Set<Invitation> invitations) {
		this.invitations = invitations;
	}
	@Override
	public JSONObject toJSON() {
		JSONObject eventJSON = new JSONObject();

		try {
			eventJSON.put(SQL.Event.COLUMN._ID, id);
			eventJSON.put(SQL.Event.COLUMN.NAME, name);
			eventJSON.put(SQL.Event.COLUMN.DESCRIPTION, description);
			
			return eventJSON;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return id + " // " + name +  " // " + description;
	}
}
