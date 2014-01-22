package fr.ingesup.vroumvroum.ws.models.localization;

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
@Table(name=SQL.Country.TABLE.NAME)
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=SQL.Country.COLUMN._ID)
	private short id;

	@Column(name=SQL.Country.COLUMN.NAME_EN)
	private String nameEN;

	@Column(name=SQL.Country.COLUMN.NAME_FR)
	private String nameFR;

	@Column(name=SQL.Country.COLUMN.CODE_ALPHA_1)
	private String codeAlpha1;

	@Column(name=SQL.Country.COLUMN.CODE_ALPHA_2)
	private String codeAlpha2;

	@Column(name=SQL.Country.COLUMN.CODE_ALPHA_3)
	private String codeAlpha3;

	@OneToMany(mappedBy="country")
	private Set<Region> regions;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getNameFR() {
		return nameFR;
	}

	public void setNameFR(String nameFR) {
		this.nameFR = nameFR;
	}

	public String getCodeAlpha1() {
		return codeAlpha1;
	}

	public void setCodeAlpha1(String codeAlpha1) {
		this.codeAlpha1 = codeAlpha1;
	}

	public String getCodeAlpha2() {
		return codeAlpha2;
	}

	public void setCodeAlpha2(String codeAlpha2) {
		this.codeAlpha2 = codeAlpha2;
	}

	public String getCodeAlpha3() {
		return codeAlpha3;
	}

	public void setCodeAlpha3(String codeAlpha3) {
		this.codeAlpha3 = codeAlpha3;
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

}