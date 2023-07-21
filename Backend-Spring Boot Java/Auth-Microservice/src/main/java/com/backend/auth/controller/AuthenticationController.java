package com.backend.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.auth.model.JwtRequest;
import com.backend.auth.model.JwtResponse;
import com.backend.auth.model.User;
import com.backend.auth.repository.UserRepository;
import com.backend.auth.service.JwtService;
import com.backend.auth.service.UserService;
import com.backend.auth.util.JwtUtil;

import java.util.List;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
    private JwtService jwtService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/register"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @PostMapping({"/login"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {

        return jwtService.createJwtToken(jwtRequest);
    }
    
    @PutMapping("/forgotPassword/{userName}")
    public ResponseEntity<?> forgotPassword(@PathVariable("userName") String userName, @RequestBody User user){
    	User userObj=userRepo.findById(userName).get();
    	if(userObj!=null) {
    		if(user.getSecretAns().equals(userObj.getSecretAns())) {
    			
    			user.setRole(userObj.getRole());
    			user.setSecretAns(user.getSecretAns());
    			user.setUserEmail(userObj.getUserEmail());
    			user.setUserFullName(userObj.getUserFullName());
    			user.setUserName(userObj.getUserName());
    			user.setUserPassword(getEncodedPassword(user.getUserPassword()));
    			
    			userRepo.saveAndFlush(user);
    			
//    			userService.forgotPassword(user);
    			return new ResponseEntity<User>(user,HttpStatus.CREATED);
    		}
    	}
    	return new ResponseEntity<String>("Password cannot be updated",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
   
    
    //   http://localhost:8081/auth/validate
    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateJwt(@RequestHeader("Authorization") String jwt){
    	jwt=jwt.substring(7);
    	final UserDetails userDetails = jwtService.loadUserByUsername(jwtUtil.getUsernameFromToken(jwt));
    	
    	try {
    		if(jwtUtil.validateToken(jwt, userDetails)) {
    			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    		}
    		else {
    			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
    		}
    	}
    	catch(Exception e){
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
    	}
    	
    }
    
    
	
	

}
