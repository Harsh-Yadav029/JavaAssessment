package com.example.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MemberRepository memberRepository;

    public DataInitializer(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if data already exists
        if (memberRepository.count() == 0) {
            // Insert dummy data only if no records exist
            memberRepository.save(new Member(
                    UUID.randomUUID(),
                    "John Doe",
                    LocalDate.of(2023, 5, 15),
                    3,
                    true
            ));

            memberRepository.save(new Member(
                    UUID.randomUUID(),
                    "Jane Smith",
                    LocalDate.of(2022, 12, 10),
                    5,
                    false
            ));

            memberRepository.save(new Member(
                    UUID.randomUUID(),
                    "Alex Johnson",
                    LocalDate.of(2021, 8, 20),
                    1,
                    true
            ));

            System.out.println("Sample data inserted.");
        } else {
            System.out.println("Data already exists. Skipping insertion.");
        }
    }
}

