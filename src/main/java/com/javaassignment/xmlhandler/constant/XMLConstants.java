package com.javaassignment.xmlhandler.constant;

public final class XmlConstants {
    private XmlConstants() {

    }

    private static final String lineSeparator = System.getProperty("line.separator");
    private static final String doubleLineSeparator = lineSeparator + lineSeparator;

    public static final String msgCompileSuccess = "Schema Compile Successful: [%1$s]" + lineSeparator;
    public static final String msgCompileFail = "Error compiling schema: %1$s:" + doubleLineSeparator;
    public static final String msgValidationSuccess = "Validation Successful: [%1$s] against [%2$s]" + lineSeparator;
    public static final String msgValidationFail = "Error validating [%1$s] against [%2$s]:" + doubleLineSeparator;
    public static final String msgHelp = "Use one of -s or -d parameter.";
    public static final String enterElementName = "Please enter element name: ";
    public static final String elementIsNotExists = "The element is not on the xml file!";
    public static final String descriptionOfTotalNumbersOfElements = "\nTotal number of Elements: ";
    public static final String descriptionOfXsdSchema = "XSD Schema";
    public static final String descriptionOfDtdSchema = "DTD Schema";
}
