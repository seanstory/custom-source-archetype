import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import static ch.qos.logback.classic.Level.*

def PATTERN = "%d %highlight(%-5level) [%thread] %logger{36} - %msg%n"

appender("console", ConsoleAppender) {
    encoder(PatternLayoutEncoder) { pattern = PATTERN }
}

logger("${package}", DEBUG)
logger("com.seanjstory.workplace.search.client", TRACE)
root(INFO, ["console"])
