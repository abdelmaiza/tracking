package com.cirta.soft.tracking.exception;

public class TicketNotFoundException  extends RuntimeException{
    public TicketNotFoundException(String message) {
        super(message);
    }
}
