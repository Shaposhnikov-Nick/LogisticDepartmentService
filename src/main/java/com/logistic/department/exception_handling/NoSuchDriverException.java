package com.logistic.department.exception_handling;

/*
исключение, возникающее при вводе id, отсутствующего в БД
 */
public class NoSuchDriverException extends RuntimeException{

    public NoSuchDriverException(String message) {
        super(message);
    }
}
