package org.springmvcframework.samples.mvc.exceptions;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String handleBusinessException(BusinessException ex){
        return "Handled BusinessException";
    }
}
