package com.javaassignment.xmlhandler.service;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface Validator {

    void validate(File file) throws IOException, SAXException, ParserConfigurationException;
}
