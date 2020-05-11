package edu.alsjava.example.vaadinsecurity.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by aluis on 5/10/20.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @NotBlank
    @Column(length = 1000, nullable = false)
    private String password;

    @Column
    private boolean enabled = true;
}
