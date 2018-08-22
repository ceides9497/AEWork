package com.tekvizion.AutomationEditor.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tekvizion.AutomationEditor.modal.Action;

@Component
public class GenerateXMLScript {
	public static final String ROOT_ELEMENT	= "tekvizion";
	public static final String SCENARIO_ELEMENT	= "scenario";
	public static final String ACTION_ELEMENT	= "action";
	public static final String NAME_ATTRIBUTE	= "name";
	public static final String PHONE_ATTRIBUTE	= "phone";
	public static final String CALL_STATE_ATTRIBUTE	= "callstate";
	public static final String CALL_TYPE_ATTRIBUTE	= "calltype";
	public static final String CALL_STATE_ATTRIBUTE2	= "callstate2";
	public static final String CALL_TYPE_ATTRIBUTE2	= "calltype2";
	public static final String DESC_ATTRIBUTE	= "desc";
	public static final String FROM_ATTRIBUTE	= "from";
	public static final String LINE_ATTRIBUTE	= "line";
	public static final String INTERMEDIATE_LINE_ATTRIBUTE	= "intermediateline";
	public static final String LINE_STATE_ATTRIBUTE	= "linestate";
	public static final String TO_ATTRIBUTE	= "to";
	public static final String VALUE_ATTRIBUTE	= "value";
	public static final String VIA_ATTRIBUTE	= "via";
	public static final String FROMLINE_ATTRIBUTE	= "fromline";
	public static final String TOLINE_ATTRIBUTE	= "toline";
	public static final String SIDE_ATTRIBUTE	= "side";
	public static final String PRIVACY_ATTRIBUTE	= "privacy";
	public static final String RECORDING_ATTRIBUTE	= "recording";
	public static final String TYPE_ATTRIBUTE	= "type";
	public static final String DEVICE_ATTRIBUTE	= "device";
	public static final String LINENUM_ATTRIBUTE	= "linenum";
	public static final String FILE_EXTENSION	= ".tc";
	public static final String SUPPRESS_CLI_ATTRIBUTE	= "suppressCLI";
	public static final String USER_ATTRIBUTE	= "user";
	public static final String NEWPASSWORD_ATTRIBUTE	= "newpassword";
	public static final String CUSTOMPASSWORD_ATTRIBUTE	= "custompassword";
	public static final String FORCELOGOUT_ATTRIBUTE	= "forcelogout";
	public static final String IDLE_ACTION_ATTRIBUTE	= "idle";
	public static final String EVENT_TYPE_ATTRIBUTE	= "eventtype";

	private static final Logger logger = LoggerFactory.getLogger(GenerateXMLScript.class);

