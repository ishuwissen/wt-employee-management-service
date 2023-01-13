package com.wissen.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Email model.
 */
@Data
public class Email {

    private String to;
    private String from;
    private String subject;
    private String template;
    private String cc;
    Map<String, Object> properties = new HashMap<>();
}
