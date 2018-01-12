package mcgoohan.springcloud.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}

	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			//parameters stationid, license plate, timestamp
			if(null != args) {
				System.out.println("parameter length is " + args.length);

				String stationId = args[0];
				String licensePlate = args[1];
				String timestamp = args[2];

				System.out.println("Station ID is " + stationId + ", License Plate is " + licensePlate + ", Timestamp is " + timestamp);
			}
		}
	}
}