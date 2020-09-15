package com.RTJP_miniApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Contact_Details")
public class CntctEntity {
	@Id
	@Column(name="Contact_Id")
	
	@GeneratedValue
	private Integer cid;
	
	@Column(name="Contact_Name")
	private String name;
	
	@Column(name="Contact_Email")
	private String email;
	
	@Column(name="Contact_PhoneNumber")
	private long number;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	

}
