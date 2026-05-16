package com.ironhacker.helloagorapi.dto;

import com.ironhacker.helloagorapi.model.Philosopher;
import com.ironhacker.helloagorapi.model.Quote;


public record QuoteDto(Long id, String content, String topic, Philosopher philosopher) {

    public static QuoteDto toDto(Quote quote) {
        return new QuoteDto(quote.getId(), quote.getContent(), quote.getTopic(), quote.getPhilosopher());
    }
}
