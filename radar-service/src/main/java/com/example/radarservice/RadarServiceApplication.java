package com.example.radarservice;


import com.example.radarservice.entites.Radar;
import com.example.radarservice.repositories.RadarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class RadarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RadarServiceApplication.class, args);
    }

    Random random = new Random();
    @Bean
    CommandLineRunner start(RadarRepository radarRepository) {
        return args -> {
            Stream.of("R1", "R2", "R3", "R4").forEach(i -> {
                Radar radar = Radar.builder()
                        .name(i)
                        .status(true)
                        .maxSpeed(120)
                        .latitude(random.nextDouble(10))
                        .longitude(random.nextDouble(10))
                        .build();
                radarRepository.save(radar);
            });
        };
    }
}
