package com.example.testtasksv.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nazardyda
 * @AbstractExceptionHandler - Exception class
 */
@Getter
@Setter
@JsonIgnoreProperties({"stackTrace", "cause", "localizedMessage", "suppressed", "statusCode", "message"})
public abstract class AbstractExceptionHandler extends RuntimeException{
    private final String error;
    private final int status;
    private final String errorMessage;

//    public AbstractExceptionHandler(int status, String error, String errorMessage) {
//        super(errorMessage);
//        this.error= error;
//        this.status = status;
//        this.errorMessage = errorMessage;
//    }
    public AbstractExceptionHandler(ExceptionDetail exceptionDetail) {
        this.error = exceptionDetail.error;
        this.status = exceptionDetail.status;
        this.errorMessage = exceptionDetail.errorMessage;
    }
    public static class ExceptionDetail {
        final String error;
        final String errorMessage;
        final int status;

        public ExceptionDetail(int status, String error, String errorMessage) {
            this.error = error;
            this.errorMessage = errorMessage;
            this.status = status;
        }
    }

}
