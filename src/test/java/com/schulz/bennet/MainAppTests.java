package com.schulz.bennet;

import org.junit.jupiter.api.Test;
import org.apache.camel.main.Main;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MainAppTests {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testMain() throws Exception {
        // GIVEN - A new instance of Main is created
        // WHEN - The main method is called
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run(new String[0]);
        // THEN - The application runs successfully without exceptions
    }
}