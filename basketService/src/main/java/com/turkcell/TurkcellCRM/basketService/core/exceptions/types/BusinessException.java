package com.turkcell.TurkcellCRM.basketService.core.exceptions.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}