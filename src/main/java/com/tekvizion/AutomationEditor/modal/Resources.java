package com.tekvizion.AutomationEditor.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Resources {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(name = "name")
	private String Name;
	
	@Column(name = "DN")
	private String DN;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "modelNo")
	private String modelNo;
	
	@Column(name = "ipaddr")
	private String ipaddr;
	
	@Column(name = "dialledAs")
	private String dialledAs;
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDN() {
		return DN;
	}

	public void setDN(String dN) {
		DN = dN;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	
	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getDialledAs() {
		return dialledAs;
	}

	public void setDialledAs(String dialledAs) {
		this.dialledAs = dialledAs;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
