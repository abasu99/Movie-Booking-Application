package com.backend.auth.service;

import com.backend.auth.repository.RoleRepository;
import com.backend.auth.repository.UserRepository;
import com.backend.auth.model.Role;
import com.backend.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setUserFullName("Admin");
        adminUser.setUserEmail("admin@bookmyshow.com");
        adminUser.setSecretAns("Fish");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();

        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    
    public List<User> getAllUsers(){
    	return userDao.findAll();
    }
    
    public User forgotPassword(User user){
    	User u=new User();
    	u.setRole(user.getRole());
		u.setSecretAns(user.getSecretAns());
		u.setUserEmail(user.getUserEmail());
		u.setUserFullName(user.getUserFullName());
		u.setUserName(user.getUserName());
		u.setUserPassword(getEncodedPassword(user.getUserPassword()));
		
		return userDao.saveAndFlush(u);
    }
    
//    @KafkaListener(topics="moviebooking", groupId="mygroup")
//	public void consumeFromTopic(String message)
//	{
//		System.out.println("Consumer message: "+ message);
//	}
}
