package com.github.srang.ca;

import com.github.srang.ca.config.CanvasConverter;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Autowired
    public void configureConverters(final CamelContext camelContext) {
        camelContext.getTypeConverterRegistry().addTypeConverters(new CanvasConverter());
    }
}
