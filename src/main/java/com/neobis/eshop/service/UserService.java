package com.neobis.eshop.service;

import java.util.*;

//import com.neobis.eshop.config.WebSecurityConfig;
import com.neobis.eshop.entity.Role;
import com.neobis.eshop.entity.User;
import com.neobis.eshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void save(User user){
        userRepository.save(user);
    }

//    public String encode(String code){
//        BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();
//        return encoder.encode(code);
//    }

    public void createUser(User user) {
//        user.setPassword(encode(user.getPassword()));
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());
        user.setRecoveryCode(null);
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
        String message =String.format(
                "Hello, ! \n" +
                        " Welcome to Eshop! Please, visit next link to activate your account: http:localhost:8080/activate/"+
                        user.getActivationCode()
        );
        try {
            Mail.SendEmail(user.getEmail(), "Activation Code", message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void createAdmin(User user) {
//        BCryptPasswordEncoder  encoder = new  BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);
        return true;
    }

    public void sendRecoveryCode(String email) throws Exception {
        User  user = userRepository.findById(email).orElseThrow(Exception::new);
        user.setRecoveryCode(String.valueOf(10000 + new Random().nextInt(90000)));
        Mail.SendEmail(user.getEmail(),"Recovery code","Your recovery code:"+user.getRecoveryCode());
        userRepository.save(user);
    }

    public User findByRecoveryCode(String code)
    {
        return userRepository.findByRecoveryCode(code);
    }


    public User findOne(String email) {
        return userRepository.getOne(email);
    }

    public boolean isUserPresent(String email) {
        Optional<User> optUser = userRepository.findById(email);
        return optUser.isPresent();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return  userRepository.findByNameLike("%"+name+"%");
    }

    public void deleteOne(String mail){
        userRepository.deleteById(mail);
    }


}
