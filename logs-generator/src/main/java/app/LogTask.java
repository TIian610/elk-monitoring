package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class LogTask extends TimerTask {

	public static final String MESSAGE_INFO = "complete={} service={} status={} response='{}' duration={}";
	public static final String MESSAGE_ERROR = "complete={} service={} status={} code={} response='{}' duration={}";

	public final Logger log = LogManager.getLogger(LogTask.class);
	public final Random random = new Random();

	@Override
	public void run() {
		Service service = Service.getRandom();
		int rand = random.nextInt(100);
		double duration = 3. * random.nextDouble();

		if (rand < 90) {
			Success success = Success.getRandom();
			log.info(MESSAGE_INFO, "success", service.toString(), success.getStatus(), success.getMessage(), String.format("%.2f", duration));
		} else {
			Error error = Error.getRandom();
			log.error(MESSAGE_ERROR, "fail", service, error.getStatus(), error.getCode(), error.getMessage(), String.format("%.2f", duration));
		}
	}

}
