package edu.ups.tdd.banco_acme_tdd.model.dto;

import java.math.BigDecimal;

public class TransferDTO {

  private String sourceAccount;
  private String targetAccount;
  private BigDecimal amount;
  private String description;

  public TransferDTO(String sourceAccount, String targetAccount, BigDecimal amount, String description) {
    this.sourceAccount = sourceAccount;
    this.targetAccount = targetAccount;
    this.amount = amount;
    this.description = description;
  }

  public String getSourceAccount() {
    return sourceAccount;
  }
  public void setSourceAccount(String sourceAccount) {
    this.sourceAccount = sourceAccount;
  }
  public String getTargetAccount() {
    return targetAccount;
  }
  public void setTargetAccount(String targetAccount) {
    this.targetAccount = targetAccount;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
}
