
package com.tekvizion.tekeye.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsTestCase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsTestCase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auto" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="automationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="configurationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estimatedRunTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expectedResults" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proceedure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tcStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testCaseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testCaseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="testSetup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="traceExist" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsTestCase", propOrder = {
		"id",
		"ProjectName",
		"title",
		"tcStatus",
		"comments",
		"testCaseId",
		"proceedure",
		"description",
		"expectedResults",
		"testSetup",
		"testCaseType",
		"traceExist",
		"auto",
		"configurationId",
		"automationStatus",
		"estimatedRunTime"
})
public class WsTestCase {

	protected String id;
	protected String ProjectName;
	protected String title;
	protected String tcStatus;
	protected String comments;
	protected String testCaseId;
	protected String proceedure;
	protected String description;
	protected String expectedResults;
	protected String testSetup;
	protected String testCaseType;
	protected boolean traceExist;
	protected boolean auto;
	protected String configurationId;
	protected String automationStatus;
	protected int estimatedRunTime;
	

    /**
     * Gets the value of the auto property.
     * 
     */
    public boolean isAuto() {
        return auto;
    }

    /**
     * Sets the value of the auto property.
     * 
     */
    public void setAuto(boolean value) {
        this.auto = value;
    }

    /**
     * Gets the value of the automationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutomationStatus() {
        return automationStatus;
    }

    /**
     * Sets the value of the automationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutomationStatus(String value) {
        this.automationStatus = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Gets the value of the configurationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationId() {
        return configurationId;
    }

    /**
     * Sets the value of the configurationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationId(String value) {
        this.configurationId = value;
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
     * Gets the value of the estimatedRunTime property.
     * 
     */
    public int getEstimatedRunTime() {
        return estimatedRunTime;
    }

    /**
     * Sets the value of the estimatedRunTime property.
     * 
     */
    public void setEstimatedRunTime(int value) {
        this.estimatedRunTime = value;
    }

    /**
     * Gets the value of the expectedResults property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedResults() {
        return expectedResults;
    }

    /**
     * Sets the value of the expectedResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedResults(String value) {
        this.expectedResults = value;
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
     * Gets the value of the proceedure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProceedure() {
        return proceedure;
    }

    /**
     * Sets the value of the proceedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProceedure(String value) {
        this.proceedure = value;
    }

    /**
     * Gets the value of the projectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * Sets the value of the projectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectName(String value) {
        this.ProjectName = value;
    }

    /**
     * Gets the value of the tcStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTcStatus() {
        return tcStatus;
    }

    /**
     * Sets the value of the tcStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTcStatus(String value) {
        this.tcStatus = value;
    }

    /**
     * Gets the value of the testCaseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestCaseId() {
        return testCaseId;
    }

    /**
     * Sets the value of the testCaseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestCaseId(String value) {
        this.testCaseId = value;
    }

    /**
     * Gets the value of the testCaseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestCaseType() {
        return testCaseType;
    }

    /**
     * Sets the value of the testCaseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestCaseType(String value) {
        this.testCaseType = value;
    }

    /**
     * Gets the value of the testSetup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestSetup() {
        return testSetup;
    }

    /**
     * Sets the value of the testSetup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestSetup(String value) {
        this.testSetup = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the traceExist property.
     * 
     */
    public boolean isTraceExist() {
        return traceExist;
    }

    /**
     * Sets the value of the traceExist property.
     * 
     */
    public void setTraceExist(boolean value) {
        this.traceExist = value;
    }

}
