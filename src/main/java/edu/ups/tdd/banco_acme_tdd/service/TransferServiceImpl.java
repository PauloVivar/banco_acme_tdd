package edu.ups.tdd.banco_acme_tdd.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import edu.ups.tdd.banco_acme_tdd.exception.InsufficientFundsException;
import edu.ups.tdd.banco_acme_tdd.model.Account;
import edu.ups.tdd.banco_acme_tdd.model.dto.TransferDTO;

public class TransferServiceImpl implements TransferService {

  private final Map<String, Account> accountsDB = new HashMap<>();
    
  public TransferServiceImpl() {
    initializeMockAccounts();
  }

  private void initializeMockAccounts() {
    accountsDB.put("123", new Account("123", new BigDecimal("1000.00")));
    accountsDB.put("456", new Account("456", new BigDecimal("0.00")));
  }

  @Override
  public boolean transfer(TransferDTO transferDTO) {
    try {
        validateTransfer(transferDTO);
        executeTransfer(transferDTO);
        return true;
    } catch (InsufficientFundsException | edu.ups.tdd.banco_acme_tdd.exception.AccountNotFoundException e) {
        return false;
    }
  }

  private void validateTransfer(TransferDTO transferDTO) {
    Account sourceAccount = getAccountOrThrow(transferDTO.getSourceAccount());
    //Account targetAccount = getAccountOrThrow(transferDTO.getTargetAccount());
    
    if (sourceAccount.getBalance().compareTo(transferDTO.getAmount()) < 0) {
        throw new InsufficientFundsException("Insufficient funds for transfer");
    }
  }

  private Account getAccountOrThrow(String accountNumber) {
      return Optional.ofNullable(accountsDB.get(accountNumber))
          .orElseThrow(() -> new edu.ups.tdd.banco_acme_tdd.exception.AccountNotFoundException("Account not found: " + accountNumber));
  }

  private void executeTransfer(TransferDTO transferDTO) {
      Account sourceAccount = accountsDB.get(transferDTO.getSourceAccount());
      Account targetAccount = accountsDB.get(transferDTO.getTargetAccount());
      
      BigDecimal newSourceBalance = sourceAccount.getBalance().subtract(transferDTO.getAmount());
      BigDecimal newTargetBalance = targetAccount.getBalance().add(transferDTO.getAmount());
      
      sourceAccount.setBalance(newSourceBalance);
      targetAccount.setBalance(newTargetBalance);
  }
  
}
