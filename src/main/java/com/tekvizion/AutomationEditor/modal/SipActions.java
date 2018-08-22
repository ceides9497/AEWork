package com.tekvizion.AutomationEditor.modal;

import java.util.List;

public class SipActions {
	protected String name;
	protected String protocol;
	protected String from;
	protected String to;
	protected String source;
	protected String destination;
	protected String method;
	protected String messagetype;
	protected String status;
	protected String sdp;
	protected String sdpvalue;
	protected String headers;
	protected String xmlheader;
	protected String payloadtype;
	protected String desc;
	protected String eventid;
	protected String endofevent;
	protected List<SipActions> multicheckactions;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSdp() {
		return sdp;
	}

	public void setSdp(String sdp) {
		this.sdp = sdp;
	}

	public String getSdpvalue() {
		return sdpvalue;
	}

	public void setSdpvalue(String sdpvalue) {
		this.sdpvalue = sdpvalue;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public String getXmlheader() {
		return xmlheader;
	}

	public void setXmlheader(String xmlheader) {
		this.xmlheader = xmlheader;
	}

	public String getPayloadtype() {
		return payloadtype;
	}

	public void setPayloadtype(String payloadtype) {
		this.payloadtype = payloadtype;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEventid() {
		return eventid;
	}

	public void setEventid(String eventid) {
		this.eventid = eventid;
	}

	public String getEndofevent() {
		return endofevent;
	}

	public void setEndofevent(String endofevent) {
		this.endofevent = endofevent;
	}

	public List<SipActions> getMulticheckactions() {
		return multicheckactions;
	}

	public void setMulticheckactions(List<SipActions> multicheckactions) {
		this.multicheckactions = multicheckactions;
	}
	
	
}