package fr.ingesup.vroumvroum.ws.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
