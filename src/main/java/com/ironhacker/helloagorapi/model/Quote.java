package com.ironhacker.helloagorapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2000)
    private String content;
    private String topic;

    @ManyToOne
    @JoinColumn(name = "philosopher_id")
    @JsonIgnore
    private Philosopher philosopher;
}
