package br.com.SepCatServer.Backend.config;

import br.com.SepCatServer.Backend.entities.User;
import br.com.SepCatServer.Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository usersRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "1234");

        User u2 = new User(null, "Alex Green", "alex@gmail.com", "1234");

        usersRepository.saveAll(Arrays.asList(u1, u2));
    }
}