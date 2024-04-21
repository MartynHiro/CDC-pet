package ru.martinov.externalsystem.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long message) {super(message.toString());}
}
