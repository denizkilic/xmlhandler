package com.javaassignment.xmlhandler.factory;

import com.javaassignment.xmlhandler.enums.SchemaType;
import com.javaassignment.xmlhandler.service.Validator;
import com.javaassignment.xmlhandler.service.impl.DtdValidationImpl;
import com.javaassignment.xmlhandler.service.impl.XsdValidatorImpl;

import javax.xml.validation.Schema;

public class ValidatorFactory {

    public static Validator create(Schema schema, SchemaType type) {
        switch (type) {
            case XSD:
                return new XsdValidatorImpl(schema);
            case DTD:
                return new DtdValidationImpl();
            default:
                return null;
        }
    }

}
