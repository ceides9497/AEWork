package com.tekvizion.AutomationEditor.modal;

import java.util.List;

public class Scenario {
	protected String name;	
	private List<Action> action;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Action> getAction() {
		return action;
	}
	public void setAction(List<Action> action) {
		this.action = action;
	}
}
