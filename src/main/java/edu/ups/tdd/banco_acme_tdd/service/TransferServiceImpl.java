package edu.ups.tdd.banco_acme_tdd.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import edu.ups.tdd.banco_acme_tdd.model.Account;
import edu.ups.tdd.banco_acme_tdd.model.dto.TransferDTO;

public class TransferServiceImpl implements TransferService {

  private final Map<String, Account> accountsDB = new HashMap<>();
    
  public TransferServiceImpl() {
      // Inicializa las cuentas mock
      accountsDB.put("123", new Account("123", new BigDecimal("1000.00")));
      accountsDB.put("456", new Account("456", new BigDecimal("0.00")));
  }

  @Override
  public boolean transfer(TransferDTO transferDTO) {
    Account sourceAccount = accountsDB.get(transferDTO.getSourceAccount());
    Account targetAccount = accountsDB.get(transferDTO.getTargetAccount());
    
    if (sourceAccount == null || targetAccount == null) {
        return false;
    }
    
    if (sourceAccount.getBalance().compareTo(transferDTO.getAmount()) < 0) {
        return false;
    }
    
    BigDecimal newSourceBalance = sourceAccount.getBalance().subtract(transferDTO.getAmount());
    BigDecimal newTargetBalance = targetAccount.getBalance().add(transferDTO.getAmount());
    
    sourceAccount.setBalance(newSourceBalance);
    targetAccount.setBalance(newTargetBalance);
    
    return true;
  }

  
  
}
