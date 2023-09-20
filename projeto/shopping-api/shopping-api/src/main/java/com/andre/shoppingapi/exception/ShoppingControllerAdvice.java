package com.andre.shoppingapi.exception;

import com.andre.shoppingclient.DTO.ErrorDTO;
import com.andre.shoppingclient.Exception.ProductNotFoundException;
import com.andre.shoppingclient.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.andre.shoppingapi.controller")
public class ShoppingControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFound(ProductNotFoundException productNotFoundException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Produto não encontrado.");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("Usuário não encontrado.");
        errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
        errorDTO.setTimestamp(LocalDateTime.now());
        return errorDTO;
    }

}
