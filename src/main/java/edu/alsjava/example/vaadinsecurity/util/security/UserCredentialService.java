package edu.alsjava.example.vaadinsecurity.util.security;

import edu.alsjava.example.vaadinsecurity.domain.User;
import edu.alsjava.example.vaadinsecurity.model.LoginData;
import edu.alsjava.example.vaadinsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by aluis on 5/10/20.
 */
@Service
public class UserCredentialService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new LoginData(user);
    }
}
