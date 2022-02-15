package com.logistic.department.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
класс - обработчик исключений
 */

@ControllerAdvice
public class DriverGlobalExceptionHandler {

    //обработчик исключения, возникающего при вводе id водителя, отсутствующего в БД
    @ExceptionHandler
    public ResponseEntity<DriverIncorrectData> handlerException(NoSuchDriverException exception){
        DriverIncorrectData data = new DriverIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
