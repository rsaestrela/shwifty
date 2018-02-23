package me.estrela.shwifty;

public interface HttpLogger {

    void trace(String log);

    void debug(String log);

    void info(String log);

    void warn(String log);

    void error(String log);

}
