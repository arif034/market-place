package com.example.market.exception;

import com.example.market.util.DateTimeUtil;
import com.example.market.util.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({CustomInvalidResponseException.class})
    @ResponseBody
    public ResponseEntity<?> handleCustomInvalidResponseException(Exception exception) {
        ResponseModel responseModel = ResponseModel.builder()
                .currentServerTime(DateTimeUtil.getCurrentServerTime())
                .messageCode("error-code")
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

}
