package com.siddharth.FitTrack.controller;



//import com.example.demo.Exception.UserAlreadyExistsException;
//import com.example.demo.Exception.UserNotVerifiedException;
//import com.example.demo.Model.*;
//import com.example.demo.Service.UserService;
//import jakarta.validation.Valid;

import com.siddharth.FitTrack.DTO.LoginRequest;
import com.siddharth.FitTrack.DTO.LoginResponse;
import com.siddharth.FitTrack.DTO.RegisterRequest;
import com.siddharth.FitTrack.exception.UserAlreadyExistsException;
import com.siddharth.FitTrack.model.UserProfile;
import com.siddharth.FitTrack.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthenticationController {


    public AuthenticationController() {
        System.out.println("In AuthenticationController");
    }

    @Autowired
    private UserService userservice;


    @PostMapping("/register")
    public ResponseEntity<LoginResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest)
    {
        System.out.println("In AuthenticationController(registerUser)");
        try {
            LoginResponse loginResponse = userservice.addUser(registerRequest);
            System.out.println(loginResponse.getMessage());
            return ResponseEntity.ok(loginResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest loginRequest)
    {
        System.out.println("In AuthenticationController(loginUser)");
        try {
            LoginResponse loginResponse = userservice.loginUser(loginRequest);
            return ResponseEntity.ok(loginResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody){
//        System.out.println("In loginUser");
//        String jwt = null;
//        try {
//            jwt = userservice.loginUser(loginBody);
//        } catch (UserNotVerifiedException ex) {
//            LoginResponse response = new LoginResponse();
//            response.setSuccess(false);
//            String reason="USER_NOT_VERIFIED";
//            if(ex.isNewEmailSent()){
//                reason+="_EMAIL_RESENT";
//            }
//            response.setFailureReason(reason);
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
//        }
//        if(jwt==null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//        else{
//            LoginResponse response = new LoginResponse();
//            response.setJwt(jwt);
//            response.setSuccess(true);
//            return ResponseEntity.ok(response);
//        }
//    }
//
//
//    /*
//        @AuthenticationPrincipal
//        extracts principal information
//        from security context( authentication set in JWTRequestFilter class )
//     */
//    @GetMapping("/me")
//    public UserProfile getLoggedInUserProfile(@AuthenticationPrincipal UserProfile userProfile) {
//        System.out.println("In AuthenticationController(getLoggedInUserProfile)");
//        return userProfile;
//    }
//
//    @PostMapping("/forgot")
//    public void forgotPassword(@RequestParam String email){
//        userservice.forgotPassword(email);
//    }
//
//    @PostMapping("/reset")
//    public void resetPassword(@Valid @RequestBody PasswordResetBody body){
//        userservice.resetPassword(body);
//    }

}
