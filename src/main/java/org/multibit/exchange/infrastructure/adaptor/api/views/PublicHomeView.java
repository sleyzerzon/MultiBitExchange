package org.multibit.exchange.infrastructure.adaptor.api.views;

import com.google.common.base.Preconditions;
import org.multibit.exchange.infrastructure.web.HomeModel;

/**
 * <p>View to provide the following to resources:</p>
 * <ul>
 * <li>Representation provided by a Freemarker template with a given common</li>
 * </ul>
 * <p>Presenting the view in this manner assists with Freemarker debugging</p>
 *
 * @since 0.0.1
 */
public class PublicHomeView extends PublicFreemarkerView<HomeModel> {

  /**
   * @param templateName The template name (no leading "/")
   * @param model The backing common for the view
   */
  public PublicHomeView(String templateName, HomeModel model) {
    super(templateName, model);
    Preconditions.checkArgument(templateName.startsWith("common"));
  }
}
