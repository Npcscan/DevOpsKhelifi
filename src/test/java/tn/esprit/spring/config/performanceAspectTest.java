package tn.esprit.spring.config;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class performanceAspectTest {
    @Mock
    private Logger logger;

    @InjectMocks
    private PerformanceAspect performanceAspect;

    @Test
    public void testProfile() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.proceed()).thenReturn("result");

        performanceAspect.profile(proceedingJoinPoint);

        verify(logger, times(1)).info(anyString());
    }