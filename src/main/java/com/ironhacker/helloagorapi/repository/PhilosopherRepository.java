package com.ironhacker.helloagorapi.repository;

import com.ironhacker.helloagorapi.model.Philosopher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhilosopherRepository extends JpaRepository<Philosopher, Long> {
}
