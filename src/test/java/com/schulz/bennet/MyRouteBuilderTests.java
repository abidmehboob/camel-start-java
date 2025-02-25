package com.schulz.bennet;

import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.camel.test.junit5.CamelTestSupport;

public class MyRouteBuilderTests extends CamelTestSupport {

    @ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
    protected MyRouteBuilder routeBuilder;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        context.addRoutes(routeBuilder);
    }

    @org.junit.jupiter.api.Test
    public void testFileProcessing() throws Exception {
        // GIVEN a file in the input directory
        String filePath = "src/data/person.xml"; 
        // WHEN the route processes the file
        template.sendBodyAndHeader(filePath, null, "CamelFileName", filePath);
        // THEN the message is routed to the correct target directory based on the city
        assertFileExists("target/messages/uk/person_london.xml");
    }

}