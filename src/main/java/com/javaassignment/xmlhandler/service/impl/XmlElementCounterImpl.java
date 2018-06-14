package com.javaassignment.xmlhandler.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilderFactory;

import com.javaassignment.xmlhandler.constant.XmlConstants;
import com.javaassignment.xmlhandler.service.XmlElementCounter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlElementCounterImpl implements XmlElementCounter {

    public XmlElementCounterImpl() {

    }

    public void numberOfCertainElementOfXmlFile(String file) {
        int totalElements = numberOfElementOnXmlFile(file);
        if (totalElements == 0) {
            System.out.println(XmlConstants.elementIsNotExists);
        }
        System.out.println(XmlConstants.descriptionOfTotalNumbersOfElements + totalElements);
    }

    private int numberOfElementOnXmlFile(String file) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse(file);

            System.out.print(XmlConstants.enterElementName);
            String element = reader.readLine();
            NodeList nodes = doc.getElementsByTagName(element);
            return nodes.getLength();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return 0;
    }
}
