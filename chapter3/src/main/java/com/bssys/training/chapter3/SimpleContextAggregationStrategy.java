package com.bssys.training.chapter3;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SimpleContextAggregationStrategy implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// put order together in old exchange by adding the order from new
		// exchange

		if (oldExchange == null) {
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.newDocument();
				Element context = (Element) document.createElement("Context");
				Node contextNode = document.appendChild(context);
				
				Document body = newExchange.getIn().getBody(Document.class);
				Element documentElement = body.getDocumentElement();
				Node adoptNode = document.adoptNode(documentElement);
				contextNode.appendChild(adoptNode);
				newExchange.getIn().setBody(document);
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return newExchange;
		}
		
		Document document = oldExchange.getIn().getBody(Document.class);
		Node contextNode = document.getElementsByTagName("Context").item(0);
		
		Document body = newExchange.getIn().getBody(Document.class);
		Element documentElement = body.getDocumentElement();
		Node importNode = document.importNode(documentElement, true);
		contextNode.appendChild(importNode);
		oldExchange.getIn().setBody(document);
		
		return oldExchange;
	}


}
