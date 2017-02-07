package com.sbertech.sale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value= HttpStatus.CONFLICT, reason="No such Order")
public class ConflictException extends RuntimeException{
}
