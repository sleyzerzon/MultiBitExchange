package org.multibit.exchange.infrastructure.adaptor.events;

import org.multibit.exchange.domainmodel.ExchangeId;

/**
 * <p>Event indicating a {@link org.multibit.exchange.domainmodel.Exchange} was created.</p>
 *
 * @since 0.0.1
 */
public class ExchangeCreatedEvent {
  private ExchangeId exchangeId;

  public ExchangeCreatedEvent(ExchangeId exchangeId) {
    this.exchangeId = exchangeId;
  }

  public ExchangeId getExchangeId() {
    return exchangeId;
  }
}
