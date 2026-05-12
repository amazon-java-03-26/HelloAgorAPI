package com.ironhacker.helloagorapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "philosopher")
public class Philosopher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String school;
    private Integer birthYear;
    @Column(length = 2000)
    private String biography;

    @OneToMany(mappedBy = "philosopher", cascade = CascadeType.ALL)
    private List<Quote> quotes = new ArrayList<>();

    @ManyToMany(mappedBy = "followedPhilosophers")
    @JsonIgnore
    private List<User> followers = new ArrayList<>();
}
