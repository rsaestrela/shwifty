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
package me.estrela.shwifty;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class LogLineController {

    private final LogLineRepository logLineRepository;

    public LogLineController(LogLineRepository logLineRepository) {
        this.logLineRepository = logLineRepository;
    }

    @GetMapping(path = "/logs", produces = "application/stream+json")
    public Flux<LogLine> getLogStream() {
        return logLineRepository.findLogLinesBy();
    }

    @GetMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam(value = "logLevel") LogLevel logLevel, @RequestParam(value = "logLine") String logLine) {
        logLineRepository.insert(new LogLine(logLevel, logLine)).block();
    }

}
