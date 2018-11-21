package app;

import java.util.Random;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTask extends TimerTask {

	private static final int PROBABILITY = 90;
	private static final String FAIL = "Fail";
	private static final String SUCCESS = "Success";
	private static final String MESSAGE_INFO = "complete={} service={} status={} response='{}' duration={}";
	private static final String MESSAGE_ERROR = "complete={} service={} status={} code={} response='{}' duration={}";

	private static final Logger log = LogManager.getLogger(LogTask.class);
	private static final Random random = new Random();

	@Override
	public void run() {
		if (isInfo()) {
			logInfo();
		} else {
			logError();
		}
	}

	private boolean isInfo() {
		return random.nextInt(100) < PROBABILITY;
	}

	private void logError() {
		Error error = Error.getRandom();
		Service service = Service.getRandom();
		log.error(MESSAGE_ERROR, FAIL, service, error.getStatus(), error.getCode(), error.getMessage(), error.getDuration());
	}

	private void logInfo() {
		Success success = Success.getRandom();
		Service service = Service.getRandom();
		log.info(MESSAGE_INFO, SUCCESS, service, success.getStatus(), success.getMessage(), success.getDuration());
	}

}
