package org.srh.vipapp.hbm.dto;

import java.math.BigDecimal;
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
import org.srh.vipapp.hbm.hql.CustomerMasterQuery;

@Entity
@Table(name="customer_master")
@NamedQuery(name=CustomerMasterQuery.GET_ALL_CUSTOMERS_$N, query=CustomerMasterQuery.GET_ALL_CUSTOMERS_$Q)
@NamedQuery(name=CustomerMasterQuery.FIND_CUSTOMER_BY_USERNAME_$N, query=CustomerMasterQuery.FIND_CUSTOMER_BY_USERNAME_$Q)
@NamedQuery(name=CustomerMasterQuery.FIND_CUSTOMERS_BY_NAME_$N, query=CustomerMasterQuery.FIND_CUSTOMERS_BY_NAME_$Q)

@POJO(hidden= {"setPwd","setCreatedBy","setModifiedBy"},
hiddenParam= {"java.lang.String","org.srh.vipapp.hbm.dto.UserMaster","org.srh.vipapp.hbm.dto.UserMaster"})

/**
 * The Entity representing the table 'customer_master' from the 'vendor_app' database.
 * Date: 01 Dec 2018
 * @author Vivek
 */
public class CustomerMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long customerId;

	@ManyToOne
	@JoinColumn(name="createdBy")
	private UserMaster createdBy;

	@ManyToOne
	@JoinColumn(name="modifiedBy")
	private UserMaster modifiedBy;

	private String username;
	private String pwd;

	private String firstName;
	private String lastName;
	private String phone = "";
	private String email = "";
	private String address = "Wieblingen";
	private String pin = "69123";
	private String country = "Germany";

	private String defaultLocation = "Wieblingen";
	private BigDecimal defaultLocationLat = new BigDecimal("49.4140614");
	private BigDecimal defaultLocationLon = new BigDecimal("8.6536843");

	private boolean deleteFlag = false;
	private Date createdOn = new Date();
	private Date modifiedOn = new Date();
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public UserMaster getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserMaster createdBy) {
		this.createdBy = createdBy;
	}
	public UserMaster getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserMaster modifiedBy) {
		this.modifiedBy = modifiedBy;
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
	public String getDefaultLocation() {
		return defaultLocation;
	}
	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	public BigDecimal getDefaultLocationLat() {
		return defaultLocationLat;
	}
	public void setDefaultLocationLat(BigDecimal defaultLocationLat) {
		this.defaultLocationLat = defaultLocationLat;
	}
	public BigDecimal getDefaultLocationLon() {
		return defaultLocationLon;
	}
	public void setDefaultLocationLon(BigDecimal defaultLocationLon) {
		this.defaultLocationLon = defaultLocationLon;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
