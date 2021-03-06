package org.multibit.exchange.infrastructure.adaptor.api.readmodel;

/**
 * <p>RuntimeException to provide the following to the api readmodel:</p>
 * <ul>
 * <li>Indication that initialization of the {@link ReadService} failed</li>
 * </ul>
 *
 * @since 0.0.1
 */
public class ReadServiceInitializationException extends RuntimeException {
  public ReadServiceInitializationException(String message, Exception cause) {
    super(message, cause);
  }

  public ReadServiceInitializationException(String message) {
    super(message);
  }
}
