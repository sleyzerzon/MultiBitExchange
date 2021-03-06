package org.multibit.exchange.domainmodel;

/**
 * <p>[Pattern] to provide the following to {@link [Object]}:</p>
 * <ul>
 * <li></li>
 * </ul>
 * <p>Example:</p>
 * <pre>
 * </pre>
 *
 * @since 0.0.1
 */
public abstract class OrderType {

  private static final OrderType MARKET_ORDER = new MarketOrder();

  public static OrderType marketOrder() {
    return MARKET_ORDER;
  }

  public boolean isMarket() {
    return false;
  }
}
