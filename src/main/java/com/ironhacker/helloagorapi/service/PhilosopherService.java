package com.ironhacker.helloagorapi.service;

import com.ironhacker.helloagorapi.exceptions.AgorApiException;
import com.ironhacker.helloagorapi.model.Philosopher;
import com.ironhacker.helloagorapi.repository.PhilosopherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhilosopherService {

    private final PhilosopherRepository philosopherRepository;

    public List<Philosopher> findAll() {
        return philosopherRepository.findAll();
    }

    public Philosopher findById(Long id) {
        return philosopherRepository.findById(id).orElseThrow(
                () -> new AgorApiException("Philosopher not found with id: " + id)
        );
    }

    public Philosopher save(Philosopher philosopher) {
        return philosopherRepository.save(philosopher);
    }

    public Philosopher update(Long id, Philosopher updatedPhilosopher) {
        var philosopher = philosopherRepository.findById(id).orElseThrow(
                () -> new AgorApiException("Philosopher not found with id: " + id)
        );

        philosopher.setName(updatedPhilosopher.getName());
        philosopher.setBiography(updatedPhilosopher.getBiography());
        philosopher.setBirthYear(updatedPhilosopher.getBirthYear());
        philosopher.setSchool(updatedPhilosopher.getSchool());

        return philosopherRepository.save(philosopher);
    }

    public void delete(Long id) {
        philosopherRepository.deleteById(id);
    }


}
