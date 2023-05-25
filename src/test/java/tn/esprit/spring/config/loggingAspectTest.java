package tn.esprit.spring.config;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class loggingAspectTest {
    @Mock
    private Logger logger;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @Test
    public void testLogMethodEntry() {
        JoinPoint joinPoint = mock(JoinPoint.class);
        when(joinPoint.getSignature().getName()).thenReturn("methodName");

        loggingAspect.logMethodEntry(joinPoint);

        verify(logger, times(1)).info("In method methodName : ");
    }

    @Test
    public void testLogMethodExit() {
        JoinPoint joinPoint = mock(JoinPoint.class);
        when(joinPoint.getSignature().getName()).thenReturn("methodName");

        loggingAspect.logMethodExit(joinPoint);

        verify(logger, times(1)).info("Out of methodName");
    }
}
