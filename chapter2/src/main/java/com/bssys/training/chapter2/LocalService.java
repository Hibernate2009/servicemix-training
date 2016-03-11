package com.bssys.training.chapter2;

import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.ExchangeProperty;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LocalService {
	
	public String generateId(){
		return UUID.randomUUID().toString();
	}
	
	public Document transform(@ExchangeProperty("statementId") String statementId, Document message){
		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
		newInstance.setNamespaceAware(true);
		Document doc = null;
		try {
			doc = newInstance.newDocumentBuilder().newDocument();
			Element ticketElement = doc.createElementNS("RootExt_Ticket", "x:Ticket");
			Element statementIdElement = doc.createElement("statementId");
			Element messageDataElement = doc.createElement("MessageData");
			
			statementIdElement.setTextContent(statementId);
			
			Node importNode = doc.importNode(message.getDocumentElement(), true);
			messageDataElement.appendChild(importNode);
			
			ticketElement.appendChild(statementIdElement);
			ticketElement.appendChild(messageDataElement);
			doc.appendChild(ticketElement);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return doc; 
	}

}
