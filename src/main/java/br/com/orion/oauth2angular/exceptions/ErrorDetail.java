package br.com.orion.oauth2angular.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorDetail {

    private int statusCode;

    private String message;

    
}