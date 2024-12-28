package edu.ups.tdd.banco_acme_tdd.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {

  @Id
  private String accountNumber;
  private BigDecimal balance;
  
  public Account() {}
  
  public Account(String accountNumber, BigDecimal balance) {
      this.accountNumber = accountNumber;
      this.balance = balance;
  }
  
  // Getters y setters
  public String getAccountNumber() { return accountNumber; }
  public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
  public BigDecimal getBalance() { return balance; }
  public void setBalance(BigDecimal balance) { this.balance = balance; }
  
}
