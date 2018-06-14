package com.javaassignment.xmlhandler.service.util;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public final class SchemaUtil {

    private SchemaUtil() {
    }

    public static Schema getWXSSchema(File file) throws SAXException {
        SchemaFactory fac = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return fac.newSchema(file);
    }
}
