package com.turkcell.TurkcellCRM.orderService.core.exceptions.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}