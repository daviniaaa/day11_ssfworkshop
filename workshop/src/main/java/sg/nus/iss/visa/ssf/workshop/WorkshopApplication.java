package sg.nus.iss.visa.ssf.workshop;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopApplication {
	private static final Logger logger = LoggerFactory.getLogger(WorkshopApplication.class);
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		// logger.info is similar to System.out.println
		logger.info("main method has started");

		SpringApplication app = new SpringApplication(WorkshopApplication.class);
		ApplicationArguments opts = new DefaultApplicationArguments(args);
		
		String portNum;
		if (opts.containsOption("port")){
			List<String> values = opts.getOptionValues("port");
			portNum = (String) values.get(0);
		} else {
			portNum = System.getenv("PORT");

			if (portNum == null) {
				portNum = DEFAULT_PORT;
			}
		} 

		app.setDefaultProperties(Collections.singletonMap("server.port", portNum));

		app.run(args);
	}

}
