package com.example.testtasksv.exceptions;

public class NotFoundException extends AbstractExceptionHandler{
    public static final ExceptionDetail ID_NOT_FOUND = new ExceptionDetail(404,
                                                                   "ID_NOT_FOUND",
                                                             "User id doen't found");

    public NotFoundException(ExceptionDetail exceptionDetail) {
        super(exceptionDetail);
    }
}
