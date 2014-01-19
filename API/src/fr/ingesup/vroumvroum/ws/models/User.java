package fr.ingesup.vroumvroum.ws.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn (
			name=SQL.User.COLUMN.ADDRESS,
			referencedColumnName=SQL.Address.COLUMN._ID)
	private Address address;


	public User() {
	}

	public User(JSONObject userJSON)
	{
		try {
			if(userJSON.has(SQL.User.COLUMN._ID))
				this.id = userJSON.getInt(SQL.User.COLUMN._ID);
			if(userJSON.has(SQL.User.COLUMN.FIRST_NAME))
				this.firstName = userJSON.getString(SQL.User.COLUMN.FIRST_NAME);
			if(userJSON.has(SQL.User.COLUMN.LAST_NAME))
				this.lastName = userJSON.getString(SQL.User.COLUMN.LAST_NAME);
			if(userJSON.has(SQL.User.COLUMN.BIRTHDATE))
				this.birthdate = new Date(userJSON.getString(SQL.User.COLUMN.BIRTHDATE));
			if(userJSON.has(SQL.User.COLUMN.EMAIL))
				this.email = userJSON.getString(SQL.User.COLUMN.EMAIL);
			if(userJSON.has(SQL.User.COLUMN.PASSWORD))
				this.password = userJSON.getString(SQL.User.COLUMN.PASSWORD);
			if(userJSON.has(SQL.User.COLUMN.PHONE_NUMBER))
				this.phoneNumber = userJSON.getString(SQL.User.COLUMN.PHONE_NUMBER);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public Integer getId() {
		return id;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		String returnString = "";

		returnString += "ID : " + this.id + "\n";
		returnString += "FIRST NAME : " + this.firstName + "\n";
		returnString += "LAST NAME : " + this.lastName + "\n";
		returnString += "PASSWORD : " + this.password + "\n";
		returnString += "PHONE NUMBER : " + this.phoneNumber + "\n";
		returnString += "EMAIL : " + this.email;

		return returnString;
	}
}