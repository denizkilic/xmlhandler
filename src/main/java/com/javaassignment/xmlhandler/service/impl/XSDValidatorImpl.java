package com.javaassignment.xmlhandler.service.impl;

import com.javaassignment.xmlhandler.exception.handler.XsdErrorHandler;
import com.javaassignment.xmlhandler.service.Validator;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;

public class XsdValidatorImpl implements Validator {
    private final Schema schema;

    public XsdValidatorImpl(Schema schema) {
        this.schema = schema;
    }

    @Override
    public void validate(File file) throws IOException, SAXException {
        javax.xml.validation.Validator validator = schema.newValidator();
        Source source = new StreamSource(file);
        validator.setErrorHandler(new XsdErrorHandler());
        validator.validate(source);
    }
}
