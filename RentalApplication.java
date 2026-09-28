package com.rental;

import com.rental.model.Product;
import com.rental.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentalApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Product("MacBook Air M2", "Apple", "Laptop",
                        "13-inch MacBook Air M2, suitable for study and work.", 999, 5000,
                        "https://images.unsplash.com/photo-1517336714739-489689fd1ca8"));
                repository.save(new Product("iPhone 15 Pro", "Apple", "Smartphone",
                        "Premium smartphone available for short and long rentals.", 799, 5000,
                        "https://images.unsplash.com/photo-1695048133142-1a20484d2569"));
                repository.save(new Product("Sony Alpha Camera", "Sony", "Camera",
                        "Mirrorless camera for events, travel and content creation.", 699, 4000,
                        "https://images.unsplash.com/photo-1516035069371-29a1b244cc32"));
                repository.save(new Product("iPad Air", "Apple", "Tablet",
                        "Lightweight tablet for study, design and entertainment.", 499, 3000,
                        "https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0"));
            }
        };
    }
}
