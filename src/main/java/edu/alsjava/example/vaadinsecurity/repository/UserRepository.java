package edu.alsjava.example.vaadinsecurity.repository;

import edu.alsjava.example.vaadinsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aluis on 5/10/20.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
