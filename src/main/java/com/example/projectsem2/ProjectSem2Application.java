package com.example.projectsem2;

import com.example.projectsem2.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ProjectSem2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSem2Application.class, args);
    }

}
