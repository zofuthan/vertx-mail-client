/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.rxjava.ext.mail;

import java.util.Map;
import io.vertx.lang.rxjava.InternalHelper;
import rx.Observable;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.mail.MailMessage;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.mail.MailService original} non RX-ified interface using Vert.x codegen.
 */

public class MailService extends MailClient {

  final io.vertx.ext.mail.MailService delegate;

  public MailService(io.vertx.ext.mail.MailService delegate) {
    super(delegate);
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public MailService sendMail(MailMessage email, Handler<AsyncResult<JsonObject>> resultHandler) { 
    this.delegate.sendMail(email, resultHandler);
    return this;
  }

  public Observable<JsonObject> sendMailObservable(MailMessage email) { 
    io.vertx.rx.java.ObservableFuture<JsonObject> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    sendMail(email, resultHandler.toHandler());
    return resultHandler;
  }

  public void close() { 
    this.delegate.close();
  }


  public static MailService newInstance(io.vertx.ext.mail.MailService arg) {
    return new MailService(arg);
  }
}
