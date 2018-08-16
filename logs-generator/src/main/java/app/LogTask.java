package app;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class LogTask extends TimerTask {
    public final List<String> levels = Arrays.asList(
            "INFO",
            "ERROR"
    );
    public final Logger log = LogManager.getLogger(LogTask.class);
    public final Random random = new Random();

    @Override
    public void run() {
        log.log(getRandomLevel(), "type=request");
    }

    private Level getRandomLevel() {
        return Level.getLevel(levels.get(random.nextInt(levels.size())));
    }
}
