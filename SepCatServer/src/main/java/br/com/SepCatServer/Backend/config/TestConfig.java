package br.com.SepCatServer.Backend.config;

import br.com.SepCatServer.Backend.entities.Users;
import br.com.SepCatServer.Backend.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public void run(String... args) throws Exception {
        Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "1234");

        Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "1234");

        usersRepository.saveAll(Arrays.asList(u1, u2));
    }
}