package edu.ups.tdd.banco_acme_tdd.exception;

public class AccountNotFoundException extends RuntimeException {

  public AccountNotFoundException(String message) {
    super(message);
  }

  public AccountNotFoundException(String message, Throwable cause) {
      super(message, cause);
  }
  
}
