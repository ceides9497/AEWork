package com.tekvizion.AutomationEditor.modal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

 
@XmlRootElement(name="tekvizion")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActionRootNode {

	private Scenario scenario;

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
}
