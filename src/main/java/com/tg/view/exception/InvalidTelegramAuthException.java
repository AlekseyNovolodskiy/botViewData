package com.tg.view.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidTelegramAuthException extends RuntimeException {
    public InvalidTelegramAuthException(String message) {
        super(message);
    }

    public InvalidTelegramAuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
