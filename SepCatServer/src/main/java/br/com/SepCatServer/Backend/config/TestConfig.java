package br.com.SepCatServer.Backend.config;

import br.com.SepCatServer.Backend.entities.Category;
import br.com.SepCatServer.Backend.entities.Inssue;
import br.com.SepCatServer.Backend.entities.User;
import br.com.SepCatServer.Backend.entities.enums.InssueStatus;
import br.com.SepCatServer.Backend.repositories.CategoryRepository;
import br.com.SepCatServer.Backend.repositories.InssueRepository;
import br.com.SepCatServer.Backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private InssueRepository inssueRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Bug");
        Category cat2 = new Category(null, "Melhoria");
        Category cat3 = new Category(null, "Nova feature");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "1234");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "1234");

        Inssue i1 = new Inssue (null, Instant.parse("2019-06-20T19:53:07Z"), InssueStatus.ABERTO,  u1);
        Inssue i2 = new Inssue (null, Instant.parse("2019-07-21T03:42:10Z"), InssueStatus.FECHADO, u2);
        Inssue i3 = new Inssue (null, Instant.parse("2019-07-22T15:21:22Z"), InssueStatus.RASCUNHO, u1);

        usersRepository.saveAll(Arrays.asList(u1, u2));
        inssueRepository.saveAll(Arrays.asList(i1, i2, i3));
    }
}