package com.ironhacker.helloagorapi.service;

import com.ironhacker.helloagorapi.dto.QuoteDto;
import com.ironhacker.helloagorapi.exceptions.AgorApiException;
import com.ironhacker.helloagorapi.model.Quote;
import com.ironhacker.helloagorapi.repository.PhilosopherRepository;
import com.ironhacker.helloagorapi.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;
    private final PhilosopherRepository philosopherRepository;

    public List<QuoteDto> findAll() {
        var allQuotes = quoteRepository.findAll();
        List<QuoteDto> allQuotesDto = new ArrayList<>();
        for (Quote quote : allQuotes) {
            allQuotesDto.add(QuoteDto.toDto(quote));
        }
        return allQuotesDto;

    }

    public QuoteDto findById(Long id) {
        var quote = quoteRepository.findById(id).orElseThrow(
                () -> new AgorApiException("Quote not found with id: " + id)

        );
        return QuoteDto.toDto(quote);
    }

    public QuoteDto save(Long philosopherId, Quote quoteToSave) {
        var philosopher = philosopherRepository.findById(philosopherId).orElseThrow(
                () -> new AgorApiException("Philosopher not found with id: " + philosopherId)
        );
        quoteToSave.setPhilosopher(philosopher);
        return QuoteDto.toDto(quoteRepository.save(quoteToSave));
    }

    public List<QuoteDto> findByPhilosopherId(Long philosopherId) {

        var allQuotes = quoteRepository.findByPhilosopher_Id(philosopherId);
        List<QuoteDto> allQuotesDto = new ArrayList<>();
        for (Quote quote : allQuotes) {
            allQuotesDto.add(QuoteDto.toDto(quote));
        }
        return allQuotesDto;
    }

    public List<QuoteDto> findByPhilosopherSchool(String school) {
        var allQuotes = quoteRepository.findByPhilosopher_School(school);
        List<QuoteDto> allQuotesDto = new ArrayList<>();
        for (Quote quote : allQuotes) {
            allQuotesDto.add(QuoteDto.toDto(quote));
        }
        return allQuotesDto;
    }

    public void delete(Long id) {
        quoteRepository.deleteById(id);
    }
}
