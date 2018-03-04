/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.shwifty.client;

import ch.qos.logback.classic.Level;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.estrela.shwifty.domain.LogLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.Marker;

import java.io.IOException;

import static java.lang.String.format;

public class ShwiftyLogger implements Logger {

    private static final String SERVER_ENDPOINT = "http://localhost:9999";
    private final CloseableHttpClient webClient;
    private final Class clazz;
    private int effectiveLevel;

    ShwiftyLogger(CloseableHttpClient webClient, Class clazz, Level level) {
        this.webClient = webClient;
        this.clazz = clazz;
        this.effectiveLevel = level.levelInt;
    }

    @Override
    public String getName() {
        return clazz.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return effectiveLevel >= Level.TRACE_INT;
    }

    @Override
    public void trace(String msg) {
        post(msg, Level.TRACE);
    }

    @Override
    public void trace(String format, Object arg) {
        if (isTraceEnabled()) {
            String msg = format(format, arg);
            post(msg, Level.TRACE);
        }
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        if (isTraceEnabled()) {
            String msg = format(format, arg1, arg2);
            post(msg, Level.TRACE);
        }
    }

    @Override
    public void trace(String format, Object... arguments) {
        if (isTraceEnabled()) {
            String msg = format(format, arguments);
            post(msg, Level.TRACE);
        }
    }

    @Override
    public void trace(String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void trace(Marker marker, String msg) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDebugEnabled() {
        return effectiveLevel >= Level.DEBUG_INT;
    }

    @Override
    public void debug(String msg) {
        if (isDebugEnabled()) {
            post(msg, Level.DEBUG);
        }
    }

    @Override
    public void debug(String format, Object arg) {
        if (isDebugEnabled()) {
            String msg = format(format, arg);
            post(msg, Level.DEBUG);
        }
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        if (isDebugEnabled()) {
            String msg = format(format, arg1, arg2);
            post(msg, Level.DEBUG);
        }
    }

    @Override
    public void debug(String format, Object... arguments) {
        if (isDebugEnabled()) {
            String msg = format(format, arguments);
            post(msg, Level.DEBUG);
        }
    }

    @Override
    public void debug(String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void debug(Marker marker, String msg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInfoEnabled() {
        return effectiveLevel >= Level.INFO_INT;
    }

    @Override
    public void info(String msg) {
        if (isInfoEnabled()) {
            post(msg, Level.INFO);
        }
    }

    @Override
    public void info(String format, Object arg) {
        if (isInfoEnabled()) {
            String msg = format(format, arg);
            post(msg, Level.INFO);
        }
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        if (isInfoEnabled()) {
            String msg = format(format, arg1, arg2);
            post(msg, Level.INFO);
        }
    }

    @Override
    public void info(String format, Object... arguments) {
        if (isInfoEnabled()) {
            String msg = format(format, arguments);
            post(msg, Level.INFO);
        }
    }

    @Override
    public void info(String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void info(Marker marker, String msg) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isWarnEnabled() {
        return effectiveLevel >= Level.WARN_INT;
    }

    @Override
    public void warn(String msg) {
        if (isWarnEnabled()) {
            post(msg, Level.WARN);
        }
    }

    @Override
    public void warn(String format, Object arg) {
        if (isWarnEnabled()) {
            String msg = format(format, arg);
            post(msg, Level.WARN);
        }
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        if (isWarnEnabled()) {
            String msg = format(format, arg1, arg2);
            post(msg, Level.WARN);
        }
    }

    @Override
    public void warn(String format, Object... arguments) {
        if (isWarnEnabled()) {
            String msg = format(format, arguments);
            post(msg, Level.WARN);
        }
    }

    @Override
    public void warn(String msg, Throwable t) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void warn(Marker marker, String msg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isErrorEnabled() {
        return effectiveLevel >= Level.ERROR_INT;
    }

    @Override
    public void error(String msg) {
        if (isErrorEnabled()) {
            post(msg, Level.WARN);
        }
    }

    @Override
    public void error(String format, Object arg) {
        if (isErrorEnabled()) {
            String msg = format(format, arg);
            post(msg, Level.WARN);
        }
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        if (isErrorEnabled()) {
            String msg = format(format, arg1, arg2);
            post(msg, Level.WARN);
        }
    }

    @Override
    public void error(String format, Object... arguments) {
        if (isErrorEnabled()) {
            String msg = format(format, arguments);
            post(msg, Level.WARN);
        }
    }

    @Override
    public void error(String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void error(Marker marker, String msg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        throw new UnsupportedOperationException();
    }

    private void post(String msg, Level level) {
        HttpPost httpPost = new HttpPost(SERVER_ENDPOINT.concat("/add"));
        httpPost.addHeader("content-type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        try {

            httpPost.setEntity(new StringEntity(
                    mapper.writeValueAsString(new LogLine(level.levelStr, msg)), ContentType.APPLICATION_JSON));
            webClient.execute(httpPost);
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}