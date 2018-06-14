package com.javaassignment.xmlhandler.service;

import com.javaassignment.xmlhandler.TestConstants;
import com.javaassignment.xmlhandler.service.impl.XsdValidatorImpl;
import com.javaassignment.xmlhandler.service.util.SchemaUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Unit tests for {@link XsdValidatorImpl}
 */
public class XsdValidatorImplTest {

    private XsdValidatorImpl underTest;
    private Schema bookSchema;
    private Schema invalidBookSchema;

    @BeforeMethod
    public void setUp() throws SAXException {
        File xsdSchemaValidFile = new File(TestConstants.booksXsdPathName);
        File xsdSchemaInvalidFile = new File(TestConstants.invalidBooksXsdPathName);
        bookSchema = SchemaUtil.getWXSSchema(xsdSchemaValidFile);
        invalidBookSchema = SchemaUtil.getWXSSchema(xsdSchemaInvalidFile);
    }

    @Test
    public void shouldValidateXMLFileWithDTDSuccessfully()
            throws SAXException, IOException {
        underTest = new XsdValidatorImpl(bookSchema);
        File file = new File(TestConstants.booksXmlPathName);
        underTest.validate(file);
    }

    @Test(expectedExceptions = SAXException.class)
    public void shouldThrowSAXExceptionWhenXSDSchemaIsInvalid() throws IOException, SAXException {
        underTest = new XsdValidatorImpl(invalidBookSchema);
        File file = new File(TestConstants.booksXmlPathName);
        underTest.validate(file);
    }


    @Test(expectedExceptions = SAXException.class)
    public void shouldThrowSAXExceptionWhenXMLFileIsInvalid() throws IOException, SAXException {
        underTest = new XsdValidatorImpl(bookSchema);
        File file = new File(TestConstants.songsXmlPathName);
        underTest.validate(file);
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void shouldThrowExceptionWithValidatingNonExistXmlFile()
            throws SAXException, IOException {
        underTest = new XsdValidatorImpl(bookSchema);
        File file = new File(TestConstants.nonExistentXmlPathName);
        underTest.validate(file);
    }
}
