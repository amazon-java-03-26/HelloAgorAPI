package com.ironhacker.helloagorapi.service;

import com.ironhacker.helloagorapi.exceptions.AgorApiException;
import com.ironhacker.helloagorapi.model.User;
import com.ironhacker.helloagorapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

     private final UserRepository userRepository;

     public List<User> findAll() {
         return userRepository.findAll();
     }

     public User findById(Long id) {
         return userRepository.findById(id).orElseThrow(
                () -> new AgorApiException("User not found with id: " + id)
         );
     }

     public User save(User user) {
         return userRepository.save(user);
     }

}
