package com.rcamargo.hrworker;

import com.rcamargo.hrworker.entities.Worker;
import com.rcamargo.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;

@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication implements CommandLineRunner {

    @Autowired
    private WorkerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(HrWorkerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Worker w1 = new Worker(null, "Rafael", 300.0);
        Worker w2 = new Worker(null, "Rui", 150.0);
        Worker w3 = new Worker(null, "Rogerio", 150.0);
        Worker w4 = new Worker(null, "Rodrigo", 200.0);

        repository.saveAll(Arrays.asList(w1,w2,w3,w4));
    }
}
