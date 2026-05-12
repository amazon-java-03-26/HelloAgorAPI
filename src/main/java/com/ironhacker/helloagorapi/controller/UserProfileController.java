package com.ironhacker.helloagorapi.controller;

import com.ironhacker.helloagorapi.model.UserProfile;
import com.ironhacker.helloagorapi.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("users/{userId}")
    public UserProfile getByUSerId(@PathVariable Long userId) {
        return userProfileService.getByUserId(userId);
    }

    @PutMapping("users/{userId}")
    public UserProfile updateUserProfile(@PathVariable Long userId, @RequestBody UserProfile updatedUserProfile) {
        return userProfileService.updateProfile(userId, updatedUserProfile);
    }
}
