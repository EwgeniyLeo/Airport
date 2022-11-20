package ru.netology.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String smg)  {
        super(smg);
    }
}