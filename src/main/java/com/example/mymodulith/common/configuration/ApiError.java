package com.example.mymodulith.common.configuration;

import org.springframework.http.HttpStatus;

import java.util.Map;

public record ApiError(HttpStatus status, String message, Map<String, String> errors) {

}
