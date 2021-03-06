package org.multibit.exchange.infrastructure.adaptor.api.views;

import com.yammer.dropwizard.views.View;
import org.multibit.common.DateUtils;
import org.multibit.exchange.infrastructure.web.BaseModel;

/**
 * <p>View to provide the following to resources:</p>
 * <ul>
 * <li>Representation provided by a Freemarker template with a given common</li>
 * </ul>
 *
 * @since 0.0.1
 */
public class PublicFreemarkerView<T extends BaseModel> extends View {

  private final T model;

  /**
   * @param templateName The template name (no leading "/")
   * @param model The backing common for the view
   */
  public PublicFreemarkerView(String templateName, T model) {
    super("/views/ftl/" + templateName);
    this.model = model;
  }

  public T getModel() {
    return model;
  }

  /**
   * @param timestamp The timestamp
   *
   * @return A social media friendly representation of the timestamp
   */
  public String formatForSocialMedia(long timestamp) {
    return DateUtils.formatForSocialMedia(timestamp);
  }

}
