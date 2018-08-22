package com.tekvizion.AutomationEditor.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

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

import com.tekvizion.AutomationEditor.modal.SipActions;

@Component
public class GenerateSIPXMLScript {
	public static final String ROOT_ELEMENT	= "tekvizion";
	public static final String MULTICHECK	= "multicheck";
	public static final String EITHERCHECK	= "eithercheck";
	public static final String SCENARIO_ELEMENT	= "scenario";
	public static final String ACTION_ELEMENT	= "action";
	public static final String NAME_ATTRIBUTE	= "name";
	public static final String PROTOCOL_ATTRIBUTE = "protocol";
	public static final String NONE = "NONE";
	public static final String FROM_ATTRIBUTE = "from";
	public static final String TO_ATTRIBUTE = "to";
	public static final String SOURCE_ATTRIBUTE = "source";
	public static final String DESTINATION_ATTRIBUTE = "destination";
	public static final String METHOD_ATTRIBUTE = "method";
	public static final String MESSAGE_TYPE_ATTRIBUTE = "messagetype";
	public static final String STATUS_ATTRIBUTE = "status";
	public static final String SDPEXISTS_ATTRIBUTE = "sdp";
	public static final String SDP_VALUE_ATTRIBUTE = "sdpvalue";
	public static final String HEADER_VALUE = "headers";
	public static final String XML_HEADER_VALUE = "xmlheaders";
	public static final String PAYLOADTYPE_ATTRIBUTE = "payloadtype";
	public static final String DESCRIPTION_ATTRIBUTE = "desc";
	public static final String EVENTID_ATTRIBUTE = "eventid";
	public static final String ENDOFEVENT_ATTRIBUTE = "endofevent";
	public static final String FILE_EXTENSION	= ".sv";
	
	private static final Logger logger = LoggerFactory.getLogger(GenerateSIPXMLScript.class);
	
