require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.mail.MailClient
module VertxMail
  #  SMTP mail client for Vert.x
  #  <p>
  #  A simple asynchronous API for sending mails from Vert.x applications
  class MailClient
    # @private
    # @param j_del [::VertxMail::MailClient] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxMail::MailClient] the underlying java delegate
    def j_del
      @j_del
    end
    #  create an instance of MailClient that is running in the local JVM
    # @param [::Vertx::Vertx] vertx the Vertx instance the operation will be run in
    # @param [Hash] config MailConfig configuration to be used for sending mails
    # @return [::VertxMail::MailClient] MailClient instance that can then be used to send multiple mails
    def self.create(vertx=nil,config=nil)
      if vertx.class.method_defined?(:j_del) && config.class == Hash && !block_given?
        return ::VertxMail::MailClient.new(Java::IoVertxExtMail::MailClient.java_method(:create, [Java::IoVertxCore::Vertx.java_class,Java::IoVertxExtMail::MailConfig.java_class]).call(vertx.j_del,Java::IoVertxExtMail::MailConfig.new(::Vertx::Util::Utils.to_json_object(config))))
      end
      raise ArgumentError, "Invalid arguments when calling create(vertx,config)"
    end
    #  send a single mail via MailClient
    # @param [Hash] email MailMessage object containing the mail text, from/to, attachments etc
    # @yield will be called when the operation is finished or it fails (may be null to ignore the result) the result JsonObject currently only contains {@code {"result":"success"}}
    # @return [self]
    def send_mail(email=nil)
      if email.class == Hash && block_given?
        @j_del.java_method(:sendMail, [Java::IoVertxExtMail::MailMessage.java_class,Java::IoVertxCore::Handler.java_class]).call(Java::IoVertxExtMail::MailMessage.new(::Vertx::Util::Utils.to_json_object(email)),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling send_mail(email)"
    end
    #  close the MailClient
    # @return [void]
    def close
      if !block_given?
        return @j_del.java_method(:close, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling close()"
    end
  end
end
