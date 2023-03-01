import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not reached! It is "+i);
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }

    @org.junit.Test
    public void thresholdReached() {
        Integer finalLimit = 0;

        LogginLab lab2 = new LogginLab();
        lab2.setThreshold(finalLimit);

        for (Integer j = 5; j >= finalLimit; j--) {
            if(lab2.thresholdReached(j)) {
                logger.log(Level.INFO, "Threshold reached! It is " + j);
                assertTrue(lab2.thresholdReached(j));
            } else {
                logger.log(Level.INFO, "Threshold is not reached!");
                assertFalse(lab2.thresholdReached(j));
            }
        }
    }
}