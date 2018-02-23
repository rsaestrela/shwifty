package me.estrela.shwifty;

import org.springframework.web.reactive.function.client.WebClient;

public class ShwiftyLogger implements HttpLogger {

    private static final WebClient.RequestHeadersUriSpec CLIENT = WebClient.create("http://localhost:8080").get();

    @Override
    public void trace(String log) {
        CLIENT.uri(String.format("/add?logLevel=%s&logLine=%s", LogLevel.TRACE, log)).exchange().block();
    }

    @Override
    public void debug(String log) {
        CLIENT.uri(String.format("/add?logLevel=%s&logLine=%s", LogLevel.DEBUG, log)).exchange().block();
    }

    @Override
    public void info(String log) {
        CLIENT.uri(String.format("/add?logLevel=%s&logLine=%s", LogLevel.INFO, log)).exchange().block();
    }

    @Override
    public void warn(String log) {
        CLIENT.uri(String.format("/add?logLevel=%s&logLine=%s", LogLevel.WARN, log)).exchange().block();
    }

    @Override
    public void error(String log) {
        CLIENT.uri(String.format("/add?logLevel=%s&logLine=%s", LogLevel.ERROR, log)).exchange().block();
    }


}
