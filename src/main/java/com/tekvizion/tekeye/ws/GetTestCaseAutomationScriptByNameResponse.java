
package com.tekvizion.tekeye.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getTestCaseAutomationScriptByNameResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getTestCaseAutomationScriptByNameResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.tekeye.tekvizion.com/}wsAutomationScript" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTestCaseAutomationScriptByNameResponse", propOrder = {
    "_return"
})
public class GetTestCaseAutomationScriptByNameResponse {

    @XmlElement(name = "return")
    protected WsAutomationScript _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link WsAutomationScript }
     *     
     */
    public WsAutomationScript getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsAutomationScript }
     *     
     */
    public void setReturn(WsAutomationScript value) {
        this._return = value;
    }

}
