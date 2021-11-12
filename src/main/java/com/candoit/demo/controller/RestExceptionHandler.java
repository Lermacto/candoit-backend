package com.candoit.demo.controller;

import javax.persistence.EntityNotFoundException;

import com.candoit.demo.commons.TransactionEnum;
import com.candoit.demo.commons.TransactionResult;
import com.candoit.demo.exception.DBException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(DBException.class)
    public ResponseEntity<?> handleDBException(){
        TransactionResult transactionResult = new TransactionResult();
        transactionResult.setIsTransactionSuccessful(Boolean.FALSE);
        transactionResult.setErrorCode(TransactionEnum.DBEXCEPTION.getErrorCode());
        transactionResult.setMessage(TransactionEnum.DBEXCEPTION.getErrorMessage());
        return new ResponseEntity<TransactionResult>(transactionResult,HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(){
        TransactionResult transactionResult = new TransactionResult();
        transactionResult.setIsTransactionSuccessful(Boolean.FALSE);
        transactionResult.setErrorCode(TransactionEnum.ENTITYNOTFOUNDEXCEPTION.getErrorCode());
        transactionResult.setMessage(TransactionEnum.ENTITYNOTFOUNDEXCEPTION.getErrorMessage());
        return new ResponseEntity<TransactionResult>(transactionResult,HttpStatus.OK);
    }
    
}
