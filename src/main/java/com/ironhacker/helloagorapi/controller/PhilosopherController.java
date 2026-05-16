package com.ironhacker.helloagorapi.controller;

import com.ironhacker.helloagorapi.model.Philosopher;
import com.ironhacker.helloagorapi.service.PhilosopherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/philosophers")
@RequiredArgsConstructor
public class PhilosopherController {

    private final PhilosopherService philosopherService;

    @GetMapping
    public List<Philosopher> getAll() {
        return philosopherService.findAll();
    }

    @GetMapping("/{id}")
    public Philosopher getById(@PathVariable Long id) {
        return philosopherService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Philosopher save(@RequestBody Philosopher philosopher) {
        return philosopherService.save(philosopher);
    }

    @PutMapping("/{id}")
    public Philosopher update(@PathVariable Long id, @RequestBody Philosopher updatedPhilosopher) {
        return philosopherService.update(id, updatedPhilosopher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        philosopherService.delete(id);
    }
}
