package com.userservice.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  userId;

    @Column( nullable = false)
    private String firstName;

    @Column( nullable = false )
    private String lastName;

    @Column( unique = true , nullable = false )
    private String email;

    @Column( nullable = false )
    private String password;

    @Column( nullable = false )
    private int age;
}

