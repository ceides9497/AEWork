package com.tekvizion.AutomationEditor.modal;

public class Action {
	protected String name;
	protected String phone;
	protected String value;
	protected String from;
	protected String to;
	protected String via;
	protected String fromline;
	protected String toline;
	protected String intermediateline;
	protected String side;
	protected String privacy;
	protected String recording;
	protected String type;
	protected String device;
	protected String linenum;
	protected String lineState;
	protected String callType;
	protected String callState;
	protected String callType2;
	protected String callState2;
	protected String desc;
	protected String comment;
	protected String line;
	protected String suppressCLI;
	protected String forcelogout;
	protected String user;
	protected String newpassword;
	protected String custompassword;
	protected String eventType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public void setTo(String to) {
		this.to = to;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getFromline() {
		return fromline;
	}

	public void setFromline(String fromline) {
		this.fromline = fromline;
	}

	public String getToline() {
		return toline;
	}

	public void setToline(String toline) {
		this.toline = toline;
	}

	public String getIntermediateline() {
		return intermediateline;
	}

	public void setIntermediateline(String intermediateline) {
		this.intermediateline = intermediateline;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getRecording() {
		return recording;
	}

	public void setRecording(String recording) {
		this.recording = recording;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getLinenum() {
		return linenum;
	}

	public void setLinenum(String linenum) {
		this.linenum = linenum;
	}

	public String getLineState() {
		return lineState;
	}

	public void setLineState(String lineState) {
		this.lineState = lineState;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getCallState() {
		return callState;
	}

	public void setCallState(String callState) {
		this.callState = callState;
	}

	public String getCallType2() {
		return callType2;
	}

	public void setCallType2(String callType2) {
		this.callType2 = callType2;
	}

	public String getCallState2() {
		return callState2;
	}

	public void setCallState2(String callState2) {
		this.callState2 = callState2;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public Action(){
	}

	public Action(String name, String from, String to){
		this.name = name;
		this.from = from;
		this.to = to;
	}

	public Action(String name, String phone){
		this.name = name;
		this.phone = phone;
	}

	public String getSuppressCLI() {
		return suppressCLI;
	}

	public void setSuppressCLI(String suppressCLI) {
		this.suppressCLI = suppressCLI;
	}

	public String getForcelogout() {
		return forcelogout;
	}

	public void setForcelogout(String forcelogout) {
		this.forcelogout = forcelogout;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getCustompassword() {
		return custompassword;
	}

	public void setCustompassword(String custompassword) {
		this.custompassword = custompassword;
	}

	/**
	 * @return the eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param eventType the eventType to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
}
