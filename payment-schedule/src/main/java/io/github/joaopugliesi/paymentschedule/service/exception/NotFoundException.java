package io.github.joaopugliesi.paymentschedule.service.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String description){
        super(description);
    }
}
