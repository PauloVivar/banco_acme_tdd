package edu.ups.tdd.banco_acme_tdd.service;

import edu.ups.tdd.banco_acme_tdd.model.dto.TransferDTO;

public interface TransferService {

  boolean transfer(TransferDTO transferDTO);
  
}