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
package me.estrela.shwifty.domain;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class LogLineController {

    private final LogLineRepository logLineRepository;

    public LogLineController(LogLineRepository logLineRepository) {
        this.logLineRepository = logLineRepository;
    }

    @RequestMapping(path = "/logs", method = RequestMethod.GET, produces = "application/stream+json")
    public Flux<LogLine> getLogStream() {
        return logLineRepository.findLogLinesBy();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Mono<Void> add(@RequestBody Mono<LogLine> logLine) {
        return logLineRepository.insert(logLine).then();
    }
}
