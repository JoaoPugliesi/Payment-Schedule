package io.github.joaopugliesi.paymentschedule.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException{
    public BadRequestException(String description){
        super(description);
    }
}