	public void generateSipValidationTestCaseFile(String scenarioName, List<SipActions> actionList, StringWriter xmlString, String fileName){
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xmlsw = null;
		if(fileName.isEmpty()){
			fileName="TestCase";
		}
		try {
			StringWriter strWriter = new StringWriter();
			StreamResult streamResulFile= new StreamResult(new FileOutputStream(fileName + FILE_EXTENSION));
			xmlsw = xmlOutputFactory.createXMLStreamWriter(strWriter);
			createXmlElements(xmlsw, scenarioName, actionList);
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
	
	private static void createXmlElements(XMLStreamWriter streamWriter, String scenario, List<SipActions> actionList){
		//root element
		try {
			streamWriter.writeStartDocument();
			streamWriter.writeStartElement(ROOT_ELEMENT);
			streamWriter.writeAttribute("version", "1.0");
			streamWriter.writeStartElement(SCENARIO_ELEMENT);	
			streamWriter.writeAttribute(NAME_ATTRIBUTE, scenario);
			for(SipActions action : actionList){
				if(action.getName().equalsIgnoreCase(MULTICHECK) || action.getName().equalsIgnoreCase(EITHERCHECK)){
					streamWriter.writeStartElement(ACTION_ELEMENT);
					streamWriter.writeAttribute(NAME_ATTRIBUTE, action.getName());
						if(action.getMulticheckactions()!=null){
							for(SipActions subaction : action.getMulticheckactions()){
								streamWriter.writeEmptyElement(ACTION_ELEMENT);	
								if(subaction.getName()!=null){
									streamWriter.writeAttribute(NAME_ATTRIBUTE, subaction.getName());
						        }
								if(subaction.getProtocol()!=null){
									streamWriter.writeAttribute(PROTOCOL_ATTRIBUTE, subaction.getProtocol());
						        }
								if(subaction.getFrom()!=null){
									streamWriter.writeAttribute(FROM_ATTRIBUTE, subaction.getFrom());
						        }
								if(subaction.getTo()!=null){
									streamWriter.writeAttribute(TO_ATTRIBUTE, subaction.getTo());
								}
								if(subaction.getSource()!=null){
									streamWriter.writeAttribute(SOURCE_ATTRIBUTE, subaction.getSource());
						        }
								if(subaction.getDestination()!=null){
									streamWriter.writeAttribute(DESTINATION_ATTRIBUTE, subaction.getDestination());
								}
								if(subaction.getMethod()!=null){
									streamWriter.writeAttribute(METHOD_ATTRIBUTE, subaction.getMethod());
						        }
								if(subaction.getMessagetype()!=null){
									streamWriter.writeAttribute(MESSAGE_TYPE_ATTRIBUTE, subaction.getMessagetype());
								}
								if(subaction.getStatus()!=null){
									streamWriter.writeAttribute(STATUS_ATTRIBUTE, subaction.getStatus());
						        }
								if(subaction.getSdp()!=null){
									streamWriter.writeAttribute(SDPEXISTS_ATTRIBUTE, subaction.getSdp());
						        }
								if(subaction.getSdpvalue()!=null){
									streamWriter.writeAttribute(SDP_VALUE_ATTRIBUTE, subaction.getSdpvalue());
						        }
								if(subaction.getHeaders()!=null){
									streamWriter.writeAttribute(HEADER_VALUE, subaction.getHeaders());
						        }
								if(subaction.getXmlheader()!=null){
									streamWriter.writeAttribute(XML_HEADER_VALUE, subaction.getXmlheader());
						        }
								if(subaction.getPayloadtype()!=null){
									streamWriter.writeAttribute(PAYLOADTYPE_ATTRIBUTE, subaction.getPayloadtype());
						        }
								if(subaction.getDesc()!=null){
									streamWriter.writeAttribute(DESCRIPTION_ATTRIBUTE, subaction.getDesc());
						        }
								if(subaction.getEventid()!=null){
									streamWriter.writeAttribute(EVENTID_ATTRIBUTE, subaction.getEventid());
						        }
								if(subaction.getEndofevent()!=null){
									streamWriter.writeAttribute(ENDOFEVENT_ATTRIBUTE, subaction.getEndofevent());
						        }
							}
						}
					streamWriter.writeEndElement();
				}
				else{
					streamWriter.writeEmptyElement(ACTION_ELEMENT);
					if(action.getName()!=null){
						streamWriter.writeAttribute(NAME_ATTRIBUTE, action.getName());
			        }
					if(action.getProtocol()!=null){
						streamWriter.writeAttribute(PROTOCOL_ATTRIBUTE, action.getProtocol());
			        }
					if(action.getFrom()!=null){
						streamWriter.writeAttribute(FROM_ATTRIBUTE, action.getFrom());
			        }
					if(action.getTo()!=null){
						streamWriter.writeAttribute(TO_ATTRIBUTE, action.getTo());
					}
					if(action.getSource()!=null){
						streamWriter.writeAttribute(SOURCE_ATTRIBUTE, action.getSource());
			        }
					if(action.getDestination()!=null){
						streamWriter.writeAttribute(DESTINATION_ATTRIBUTE, action.getDestination());
					}
					if(action.getMethod()!=null){
						streamWriter.writeAttribute(METHOD_ATTRIBUTE, action.getMethod());
			        }
					if(action.getMessagetype()!=null){
						streamWriter.writeAttribute(MESSAGE_TYPE_ATTRIBUTE, action.getMessagetype());
					}
					if(action.getStatus()!=null){
						streamWriter.writeAttribute(STATUS_ATTRIBUTE, action.getStatus());
			        }
					if(action.getSdp()!=null){
						streamWriter.writeAttribute(SDPEXISTS_ATTRIBUTE, action.getSdp());
			        }
					if(action.getSdpvalue()!=null){
						streamWriter.writeAttribute(SDP_VALUE_ATTRIBUTE, action.getSdpvalue());
			        }
					if(action.getHeaders()!=null){
						streamWriter.writeAttribute(HEADER_VALUE, action.getHeaders());
			        }
					if(action.getXmlheader()!=null){
						streamWriter.writeAttribute(XML_HEADER_VALUE, action.getXmlheader());
			        }
					if(action.getPayloadtype()!=null){
						streamWriter.writeAttribute(PAYLOADTYPE_ATTRIBUTE, action.getPayloadtype());
			        }
					if(action.getDesc()!=null){
						streamWriter.writeAttribute(DESCRIPTION_ATTRIBUTE, action.getDesc());
			        }
					if(action.getEventid()!=null){
						streamWriter.writeAttribute(EVENTID_ATTRIBUTE, action.getEventid());
			        }
					if(action.getEndofevent()!=null){
						streamWriter.writeAttribute(ENDOFEVENT_ATTRIBUTE, action.getEndofevent());
			        }
				}
			}
			streamWriter.writeEndElement();
			streamWriter.writeEndDocument();
		} catch (XMLStreamException e) {
			logger.error(e.getMessage());
		} 
	}
}
