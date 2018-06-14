package com.javaassignment.xmlhandler;

import com.javaassignment.xmlhandler.constant.XmlConstants;
import com.javaassignment.xmlhandler.enums.SchemaType;
import com.javaassignment.xmlhandler.service.Validator;
import com.javaassignment.xmlhandler.factory.ValidatorFactory;
import com.javaassignment.xmlhandler.service.XmlElementCounter;
import com.javaassignment.xmlhandler.service.util.SchemaUtil;
import com.javaassignment.xmlhandler.service.impl.XmlElementCounterImpl;
import com.sampullara.cli.Args;
import com.sampullara.cli.Argument;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;

import org.xml.sax.SAXException;

public class XmlValidatorMain {

    @Argument(value = "s", alias = "xsd", description = XmlConstants.descriptionOfXsdSchema)
    private String xsdSchema;

    @Argument(value = "d", alias = "dtd", description = XmlConstants.descriptionOfDtdSchema)
    private String dtdSchema;

    private final static Logger logger = Logger.getLogger(XmlValidatorMain.class.getName());

    public static void main(String[] arg) throws IOException {
        XmlValidatorMain parser = new XmlValidatorMain();
        List<String> extras = Args.parse(parser, arg);

        if (parser.xsdSchema == null && parser.dtdSchema == null) {
            logger.severe(XmlConstants.msgHelp);
            Args.usage(parser);
            System.exit(1);
        }

        // Compile XSD schema
        Schema xsd = null;
        try {
            xsd = parser.xsdSchema != null ? SchemaUtil.getWXSSchema(new File(parser.xsdSchema)) : null;
            logger.info(String.format(XmlConstants.msgCompileSuccess, parser.xsdSchema));
        } catch (SAXException exception) {
            logger.severe(String.format(XmlConstants.msgCompileFail, parser.xsdSchema));
            logger.severe(exception.getMessage());
        }

        // Validate the XML files
        final XmlElementCounter xmlElementCounter = new XmlElementCounterImpl();
        for (String file : extras) {
            SchemaType type = xsd == null ? SchemaType.DTD : SchemaType.XSD;
            Validator validator = ValidatorFactory.create(xsd, type);
            try {
                validator.validate(new File(file));
                logger.info(String.format(XmlConstants.msgValidationSuccess, file, type.name()));
                xmlElementCounter.numberOfCertainElementOfXmlFile(file);
            } catch (SAXException | ParserConfigurationException | FileNotFoundException exception) {
                logger.severe(String.format(XmlConstants.msgValidationFail, file, type.name()));
                logger.severe(exception.getMessage());
            }
        }
    }
}

