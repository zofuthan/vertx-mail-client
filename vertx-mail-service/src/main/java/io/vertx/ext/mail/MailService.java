package io.vertx.ext.mail;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.ProxyIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@ProxyGen
@VertxGen
public interface MailService extends MailClient {

  /**
   * create an instance of  MailService that calls the mail service via the event bus running somewhere else
   *
   * @param vertx the Vertx instance the operation will be run in
   * @param address the eb address of the mail service running somewhere, default is "vertx.mail"
   * @return MailService instance that can then be used to send multiple mails
   */
  static MailService createEventBusProxy(Vertx vertx, String address) {
    return ProxyHelper.createProxy(MailService.class, vertx, address);
  }

  @Override
  @Fluent
  MailService sendMail(MailMessage email, Handler<AsyncResult<JsonObject>> resultHandler);

  @Override
  @ProxyIgnore
  void close();
}