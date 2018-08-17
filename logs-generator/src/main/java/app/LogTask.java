package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.TimerTask;

public class LogTask extends TimerTask {
    public static final String MESSAGE = "complete={} status={}";
    public final Logger log = LogManager.getLogger(LogTask.class);
    public final Random random = new Random();

    @Override
    public void run() {
        int rand = random.nextInt(100);
        if (rand < 95) {
            log.info(MESSAGE, "success", "200");
        } else {
            log.error(MESSAGE, "fail", "500");
        }
    }

}
