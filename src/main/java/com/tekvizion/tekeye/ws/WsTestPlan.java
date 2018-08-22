
package com.tekvizion.tekeye.ws;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTestPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTestPlan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="automatable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="customer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="program" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subProgram" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTestPlan", propOrder = {
    "automatable",
    "customer",
    "description",
    "id",
    "name",
    "program",
    "status",
    "subProgram",
    "testType",
    "type",
    "ver",
	"executionType",
	"phoneNameList",
	"localPhoneCount",
	"pstnPhoneCount",
	"estimatedExecutionTime",
	"phoneTypes"
})
public class WsTestPlan {

	protected String id;
	protected String name;
	protected String ver;
	protected String testType;
	protected String program;
	protected String subProgram;
	protected String description;
	protected boolean automatable;
	protected String type;
	protected String status;
	protected String customer;
	protected String executionType;	
	protected List<String> phoneNameList;
	protected int localPhoneCount;
	protected int pstnPhoneCount;
	protected long estimatedExecutionTime;
	protected List<String> phoneTypes;
	
	
    /**
     * Gets the value of the automatable property.
     * 
     */
    public boolean isAutomatable() {
        return automatable;
    }

    /**
     * Sets the value of the automatable property.
     * 
     */
    public void setAutomatable(boolean value) {
        this.automatable = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer(String value) {
        this.customer = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the program property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgram() {
        return program;
    }

    /**
     * Sets the value of the program property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgram(String value) {
        this.program = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the subProgram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubProgram() {
        return subProgram;
    }

    /**
     * Sets the value of the subProgram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubProgram(String value) {
        this.subProgram = value;
    }

    /**
     * Gets the value of the testType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestType() {
        return testType;
    }

    /**
     * Sets the value of the testType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestType(String value) {
        this.testType = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the ver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVer() {
        return ver;
    }

    /**
     * Sets the value of the ver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVer(String value) {
        this.ver = value;
    }

    /**
     * Gets the value of the executionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
	public String getExecutionType() {
		return executionType;
	}

    /**
     * Sets the value of the executionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

    /**
     * Gets the value of the phoneNameList property.
     * 
     * @return
     *     possible object is
     *     {@link List<String>}
     *     
     */
	public List<String> getPhoneNameList() {
		return phoneNameList;
	}

    /**
     * Sets the value of the phoneNameList property.
     * 
     * @param value
     *     allowed object is
     *     {@link List<String>}
     *     
     */
	public void setPhoneNameList(List<String> phoneNameList) {
		this.phoneNameList = phoneNameList;
	}

    /**
     * Gets the value of the localPhoneCount property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
	public int getLocalPhoneCount() {
		return localPhoneCount;
	}

    /**
     * Sets the value of the localPhoneCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
	public void setLocalPhoneCount(int localPhoneCount) {
		this.localPhoneCount = localPhoneCount;
	}

    /**
     * Gets the value of the pstnPhoneCount property.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
	public int getPstnPhoneCount() {
		return pstnPhoneCount;
	}

    /**
     * Sets the value of the pstnPhoneCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
	public void setPstnPhoneCount(int pstnPhoneCount) {
		this.pstnPhoneCount = pstnPhoneCount;
	}

	
	/**
	 * @return the estimatedExecutionTime
	 */
	public long getEstimatedExecutionTime() {
		return estimatedExecutionTime;
	}

	/**
	 * @param estimatedExecutionTime the estimatedExecutionTime to set
	 */
	public void setEstimatedExecutionTime(long estimatedExecutionTime) {
		this.estimatedExecutionTime = estimatedExecutionTime;
	}

	
	/**
	 * @return the phoneTypes
	 */
	public List<String> getPhoneTypes() {
		return phoneTypes;
	}

	/**
	 * @param phoneTypes the phoneTypes to set
	 */
	public void setPhoneTypes(List<String> phoneTypes) {
		this.phoneTypes = phoneTypes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WsTestPlan [id=" + id + ", name=" + name + ", ver=" + ver + ", testType=" + testType + ", program="
				+ program + ", subProgram=" + subProgram + ", description=" + description + ", automatable="
				+ automatable + ", type=" + type + ", status=" + status + ", customer=" + customer + ", executionType="
				+ executionType + ", phoneNameList=" + phoneNameList + ", localPhoneCount=" + localPhoneCount
				+ ", pstnPhoneCount=" + pstnPhoneCount + ", estimatedExecutionTime=" + estimatedExecutionTime +"]";
	}

	
}
