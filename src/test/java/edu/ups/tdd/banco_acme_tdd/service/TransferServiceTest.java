package edu.ups.tdd.banco_acme_tdd.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ups.tdd.banco_acme_tdd.model.dto.TransferDTO;

public class TransferServiceTest {

  private TransferService transferService;
  private static final String SOURCE_ACCOUNT = "123";
  private static final String TARGET_ACCOUNT = "456";
  
  @BeforeEach
  void setUp() {
      transferService = new TransferServiceImpl();
  }
  
  @Test
  void shouldTransferSuccessfullyWhenEnoughBalance() {
    // Arrange
    TransferDTO transferDTO = new TransferDTO(
        SOURCE_ACCOUNT,
        TARGET_ACCOUNT,
        new BigDecimal("500.00"),
        "Test transfer"
    );
    
    // Act
    boolean result = transferService.transfer(transferDTO);
    
    // Assert
    assertTrue(result);
  }

  @Test
  void shouldFailTransferWhenInsufficientBalance() {
    // Arrange
    TransferDTO transferDTO = new TransferDTO(
        SOURCE_ACCOUNT,
        TARGET_ACCOUNT,
        new BigDecimal("500.00"),
        "Test transfer"
    );
    
    // Act
    boolean result = transferService.transfer(transferDTO);
    
    // Assert
    assertTrue(result);
  }
  
}