	public void generateTestCaseFile(String scenarioName, List<Action> actionList, StringWriter xmlString, String fileName,Set<String> resourceSet,boolean idlePhonesInd){
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xmlsw = null;
		if(fileName.isEmpty()){
			fileName="TestCase";
		}
		try {
			StringWriter strWriter = new StringWriter();
			StreamResult streamResulFile= new StreamResult(new FileOutputStream(fileName + FILE_EXTENSION));
			xmlsw = xmlOutputFactory.createXMLStreamWriter(strWriter);
			createXmlElements(xmlsw, scenarioName, actionList, resourceSet, idlePhonesInd);

			final StreamResult streamResult = new StreamResult(System.out);
			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		    transformer.setOutputProperty(
		    	    "{http://xml.apache.org/xslt}indent-amount", "4");
		    transformer.transform(new StreamSource(new StringReader(strWriter.toString())), new StreamResult(xmlString));
		    transformer.transform(new StreamSource(new StringReader(strWriter.toString())), streamResulFile);
		    transformer.transform(new StreamSource(new StringReader(strWriter.toString())), streamResult);


		    streamResulFile.getOutputStream().close();
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (TransformerConfigurationException e) {
			logger.error(e.getMessage());
		} catch (TransformerException e) {
			logger.error(e.getMessage());
		} catch (XMLStreamException e) {
			logger.error(e.getMessage());
		} catch (IOException e){
			logger.error(e.getMessage());
		}
	}

	private static void createXmlElements(XMLStreamWriter streamWriter, String scenario, List<Action> actionList,Set<String> resourceSet, boolean idlePhonesInd){
		//root element
		try {
			streamWriter.writeStartDocument();
			streamWriter.writeStartElement(ROOT_ELEMENT);

			streamWriter.writeStartElement(SCENARIO_ELEMENT);
			streamWriter.writeAttribute(NAME_ATTRIBUTE, scenario);
			
			if(resourceSet!=null && resourceSet.size()>0){
				
				//Write Resource Element
				streamWriter.writeEmptyElement("resources");
				streamWriter.writeAttribute("phoneresources", resourceSet.toString());
				
				//Write Idle action for all phone resources
				if(idlePhonesInd){
					for(String phoneResource: resourceSet){
						streamWriter.writeEmptyElement(ACTION_ELEMENT);
						streamWriter.writeAttribute(NAME_ATTRIBUTE, IDLE_ACTION_ATTRIBUTE);
						streamWriter.writeAttribute(PHONE_ATTRIBUTE, phoneResource);
					}
				}
	        }
			
			for(Action action : actionList){
				if(action.getComment()==null){
					streamWriter.writeEmptyElement(ACTION_ELEMENT);
					if(action.getName()!=null){
						streamWriter.writeAttribute(NAME_ATTRIBUTE, action.getName());
			        }
					if(action.getPhone()!=null){
						streamWriter.writeAttribute(PHONE_ATTRIBUTE, action.getPhone());
			        }
					if(action.getCallState()!=null){
						streamWriter.writeAttribute(CALL_STATE_ATTRIBUTE, action.getCallState());
					}
					if(action.getCallState2()!=null){
						streamWriter.writeAttribute(CALL_STATE_ATTRIBUTE2, action.getCallState2());
			        }
					if(action.getCallType()!=null){
						streamWriter.writeAttribute(CALL_TYPE_ATTRIBUTE, action.getCallType());
					}
					if(action.getCallType2()!=null){
						streamWriter.writeAttribute(CALL_TYPE_ATTRIBUTE2, action.getCallType2());
			        }
					if(action.getDesc()!=null){
						streamWriter.writeAttribute(DESC_ATTRIBUTE, action.getDesc());
			        }
					if(action.getFrom()!=null){
						streamWriter.writeAttribute(FROM_ATTRIBUTE, action.getFrom());
			        }
					if(action.getLine()!=null){
						streamWriter.writeAttribute(LINE_ATTRIBUTE, action.getLine());
			        }
					if(action.getLineState()!=null){
						streamWriter.writeAttribute(LINE_STATE_ATTRIBUTE, action.getLineState());
			        }
					if(action.getTo()!=null){
						streamWriter.writeAttribute(TO_ATTRIBUTE, action.getTo());
			        }
					if(action.getValue()!=null){
						streamWriter.writeAttribute(VALUE_ATTRIBUTE, action.getValue());
			        }
					if(action.getVia()!=null){
						streamWriter.writeAttribute(VIA_ATTRIBUTE, action.getVia());
			        }
					if(action.getFromline()!=null){
						streamWriter.writeAttribute(FROMLINE_ATTRIBUTE, action.getFromline());
			        }
					if(action.getToline()!=null){
						streamWriter.writeAttribute(TOLINE_ATTRIBUTE, action.getToline());
			        }
					if(action.getSide()!=null){
						streamWriter.writeAttribute(SIDE_ATTRIBUTE, action.getSide());
			        }
					if(action.getPrivacy()!=null){
						streamWriter.writeAttribute(PRIVACY_ATTRIBUTE, action.getPrivacy());
			        }
					if(action.getRecording()!=null){
						streamWriter.writeAttribute(RECORDING_ATTRIBUTE, action.getRecording());
			        }
					if(action.getType()!=null){
						streamWriter.writeAttribute(TYPE_ATTRIBUTE, action.getType());
			        }
					if(action.getDevice()!=null){
						streamWriter.writeAttribute(DEVICE_ATTRIBUTE, action.getDevice());
			        }
					if(action.getLinenum()!=null){
						streamWriter.writeAttribute(LINENUM_ATTRIBUTE, action.getLinenum());
			        }
					if(action.getSuppressCLI()!=null){
						streamWriter.writeAttribute(SUPPRESS_CLI_ATTRIBUTE, action.getSuppressCLI());
			        }
					if(action.getEventType()!=null){
						streamWriter.writeAttribute(EVENT_TYPE_ATTRIBUTE, action.getEventType());
			        }
					if(action.getIntermediateline()!=null){
						streamWriter.writeAttribute(INTERMEDIATE_LINE_ATTRIBUTE, action.getIntermediateline());
			        }
					if(action.getUser()!=null){
						streamWriter.writeAttribute(USER_ATTRIBUTE, action.getUser());
			        }
					if(action.getNewpassword()!=null){
						streamWriter.writeAttribute(NEWPASSWORD_ATTRIBUTE, action.getNewpassword());
			        }
					if(action.getCustompassword()!=null){
						streamWriter.writeAttribute(CUSTOMPASSWORD_ATTRIBUTE, action.getCustompassword());
			        }
					if(action.getForcelogout()!=null){
						streamWriter.writeAttribute(FORCELOGOUT_ATTRIBUTE, action.getForcelogout());
			        }
				}
				else if(action.getComment()!=null){
					streamWriter.writeComment(action.getComment());
		        }
			}
			
			streamWriter.writeEndElement();
			streamWriter.writeEndDocument();
		} catch (XMLStreamException e) {
			logger.error(e.getMessage());
		}
	}
}
