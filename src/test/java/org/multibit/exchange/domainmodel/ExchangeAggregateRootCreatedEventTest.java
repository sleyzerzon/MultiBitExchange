package org.multibit.exchange.domainmodel;

import org.junit.Test;
import org.multibit.exchange.infrastructure.adaptor.events.CurrencyPairRegisteredEvent;

public class ExchangeAggregateRootCreatedEventTest extends ExchangeAggregateRootTestBase {

  @Test
  public void test_Create() {
    // Arrange

    // Act
    new CurrencyPairRegisteredEvent(exchangeId, currencyPair);

    // Assert
  }

  @Test
  public void test_Create_NullExchangeId() {
    // Arrange
    thrown.expect(NullPointerException.class);
    thrown.expectMessage("exchangeId must not be null");

    // Act
    new CurrencyPairRegisteredEvent(null, currencyPair);

    // Assert
  }

  @Test
  public void test_Create_NullCurrencyPair() {
    // Arrange
    thrown.expect(NullPointerException.class);
    thrown.expectMessage("currencyPair must not be null");

    // Act
    new CurrencyPairRegisteredEvent(exchangeId, null);

    // Assert
  }
}
