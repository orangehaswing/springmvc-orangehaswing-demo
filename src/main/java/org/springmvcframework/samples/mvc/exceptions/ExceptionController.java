package org.springmvcframework.samples.mvc.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/exception")
    public String exception(){
        throw new IllegalStateException("Soory!");
    }

    @GetMapping("/global-exception")
    public String businessException() throws BusinessException {
        throw new BusinessException();
    }

    @ExceptionHandler
    public String hanle(IllegalStateException e){
        return "IllegalStateException handled!";
    }
}
