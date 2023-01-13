package com.wissen.exception;

/**
 * Exception class for data already exist in db.
 *
 * @author Vishal Tomar
 */
public class DataAlreadyExistException extends RuntimeException {

    public DataAlreadyExistException(String message) {
        super(message);
    }
}
