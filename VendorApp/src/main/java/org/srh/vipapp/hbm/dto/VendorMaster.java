/**
 * 
 */
package org.srh.vipapp.hbm.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.srh.vipapp.hbm.hql.VendorMasterQuery;

@Entity
@Table(name="vendor_master")
@NamedQueries({
	@NamedQuery(name=VendorMasterQuery.GET_ALL_VENDOR_$N, query=VendorMasterQuery.GET_ALL_VENDOR_$Q),
	@NamedQuery(name=VendorMasterQuery.FIND_VENDOR_BY_VENDORNAME_$N, query=VendorMasterQuery.FIND_VENDOR_BY_VENDORNAME_$Q),
})


/**
 * The Entity representing the table 'vendor_master' from the 'vendor_app' database.
 * Date: 30 Nov 2018
 * @author Maitreyee
 */
public class VendorMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int vendorId;

	private String vendorName;

	private String phone;
	private String email;
	private String country = "Germany";
	private boolean deleteFlag = false;
	private int createdBy;
	private Date createdOn = new Date();
	private int modifiedBy;
	private Date modifiedOn = new Date();

}
