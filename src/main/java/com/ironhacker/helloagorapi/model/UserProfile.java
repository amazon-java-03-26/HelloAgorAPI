package com.ironhacker.helloagorapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private Integer age;
    private String favoriteSchoolOfThought;
    @Column(length = 2000)
    private String bio;
}
