package org.multibit.exchange.infrastructure.adaptor.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.base.Preconditions;
import com.google.inject.CreationException;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import java.io.FileInputStream;
import java.io.IOException;
import org.multibit.exchange.infrastructure.adaptor.api.config.MultiBitExchangeApiConfiguration;
import org.multibit.exchange.infrastructure.adaptor.api.config.MultiBitExchangeApiServiceModule;

/**
 * <p>Service to provide the following to application:</p>
 * <ul>
 * <li>Provision of configuration of dropwizard application</li>
 * </ul>
 * <p>Use <code>java -jar web-develop-SNAPSHOT.jar server mbexchange-demo.yml</code> to start the demo</p>
 *
 * @since 0.0.1
 *         
 */
public class MultiBitExchangeApiWebService extends Service<MultiBitExchangeApiConfiguration> {

  /**
   * The command line arguments to allow DB configuration to take place by Guice
   */
  private String[] args;

  /**
   * Main entry point to the application
   *
   * @param args CLI arguments
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    try {
      new MultiBitExchangeApiWebService(args).run(args);
    } catch (CreationException e) {
      System.err.printf("*********%nException on start up - is 'mongod' running and accessible?%n*********%n");
      System.err.printf(String.format("%s:\n%s", e.getClass().getName(), e.getMessage()));
    }
  }

  /**
   * @param args The command line arguments to allow DB configuration to take place by Guice
   */
  private MultiBitExchangeApiWebService(String[] args) {
    this.args = args;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void initialize(Bootstrap<MultiBitExchangeApiConfiguration> bootstrap) {

    // Configure Guice first
    // TODO The intermediate call to initialize() can be removed after DW 0.6.2+
    // This will fix the unchecked warning
    ConfiguredBundle guiceBundle = GuiceBundle
        .newBuilder()
        .addModule(new MultiBitExchangeApiServiceModule(loadConfigurationFromFile(args))) // The main Guice module with bindings
        .enableAutoConfig(getClass().getPackage().getName()) // Scan application classes
        .build();
    guiceBundle.initialize(bootstrap);
    bootstrap.addBundle(guiceBundle);

    // Add asset bundles
//    bootstrap.addBundle(new AssetsBundle("/assets/css", "/css"));
//    bootstrap.addBundle(new AssetsBundle("/assets/jquery", "/jquery"));
//    bootstrap.addBundle(new AssetsBundle("/assets/images", "/images"));
//
//    // Add view bundle
//    bootstrap.addBundle(new ViewBundle());
  }

  public MultiBitExchangeApiConfiguration loadConfigurationFromFile(String[] args) {
    Preconditions.checkNotNull(args);
    Preconditions.checkElementIndex(1, args.length);

    // Read the YAML configuration
    ObjectMapper om = new ObjectMapper(new YAMLFactory());
    FileInputStream fis;
    try {
      fis = new FileInputStream(args[1]);
      // Stream will be closed on completion
      return om.readValue(fis, MultiBitExchangeApiConfiguration.class);
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot read external configuration from '" + args[1] + "'", e);
    }
  }

  @Override
  public void run(MultiBitExchangeApiConfiguration configuration, Environment environment) throws Exception {

    // Add any specialised configuration here

  }
}
