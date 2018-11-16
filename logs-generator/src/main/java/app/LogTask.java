package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class LogTask extends TimerTask {

	public static final String MESSAGE_INFO = "complete={} service={} status={} response='{}'";
	public static final String MESSAGE_ERROR = "complete={} service={} status={} code={} response='{}'";

	public final Logger log = LogManager.getLogger(LogTask.class);
	public final Random random = new Random();
	public final List<String> services = Arrays.asList("invoice", "payroll", "user", "accounting", "purchasing", "sale");
	public final List<String> errors = Arrays.asList("400:A001:Bad request", "500:B002:Exception null pointer exeption", "403:C050:Unauthorized token", "500:B003:Dependent records not completed");
	public final List<String> success = Arrays.asList("200:Operation success", "201:Saved record", "204:Operation success", "404:Not found");

	@Override
	public void run() {
		int rand = random.nextInt(100);
		String service = services.get(random.nextInt(services.size()));

		if (rand < 90) {
			String[] info = success.get(random.nextInt(success.size())).split(":");
			log.info(MESSAGE_INFO, "success", service, info[0], info[1]);
		} else {
			String[] error = errors.get(random.nextInt(errors.size())).split(":");
			log.error(MESSAGE_ERROR, "fail", service, error[0], error[1], error[2]);
		}
	}

}
