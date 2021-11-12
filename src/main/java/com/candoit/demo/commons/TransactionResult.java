package com.candoit.demo.commons;

public class TransactionResult {
    
    private String message;
    private Boolean isTransactionSuccessful;
    private Integer errorCode;
    
    public TransactionResult(String message, Boolean isTransactionSuccessful){
        this.setMessage(message);
        this.setIsTransactionSuccessful(isTransactionSuccessful);
    }

    public TransactionResult() {
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Boolean getIsTransactionSuccessful() {
        return isTransactionSuccessful;
    }

    public void setIsTransactionSuccessful(Boolean isTransactionSuccessful) {
        this.isTransactionSuccessful = isTransactionSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
