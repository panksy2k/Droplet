package com.pardasani.digital;

import com.pardasani.digital.common.config.MongoDBConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Import({MongoDBConfiguration.class})
public class MediaManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaManagementApplication.class, args);
	}
}
