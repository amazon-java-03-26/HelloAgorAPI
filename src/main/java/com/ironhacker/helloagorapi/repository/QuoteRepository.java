package com.ironhacker.helloagorapi.repository;

import com.ironhacker.helloagorapi.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findByPhilosopher_Id(Long philosopherId);

    List<Quote> findByPhilosopher_School(String school);
}
