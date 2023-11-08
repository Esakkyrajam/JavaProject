/*
 * package com.cinema.error;
 * 
 * public class CustomDataAccessException extends RuntimeException{ public
 * CustomDataAccessException() { super(); }
 * 
 * public CustomDataAccessException(String message) { super(message); }
 * 
 * public CustomDataAccessException(String message, Throwable cause) {
 * super(message, cause); }
 * 
 * }
 */
package com.cinema.error;

public class CustomDataAccessException extends RuntimeException {
    public CustomDataAccessException(String message) {
        super(message);
    }
}
