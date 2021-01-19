package com.networkntvalidation.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationMessage;

import java.io.IOException;
import java.util.Set;


public class ValidatorExample {

    public static void main(String[] args) throws IOException {
        BaseJsonSchemaValidator validator = new BaseJsonSchemaValidator();
        JsonNode schemaNode = validator.getJsonNodeFromClasspath("fhir.schema.json");
        JsonSchema schema = validator.getJsonSchemaFromJsonNodeAutomaticVersion(schemaNode);
        JsonNode node = validator.getJsonNodeFromClasspath("Patient.json");
        Set<ValidationMessage> errors = schema.validate(node);
        System.out.println(errors);
    }
}
