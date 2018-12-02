
/**
 * Base package with the Hibernate implementation.   <br/>
 * The framework is structured in form of Service, DAO and DTO.   <br/>
 * The classes within this package are independent from the components outside the package and act as a micro-service.
 */

/**
 * The package compositions are as follows:    <br/>
 *   Config: The direct composition of the package is Config class
 *   Service: Layer contains the HBM Service Interface along with Class implementation.   <br/>
 *   DAO: Layer contains the HBM DAO Interface along with Class implementation that interact directly with database.   <br/>
 *   DTO: Contains Entities (POJO equivalent of the database table)
 *   HQL: Contain HQL queries for {@link Query} interface.
 * 
 * Date: 28 Nov 2018
 * @author Vivek
 *
 */
package org.srh.vipapp.hbm;

import org.hibernate.query.Query;
