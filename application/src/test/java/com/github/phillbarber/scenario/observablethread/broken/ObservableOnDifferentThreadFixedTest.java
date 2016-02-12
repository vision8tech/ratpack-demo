package com.github.phillbarber.scenario.observablethread.broken;

import ch.qos.logback.classic.Level;
import com.github.phillbarber.ExpectedLogs;
import com.github.phillbarber.FunctionalTest;
import org.junit.Rule;
import org.junit.Test;
//import uk.org.lidalia.slf4jtest.LoggingEvent;
//import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.phillbarber.scenario.observablethread.broken.ObservableOnDifferentThreadBrokenTest.NO_RESPONSE_SENT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class ObservableOnDifferentThreadFixedTest extends FunctionalTest {


    //https://github.com/ratpack/ratpack/issues/682


    @Rule
    public ExpectedLogs expectedLogs = ExpectedLogs.forRootLogger();


    @Test
    public void observableOnDifferentThreadWorksWhenConvertedToAPromise() throws URISyntaxException {


  //      TestLoggerFactory.clear();
        URI uri = new URI(getAddress().toString() + "observable-different-thread-fixed");
        Response response = jerseyClient().target(uri).request().get();

        assertThat(response.getStatus()).isEqualTo(200);

        expectedLogs.assertLogsDoNotContain(Level.WARN, NO_RESPONSE_SENT_ERROR_MESSAGE);


        //    List<LoggingEvent> allLoggingEvents = TestLoggerFactory.getAllLoggingEvents();

      //  assertThat(containsLogEventWithThrowable(allLoggingEvents, DoubleTransmissionException.class)).isFalse();
       // assertThat(containsLogEventWithMessage(allLoggingEvents, "No response sent for GET request to /observable-different-thread-broken ")).isFalse();


    }

//    private boolean containsLogEventWithThrowable(List<LoggingEvent> allLoggingEvents, Class clazz) {
//
//        return allLoggingEvents.parallelStream()
//                .filter(loggingEventPredicate -> loggingEventPredicate.getThrowable().isPresent())
//                .filter(loggingEvent -> loggingEvent.getThrowable().get().getClass().equals(clazz)).findAny().isPresent();
//    }
//
//    private boolean containsLogEventWithMessage(List<LoggingEvent> allLoggingEvents, String message) {
//
//        return allLoggingEvents.parallelStream()
//                .filter(loggingEvent -> loggingEvent.getMessage().contains(message)).findAny().isPresent();
//    }
}
