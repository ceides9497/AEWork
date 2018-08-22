package com.tekvizion.AutomationEditor.modal;

import java.util.List;

public class StateActionsResponse {
	public List<ActionDetails> actionList;
	public String nextState;

	public String getNextState() {
		return nextState;
	}

	public void setNextState(String nextState) {
		this.nextState = nextState;
	}

	public List<ActionDetails> getActionList() {
		return actionList;
	}

	public void setActionList(List<ActionDetails> actionList) {
		this.actionList = actionList;
	}
}
