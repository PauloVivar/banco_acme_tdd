package edu.ups.tdd.banco_acme_tdd.exception;

public class InsufficientFundsException extends RuntimeException {

  public InsufficientFundsException(String message) {
    super(message);
  }

  public InsufficientFundsException(String message, Throwable cause) {
      super(message, cause);
  }
  
}
