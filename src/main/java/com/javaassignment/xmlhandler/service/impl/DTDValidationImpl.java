package com.javaassignment.xmlhandler.service.impl;

import com.javaassignment.xmlhandler.exception.handler.DtdValidatorHandler;
import com.javaassignment.xmlhandler.service.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class DtdValidationImpl implements Validator {

    @Override
    public void validate(File file) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setValidating(true);
        SAXParser parser = saxParserFactory.newSAXParser();
        parser.parse(file, new DtdValidatorHandler());
    }
}
