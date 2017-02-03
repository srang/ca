package com.github.srang.ca.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.srang.ca.model.Canvas;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by srang on 2/2/17.
 */
public class CanvasConverter implements TypeConverters {
    @Autowired
    ObjectMapper mapper;
    @Converter
    public String toString(Canvas canvas) throws JsonProcessingException {
        return mapper.writeValueAsString(canvas);
    }

    @Converter
    public InputStream toInputStream(Canvas canvas) throws Exception {
        return new ByteArrayInputStream(toString(canvas).getBytes());
    }
}
