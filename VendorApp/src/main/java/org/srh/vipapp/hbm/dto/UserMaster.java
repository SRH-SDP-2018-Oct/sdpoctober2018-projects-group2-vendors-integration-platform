package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.srh.annotation.POJO;
import org.srh.vipapp.hbm.hql.UserMasterQuery;

@Entity
@Table(name="user_master")
@NamedQuery(name=UserMasterQuery.GET_ALL_USER_$N, query=UserMasterQuery.GET_ALL_USER_$Q)
@NamedQuery(name=UserMasterQuery.FIND_USER_BY_USERNAME_$N, query=UserMasterQuery.FIND_USER_BY_USERNAME_$Q)
@POJO(hidden="setPwd", hiddenParam="java.lang.String")

/**
 * The Entity representing the table 'user_master' from the 'vendor_app' database.
 * Date: 28 Nov 2018
 * @author Vivek
 */
public class UserMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int userId;

	@ManyToOne
	@JoinColumn(name="userType")
	private UserType userType;

	private String username;
	private String pwd;

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private String pin;
	private String country;
	private boolean deleteFlag = false;
	private int createdBy;
	private Date createdOn;
	private int modifiedBy;
	private Date modifiedOn;

	public int getId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
}
