package com.javaassignment.xmlhandler.exception.handler;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class DtdValidatorHandler extends DefaultHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXParseException {
        System.out.println(exception.getMessage());
        throw exception;
    }

    @Override
    public void error(SAXParseException exception) throws SAXParseException {
        System.out.println(exception.getMessage());
        throw exception;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXParseException {
        System.out.println(exception.getMessage());
        throw exception;
    }
}
