package fr.ingesup.vroumvroum.ws.models.events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.ingesup.vroumvroum.ws.utils.SQL;

@Entity
@Table(name=SQL.Invitation.TABLE.NAME)
public class Invitation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Invitation.COLUMN._ID)
	private int id;
	
	@Column(name=SQL.Invitation.COLUMN.HOST_FACEBOOK_ID)
	private String hostFbId;

	@Column(name=SQL.Invitation.COLUMN.GUEST_FACEBOOK_ID)
	private String guestFbId;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostFbId() {
		return hostFbId;
	}

	public void setHostFbId(String hostFbId) {
		this.hostFbId = hostFbId;
	}

	public String getGuestFbId() {
		return guestFbId;
	}

	public void setGuestFbId(String guestFbId) {
		this.guestFbId = guestFbId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
