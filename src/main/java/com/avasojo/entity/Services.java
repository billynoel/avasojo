/**
 * 
 */
package com.avasojo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Avasojo
 *
 */
@Entity
public class Services {
	

	@Id @GeneratedValue
	private Long id;
	private String servicesName;
	public Services(String servicesName) {
		super();
		this.servicesName = servicesName;
	}
	public Services() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getServicesName() {
		return servicesName;
	}
	public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}
	@Override
	public String toString() {
		return "Services [id=" + id + ", servicesName=" + servicesName + "]";
	}
}

