package com.ironhacker.helloagorapi.controller;

import com.ironhacker.helloagorapi.dto.QuoteDto;
import com.ironhacker.helloagorapi.model.Quote;
import com.ironhacker.helloagorapi.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping
    public List<QuoteDto> getAll() {
        return quoteService.findAll();
    }

    @GetMapping("/{id}")
    public QuoteDto getById(@PathVariable Long id) {
        return quoteService.findById(id);
    }

    @PostMapping("philosophers/{philosopherId}")
    public QuoteDto save(@PathVariable Long philosopherId, @RequestBody Quote quote) {
        return quoteService.save(philosopherId, quote);
    }

    @GetMapping("philosophers/{philosopherId}")
    public List<QuoteDto> getByPhilosopherId(@PathVariable Long philosopherId) {
        return quoteService.findByPhilosopherId(philosopherId);
    }

    @GetMapping("philosophers/school/{philosopherSchool}")
    public List<QuoteDto> getByPhilosopherSchool(@PathVariable String philosopherSchool) {
        return quoteService.findByPhilosopherSchool(philosopherSchool);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quoteService.delete(id);
    }



}
