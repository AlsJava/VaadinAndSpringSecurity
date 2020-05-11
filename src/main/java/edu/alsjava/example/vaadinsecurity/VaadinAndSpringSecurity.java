package edu.alsjava.example.vaadinsecurity;

import edu.alsjava.example.vaadinsecurity.domain.User;
import edu.alsjava.example.vaadinsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by aluis on 5/10/20.
 */
@SpringBootApplication
public class VaadinAndSpringSecurity {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(VaadinAndSpringSecurity.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        createUser("demo", "demo");
        createUser("test", "test");
    }

    private void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.saveAndFlush(user);
    }

}
