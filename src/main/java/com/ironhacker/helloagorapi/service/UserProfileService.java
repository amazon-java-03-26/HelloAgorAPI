package com.ironhacker.helloagorapi.service;

import com.ironhacker.helloagorapi.model.User;
import com.ironhacker.helloagorapi.model.UserProfile;
import com.ironhacker.helloagorapi.repository.UserProfileRepository;
import com.ironhacker.helloagorapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    public UserProfile getByUserId(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found with id: " + userId)
        );

        return user.getProfile();
    }

    public UserProfile updateProfile(Long userId, UserProfile updatedProfile) {
        var user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found with id: " + userId)
        );

        var profile = user.getProfile();
        profile.setBio(updatedProfile.getBio());
        profile.setAge(updatedProfile.getAge());
        profile.setCountry(updatedProfile.getCountry());
        profile.setFavoriteSchoolOfThought(updatedProfile.getFavoriteSchoolOfThought());

        return userProfileRepository.save(profile);
    }
}
