package com.blog.my.json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONManager {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static ObjectMapper getMapper(){return MAPPER;}
}
