package com.candoit.demo.commons;

public enum TransactionEnum {
    DBEXCEPTION(0,"An error occured while connecting to the database."),
    ENTITYNOTFOUNDEXCEPTION(1,"Couldn't retrieve the specified entity");

    private final Integer errorCode;
    private final String errorMessage;

    TransactionEnum(Integer errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
