package com.javaassignment.xmlhandler.service;

import com.javaassignment.xmlhandler.TestConstants;
import com.javaassignment.xmlhandler.service.impl.DtdValidationImpl;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Unit tests for {@link DtdValidationImpl}
 */
public class DtdValidationImplTest {

    @InjectMocks
    private DtdValidationImpl underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldValidateXMLFileWithDTDSuccessfully()
            throws ParserConfigurationException, SAXException, IOException {
        File file = new File(TestConstants.howToXmlPathName);
        underTest.validate(file);
    }

    @Test(expectedExceptions = FileNotFoundException.class)
    public void shouldThrowExceptionWithValidatingNonExistXmlFile()
            throws ParserConfigurationException, SAXException, IOException {
        File file = new File(TestConstants.nonExistentXmlPathName);
        underTest.validate(file);
    }

    @Test(expectedExceptions = SAXException.class)
    public void shouldThrowSAXExceptionWithInvalidXmlFile()
            throws ParserConfigurationException, SAXException, IOException {
        File file = new File(TestConstants.booksXmlPathName);
        underTest.validate(file);
    }

}
